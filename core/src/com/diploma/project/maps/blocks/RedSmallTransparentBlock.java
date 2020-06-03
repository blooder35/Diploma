package com.diploma.project.maps.blocks;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.collision.Collision;
import com.diploma.project.collision.SmallBlockCollision;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.Resources;

/**
 * Красный маленький прозрачный блок карты
 */
public class RedSmallTransparentBlock extends MapBlock {

    /**
     * Конструктор
     *
     * @param position вектор - координаты левого нижнего угла колизии
     */
    public RedSmallTransparentBlock(Vector2 position) {
        super(true, position, new SmallBlockCollision(position), Resources.Game.RED_SMALL_LEVEL_BLOCK, ColorType.RED);
    }
}
