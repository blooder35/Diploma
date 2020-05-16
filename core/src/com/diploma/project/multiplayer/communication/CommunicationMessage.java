package com.diploma.project.multiplayer.communication;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.SerializationException;
import com.diploma.project.multiplayer.client.Client;
import com.diploma.project.multiplayer.communication.messages.client.game.GameCycleClientMessage;
import com.diploma.project.multiplayer.communication.messages.client.lobby.LobbyMessage;
import com.diploma.project.multiplayer.communication.messages.server.game.GameStateMessage;
import com.diploma.project.multiplayer.communication.messages.server.lobby.LobbyStateMessage;
import com.diploma.project.multiplayer.communication.processing.GameClientProcessor;
import com.diploma.project.multiplayer.communication.processing.GameServerProcessor;
import com.diploma.project.multiplayer.communication.processing.LobbyClientProcessor;
import com.diploma.project.multiplayer.communication.processing.LobbyServerProcessor;
import com.diploma.project.multiplayer.server.ServerConstants;
import com.diploma.project.screens.GameScreen;
import com.diploma.project.screens.LobbyScreen;

/**
 * Сообщение для отправки серверу
 */
public class CommunicationMessage {
    //todo продумать как туту должно быть
    private ApplicationState state;
    private String message;

    public CommunicationMessage() {

    }

    public CommunicationMessage(ApplicationState state, String message) {
        this.state = state;
        this.message = message;
    }

    public static void serverProcess(Integer clientIdentificator, String message, Json json) {
        //todo тут будет первоначальный разбор сообщения и проброс в дальнейший обработчик остатка
        //todo пока что будем просто отправлять сообщение всем пользователям
        try {
            CommunicationMessage communicationMessage = json.fromJson(CommunicationMessage.class, message);
            switch (communicationMessage.state) {
                case LOBBY_MENU:
                    LobbyServerProcessor.process(clientIdentificator, json.fromJson(LobbyMessage.class, communicationMessage.message));
                    break;
                case IN_GAME:
                    GameServerProcessor.process(clientIdentificator, json.fromJson(GameCycleClientMessage.class, communicationMessage.message));
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
                    LobbyClientProcessor.process((LobbyScreen) screen, json.fromJson(LobbyStateMessage.class, message));
                }
            case IN_GAME:
                if (screen instanceof GameScreen) {
                    GameClientProcessor.process((GameScreen) screen, json.fromJson(GameStateMessage.class, message));
                }
        }
    }

    public void sendToServer() {
        Json json = new Json();
        Client.getInstance().sendMessage(json.toJson(this) + ServerConstants.MESSAGE_ESCAPE_CHARACTER);
    }

    public ApplicationState getState() {
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
