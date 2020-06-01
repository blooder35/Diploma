package com.diploma.project.multiplayerImpl.communication.messages.server.game;

import com.diploma.project.constants.ColorType;
import com.diploma.project.maps.Level;
import com.diploma.project.maps.MapManager;

public class GameStateMessageServerChanger {
    private static final GameStateMessageServerChanger INSTANCE = new GameStateMessageServerChanger();
    private GameStateGameMessage state;
    private Level level;

    private GameStateMessageServerChanger() {
        this.state = new GameStateGameMessage();
        this.level = null;
    }

    public static GameStateMessageServerChanger getInstance() {
        return INSTANCE;
    }

    public synchronized void setPlayerGameInfo(int index, float posX, float posY, ColorType colorType) {
        state.setPlayerGameInfo(index, posX, posY, colorType);
    }

    public GameStateGameMessage getCurrentState() {
        return state;
    }

    public void initialize(int selectedLevel) {
        Level level = MapManager.getInstance().getLevel(selectedLevel);
        for (int i = 0; i < level.getMaximumPlayers(); i++) {
            state.setPlayerGameInfo(i, level.getPlayerStartPosition(i).x, level.getPlayerStartPosition(i).y, level.getPlayerColorType(i));
        }
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
}
