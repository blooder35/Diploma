package com.diploma.project.multiplayer.communication.messages;

import com.diploma.project.multiplayer.communication.ApplicationState;

public abstract class CommonMessage {

    protected abstract ApplicationState getMessageState();
}
