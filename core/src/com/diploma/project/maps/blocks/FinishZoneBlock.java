package com.diploma.project.maps.blocks;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.collision.LargeBlockCollision;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.Resources;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerAttributes;

/**
 * Блок карты - финиш
 */
public class FinishZoneBlock extends InteractingMapBlock {
    ColorType previousColorType;
    boolean spotIsFree;

    /**
     * Конструктор
     *
     * @param position координата вектор левого нижнего угла блока
     */
    public FinishZoneBlock(Vector2 position) {
        super(false, position, new LargeBlockCollision(position), Resources.Game.FINISH_ZONE_BLOCK, ColorType.NONE);
        previousColorType = ColorType.NONE;
        spotIsFree = true;
    }

    @Override
    public void interact(PlayerAttributes attr) {
        if (!attr.isFinished() && spotIsFree) {
            previousColorType = attr.getColorType();
            attr.setColorType(ColorType.WHITE);
            spotIsFree = false;
            attr.setFinished(true);
        } else if (attr.getColorType() == ColorType.WHITE) {
            spotIsFree = true;
            attr.setColorType(previousColorType);
            attr.setFinished(false);
        }
    }
}
