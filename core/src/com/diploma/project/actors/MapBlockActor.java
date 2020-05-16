package com.diploma.project.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.diploma.project.maps.blocks.MapBlock;

public class MapBlockActor extends Actor {
    private MapBlock block;
    private Texture texture;

    public MapBlockActor(MapBlock block) {
        this.block = block;
        this.texture = new Texture(block.getTexturePath());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, block.getPosition().x, block.getPosition().y);
    }
}
