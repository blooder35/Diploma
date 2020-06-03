package com.diploma.project.maps.blocks;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.collision.SmallBlockCollision;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.Resources;

/**
 * Маленький блок карты
 */
public class SmallMapBlock extends MapBlock {

    /**
     * Конструктор
     *
     * @param position вектор - координаты левого нижнего угла колизии
     */
    public SmallMapBlock(Vector2 position) {
        super(true, position, new SmallBlockCollision(position), Resources.Game.SMALL_LEVEL_BLOCK, ColorType.NONE);
    }
}
