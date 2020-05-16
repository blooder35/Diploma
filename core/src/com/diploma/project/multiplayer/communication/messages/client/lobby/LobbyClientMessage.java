package com.diploma.project.multiplayer.communication.messages.client.lobby;

public class LobbyClientMessage extends LobbyMessage {
    private String name;
    private Boolean ready;

    public LobbyClientMessage() {

    }

    @Override
    LobbyMessageType getMessageType() {
        return LobbyMessageType.LOBBY_CLIENT_MESSAGE;
    }

    public LobbyClientMessage(String name, Boolean ready) {
        this.name = name;
        this.ready = ready;
    }

    public String getName() {
        return name;
    }

    public Boolean isReady() {
        return ready;
    }
}
