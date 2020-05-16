package com.diploma.project.multiplayer.server;

import com.diploma.project.multiplayer.communication.ApplicationState;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс отвечающий за создание и хранение подключений пользователей
 * запуск и остановку сервера.
 */
public class Server {
    private static volatile Server instance = null;
    private String serverFullIp;
    private boolean started;
    private ServerThread serverThread;
    private ServerProcessingThread serverProcessingThread;

    private Server() {
    }

    public static Server getInstance() {
        if (instance == null) {
            synchronized (Server.class) {
                if (instance == null) {
                    instance = new Server();
                }
            }
        }
        return instance;
    }

    public void start(int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        started = true;
        serverFullIp = serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort();
        System.out.println("SocketServer started at " + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort());
        serverSocket.setSoTimeout(ServerConstants.SOCKET_ACCEPT_TIMEOUT);
        serverThread = new ServerThread(serverSocket);
        serverThread.start();
        serverProcessingThread = new ServerProcessingThread(ApplicationState.LOBBY_MENU);
        serverProcessingThread.start();
    }

    public void stop() {
        serverThread.setListening(false);
        try {
            // закрываем сокет сервер в этом случае
            serverThread.serverSocket.close();
            started = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isStarted() {
        return started;
    }

    public String getServerFullIp() {
        return serverFullIp;
    }

    public List<String> getClientMessages() {
        List<String> list = new LinkedList<>();
        for (ServerClientThread client : serverThread.getClients()) {
            list.addAll(client.getAndClearMessages());
        }
        return list;
    }

    public void sendMessageToAll(String message) {
        for (ServerClientThread client : serverThread.getClients()) {
            client.sendMessage(message);
        }
    }
}
