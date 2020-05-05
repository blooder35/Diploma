package com.diploma.project.multiplayer.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Stack;

public class ServerClientThread extends Thread {
    private Socket socket = null;
    private boolean active = false;
    private Stack<String> messages;

    public ServerClientThread(Socket socket) {
        super("ServerClientThread");
        this.socket = socket;
        active = true;
        messages = new Stack<>();
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            while (true) {
                String clientMessage = readClientMessage(in);
                appendClientMessage(clientMessage);
            }
        } catch (IOException e) {
            active = false;
            e.printStackTrace();
        }
    }

    public boolean isActive() {
        return active;
    }

    public Stack<String> getMessages() {
        //todo нужно подумать над синхронизацией вызова к хранилищу сообщений
        return messages;
    }

    private String readClientMessage(BufferedReader in) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] inputBuffer = new char[ServerConstants.SERVER_INPUT_BUFFER_SIZE];
        int i = in.read(inputBuffer);
        if (i == -1) {
            throw new IOException("Client closed the connection");
        } else {
            while (i > 0) {
                sb.append(new String(inputBuffer));
                if (i > inputBuffer.length) {
                    i = in.read(inputBuffer);
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }

    private void appendClientMessage(String clientMessage) {
        //todo возможно нужна будет синхронизация (т.к. получение из места обсчёта логики будет из другого потока)
        if (messages.size() < ServerConstants.MAXIMUM_MESSAGES_STACK_COUNT) {
            System.out.println("Получено сообщение от пользователя");
            messages.push(clientMessage);
        } else {
            System.err.println("Ошибка при записи сообщения пользователя в стек: стек переполнен, сообщение отброшено");
        }
    }
}
