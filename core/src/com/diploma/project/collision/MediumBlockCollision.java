package com.diploma.project.collision;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.constants.GameConstants;

public class MediumBlockCollision extends Collision {
    public MediumBlockCollision(Vector2 posistion) {
        super(posistion.x,posistion.y, GameConstants.MEDIUM_BLOCK_WIDTH, GameConstants.MEDIUM_BLOCK_HEIGHT, CollisionType.RECTANGLE);
    }
}
