package com.diploma.project.multiplayer.server;

import com.diploma.project.multiplayer.common.CommonMultiplayerThread;

import java.net.Socket;

public class ServerClientThread extends CommonMultiplayerThread {
    private int clientIdentificator;

    public ServerClientThread(Socket socket) {
        super(socket, "ServerClientThread");
    }

    public int getClientIdentificator() {
        return clientIdentificator;
    }

    public void setClientIdentificator(int clientIdentificator) {
        this.clientIdentificator = clientIdentificator;
    }
}
