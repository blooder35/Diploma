package com.diploma.project.collision;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.constants.GameConstants;

public class LargeBlockCollision extends Collision {
    public LargeBlockCollision(Vector2 posistion) {
        super(posistion.x,posistion.y, GameConstants.LARGE_BLOCK_WIDTH, GameConstants.LARGE_BLOCK_HEIGHT, CollisionType.RECTANGLE);
    }
}
