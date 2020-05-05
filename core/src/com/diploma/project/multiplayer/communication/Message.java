package com.diploma.project.multiplayer.communication;

/**
 * Сообщение для отправки серверу
 */
public class Message {
    //todo продумать как туту должно быть
    private String state;
    private String message;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
