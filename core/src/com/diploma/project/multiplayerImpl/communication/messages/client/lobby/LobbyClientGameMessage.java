package com.diploma.project.multiplayerImpl.communication.messages.client.lobby;

public class LobbyClientGameMessage extends LobbyGameMessage {
    private String name;
    private Boolean ready;

    public LobbyClientGameMessage() {

    }

    @Override
    LobbyMessageType getMessageType() {
        return LobbyMessageType.LOBBY_CLIENT_MESSAGE;
    }

    public LobbyClientGameMessage(String name, Boolean ready) {
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
