package com.diploma.project.multiplayer.server;

public class ServerConstants {
    private ServerConstants() {

    }

    public static final String LOCALHOST = "127.0.0.1";
    public static final int SERVER_INPUT_BUFFER_SIZE = 200;
    public static final int MAXIMUM_PLAYERS = 3;
    public static final int MAXIMUM_MESSAGES_STACK_COUNT = 10;
    public static final int SOCKET_ACCEPT_TIMEOUT = 1000;
    public static final int SOCKET_READ_TIMEOUT = 1000;
    //todo в бою должно быть 17
    public static final long SERVER_PROCESSING_CYCLE_TIME = 1000;
}
