package com.diploma.project.maps.blocks;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.collision.SmallBlockCollision;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.Resources;

/**
 * Маленький прозрачный блок карты цвета маджента
 */
public class MagentaSmallTransparentBlock extends MapBlock {

    /**
     * Конструктор
     *
     * @param position координата вектор левого нижнего угла блока
     */
    public MagentaSmallTransparentBlock(Vector2 position) {
        super(true, position, new SmallBlockCollision(position), Resources.Game.MAGENTA_SMALL_LEVEL_BLOCK, ColorType.MAGENTA);
    }
}
