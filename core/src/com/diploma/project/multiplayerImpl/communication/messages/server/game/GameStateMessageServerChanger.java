package com.diploma.project.multiplayerImpl.communication.messages.server.game;

import com.diploma.project.constants.ColorType;
import com.diploma.project.maps.Level;
import com.diploma.project.maps.MapManager;

/**
 * Класс, для изменения состояния игроков в игре
 */
public class GameStateMessageServerChanger {
    private static final GameStateMessageServerChanger INSTANCE = new GameStateMessageServerChanger();
    private GameStateGameMessage state;
    private Level level;

    private GameStateMessageServerChanger() {
        this.state = new GameStateGameMessage();
        this.level = null;
    }

    /**
     * @return экземпляр класса
     */
    public static GameStateMessageServerChanger getInstance() {
        return INSTANCE;
    }

    /**
     * Установить состояние игрока по идентификатору
     *
     * @param index     идентификатор игрока
     * @param posX      позиция x игрока
     * @param posY      позиция y игрока
     * @param colorType тип цвета игрока
     */
    public synchronized void setPlayerGameInfo(int index, float posX, float posY, ColorType colorType) {
        state.setPlayerGameInfo(index, posX, posY, colorType);
    }

    /**
     * Получить текущее состояние пользователей
     *
     * @return Текущее состояние пользователей
     */
    public GameStateGameMessage getCurrentState() {
        return state;
    }

    /**
     * Инициализировать состояние игроков начальными значениями из уровня
     *
     * @param selectedLevel идентификатор выбранного уровня
     */
    public void initialize(int selectedLevel) {
        Level level = MapManager.getInstance().getLevel(selectedLevel);
        for (int i = 0; i < level.getMaximumPlayers(); i++) {
            state.setPlayerGameInfo(i, level.getPlayerStartPosition(i).x, level.getPlayerStartPosition(i).y, level.getPlayerColorType(i));
        }
        this.level = level;
    }

    /**
     * @return текущий уровень игры
     */
    public Level getLevel() {
        return level;
    }
}
