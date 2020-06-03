package com.diploma.project.multiplayerImpl.communication.messages.client.lobby;

import com.badlogic.gdx.utils.Json;
import com.diploma.project.multiplayerImpl.communication.ApplicationState;
import com.diploma.project.multiplayerImpl.communication.messages.ClientGameMessage;

/**
 * Общий вид сообщения пользователя, находящегося в лобби
 */
public class LobbyGameMessage extends ClientGameMessage {
    private LobbyMessageType type;
    private String message;

    /**
     * Конструктор
     */
    public LobbyGameMessage() {
    }

    /**
     * Конструктор
     *
     * @param type тип сообщения Лобби
     * @param message строка сообщения
     */
    public LobbyGameMessage(LobbyMessageType type, String message) {
        this.type = type;
        this.message = message;
    }

    /**
     * @return тип сообщения из лобби
     */
    public LobbyMessageType getType() {
        return type;
    }

    /**
     * @return строка сообщения
     */
    public String getMessage() {
        return message;
    }

    @Override
    public String getMessageToSend() {
        Json json = new Json();
        return json.toJson(new LobbyGameMessage(getMessageType(), json.toJson(this)));
    }

    /**
     * @return тип сообщения из лобби
     */
    LobbyMessageType getMessageType() {
        return null;
    }

    @Override
    public com.diploma.project.multiplayerImpl.communication.ApplicationState getMessageState() {
        return ApplicationState.LOBBY_MENU;
    }
}
