package com.diploma.project.multiplayerImpl.communication.messages.server.game;

import com.diploma.project.constants.ColorType;

/**
 * Игровая иноформация игрока
 */
public class PlayerGameInfo {
    float posX;
    float posY;
    ColorType colorType;

    /**
     * Конструктор
     */
    public PlayerGameInfo() {

    }

    /**
     * Конструктор
     *
     * @param posX      позиция x игрока
     * @param posY      позиция y игрока
     * @param colorType тип цвета игрока
     */
    public PlayerGameInfo(float posX, float posY, ColorType colorType) {
        this.posX = posX;
        this.posY = posY;
        this.colorType = colorType;
    }

    /**
     * @return позиция x игрока
     */
    public float getPosX() {
        return posX;
    }

    /**
     * Установить позицию x игрока
     *
     * @return позиция x игрока
     */
    public void setPosX(float posX) {
        this.posX = posX;
    }

    /**
     * @return позиция y игрока
     */
    public float getPosY() {
        return posY;
    }

    /**
     * Установить позицию y игрока
     *
     * @return позиция y игрока
     */
    public void setPosY(float posY) {
        this.posY = posY;
    }

    /**
     * @return тип цвета игрока
     */
    public ColorType getColorType() {
        return colorType;
    }
}
