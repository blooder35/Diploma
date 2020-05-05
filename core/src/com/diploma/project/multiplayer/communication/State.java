package com.diploma.project.multiplayer.communication;

public enum State {
    MAIN_MENU("mainMenu"),
    IN_GAME("inGame");

    private String value;

    State(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
