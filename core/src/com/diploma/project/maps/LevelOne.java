package com.diploma.project.maps;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.constants.ColorType;
import com.diploma.project.maps.blocks.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOne implements Level {
    private static final int MAXIMUM_PLAYERS = 3;

    private final List<Vector2> playerStartPositions;
    private final List<ColorType> playerStartColorType;
    private final List<MapBlock> mapBlocks;
    private final List<InteractingMapBlock> interactingMapBlocks;

    public LevelOne() {
        //todo встваить рисование зон
        playerStartPositions = new ArrayList<>(MAXIMUM_PLAYERS);
        playerStartPositions.add(0, new Vector2(920, 500));
        playerStartPositions.add(1, new Vector2(760, 500));
        playerStartPositions.add(2, new Vector2(1080, 500));
        playerStartColorType = new ArrayList<>(MAXIMUM_PLAYERS);
        for (int i = 0; i < MAXIMUM_PLAYERS; i++) {
            playerStartColorType.add(ColorType.BLACK);
        }

        interactingMapBlocks = new LinkedList<>();
        interactingMapBlocks.add(new RedZoneBlock(new Vector2(160, 780)));
        interactingMapBlocks.add(new GreenZoneBlock(new Vector2(160, 140)));
        interactingMapBlocks.add(new BlueZoneBlock(new Vector2(1600, 780)));
        interactingMapBlocks.add(new CyanZoneBlock(new Vector2(1600, 140)));
        interactingMapBlocks.add(new FinishZoneBlock(new Vector2(80, 460)));
        interactingMapBlocks.add(new FinishZoneBlock(new Vector2(880, 860)));
        interactingMapBlocks.add(new FinishZoneBlock(new Vector2(1680, 460)));

        mapBlocks = new LinkedList<>();
        int x = 1840;
        while (x >= 0) {
            mapBlocks.add(new MediumMapBlock(new Vector2(x, 1020)));
            x -= 80;
        }
        mapBlocks.add(new RedSmallTransparentBlock(new Vector2(280, 580)));
        mapBlocks.add(new RedSmallTransparentBlock(new Vector2(280, 540)));
        mapBlocks.add(new RedSmallTransparentBlock(new Vector2(280, 500)));
        mapBlocks.add(new RedSmallTransparentBlock(new Vector2(280, 460)));
        mapBlocks.add(new MediumMapBlock(new Vector2(240, 380)));
        mapBlocks.add(new MediumMapBlock(new Vector2(240, 620)));
        mapBlocks.add(new MediumMapBlock(new Vector2(160, 380)));
        mapBlocks.add(new MediumMapBlock(new Vector2(160, 620)));
        mapBlocks.add(new MediumMapBlock(new Vector2(80, 380)));
        mapBlocks.add(new MediumMapBlock(new Vector2(80, 620)));
        int y = 940;
        while (y >= -20) {
            mapBlocks.add(new MediumMapBlock(new Vector2(1840, y)));
            y -= 80;
        }
        mapBlocks.add(new MediumMapBlock(new Vector2(1040, 940)));
        mapBlocks.add(new MediumMapBlock(new Vector2(1040, 860)));
        mapBlocks.add(new MediumMapBlock(new Vector2(1040, 780)));
        mapBlocks.add(new GreenSmallTransparentBlock(new Vector2(1000, 780)));
        mapBlocks.add(new GreenSmallTransparentBlock(new Vector2(960, 780)));
        mapBlocks.add(new GreenSmallTransparentBlock(new Vector2(920, 780)));
        mapBlocks.add(new GreenSmallTransparentBlock(new Vector2(880, 780)));
        mapBlocks.add(new MediumMapBlock(new Vector2(800, 940)));
        mapBlocks.add(new MediumMapBlock(new Vector2(800, 860)));
        mapBlocks.add(new MediumMapBlock(new Vector2(800, 780)));
        y = 940;
        while (y > -20) {
            mapBlocks.add(new MediumMapBlock(new Vector2(0, y)));
            y -= 80;
        }
        mapBlocks.add(new MediumMapBlock(new Vector2(1760, 380)));
        mapBlocks.add(new MediumMapBlock(new Vector2(1760, 620)));
        mapBlocks.add(new MediumMapBlock(new Vector2(1680, 380)));
        mapBlocks.add(new MediumMapBlock(new Vector2(1680, 620)));
        mapBlocks.add(new MediumMapBlock(new Vector2(1600, 620)));
        mapBlocks.add(new BlueSmallTransparentBlock(new Vector2(1600, 580)));
        mapBlocks.add(new BlueSmallTransparentBlock(new Vector2(1600, 540)));
        mapBlocks.add(new BlueSmallTransparentBlock(new Vector2(1600, 500)));
        mapBlocks.add(new BlueSmallTransparentBlock(new Vector2(1600, 460)));
        mapBlocks.add(new MediumMapBlock(new Vector2(1600, 380)));
        x = 1840;
        while (x >= 0) {
            mapBlocks.add(new MediumMapBlock(new Vector2(x, -20)));
            x -= 80;
        }
    }

    @Override
    public Vector2 getPlayerStartPosition(int playerIndex) {
        return playerStartPositions.get(playerIndex);
    }

    @Override
    public int getMaximumPlayers() {
        return MAXIMUM_PLAYERS;
    }

    public List<MapBlock> getMapBlocks() {
        return mapBlocks;
    }

    @Override
    public ColorType getPlayerColorType(int playerIndex) {
        return playerStartColorType.get(playerIndex);
    }

    @Override
    public List<InteractingMapBlock> getInteractingMapBlocks() {
        return interactingMapBlocks;
    }
}
