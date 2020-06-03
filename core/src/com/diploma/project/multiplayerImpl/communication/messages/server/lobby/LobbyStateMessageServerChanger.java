package com.diploma.project.multiplayerImpl.communication.messages.server.lobby;

/**
 * Класс для изменения состояний игроков в лобби
 */
public class LobbyStateMessageServerChanger {
    private static final LobbyStateMessageServerChanger INSTANCE = new LobbyStateMessageServerChanger();
    private com.diploma.project.multiplayerImpl.communication.messages.server.lobby.LobbyStateGameMessage state;

    private LobbyStateMessageServerChanger() {
        this.state = new com.diploma.project.multiplayerImpl.communication.messages.server.lobby.LobbyStateGameMessage();
    }

    /**
     * @return экземпляр класса
     */
    public static LobbyStateMessageServerChanger getInstance() {
        return INSTANCE;
    }

    /**
     * Установить состояние игрока в лобби
     *
     * @param index идентификато игрока
     * @param name  имя игрока
     * @param ready готов ли игрок к началу игры
     */
    public synchronized void setPlayerState(Integer index, String name, boolean ready) {
        state.setPlayerState(index, name, ready);
    }

    /**
     * Изменить состояние начала игры
     *
     * @param gameStarted   флаг того, что игра началась
     * @param selectedLevel идентификатор выбранного уровня
     */
    public synchronized void setGameStarted(Boolean gameStarted, int selectedLevel) {
        state.setGameStarted(gameStarted);
        state.setSelectedLevel(selectedLevel);
    }

    /**
     * Получить текущее состояние лобби
     *
     * @return состояние игроков в лобби
     */
    public LobbyStateGameMessage getCurrentState() {
        return state;
    }
}

