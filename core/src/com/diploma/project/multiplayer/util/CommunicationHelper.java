package com.diploma.project.multiplayer.util;

import com.diploma.project.multiplayer.server.ServerConstants;

import java.io.BufferedReader;
import java.io.IOException;

public class CommunicationHelper {

    public static String readMessage(BufferedReader in) throws IOException {
        StringBuilder sb = new StringBuilder();
        int value;
        while ((value = in.read()) != -1) {
            if (value == (int) ServerConstants.MESSAGE_ESCAPE_CHARACTER) {
                in.mark(0);
                in.reset();
                return sb.toString();
            }
            sb.append((char) value);
        }
        throw new IOException("Client closed the connection");
    }
}
