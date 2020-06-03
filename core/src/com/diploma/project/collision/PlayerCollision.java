package com.diploma.project.collision;

import com.diploma.project.constants.GameConstants;

/**
 * Колизия игрока
 */
public class PlayerCollision extends Collision {

    /**
     * Конструктор
     *
     * @param posX координата x левого края колизии
     * @param posY координата y нижнего края колизии
     */
    public PlayerCollision(float posX, float posY) {
        super(posX, posY, GameConstants.PLAYER_WIDTH, CollisionType.CIRCLE);
    }
}
