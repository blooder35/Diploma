package com.diploma.project.multiplayer.communication.messages.client.game;

public class GameCycleClientMessage extends GameMessage {
    private float vectorX;
    private float vectorY;
    private boolean interacting;

    public GameCycleClientMessage() {
    }

    public GameCycleClientMessage(float vectorX, float vectorY, boolean interacting) {
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
