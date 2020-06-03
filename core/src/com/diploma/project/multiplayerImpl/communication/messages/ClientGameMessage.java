package com.diploma.project.multiplayerImpl.communication.messages;

import com.badlogic.gdx.utils.Json;
import com.diploma.project.multiplayerImpl.communication.GameCommunicationMessage;
import multiplayer.client.ClientMessage;

/**
 * Абстрактный класс сообщения пользователя
 */
public abstract class ClientGameMessage extends ClientMessage implements CommonGameMessage {

    /**
     * Получить строку сообщения для отправки
     *
     * @return строка собщения для отправки
     */
    public String getMessageToSend() {
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
