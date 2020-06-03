package com.diploma.project.collision;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.constants.GameConstants;

/**
 * Колизия среднего блока
 */
public class MediumBlockCollision extends Collision {
    /**
     * Конструктор
     *
     * @param position вектор - координаты левого нижнего угла колизии
     */
    public MediumBlockCollision(Vector2 position) {
        super(position.x, position.y, GameConstants.MEDIUM_BLOCK_WIDTH, GameConstants.MEDIUM_BLOCK_HEIGHT, CollisionType.RECTANGLE);
    }
}
