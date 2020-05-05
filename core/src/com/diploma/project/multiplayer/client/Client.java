package com.diploma.project.multiplayer.client;

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
        clientThread.interrupt();
        started = false;
    }

    public boolean isStarted() {
        return started;
    }
}
