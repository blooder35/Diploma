package com.diploma.project.collision;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.GameConstants;
import com.diploma.project.maps.blocks.InteractingMapBlock;
import com.diploma.project.maps.blocks.MapBlock;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerAttributes;

/**
 * Класс-помощник, для расчёта столкновений объектов
 */
public class CollisionHelper {

    /**
     * Метод, совершающий обработку столкновения как абсолютно упругого
     *
     * @param player       колизия игрока
     * @param wall         блок карты
     * @param posX         координата x игрока
     * @param posY         координата y игрока
     * @param playerVector вектор движения игрока
     * @param colorType    тип цвета игрока
     * @return вектор движения игрока после столкновения
     */
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

    /**
     * Метод, совершающий обработку взаимодействия игрока с объектами карты
     *
     * @param playerAttributes     аттрибуты игрока
     * @param playerCollision      колизия игрока
     * @param interactingMapBlocks блок карты, с которым возможно взаимодействие
     * @param posX                 координата x игрока
     * @param posY                 координата y игрока
     */
    public static void interactingCollision(PlayerAttributes playerAttributes, PlayerCollision playerCollision, InteractingMapBlock interactingMapBlocks, float posX, float posY) {
        playerCollision.setX(posX);
        playerCollision.setY(posY);
        if (interactingMapBlocks.centerInside(playerCollision)) {
            interactingMapBlocks.interact(playerAttributes);
        }
    }
}
