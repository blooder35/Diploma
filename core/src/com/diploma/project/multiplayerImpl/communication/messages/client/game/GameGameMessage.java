package com.diploma.project.multiplayerImpl.communication.messages.client.game;

import com.diploma.project.multiplayerImpl.communication.ApplicationState;
import com.diploma.project.multiplayerImpl.communication.messages.ClientGameMessage;

/**
 * Сообщение пользователя, находящегося в игре
 */
public class GameGameMessage extends ClientGameMessage {
    @Override
    public ApplicationState getMessageState() {
        return ApplicationState.IN_GAME;
    }
}
