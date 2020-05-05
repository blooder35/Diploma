package com.diploma.project.multiplayer;

import com.diploma.project.multiplayer.client.Client;

import java.io.IOException;

public class MainClient {
    private static final String ADDRESS = "127.0.0.1";
    private static final int PORT = 4444;

    public static void main(String[] args) throws Exception {
        Client.getInstance().start(ADDRESS, PORT);
        Client.getInstance().stop();
    }
}
