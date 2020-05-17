package com.diploma.project.multiplayerImpl;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.diploma.project.collision.CollisionHelper;
import com.diploma.project.collision.PlayerCollision;
import com.diploma.project.constants.GameConstants;
import com.diploma.project.maps.blocks.InteractingMapBlock;
import com.diploma.project.maps.blocks.MapBlock;
import com.diploma.project.multiplayer.configuration.Configuration;
import com.diploma.project.multiplayerImpl.communication.ApplicationState;
import com.diploma.project.multiplayerImpl.communication.GameCommunicationMessage;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.GameStateMessageServerChanger;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerAttributes;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerGameInfo;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerInfoServerSaver;
import com.diploma.project.multiplayerImpl.communication.messages.server.lobby.LobbyStateGameMessage;
import com.diploma.project.multiplayerImpl.communication.messages.server.lobby.LobbyStateMessageServerChanger;
import com.diploma.project.multiplayer.server.ServerProcessingThread;

import java.util.List;
import java.util.Map;

public class ServerProcessingThreadImpl extends ServerProcessingThread {
    private ApplicationState state;
    private Json json;

    public ServerProcessingThreadImpl(ApplicationState state) {
        super("ServerProcessingThread");
        this.state = state;
        json = new Json();
    }

    @Override
    protected void processMessages(Map<Integer, List<String>> messages, float delta) {
        //todo implementation of message reading
        for (Map.Entry<Integer, List<String>> entry : messages.entrySet()) {
            for (String message : entry.getValue()) {
                System.out.println("Got a message" + message);
                GameCommunicationMessage.serverProcess(entry.getKey(), message, json);
            }
        }
        //todo возможно для чистоты расширить это в отдельный метод (идея с продуктом: библиотекой) заодно убрать state(ведь он не относится к библиотеке)
        switch (state) {
            case LOBBY_MENU:
                LobbyStateGameMessage lobbyState = LobbyStateMessageServerChanger.getInstance().getCurrentState();
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
                for (int i = 0; i < Configuration.getInstance().getMaximumAllowedClients(); i++) {
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

                    GameStateMessageServerChanger.getInstance().setPlayerGameInfo(i, player.getPosX(), player.getPosY(), playerAttributes.getColorType());
                }
                if (finishedPlayersCounter == GameStateMessageServerChanger.getInstance().getLevel().getMaximumPlayers()) {
                    GameStateMessageServerChanger.getInstance().getCurrentState().setLevelFinished(true);
                }
                GameStateMessageServerChanger.getInstance().getCurrentState().sendMessageToAll();
                break;
        }
    }


    private void setState(ApplicationState state) {
        this.state = state;
    }
}
