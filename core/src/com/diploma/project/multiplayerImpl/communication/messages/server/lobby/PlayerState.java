package com.diploma.project.multiplayerImpl.communication.messages.server.lobby;

/**
 * Состояние игрока
 */
public class PlayerState {
    private String name;
    private Boolean ready;

    /**
     * Конструктор
     */
    public PlayerState() {
    }

    /**
     * Конструктор
     *
     * @param name  имя игрока
     * @param ready готов ли игрок к началу игры
     */
    public PlayerState(String name, Boolean ready) {
        this.name = name;
        this.ready = ready;
    }

    /**
     * Получить имя игрока
     *
     * @return имя игрока
     */
    public String getName() {
        return name;
    }

    /**
     * Установить имя игрока
     *
     * @param name имя игрока
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получить флаг того, что игрок готов к началу игры
     *
     * @return true - игрок готов к началу игры, false - нет
     */
    public Boolean getReady() {
        return ready;
    }

    /**
     * Установить флаг того, что игрок готов к началу игры
     *
     * @param ready true - игрок готов к началу игры, false - нет
     */
    public void setReady(Boolean ready) {
        this.ready = ready;
    }
}
