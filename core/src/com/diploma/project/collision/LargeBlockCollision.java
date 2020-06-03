package com.diploma.project.collision;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.constants.GameConstants;

/**
 * Колизия большого блока
 */
public class LargeBlockCollision extends Collision {
    /**
     * Конструктор
     *
     * @param position вектор - координаты левого нижнего угла колизии
     */
    public LargeBlockCollision(Vector2 position) {
        super(position.x, position.y, GameConstants.LARGE_BLOCK_WIDTH, GameConstants.LARGE_BLOCK_HEIGHT, CollisionType.RECTANGLE);
    }
}
