package com.diploma.project.multiplayerImpl.communication.messages.server.lobby;

public class PlayerState {
    private String name;
    private Boolean ready;

    public PlayerState() {
    }

    public PlayerState(String name, Boolean ready) {
        this.name = name;
        this.ready = ready;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }
}
