package com.diploma.project.multiplayer.communication.messages;

import com.diploma.project.multiplayer.communication.ApplicationState;

public abstract class CommonMessage {

    public void sendMessageToServer() {
        Json json = new Json();
        CommunicationMessage message = new CommunicationMessage(getMessageState(), json.toJson(this));
        message.sendToServer();
    }

    abstract State getMessageState();
}
