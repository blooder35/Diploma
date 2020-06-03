package com.diploma.project.multiplayerImpl.communication.messages.server.lobby;

import com.diploma.project.multiplayer.configuration.Configuration;
import com.diploma.project.multiplayerImpl.communication.ApplicationState;
import com.diploma.project.multiplayerImpl.communication.messages.ServerGameMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Сообщение о состоянии игроков в лобби
 * Класс служит одновременно и для отправки сообщений сервером и для храненеия текущего состояния игроков в лобби
 * Для взаимодействия использовать класс {@link LobbyStateMessageServerChanger}
 */
public class LobbyStateGameMessage extends ServerGameMessage {
    private List<PlayerState> playerStates;
    private boolean gameStarted;
    private int selectedLevel;
    private int playerId;

    /**
     * Конструктор
     */
    public LobbyStateGameMessage() {
        playerStates = new ArrayList<>(Configuration.getInstance().getMaximumAllowedClients());
        for (int i = 0; i < Configuration.getInstance().getMaximumAllowedClients(); i++) {
            playerStates.add(null);
        }
    }

    /**
     * Установить состояние игрока в лобби
     *
     * @param index идентификатор игрока
     * @param name  имя игрока
     * @param ready указатель того, что игрок готов
     */
    void setPlayerState(Integer index, String name, boolean ready) {
        playerStates.set(index, new PlayerState(name, ready));
    }

    /**
     * Установить флаг того, что игра началась
     *
     * @param gameStarted true - игра началась, false - нет
     */
    void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    /**
     * Установить идентификатор выбранного уровня
     *
     * @param selectedLevel идентификатор выбранного уровня
     */
    void setSelectedLevel(int selectedLevel) {
        this.selectedLevel = selectedLevel;
    }

    /**
     * Получение состояния игрока по идентификатору
     *
     * @param index идентификатор игрока
     * @return состояние игрока
     */
    public PlayerState getPlayerState(Integer index) {
        return playerStates.get(index);
    }

    /**
     * Получить флаг того, что игра началась
     *
     * @return true - игра началась, false - нет
     */
    public boolean isGameStarted() {
        return gameStarted;
    }

    /**
     * получить иднетификатор выбранного уровня
     *
     * @return идентификатор выбранного уровня
     */
    public int getSelectedLevel() {
        return selectedLevel;
    }

    @Override
    public com.diploma.project.multiplayerImpl.communication.ApplicationState getMessageState() {
        return ApplicationState.LOBBY_MENU;
    }
}
