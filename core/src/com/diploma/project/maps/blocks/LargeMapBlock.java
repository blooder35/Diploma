package com.diploma.project.maps.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.diploma.project.collision.LargeBlockCollision;
import com.diploma.project.collision.MediumBlockCollision;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.Resources;

public class LargeMapBlock extends MapBlock {

    public LargeMapBlock(Vector2 position) {
        super(true, position, new LargeBlockCollision(position),Resources.Game.LARGE_LEVEL_BLOCK, ColorType.NONE);
    }
}
