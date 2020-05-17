package com.diploma.project.collision;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.GameConstants;
import com.diploma.project.maps.blocks.InteractingMapBlock;
import com.diploma.project.maps.blocks.MapBlock;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerAttributes;

public class CollisionHelper {

    //todo возможно сделать похожий для двух игроков?
    public static Vector2 solidWallBounceCollision(Collision player, MapBlock wall, float posX, float posY, Vector2 playerVector, ColorType colorType) {
        player.setX(posX + playerVector.x);
        player.setY(posY + playerVector.y);
        if (wall.colides(player, colorType)) {
            player.setX(posX);
            player.setY(posY + playerVector.y);
            float newVectorX = playerVector.x;
            float newVectorY = playerVector.y;
            if (wall.colides(player, colorType)) {
                newVectorY = -newVectorY;
            }
            player.setX(posX + playerVector.x);
            player.setY(posY);
            if (wall.colides(player, colorType)) {
                newVectorX = -newVectorX;
            }
            return new Vector2(newVectorX * GameConstants.PLAYER_COLLISION_SPEED_COEFFICIENT, newVectorY * GameConstants.PLAYER_COLLISION_SPEED_COEFFICIENT);
        }
        return playerVector;
    }

    public static void interactingCollision(PlayerAttributes playerAttributes, PlayerCollision playerCollision, InteractingMapBlock interactingMapBlocks, float posX, float posY) {
        playerCollision.setX(posX);
        playerCollision.setY(posY);
        if (interactingMapBlocks.centerInside(playerCollision)) {
            interactingMapBlocks.interact(playerAttributes);
        }
    }
}
