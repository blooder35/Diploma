package com.diploma.project.multiplayer.client;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Json;
import com.diploma.project.multiplayer.communication.CommunicationMessage;

import java.net.Socket;

public class Client {
    private static volatile Client instance = null;
    private ClientThread clientThread = null;
    private boolean started;

    private Client() {
    }

    public static Client getInstance() {
        if (instance == null) {
            synchronized (Client.class) {
                if (instance == null) {
                    instance = new Client();
                }
            }
        }
        return instance;
    }

    public void start(String address, int port) throws Exception {
        clientThread = new ClientThread(new Socket(address, port));
        clientThread.start();
        started = true;
    }

    public void stop() {
        started = false;
        clientThread.setActive(false);
        clientThread.interrupt();
    }

    public boolean isStarted() {
        return started;
    }

    public void processClientMessages(Screen screen, Json json) {
        for (String message : clientThread.getAndClearMessages()) {
            CommunicationMessage serverMessage = json.fromJson(CommunicationMessage.class, message);
            serverMessage.clientProcess(screen, json);
        }
    }

    public void sendMessage(String message) {
        clientThread.sendMessage(message);
    }
}
