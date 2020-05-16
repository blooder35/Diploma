package com.diploma.project.multiplayer.communication.messages.client.game;

import com.diploma.project.multiplayer.communication.ApplicationState;
import com.diploma.project.multiplayer.communication.messages.ClientMessage;

public class GameMessage extends ClientMessage {
    @Override
    protected ApplicationState getMessageState() {
        return ApplicationState.IN_GAME;
    }
}
