package com.diploma.project.collision;

import com.diploma.project.constants.GameConstants;

public class PlayerCollision extends Collision {

    public PlayerCollision(float posX, float posY) {
        super(posX,posY, GameConstants.PLAYER_WIDTH, CollisionType.CIRCLE);
    }
}
