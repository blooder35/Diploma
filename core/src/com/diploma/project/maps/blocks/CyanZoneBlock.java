package com.diploma.project.maps.blocks;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.collision.ColorChangingZoneCollision;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.Resources;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerAttributes;

/**
 * Блок карты зоны для смены цвета саян
 */
public class CyanZoneBlock extends InteractingMapBlock {

    /**
     * Конструктор
     *
     * @param position координата вектор левого нижнего угла блока
     */
    public CyanZoneBlock(Vector2 position) {
        super(false, position, new ColorChangingZoneCollision(position), Resources.Game.CYAN_ZONE_BLOCK, ColorType.NONE);
    }

    @Override
    public void interact(PlayerAttributes attr) {
        attr.setColorType(ColorType.CYAN);
    }
}
