package com.diploma.project.multiplayer.communication.messages.server.game;

import com.diploma.project.constants.ColorType;
import com.diploma.project.multiplayer.communication.ApplicationState;
import com.diploma.project.multiplayer.communication.messages.ServerMessage;
import com.diploma.project.multiplayer.server.ServerConstants;

import java.util.ArrayList;
import java.util.List;

public class GameStateMessage extends ServerMessage {
    private List<PlayerGameInfo> playerGameInfo;
    private boolean levelFinished;

    public GameStateMessage() {
        playerGameInfo = new ArrayList<>(ServerConstants.MAXIMUM_PLAYERS);
        for (int i = 0; i < ServerConstants.MAXIMUM_PLAYERS; i++) {
            playerGameInfo.add(new PlayerGameInfo(0,0, ColorType.NONE));
        }
        levelFinished = false;
    }

    public void setPlayerGameInfo(int index, float posX, float postY, ColorType colorType) {
        playerGameInfo.set(index, new PlayerGameInfo(posX, postY, colorType));
    }

    public List<PlayerGameInfo> getPlayerGameInfoList() {
        return playerGameInfo;
    }

    @Override
    protected ApplicationState getMessageState() {
        return ApplicationState.IN_GAME;
    }

    public boolean isLevelFinished() {
        return levelFinished;
    }

    public void setLevelFinished(boolean levelFinished) {
        this.levelFinished = levelFinished;
    }
}
