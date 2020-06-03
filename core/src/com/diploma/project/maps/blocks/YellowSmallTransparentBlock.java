package com.diploma.project.maps.blocks;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.collision.SmallBlockCollision;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.Resources;

/**
 * Жёлтый маленький прозрачный блок карты
 */
public class YellowSmallTransparentBlock extends MapBlock {

    /**
     * Конструктор
     *
     * @param position вектор - координаты левого нижнего угла колизии
     */
    public YellowSmallTransparentBlock(Vector2 position) {
        super(true, position, new SmallBlockCollision(position), Resources.Game.YELLOW_SMALL_LEVEL_BLOCK, ColorType.YELLOW);
    }
}
