package com.diploma.project.multiplayer.communication;

public enum ApplicationState {
    LOBBY_MENU("Lobby"),
    IN_GAME("inGame");

    private String value;

    ApplicationState(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
