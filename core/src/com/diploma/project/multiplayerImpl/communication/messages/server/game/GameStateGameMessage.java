package com.diploma.project.multiplayerImpl.communication.messages.server.game;

import com.diploma.project.constants.ColorType;
import com.diploma.project.multiplayer.configuration.Configuration;
import com.diploma.project.multiplayerImpl.communication.ApplicationState;
import com.diploma.project.multiplayerImpl.communication.messages.ServerGameMessage;

import java.util.ArrayList;
import java.util.List;

public class GameStateGameMessage extends ServerGameMessage {
    private List<com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerGameInfo> playerGameInfo;
    private boolean levelFinished;

    public GameStateGameMessage() {
        playerGameInfo = new ArrayList<>(Configuration.getInstance().getMaximumAllowedClients());
        for (int i = 0; i < Configuration.getInstance().getMaximumAllowedClients(); i++) {
            playerGameInfo.add(new com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerGameInfo(0,0, ColorType.NONE));
        }
        levelFinished = false;
    }

    public void setPlayerGameInfo(int index, float posX, float postY, ColorType colorType) {
        playerGameInfo.set(index, new com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerGameInfo(posX, postY, colorType));
    }

    public List<PlayerGameInfo> getPlayerGameInfoList() {
        return playerGameInfo;
    }

    @Override
    public ApplicationState getMessageState() {
        return ApplicationState.IN_GAME;
    }

    public boolean isLevelFinished() {
        return levelFinished;
    }

    public void setLevelFinished(boolean levelFinished) {
        this.levelFinished = levelFinished;
    }
}
