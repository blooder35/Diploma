package com.diploma.project.collision;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.GameConstants;

/**
 * Колизия для маленького блока
 */
public class SmallBlockCollision extends Collision {
    /**
     * Конструктор
     *
     * @param position вектор - координаты левого нижнего угла колизии
     */
    public SmallBlockCollision(Vector2 position) {
        super(position.x, position.y, GameConstants.SMALL_BLOCK_WIDTH, GameConstants.SMALL_BLOCK_HEIGHT, CollisionType.RECTANGLE);
    }
}
