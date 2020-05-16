package com.diploma.project.collision;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.constants.GameConstants;

//todo возможно переиспользовать экземпляр вместо создания нового?
public class PlayerCollision extends Collision {

    public PlayerCollision(float posX, float posY) {
        super(posX,posY, GameConstants.PLAYER_WIDTH, CollisionType.CIRCLE);
    }
}
