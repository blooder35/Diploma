package com.diploma.project.maps.blocks;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.collision.Collision;
import com.diploma.project.collision.EmptyCollision;
import com.diploma.project.collision.LargeBlockCollision;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.Resources;
import com.diploma.project.multiplayer.communication.messages.server.game.PlayerAttributes;

public class FinishZoneBlock extends InteractingMapBlock {

    public FinishZoneBlock(Vector2 position) {
        super(false, position, new LargeBlockCollision(position), Resources.Game.FINISH_ZONE_BLOCK, ColorType.NONE);
    }

    @Override
    public void interact(PlayerAttributes attr) {
        //todo)
    }
}
