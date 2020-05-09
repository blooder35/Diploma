package com.diploma.project.multiplayer.client;

import com.diploma.project.multiplayer.common.CommonMultiplayerThread;
import java.net.Socket;
import java.net.SocketException;

public class ClientThread extends CommonMultiplayerThread {

    public ClientThread(Socket socket) throws SocketException {
        super(socket, "ClientThread");
    }
}
