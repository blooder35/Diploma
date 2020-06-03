package com.diploma.project.maps.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.diploma.project.collision.LargeBlockCollision;
import com.diploma.project.collision.MediumBlockCollision;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.Resources;

/**
 * Большой блок карты
 */
public class LargeMapBlock extends MapBlock {

    /**
     * Конструктор
     *
     * @param position координата вектор левого нижнего угла блока
     */
    public LargeMapBlock(Vector2 position) {
        super(true, position, new LargeBlockCollision(position), Resources.Game.LARGE_LEVEL_BLOCK, ColorType.NONE);
    }
}
