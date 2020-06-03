package com.diploma.project.multiplayerImpl.communication.messages.server.game;

import com.diploma.project.constants.ColorType;

/**
 * Аттрибуты игрока
 */
public class PlayerAttributes {
    ColorType colorType;
    boolean interacting;
    boolean finished;

    /**
     * Конструктор
     *
     * @param colorType   тип цвета
     * @param interacting указатель того, что пользователь взаимодействует
     */
    public PlayerAttributes(ColorType colorType, boolean interacting) {
        this.colorType = colorType;
        this.interacting = interacting;
        finished = false;
    }

    /**
     * @return тип цвета игрока
     */
    public ColorType getColorType() {
        return colorType;
    }

    /**
     * @return true - пользователь совершает взаимодействие, false - не совершает
     */
    public boolean isInteracting() {
        return interacting;
    }

    /**
     * Установить тип цвета пользователя
     *
     * @param colorType тип цвета
     */
    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

    /**
     * Установить флаг совершения пользователем взаимодействия
     *
     * @param interacting true - пользователь совершает взаимодействие, false - не совершает
     */
    public void setInteracting(boolean interacting) {
        this.interacting = interacting;
    }

    /**
     * Флаг, определяющий, что пользователь финишировал
     *
     * @return true - финишировал, false - не финишировал
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * Установить флаг, определяющий, что пользователь финишировал
     *
     * @param finished true - финишировал, false - не финишировал
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
