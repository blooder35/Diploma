package com.diploma.project.maps;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.constants.ColorType;
import com.diploma.project.maps.blocks.InteractingMapBlock;
import com.diploma.project.maps.blocks.MapBlock;

import java.util.List;

/**
 * Уровень игры
 */
public interface Level {
    /**
     * Получить стартовую позицию игрока по индексу
     *
     * @param playerIndex индекс игрока
     * @return координата вектор стартовой позиции игрока
     */
    Vector2 getPlayerStartPosition(int playerIndex);

    /**
     * Получить тип цвета игрока по индексу
     *
     * @param playerIndex индекс игрока
     * @return тип цвета игрока
     */
    ColorType getPlayerColorType(int playerIndex);

    /**
     * Максимальное количество игроков
     *
     * @return число игроков
     */
    int getMaximumPlayers();

    /**
     * Получить список блоков карты
     *
     * @return список блоков карты
     */
    List<MapBlock> getMapBlocks();

    /**
     * Получить список блоков карты, с которыми возможно взаимодействие
     *
     * @return список блоков, с которыми возможно взаимодействие
     */
    List<InteractingMapBlock> getInteractingMapBlocks();
}
