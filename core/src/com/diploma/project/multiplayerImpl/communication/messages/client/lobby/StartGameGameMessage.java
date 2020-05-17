package com.diploma.project.multiplayerImpl.communication.messages.client.lobby;

import com.diploma.project.constants.Levels;

public class StartGameGameMessage extends LobbyGameMessage {
    int selectedLevel;

    public StartGameGameMessage() {

    }

    public StartGameGameMessage(String selectedLevel) {
        this.selectedLevel = Levels.valueOf(selectedLevel).getValue();
    }

    public int getSelectedLevel() {
        return selectedLevel;
    }

    @Override
    com.diploma.project.multiplayerImpl.communication.messages.client.lobby.LobbyMessageType getMessageType() {
        return LobbyMessageType.START_GAME_MESSAGE;
    }
}
