package com.diploma.project.multiplayerImpl.communication.messages.client.lobby;

import com.diploma.project.constants.Levels;

/**
 * Сообщение ифнормирующее сервер о начале игры
 */
public class StartGameGameMessage extends LobbyGameMessage {
    int selectedLevel;

    /**
     * Конструктор
     */
    public StartGameGameMessage() {

    }

    /**
     * Конструктор
     *
     * @param selectedLevel выбранный уровень
     */
    public StartGameGameMessage(String selectedLevel) {
        this.selectedLevel = Levels.valueOf(selectedLevel).getValue();
    }

    /**
     * @return идентификатор выбранного уровня
     */
    public int getSelectedLevel() {
        return selectedLevel;
    }

    @Override
    com.diploma.project.multiplayerImpl.communication.messages.client.lobby.LobbyMessageType getMessageType() {
        return LobbyMessageType.START_GAME_MESSAGE;
    }
}
