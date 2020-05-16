package com.diploma.project.multiplayer.communication.messages.client.lobby;

import com.diploma.project.constants.Levels;

import static com.diploma.project.constants.Levels.*;

public class StartGameMessage extends LobbyMessage {
    int selectedLevel;

    public StartGameMessage() {

    }

    public StartGameMessage(String selectedLevel) {
        this.selectedLevel = Levels.valueOf(selectedLevel).getValue();
    }

    public int getSelectedLevel() {
        return selectedLevel;
    }

    @Override
    LobbyMessageType getMessageType() {
        return LobbyMessageType.START_GAME_MESSAGE;
    }
}
