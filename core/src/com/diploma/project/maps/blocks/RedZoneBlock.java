package com.diploma.project.maps.blocks;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.collision.ColorChangingZoneCollision;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.Resources;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerAttributes;

/**
 * Блок карты для смены цвета красный
 */
public class RedZoneBlock extends InteractingMapBlock {

    /**
     * Конструктор
     *
     * @param position вектор - координаты левого нижнего угла колизии
     */
    public RedZoneBlock(Vector2 position) {
        super(false, position, new ColorChangingZoneCollision(position), Resources.Game.RED_ZONE_BLOCK, ColorType.NONE);
    }

    @Override
    public void interact(PlayerAttributes attr) {
        attr.setColorType(ColorType.RED);
    }
}
