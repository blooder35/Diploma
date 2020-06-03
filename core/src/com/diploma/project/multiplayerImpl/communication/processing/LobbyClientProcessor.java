package com.diploma.project.multiplayerImpl.communication.processing;

import com.diploma.project.multiplayerImpl.communication.messages.server.lobby.LobbyStateGameMessage;
import com.diploma.project.multiplayerImpl.communication.messages.server.lobby.PlayerState;
import com.diploma.project.screens.LobbyScreen;

/**
 * Обработчик сообщений, пришедших от сервера, пользователем находящимся в лобби
 */
public class LobbyClientProcessor {
    private LobbyClientProcessor() {
    }

    /**
     * Обработать сообщение пришедшие от сервера
     *
     * @param screen экран лобби
     * @param state  сообщение состояния игроков
     */
    public static void process(LobbyScreen screen, LobbyStateGameMessage state) {
        com.diploma.project.multiplayerImpl.communication.messages.server.lobby.PlayerState playerOneState = state.getPlayerState(0);
        if (playerOneState != null)
            screen.setPlayer1Info(playerOneState.getName(), playerOneState.getReady());
        com.diploma.project.multiplayerImpl.communication.messages.server.lobby.PlayerState playerTwoState = state.getPlayerState(1);
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
