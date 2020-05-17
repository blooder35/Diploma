package com.diploma.project.multiplayer.communication.processing;

import com.diploma.project.multiplayer.communication.messages.server.game.GameStateMessage;
import com.diploma.project.multiplayer.communication.messages.server.game.PlayerGameInfo;
import com.diploma.project.screens.GameScreen;

public class GameClientProcessor {
    private GameClientProcessor() {

    }

    public static void process(GameScreen screen, GameStateMessage message) {
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
