package com.diploma.project.maps.blocks;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.collision.Collision;
import com.diploma.project.constants.ColorType;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerAttributes;

/**
 * Блок карты, с которым возможно взаимодействие
 */
public abstract class InteractingMapBlock extends MapBlock {

    /**
     * Конструктор
     *
     * @param solid       возможно ли столкновение с объектом
     * @param position    координата-вектор левого нижнего края блока
     * @param collision   колизия блока
     * @param texturePath путь к ресурсу текстуры блока
     * @param colorType   тип цвета блока
     */
    public InteractingMapBlock(boolean solid, Vector2 position, Collision collision, String texturePath, ColorType colorType) {
        super(solid, position, collision, texturePath, colorType);
    }

    /**
     * Обработка взаимодействия с блоком карты
     *
     * @param attr аттрибуты игрока, который совершает взаимодействие
     */
    public abstract void interact(PlayerAttributes attr);
}
