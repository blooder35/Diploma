package com.diploma.project.multiplayerImpl.communication.messages.client.game;

public class GameCycleClientGameMessage extends GameGameMessage {
    private float vectorX;
    private float vectorY;
    private boolean interacting;

    public GameCycleClientGameMessage() {
    }

    public GameCycleClientGameMessage(float vectorX, float vectorY, boolean interacting) {
        this.vectorX = vectorX;
        this.vectorY = vectorY;
        this.interacting = interacting;
    }

    public float getVectorX() {
        return vectorX;
    }

    public float getVectorY() {
        return vectorY;
    }

    public boolean isInteracting() {
        return interacting;
    }
}
