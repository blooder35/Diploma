package com.diploma.project.multiplayerImpl.communication.messages.server.lobby;

import com.diploma.project.multiplayer.configuration.Configuration;
import com.diploma.project.multiplayerImpl.communication.ApplicationState;
import com.diploma.project.multiplayerImpl.communication.messages.ServerGameMessage;

import java.util.ArrayList;
import java.util.List;

public class LobbyStateGameMessage extends ServerGameMessage {
    private List<PlayerState> playerStates;
    private boolean gameStarted;
    private int selectedLevel;
    private int playerId;

    public LobbyStateGameMessage(){
        playerStates = new ArrayList<>(Configuration.getInstance().getMaximumAllowedClients());
        for (int i = 0; i < Configuration.getInstance().getMaximumAllowedClients(); i++) {
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
    public com.diploma.project.multiplayerImpl.communication.ApplicationState getMessageState() {
        return ApplicationState.LOBBY_MENU;
    }
}
