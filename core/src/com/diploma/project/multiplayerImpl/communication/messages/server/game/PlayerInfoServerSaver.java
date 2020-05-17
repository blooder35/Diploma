package com.diploma.project.multiplayerImpl.communication.messages.server.game;

import com.badlogic.gdx.math.Vector2;
import com.diploma.project.constants.ColorType;
import com.diploma.project.maps.Level;
import com.diploma.project.maps.MapManager;
import com.diploma.project.multiplayer.configuration.Configuration;

import java.util.ArrayList;
import java.util.List;

public class PlayerInfoServerSaver {
    private static final PlayerInfoServerSaver INSTANCE = new PlayerInfoServerSaver();
    private List<PlayerAttributes> playerAttributes;
    private List<Vector2> playerVectors;
    private List<Vector2> normalizedPlayerVectors;


    private PlayerInfoServerSaver() {
        playerAttributes = new ArrayList<>(Configuration.getInstance().getMaximumAllowedClients());
        playerVectors = new ArrayList<>(Configuration.getInstance().getMaximumAllowedClients());
        normalizedPlayerVectors = new ArrayList<>(Configuration.getInstance().getMaximumAllowedClients());
        for (int i = 0; i < Configuration.getInstance().getMaximumAllowedClients(); i++) {
            playerAttributes.add(new PlayerAttributes(ColorType.NONE, false));
            playerVectors.add(new Vector2(0, 0));
            normalizedPlayerVectors.add(new Vector2(0, 0));
        }
    }

    public static PlayerInfoServerSaver getInstance() {
        return INSTANCE;
    }

    public Vector2 addPlayerVector(int index, float vectorX, float vectorY) {
        return playerVectors.get(index).add(vectorX, vectorY);
    }

    public Vector2 getPlayerVectorAndClear(int index) {
        Vector2 playerVector = new Vector2(playerVectors.get(index));
        resetPlayerVector(index);
        return playerVector;
    }

    public Vector2 addNormalizedPlayerVector(int index, Vector2 vector) {
        return normalizedPlayerVectors.get(index).add(vector);
    }

    public Vector2 setNormalizedPlayerVector(int index, Vector2 vector) {
        return normalizedPlayerVectors.get(index).set(vector);
    }

    public void setPlayerInteracting(int index) {
        playerAttributes.get(index).setInteracting(true);
    }

    public PlayerAttributes getPlayerAttributes(int index) {
        return playerAttributes.get(index);
    }

    public void initialize(int currentLevel) {
        Level level = MapManager.getInstance().getLevel(currentLevel);
        for (int i = 0; i < level.getMaximumPlayers(); i++) {
            playerAttributes.set(i, new PlayerAttributes(level.getPlayerColorType(i), false));
        }
    }

    private void resetPlayerVector(int index) {
        playerVectors.get(index).set(0, 0);
    }
}
