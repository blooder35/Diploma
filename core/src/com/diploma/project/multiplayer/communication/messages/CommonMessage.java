package com.diploma.project.multiplayer.communication.messages;

import com.badlogic.gdx.utils.Json;
import com.diploma.project.multiplayer.communication.CommunicationMessage;
import com.diploma.project.multiplayer.communication.State;

public abstract class CommonMessage {

    public void sendMessageToServer() {
        Json json = new Json();
        CommunicationMessage message = new CommunicationMessage(getMessageState(), json.toJson(this));
        message.sendToServer();
    }

    abstract State getMessageState();
}
