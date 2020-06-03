package com.diploma.project.multiplayerImpl.communication;

/**
 * Возможные состояния пользователей (приложения)
 */
public enum ApplicationState {
    /**
     * В лобби
     */
    LOBBY_MENU("Lobby"),
    /**
     * В игре
     */
    IN_GAME("inGame");

    private String value;

    ApplicationState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
