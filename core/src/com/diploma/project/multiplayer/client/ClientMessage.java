package com.diploma.project.multiplayer.client;

import com.diploma.project.multiplayer.configuration.Configuration;

public abstract class ClientMessage {
    public void sendMessageToServer() {
        Client.getInstance().sendMessage(getMessageStringToSend() + Configuration.getInstance().getMessageEscapeCharacter());
    }

    protected abstract String getMessageStringToSend();
}
