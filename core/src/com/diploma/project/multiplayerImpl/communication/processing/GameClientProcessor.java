package com.diploma.project.multiplayerImpl.communication.processing;

import com.diploma.project.multiplayerImpl.communication.messages.server.game.GameStateGameMessage;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerGameInfo;
import com.diploma.project.screens.GameScreen;

public class GameClientProcessor {
    private GameClientProcessor() {

    }

    public static void process(GameScreen screen, GameStateGameMessage message) {
        int index = 0;
        for (PlayerGameInfo info : message.getPlayerGameInfoList()) {
            screen.movePlayer(index, info.getPosX(), info.getPosY());
            screen.changePlayerColorType(index, info.getColorType());
            index++;
        }
        if (message.isLevelFinished()) {
            screen.setLevelFinished();
        }
    }
}
