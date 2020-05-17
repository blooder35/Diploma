package com.diploma.project.multiplayerImpl.communication.messages.server.game;

import com.diploma.project.constants.ColorType;

public class PlayerGameInfo {
    float posX;
    float posY;
    ColorType colorType;

    public PlayerGameInfo(){

    }

    public PlayerGameInfo(float posX, float posY, ColorType colorType) {
        this.posX = posX;
        this.posY = posY;
        this.colorType = colorType;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public ColorType getColorType() {
        return colorType;
    }
}
