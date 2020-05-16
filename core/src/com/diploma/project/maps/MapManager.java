package com.diploma.project.maps;

import java.util.ArrayList;
import java.util.List;

public class MapManager {
    private static final MapManager INSTANCE = new MapManager();
    List<Level> maps;

    private MapManager() {
        maps = new ArrayList<>();
        maps.add(new LevelOne());
    }

    public static MapManager getInstance() {
        return INSTANCE;
    }

    public Level getLevel(int index) {
        switch (index) {
            //todo карта должна инициализироваться только 1 раз
            case 1: return maps.get(0);
            default:
                System.out.println("Unrecognized map index:" + index);
                return null;
        }
    }
}
