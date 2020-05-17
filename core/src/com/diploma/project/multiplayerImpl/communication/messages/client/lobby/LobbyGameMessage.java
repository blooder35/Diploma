package com.diploma.project.multiplayerImpl.communication.messages.client.lobby;

import com.badlogic.gdx.utils.Json;
import com.diploma.project.multiplayerImpl.communication.ApplicationState;
import com.diploma.project.multiplayerImpl.communication.messages.ClientGameMessage;

public class LobbyGameMessage extends ClientGameMessage {
    private LobbyMessageType type;
    private String message;

    public LobbyGameMessage() {
    }

    public LobbyGameMessage(LobbyMessageType type, String message) {
        this.type = type;
        this.message = message;
    }

    public LobbyMessageType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String getMessageToSend() {
        Json json = new Json();
        return json.toJson(new LobbyGameMessage(getMessageType(), json.toJson(this)));
    }

    LobbyMessageType getMessageType(){
        return null;
    }

    @Override
    public com.diploma.project.multiplayerImpl.communication.ApplicationState getMessageState() {
        return ApplicationState.LOBBY_MENU;
    }
}
