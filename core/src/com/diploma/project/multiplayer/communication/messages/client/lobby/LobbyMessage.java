package com.diploma.project.multiplayer.communication.messages.client.lobby;

import com.badlogic.gdx.utils.Json;
import com.diploma.project.multiplayer.communication.ApplicationState;
import com.diploma.project.multiplayer.communication.messages.ClientMessage;

public class LobbyMessage extends ClientMessage {
    private LobbyMessageType type;
    private String message;

    public LobbyMessage() {
    }

    public LobbyMessage(LobbyMessageType type, String message) {
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
        return json.toJson(new LobbyMessage(getMessageType(), json.toJson(this)));
    }

    LobbyMessageType getMessageType(){
        return null;
    }

    @Override
    protected ApplicationState getMessageState() {
        return ApplicationState.LOBBY_MENU;
    }
}
