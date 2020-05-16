package com.diploma.project.multiplayer.communication.processing;

import com.badlogic.gdx.utils.Json;
import com.diploma.project.multiplayer.communication.ApplicationState;
import com.diploma.project.multiplayer.communication.messages.client.lobby.LobbyClientMessage;
import com.diploma.project.multiplayer.communication.messages.client.lobby.LobbyMessage;
import com.diploma.project.multiplayer.communication.messages.client.lobby.StartGameMessage;
import com.diploma.project.multiplayer.communication.messages.server.lobby.LobbyStateMessageServerChanger;
import com.diploma.project.multiplayer.server.Server;

public class LobbyServerProcessor {
    public static void process(Integer clientIdentificator, LobbyMessage clientMessage) {
        Json json = new Json();
        switch (clientMessage.getType()) {
            case START_GAME_MESSAGE:
                StartGameMessage startGameMessage = json.fromJson(StartGameMessage.class, clientMessage.getMessage());
                LobbyStateMessageServerChanger.getInstance().setGameStarted(true, startGameMessage.getSelectedLevel());
                break;
            case LOBBY_CLIENT_MESSAGE:
                LobbyClientMessage lobbyClientMessage = json.fromJson(LobbyClientMessage.class, clientMessage.getMessage());
                LobbyStateMessageServerChanger.getInstance().setPlayerState(clientIdentificator, lobbyClientMessage.getName(), lobbyClientMessage.isReady());
                break;
        }
    }
}
