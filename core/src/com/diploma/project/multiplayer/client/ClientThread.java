package com.diploma.project.multiplayer.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        super("ClientThread");
        this.socket = socket;
    }
    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out.println("YO MATE");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
