package com.diploma.project.multiplayerImpl.communication.messages;

import com.badlogic.gdx.utils.Json;
import com.diploma.project.multiplayer.server.ServerMessage;
import com.diploma.project.multiplayerImpl.communication.GameCommunicationMessage;

/**
 * Абстрактный класс сообщения сервера
 */
public abstract class ServerGameMessage extends ServerMessage implements CommonGameMessage {
    @Override
    protected String getMessageStringToSend() {
        Json json = new Json();
        com.diploma.project.multiplayerImpl.communication.GameCommunicationMessage message = new GameCommunicationMessage(getMessageState(), json.toJson(this));
        return json.toJson(message);
    }
}
