package com.diploma.project.multiplayer.communication.messages.server.game;

import com.diploma.project.constants.ColorType;

public class PlayerAttributes {
    ColorType colorType;
    boolean interacting;

    public PlayerAttributes(ColorType colorType, boolean interacting) {
        this.colorType = colorType;
        this.interacting = interacting;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public boolean isInteracting() {
        return interacting;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

    public void setInteracting(boolean interacting) {
        this.interacting = interacting;
    }
}
