package com.diploma.project.maps.blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.diploma.project.collision.Collision;
import com.diploma.project.constants.ColorType;

public class MapBlock {
    private boolean solid;
    private Vector2 position;
    private Collision collision;
    private ColorType colorType;
    private String texturePath;

    public MapBlock(boolean solid, Vector2 position, Collision collision, String texturePath, ColorType colorType) {
        this.solid = solid;
        this.position = position;
        this.collision = collision;
        this.texturePath = texturePath;
        this.colorType = colorType;
    }

    /**
     * Просто наличие пересечения
     */
    private boolean colides(Collision collision) {
        return this.collision.colides(collision);
    }

    /**
     * C проверкой solid и цвета
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
     * Возвращает признак того, что аргумента принадлежит текущей
    */
    public boolean centerInside(Collision collision) {
        return this.collision.inside(collision);
    }

    public String getTexturePath() {
        return texturePath;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Collision getCollision() {
        return collision;
    }
}
