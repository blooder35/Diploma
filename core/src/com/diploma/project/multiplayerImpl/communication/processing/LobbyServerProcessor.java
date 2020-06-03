package com.diploma.project.multiplayerImpl.communication.processing;

import com.badlogic.gdx.utils.Json;
import com.diploma.project.multiplayerImpl.communication.messages.client.lobby.LobbyClientGameMessage;
import com.diploma.project.multiplayerImpl.communication.messages.client.lobby.LobbyGameMessage;
import com.diploma.project.multiplayerImpl.communication.messages.client.lobby.StartGameGameMessage;
import com.diploma.project.multiplayerImpl.communication.messages.server.lobby.LobbyStateMessageServerChanger;

/**
 * Обработка сервером сообщения, пришедшего от пользователя находящегося в лобби
 */
public class LobbyServerProcessor {

    /**
     * Обработать сообщение
     * @param clientIdentificator идентификатор пользователя
     * @param clientMessage Сообщение пользователя, находящегося в лобби
     */
    public static void process(Integer clientIdentificator, LobbyGameMessage clientMessage) {
        Json json = new Json();
        switch (clientMessage.getType()) {
            case START_GAME_MESSAGE:
                StartGameGameMessage startGameMessage = json.fromJson(StartGameGameMessage.class, clientMessage.getMessage());
                com.diploma.project.multiplayerImpl.communication.messages.server.lobby.LobbyStateMessageServerChanger.getInstance().setGameStarted(true, startGameMessage.getSelectedLevel());
                break;
            case LOBBY_CLIENT_MESSAGE:
                LobbyClientGameMessage lobbyClientMessage = json.fromJson(LobbyClientGameMessage.class, clientMessage.getMessage());
                LobbyStateMessageServerChanger.getInstance().setPlayerState(clientIdentificator, lobbyClientMessage.getName(), lobbyClientMessage.isReady());
                break;
        }
    }
}
