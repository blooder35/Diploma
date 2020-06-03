package com.diploma.project.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.diploma.project.constants.ColorType;

/**
 * Актёр - игрок
 */
public class PlayerActor extends Actor {
    Texture texture;
    ColorType colorType;

    /**
     * ctor
     *
     * @param texture   текстура для отрисовки
     * @param colorType тип цвета
     */
    public PlayerActor(Texture texture, ColorType colorType) {
        this.texture = texture;
        this.colorType = colorType;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY());
    }

    /**
     * Установить текстуру для отрисовки
     *
     * @param texture текстура для отрисовки
     */
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void act(float delta) {

    }

    /**
     * @return текущий тип цвета актёра - игрока
     */
    public ColorType getColorType() {
        return colorType;
    }

    /**
     * Установить тип цвета актёра - игрока
     *
     * @param colorType тип цвета
     */
    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }
}
