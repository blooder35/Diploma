package com.diploma.project.maps.blocks;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.collision.SmallBlockCollision;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.Resources;

public class BlackSmallTransparentBlock extends MapBlock {

    public BlackSmallTransparentBlock(Vector2 position) {
        super(true, position, new SmallBlockCollision(position), Resources.Game.BLACK_SMALL_LEVEL_BLOCK, ColorType.BLACK);
    }
}
