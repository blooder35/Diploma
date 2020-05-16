package com.diploma.project.collision;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.GameConstants;

public class SmallBlockCollision extends Collision {
    public SmallBlockCollision(Vector2 posistion) {
        super(posistion.x,posistion.y, GameConstants.SMALL_BLOCK_WIDTH, GameConstants.SMALL_BLOCK_HEIGHT, CollisionType.RECTANGLE);
    }
}
