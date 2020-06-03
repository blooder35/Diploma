package com.diploma.project.multiplayerImpl.communication.messages.client.game;

/**
 * Сообщение игрового цилка клиента
 */
public class GameCycleClientGameMessage extends GameGameMessage {
    private float vectorX;
    private float vectorY;
    private boolean interacting;

    public GameCycleClientGameMessage() {
    }

    /**
     * Конструктор
     *
     * @param vectorX     компонента x вектора передвижения игрока
     * @param vectorY     компонента y вектора передвижения игрока
     * @param interacting производит ли пользователь взаимодействие (true\false)
     */
    public GameCycleClientGameMessage(float vectorX, float vectorY, boolean interacting) {
        this.vectorX = vectorX;
        this.vectorY = vectorY;
        this.interacting = interacting;
    }

    /**
     * @return x компонента вектора передвижения игрока
     */
    public float getVectorX() {
        return vectorX;
    }

    /**
     * @return y компонента вектора передвижения игрока
     */
    public float getVectorY() {
        return vectorY;
    }

    /**
     * @return true - пользователь совершает взаимодействие, false - не совершает
     */
    public boolean isInteracting() {
        return interacting;
    }
}
