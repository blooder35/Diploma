package com.diploma.project.multiplayer.communication.messages.server.game;

import com.diploma.project.constants.ColorType;
import com.diploma.project.maps.Level;
import com.diploma.project.maps.MapManager;

public class GameStateMessageServerChanger {
    private static final GameStateMessageServerChanger INSTANCE = new GameStateMessageServerChanger();
    private GameStateMessage state;
    private Level level;

    private GameStateMessageServerChanger() {
        this.state = new GameStateMessage();
        this.level = null;
    }

    public static GameStateMessageServerChanger getInstance() {
        return INSTANCE;
    }

    //todo тут было syncronized (убрал для теста)
    public void setPlayerGameInfo(int index, float posX, float posY, ColorType colorType) {
        state.setPlayerGameInfo(index, posX, posY, colorType);
    }

    public GameStateMessage getCurrentState() {
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
