package com.diploma.project.multiplayer.server;

import com.diploma.project.multiplayer.common.CommonMultiplayerThread;

import java.net.Socket;

public class ServerClientThread extends CommonMultiplayerThread {
    private int clientIdentifier;

    public ServerClientThread(Socket socket) {
        super(socket, "ServerClientThread");
    }

    public int getClientIdentifier() {
        return clientIdentifier;
    }

    public void setClientIdentifier(int clientIdentifier) {
        this.clientIdentifier = clientIdentifier;
    }
}
