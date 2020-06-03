package com.diploma.project.screens.storage;

import com.badlogic.gdx.graphics.Texture;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.Resources;

import java.util.HashMap;
import java.util.Map;

/**
 * Хранилище текстур для игрока
 */
public class PlayerTextureStorage {
    Map<ColorType, Texture> playerTextures;

    /**
     * Конструктор
     */
    public PlayerTextureStorage() {
        playerTextures = new HashMap<>();
        playerTextures.put(ColorType.WHITE, new Texture(Resources.Game.WHITE_PLAYER_CIRCLE_IMAGE));
        playerTextures.put(ColorType.RED, new Texture(Resources.Game.RED_PLAYER_CIRCLE_IMAGE));
        playerTextures.put(ColorType.GREEN, new Texture(Resources.Game.GREEN_PLAYER_CIRCLE_IMAGE));
        playerTextures.put(ColorType.BLUE, new Texture(Resources.Game.BLUE_PLAYER_CIRCLE_IMAGE));
        playerTextures.put(ColorType.CYAN, new Texture(Resources.Game.CYAN_PLAYER_CIRCLE_IMAGE));
        playerTextures.put(ColorType.MAGENTA, new Texture(Resources.Game.MAGENTA_PLAYER_CIRCLE_IMAGE));
        playerTextures.put(ColorType.YELLOW, new Texture(Resources.Game.YELLOW_PLAYER_CIRCLE_IMAGE));
        playerTextures.put(ColorType.BLACK, new Texture(Resources.Game.BLACK_PLAYER_CIRCLE_IMAGE));
    }

    /**
     * Получить текстуру по типу цвета
     *
     * @param colorType тип цвета
     * @return текстура, готовая к отрисовке
     */
    public Texture getPlayerTexture(ColorType colorType) {
        return playerTextures.get(colorType);
    }
}
