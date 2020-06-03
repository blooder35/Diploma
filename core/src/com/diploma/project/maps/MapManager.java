package com.diploma.project.maps;

import java.util.ArrayList;
import java.util.List;

/**
 * Менеджер, для загрузки карт
 */
public class MapManager {
    private static final MapManager INSTANCE = new MapManager();
    List<Level> maps;

    private MapManager() {
        maps = new ArrayList<>();
        maps.add(new LevelOne());
    }

    /**
     * @return экземпляр менеджера, для загрузки карт
     */
    public static MapManager getInstance() {
        return INSTANCE;
    }

    /**
     * Получить карту по идентификатору уровня игры
     *
     * @param index идентификатор уровня
     * @return карта уровня
     */
    public Level getLevel(int index) {
        switch (index) {
            case 1:
                return maps.get(0);
            default:
                System.out.println("Unrecognized map index:" + index);
                return null;
        }
    }
}
