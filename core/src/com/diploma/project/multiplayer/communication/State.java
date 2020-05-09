package com.diploma.project.multiplayer.communication;

public enum State {
    LOBBY_MENU("Lobby"),
    IN_GAME("inGame");

    private String value;

    State(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
