package com.diploma.project.multiplayerImpl.communication.messages.server.game;

import com.diploma.project.constants.ColorType;
import com.diploma.project.multiplayer.configuration.Configuration;
import com.diploma.project.multiplayerImpl.communication.ApplicationState;
import com.diploma.project.multiplayerImpl.communication.messages.ServerGameMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Сообщение состояния пользователей в игре
 * Класс служит одновременно и для отправки сообщений сервером и для храненеия текущего состояния игроков во время игры
 * Для изменения состояния пользователей использовать класс {@link GameStateMessageServerChanger}
 */
public class GameStateGameMessage extends ServerGameMessage {
    private List<com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerGameInfo> playerGameInfo;
    private boolean levelFinished;

    /**
     * Конструктор
     */
    public GameStateGameMessage() {
        playerGameInfo = new ArrayList<>(Configuration.getInstance().getMaximumAllowedClients());
        for (int i = 0; i < Configuration.getInstance().getMaximumAllowedClients(); i++) {
            playerGameInfo.add(new com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerGameInfo(0, 0, ColorType.NONE));
        }
        levelFinished = false;
    }

    /**
     * Установить состояние игрока по идентификатору
     *
     * @param index     идентификатор игрока
     * @param posX      x позиции игрока
     * @param postY     y позиции игрока
     * @param colorType тип цвета пользователя
     */
    public void setPlayerGameInfo(int index, float posX, float postY, ColorType colorType) {
        playerGameInfo.set(index, new com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerGameInfo(posX, postY, colorType));
    }

    /**
     * @return список состояний всех игроков
     */
    public List<PlayerGameInfo> getPlayerGameInfoList() {
        return playerGameInfo;
    }

    @Override
    public ApplicationState getMessageState() {
        return ApplicationState.IN_GAME;
    }

    /**
     * @return true - уровень пройден, false - уровень не пройдён
     */
    public boolean isLevelFinished() {
        return levelFinished;
    }

    /**
     * Установить пройден ли уровень
     *
     * @param levelFinished флаг, того пройден ли уровень
     */
    public void setLevelFinished(boolean levelFinished) {
        this.levelFinished = levelFinished;
    }
}
