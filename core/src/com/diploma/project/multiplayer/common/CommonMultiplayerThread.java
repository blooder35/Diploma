package com.diploma.project.multiplayer.common;

import com.diploma.project.multiplayer.server.ServerConstants;
import com.diploma.project.multiplayer.util.CommunicationHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

public class CommonMultiplayerThread extends Thread {
    private Socket socket = null;
    private AtomicBoolean active;
    private Stack<String> messages;
    private PrintWriter out;

    public CommonMultiplayerThread(Socket socket, String threadName) {
        super(threadName);
        this.socket = socket;
        active = new AtomicBoolean(true);
        messages = new Stack<>();
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            this.socket.setSoTimeout(ServerConstants.SOCKET_READ_TIMEOUT);
        } catch (IOException e) {
            active = new AtomicBoolean(false);
        }
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            while (active.get()) {
                try {
                    //todo поток самого чтения сообщений сейчас не закрывается при нажатии кнопки назад
                    String clientMessage = CommunicationHelper.readMessage(in);
                    appendClientMessage(clientMessage);
                } catch (SocketTimeoutException e) {
                    System.out.println(this.getClass() + " readingMessage");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isActive() {
        return active.get();
    }

    public void setActive(boolean active) {
        this.active.set(active);
    }

    public synchronized List<String> getAndClearMessages() {
        //todo нужно подумать над синхронизацией вызова к хранилищу сообщений
        List<String> tmp = new LinkedList<>(messages);
        messages.clear();
        return tmp;
    }

    public void sendMessage(String message) {
        out.print(message);
        out.flush();
    }

    protected void appendClientMessage(String clientMessage) {
        if (messages.size() < ServerConstants.MAXIMUM_MESSAGES_STACK_COUNT) {
            System.out.println("Received message from user");
            messages.push(clientMessage);
        } else {
            System.err.println("Error while adding client message to stack");
        }
    }
}
