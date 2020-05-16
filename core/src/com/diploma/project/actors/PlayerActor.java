package com.diploma.project.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.diploma.project.constants.ColorType;

public class PlayerActor extends Actor {
    Texture texture;
    ColorType colorType;

    public PlayerActor(Texture texture, ColorType colorType) {
        this.texture = texture;
        this.colorType = colorType;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY());
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void act(float delta) {

    }

    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }
}
