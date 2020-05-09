package com.diploma.project.multiplayer.communication.messages;

import com.diploma.project.multiplayer.communication.State;

public class InitialMessage extends CommonMessage {
    private String name;

    public InitialMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    State getMessageState() {
        return State.LOBBY_MENU;
    }
}
