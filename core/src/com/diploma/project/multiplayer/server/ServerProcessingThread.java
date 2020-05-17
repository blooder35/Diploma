package com.diploma.project.multiplayer.server;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.TimeUtils;
import com.diploma.project.collision.CollisionHelper;
import com.diploma.project.collision.PlayerCollision;
import com.diploma.project.constants.GameConstants;
import com.diploma.project.maps.blocks.InteractingMapBlock;
import com.diploma.project.maps.blocks.MapBlock;
import com.diploma.project.multiplayer.communication.ApplicationState;
import com.diploma.project.multiplayer.communication.CommunicationMessage;
import com.diploma.project.multiplayer.communication.messages.server.game.GameStateMessageServerChanger;
import com.diploma.project.multiplayer.communication.messages.server.game.PlayerAttributes;
import com.diploma.project.multiplayer.communication.messages.server.game.PlayerGameInfo;
import com.diploma.project.multiplayer.communication.messages.server.game.PlayerInfoServerSaver;
import com.diploma.project.multiplayer.communication.messages.server.lobby.LobbyStateMessage;
import com.diploma.project.multiplayer.communication.messages.server.lobby.LobbyStateMessageServerChanger;

import java.util.List;
import java.util.Map;

public class ServerProcessingThread extends Thread {
    private ApplicationState state;

    ServerProcessingThread(ApplicationState state) {
        super("ServerProcessingThread");
        this.state = state;
    }

    @Override
    public void run() {
        Json json = new Json();
        long delta = 0;
        long startTime = TimeUtils.millis();
        long prevCycleTime = 0;
        while (Server.getInstance().isStarted()) {
            prevCycleTime = TimeUtils.timeSinceMillis(startTime);
            startTime = TimeUtils.millis();
            //todo вернуть вызов обратно в скобки (убрать temp)
            Map<Integer, List<String>> temp = Server.getInstance().getClientMessages();
            processMessages(temp, json, prevCycleTime/1000f);
            delta = TimeUtils.timeSinceMillis(startTime);
            if (delta < ServerConstants.SERVER_PROCESSING_CYCLE_TIME) {
                try {
                    sleep(ServerConstants.SERVER_PROCESSING_CYCLE_TIME - delta);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setState(ApplicationState state) {
        this.state = state;
    }

    private void processMessages(Map<Integer, List<String>> messages, Json json, float delta) {
        //todo implementation of message reading
        for (Map.Entry<Integer, List<String>> entry : messages.entrySet()) {
            for (String message : entry.getValue()) {
                System.out.println("Got a message" + message);
                CommunicationMessage.serverProcess(entry.getKey(), message, json);
            }
        }
        //todo возможно для чистоты расширить это в отдельный метод (идея с продуктом: библиотекой) заодно убрать state(ведь он не относится к библиотеке)
        switch (state) {
            case LOBBY_MENU:
                LobbyStateMessage lobbyState = LobbyStateMessageServerChanger.getInstance().getCurrentState();
                lobbyState.sendMessageToAll();
                if (lobbyState.isGameStarted()) {
                    setState(ApplicationState.IN_GAME);
                    GameStateMessageServerChanger.getInstance().initialize(lobbyState.getSelectedLevel());
                    PlayerInfoServerSaver.getInstance().initialize(lobbyState.getSelectedLevel());
                }
                break;
            case IN_GAME:
                //todo так же нужно будет вынести в отдельный обработчик или метод (пока что без просчёта коллизий)
                //todo возмножно вынести ещё выше
                PlayerCollision playerCollision = new PlayerCollision(0, 0);
                int finishedPlayersCounter = 0;
                for (int i = 0; i < ServerConstants.MAXIMUM_PLAYERS; i++) {
                    //todo refactor to remove new local variable
                    Vector2 tempVector = PlayerInfoServerSaver.getInstance().getPlayerVectorAndClear(i);
                    Vector2 normalizedIncreementPlayerVector = new Vector2(tempVector.x * delta * GameConstants.MOVEMENT_SPEED, tempVector.y * delta * GameConstants.MOVEMENT_SPEED);
                    Vector2 currentPlayerVector = PlayerInfoServerSaver.getInstance().addNormalizedPlayerVector(i, normalizedIncreementPlayerVector);
                    PlayerAttributes playerAttributes = PlayerInfoServerSaver.getInstance().getPlayerAttributes(i);

                    PlayerGameInfo player = GameStateMessageServerChanger.getInstance().getCurrentState().getPlayerGameInfoList().get(i);

                    for (MapBlock mapBlock : GameStateMessageServerChanger.getInstance().getLevel().getMapBlocks()) {
                        currentPlayerVector = CollisionHelper.solidWallBounceCollision(playerCollision, mapBlock, player.getPosX(), player.getPosY(), currentPlayerVector, playerAttributes.getColorType());
                    }
                    currentPlayerVector.x *= GameConstants.PLAYER_MOVEMENT_COEF;
                    currentPlayerVector.y *= GameConstants.PLAYER_MOVEMENT_COEF;
                    player.setPosX(player.getPosX() + currentPlayerVector.x);
                    player.setPosY(player.getPosY() + currentPlayerVector.y);

                    // взаимодействие с использующимися полями
                    if (playerAttributes.isInteracting()) {
                        playerAttributes.setInteracting(false);
                        for (InteractingMapBlock interactingMapBlocks : GameStateMessageServerChanger.getInstance().getLevel().getInteractingMapBlocks()) {
                            CollisionHelper.interactingCollision(playerAttributes, playerCollision, interactingMapBlocks, player.getPosX(), player.getPosY());
                        }
                    }
                    PlayerInfoServerSaver.getInstance().setNormalizedPlayerVector(i, currentPlayerVector);

                    if (playerAttributes.isFinished()) {
                        finishedPlayersCounter++;
                    }

                    GameStateMessageServerChanger.getInstance().setPlayerGameInfo(i, player.getPosX() , player.getPosY(), playerAttributes.getColorType());
                }
                if (finishedPlayersCounter == GameStateMessageServerChanger.getInstance().getLevel().getMaximumPlayers()) {
                    GameStateMessageServerChanger.getInstance().getCurrentState().setLevelFinished(true);
                }
                GameStateMessageServerChanger.getInstance().getCurrentState().sendMessageToAll();
                break;
        }
    }
}
