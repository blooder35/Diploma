package com.diploma.project.multiplayer.communication.messages;

import com.badlogic.gdx.utils.Json;
import com.diploma.project.multiplayer.communication.CommunicationMessage;
import com.diploma.project.multiplayer.server.Server;
import com.diploma.project.multiplayer.server.ServerConstants;

public abstract class ServerMessage extends CommonMessage{
    public void sendMessageToAll() {
        Json json = new Json();
        CommunicationMessage message = new CommunicationMessage(getMessageState(), json.toJson(this));
        Server.getInstance().sendMessageToAll(json.toJson(message) + ServerConstants.MESSAGE_ESCAPE_CHARACTER);
    }
}
