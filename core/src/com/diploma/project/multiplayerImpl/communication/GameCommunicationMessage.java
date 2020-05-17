package com.diploma.project.multiplayerImpl.communication;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.SerializationException;
import com.diploma.project.multiplayerImpl.communication.messages.client.game.GameCycleClientGameMessage;
import com.diploma.project.multiplayerImpl.communication.messages.client.lobby.LobbyGameMessage;
import com.diploma.project.multiplayerImpl.communication.messages.server.lobby.LobbyStateGameMessage;
import com.diploma.project.multiplayerImpl.communication.processing.GameClientProcessor;
import com.diploma.project.multiplayerImpl.communication.processing.GameServerProcessor;
import com.diploma.project.multiplayerImpl.communication.processing.LobbyClientProcessor;
import com.diploma.project.multiplayerImpl.communication.processing.LobbyServerProcessor;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.GameStateGameMessage;
import com.diploma.project.screens.GameScreen;
import com.diploma.project.screens.LobbyScreen;

/**
 * Сообщение для отправки серверу
 */
public class GameCommunicationMessage {
    //todo продумать как туту должно быть
    private com.diploma.project.multiplayerImpl.communication.ApplicationState state;
    private String message;

    public GameCommunicationMessage() {

    }

    public GameCommunicationMessage(com.diploma.project.multiplayerImpl.communication.ApplicationState state, String message) {
        this.state = state;
        this.message = message;
    }

    public static void serverProcess(Integer clientIdentificator, String message, Json json) {
        //todo тут будет первоначальный разбор сообщения и проброс в дальнейший обработчик остатка
        //todo пока что будем просто отправлять сообщение всем пользователям
        try {
            GameCommunicationMessage gameCommunicationMessage = json.fromJson(GameCommunicationMessage.class, message);
            switch (gameCommunicationMessage.state) {
                case LOBBY_MENU:
                    LobbyServerProcessor.process(clientIdentificator, json.fromJson(LobbyGameMessage.class, gameCommunicationMessage.message));
                    break;
                case IN_GAME:
                    GameServerProcessor.process(clientIdentificator, json.fromJson(GameCycleClientGameMessage.class, gameCommunicationMessage.message));
                    break;
            }
        } catch (SerializationException e) {
            e.printStackTrace();
        }
    }

    public void clientProcess(Screen screen, Json json) {
        switch (state) {
            case LOBBY_MENU:
                if (screen instanceof LobbyScreen) {
                    LobbyClientProcessor.process((LobbyScreen) screen, json.fromJson(LobbyStateGameMessage.class, message));
                }
            case IN_GAME:
                if (screen instanceof GameScreen) {
                    GameClientProcessor.process((GameScreen) screen, json.fromJson(GameStateGameMessage.class, message));
                }
        }
    }

    public com.diploma.project.multiplayerImpl.communication.ApplicationState getState() {
        return state;
    }

    public void setState(ApplicationState state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
