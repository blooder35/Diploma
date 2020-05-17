package com.diploma.project.multiplayerImpl.communication.messages.server.game;

import com.diploma.project.constants.ColorType;

public class PlayerAttributes {
    ColorType colorType;
    boolean interacting;
    boolean finished;

    public PlayerAttributes(ColorType colorType, boolean interacting) {
        this.colorType = colorType;
        this.interacting = interacting;
        finished = false;
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

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
