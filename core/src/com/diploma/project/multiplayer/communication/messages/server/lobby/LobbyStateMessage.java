package com.diploma.project.multiplayer.communication.messages.server.lobby;

import com.diploma.project.multiplayer.communication.ApplicationState;
import com.diploma.project.multiplayer.communication.messages.ServerMessage;
import com.diploma.project.multiplayer.server.ServerConstants;

import java.util.ArrayList;
import java.util.List;

public class LobbyStateMessage extends ServerMessage {
    private List<PlayerState> playerStates;
    private boolean gameStarted;
    private int selectedLevel;
    private int playerId;

    public LobbyStateMessage(){
        playerStates = new ArrayList<>(ServerConstants.MAXIMUM_PLAYERS);
        for (int i = 0; i < ServerConstants.MAXIMUM_PLAYERS; i++) {
            playerStates.add(null);
        }
    }

    void setPlayerState(Integer index,String name, boolean ready) {
        playerStates.set(index, new PlayerState(name, ready));
    }

    void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    void setSelectedLevel(int selectedLevel) {
        this.selectedLevel = selectedLevel;
    }

    public PlayerState getPlayerState(Integer index) {
        return playerStates.get(index);
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public int getSelectedLevel() {
        return selectedLevel;
    }

    @Override
    protected ApplicationState getMessageState() {
        return ApplicationState.LOBBY_MENU;
    }
}
