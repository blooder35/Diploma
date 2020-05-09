package com.diploma.project.multiplayer.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Поток сервера отвечающий за подключение новых клиентов и создание соединения.
 */
public class ServerThread extends Thread {
    private AtomicBoolean listening;
    private List<ServerClientThread> clients;
    ServerSocket serverSocket;

    public ServerThread(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        this.listening = new AtomicBoolean(true);
        this.clients = new ArrayList<ServerClientThread>();
    }

    @Override
    public void run() {
        while (listening.get() && clients.size() < ServerConstants.MAXIMUM_PLAYERS) {
            try {
                ServerClientThread newPlayerThread = new ServerClientThread(serverSocket.accept());
                clients.add(newPlayerThread);
                newPlayerThread.start();
            } catch (IOException e) {
                //todo do nothing here just debug
                System.out.println("Server accept hanged out of time");
            }
        }
        //todo check and delete
        System.out.println("SERVER STOPPED LISTENING FOR A NEW PLAYERS");
    }

    public void setListening(boolean listening) {
        this.listening.lazySet(listening);
    }

    public List<ServerClientThread> getClients() {
        return clients;
    }
}
