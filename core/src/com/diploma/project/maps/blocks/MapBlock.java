package com.diploma.project.maps.blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.diploma.project.collision.Collision;
import com.diploma.project.constants.ColorType;

/**
 * Блок карты
 */
public class MapBlock {
    private boolean solid;
    private Vector2 position;
    private Collision collision;
    private ColorType colorType;
    private String texturePath;

    /**
     * Конструктор
     *
     * @param solid       возможно ли столкновение с объектом
     * @param position    координата-вектор левого нижнего края блока
     * @param collision   колизия блока
     * @param texturePath путь к ресурсу текстура блока
     * @param colorType   тип цвета блока
     */
    public MapBlock(boolean solid, Vector2 position, Collision collision, String texturePath, ColorType colorType) {
        this.solid = solid;
        this.position = position;
        this.collision = collision;
        this.texturePath = texturePath;
        this.colorType = colorType;
    }

    /**
     * Проверка наличия только пересечения
     *
     * @param collision колизия, с которой совершается проверка
     * @return true - пересечение есть, false - пересечения нет
     */
    private boolean colides(Collision collision) {
        return this.collision.colides(collision);
    }

    /**
     * Проверка наличия пересечения с учётом типа цвета
     *
     * @param collision колизия, с которой совершается проверка
     * @param type      тип цвета
     * @return true - пересечение есть, false - пересечения нет
     */
    public boolean colides(Collision collision, ColorType type) {
        if (solid) {
            if (type == this.colorType) {
                return false;
            }
            return colides(collision);
        }
        return false;
    }

    /**
     * Проверка находится ли колизия внутри другой (необходима для проверки возможности взаимодействия)
     *
     * @param collision колизия, с которой совершается проверка
     * @return true - находится, false - не находится
     */
    public boolean centerInside(Collision collision) {
        return this.collision.inside(collision);
    }

    /**
     * @return Путь к ресурсу текстуры
     */
    public String getTexturePath() {
        return texturePath;
    }

    /**
     * @return координата вектор левого нижнего края блока
     */
    public Vector2 getPosition() {
        return position;
    }

    /**
     * @return колизия блока карты
     */
    public Collision getCollision() {
        return collision;
    }
}
