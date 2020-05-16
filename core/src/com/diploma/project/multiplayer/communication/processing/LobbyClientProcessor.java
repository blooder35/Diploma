package com.diploma.project.multiplayer.communication.processing;

import com.diploma.project.multiplayer.communication.messages.server.lobby.LobbyStateMessage;
import com.diploma.project.multiplayer.communication.messages.server.lobby.PlayerState;
import com.diploma.project.screens.LobbyScreen;

public class LobbyClientProcessor {
    private LobbyClientProcessor() {
    }

    public static void process(LobbyScreen screen, LobbyStateMessage state) {
        PlayerState playerOneState = state.getPlayerState(0);
        if (playerOneState != null)
            screen.setPlayer1Info(playerOneState.getName(), playerOneState.getReady());
        PlayerState playerTwoState = state.getPlayerState(1);
        if (playerTwoState != null)
            screen.setPlayer2Info(playerTwoState.getName(), playerTwoState.getReady());
        PlayerState playerThreeState = state.getPlayerState(2);
        if (playerThreeState != null)
            screen.setPlayer3Info(playerThreeState.getName(), playerThreeState.getReady());
        if (state.isGameStarted()) {
            screen.setGameStarted();
            screen.setSelectedLevel(state.getSelectedLevel());
        }
    }
}
