package com.diploma.project.multiplayer.server;

import com.diploma.project.multiplayer.configuration.Configuration;

public abstract class ServerMessage {
    public void sendMessageToAll() {
        Server.getInstance().sendMessageToAll(getMessageStringToSend() + Configuration.getInstance().getMessageEscapeCharacter());
    }

    protected abstract String getMessageStringToSend();
}
