package com.diploma.project.multiplayer.communication;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import com.diploma.project.multiplayer.client.Client;
import com.diploma.project.multiplayer.server.Server;
import com.diploma.project.screens.LobbyScreen;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.parser.JSONParser;

/**
 * Сообщение для отправки серверу
 */
public class CommunicationMessage {
    //todo продумать как туту должно быть
    private State state;
    private String message;

    public CommunicationMessage() {

    }

    public CommunicationMessage(State state, String message) {
        this.state = state;
        this.message = message;
    }

    public static void serverProcess(String message) {
        Json json = new Json();
        //todo пока что будем просто отправлять сообщение всем пользователям
        Server.getInstance().sendMessageToAll(message);
    }

    public void clientProcess(Screen screen) {
        if (screen instanceof LobbyScreen) {
            ((LobbyScreen) screen).appendInfoMessage(message);
        }
    }

    public void sendToServer() {
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        Client.getInstance().sendMessage(json.toJson(this));
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
