package com.diploma.project.multiplayer.communication.messages;

import com.badlogic.gdx.utils.Json;
import com.diploma.project.multiplayer.communication.CommunicationMessage;

public abstract class ClientMessage extends CommonMessage {
    public void sendMessageToServer() {
        CommunicationMessage message = new CommunicationMessage(getMessageState(), getMessageToSend());
        message.sendToServer();
    }

    public String getMessageToSend(){
        Json json = new Json();
        return json.toJson(this);
    };
}
