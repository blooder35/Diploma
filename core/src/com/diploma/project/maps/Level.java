package com.diploma.project.maps;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.constants.ColorType;
import com.diploma.project.maps.blocks.InteractingMapBlock;
import com.diploma.project.maps.blocks.MapBlock;

import java.util.List;

public interface Level {
    Vector2 getPlayerStartPosition(int playerIndex);
    ColorType getPlayerColorType(int playerIndex);
    int getMaximumPlayers();
    List<MapBlock> getMapBlocks();
    List<InteractingMapBlock> getInteractingMapBlocks();
}
