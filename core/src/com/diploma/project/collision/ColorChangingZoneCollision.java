package com.diploma.project.collision;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.constants.GameConstants;

public class ColorChangingZoneCollision extends Collision{

    public ColorChangingZoneCollision(Vector2 position) {
        super(position.x, position.y, GameConstants.COLOR_CHANGING_BLOCK_WIDTH, CollisionType.CIRCLE);
    }
}
