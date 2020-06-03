package com.diploma.project.maps.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.diploma.project.collision.MediumBlockCollision;
import com.diploma.project.collision.SmallBlockCollision;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.Resources;

/**
 * Средний блок карты
 */
public class MediumMapBlock extends MapBlock {

    /**
     * Конструктор
     *
     * @param position вектор - координаты левого нижнего угла колизии
     */
    public MediumMapBlock(Vector2 position) {
        super(true, position, new MediumBlockCollision(position), Resources.Game.MEDIUM_LEVEL_BLOCK, ColorType.NONE);
    }
}
