package com.diploma.project.maps.blocks;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.collision.Collision;
import com.diploma.project.constants.ColorType;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerAttributes;

public abstract class InteractingMapBlock extends MapBlock {

    public InteractingMapBlock(boolean solid, Vector2 position, Collision collision, String texturePath, ColorType colorType) {
        super(solid, position, collision, texturePath, colorType);
    }

    public abstract void interact(PlayerAttributes attr);
}
