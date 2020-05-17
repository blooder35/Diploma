package com.diploma.project.multiplayerImpl.communication.messages.server.lobby;

public class LobbyStateMessageServerChanger {
    private static final LobbyStateMessageServerChanger INSTANCE = new LobbyStateMessageServerChanger();
    private com.diploma.project.multiplayerImpl.communication.messages.server.lobby.LobbyStateGameMessage state;

    private LobbyStateMessageServerChanger() {
        this.state = new com.diploma.project.multiplayerImpl.communication.messages.server.lobby.LobbyStateGameMessage();
    }

    public static LobbyStateMessageServerChanger getInstance() {
        return INSTANCE;
    }

    //todo возможно убрать joined
    public synchronized void setPlayerState(Integer index,String name, boolean ready) {
        state.setPlayerState(index, name, ready);
    }

    public synchronized void setGameStarted(Boolean gameStarted, int selectedLevel) {
        state.setGameStarted(gameStarted);
        state.setSelectedLevel(selectedLevel);
    }

    public LobbyStateGameMessage getCurrentState() {
        return state;
    }
}

