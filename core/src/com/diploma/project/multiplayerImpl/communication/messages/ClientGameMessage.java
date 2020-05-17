package com.diploma.project.multiplayerImpl.communication.messages;

import com.badlogic.gdx.utils.Json;
import com.diploma.project.multiplayer.client.ClientMessage;
import com.diploma.project.multiplayerImpl.communication.GameCommunicationMessage;

public abstract class ClientGameMessage extends ClientMessage implements CommonGameMessage {

    public String getMessageToSend(){
        Json json = new Json();
        return json.toJson(this);
    }

    @Override
    protected String getMessageStringToSend() {
        Json json = new Json();
        com.diploma.project.multiplayerImpl.communication.GameCommunicationMessage message = new GameCommunicationMessage(getMessageState(), getMessageToSend());
        return json.toJson(message);
    }
}
