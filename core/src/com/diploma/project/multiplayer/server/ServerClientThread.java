package com.diploma.project.multiplayer.server;

import com.diploma.project.multiplayer.common.CommonMultiplayerThread;
import java.net.Socket;

public class ServerClientThread extends CommonMultiplayerThread {

    public ServerClientThread(Socket socket) {
        super(socket,"ServerClientThread");
    }
}
