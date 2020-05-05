package com.diploma.project.multiplayer.server;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Класс отвечающий за создание и хранение подключений пользователей
 * запуск и остановку сервера.
 */
public class Server {
    private AtomicBoolean listening = new AtomicBoolean(true);
    private static volatile Server instance = null;
    private List<ServerClientThread> clients = new ArrayList<>();
    private String serverFullIp;
    private boolean started;

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
        //todo нужно сделать, чтоб сервер запускался в отдельном потоке иначе UI не будет работать
//        try (ServerSocket serverSocket = new ServerSocket(port)) {
//            started = true;
//            serverFullIp = serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort();
//            System.out.println("SocketServer started at " + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort());
//            while (listening.get() && clients.size() < ServerConstants.MAXIMUM_PLAYERS) {
//                ServerClientThread newPlayerThread = new ServerClientThread(serverSocket.accept());
//                clients.add(newPlayerThread);
//                newPlayerThread.start();
//            }
//        }
    }

    public void stop() {
        listening.lazySet(false);
    }

    public boolean isStarted() {
        return started;
    }

    public String getServerFullIp() {
        return serverFullIp;
    }
}
