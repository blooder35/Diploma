package com.diploma.project.multiplayer.util;

import com.diploma.project.multiplayer.server.ServerConstants;

import java.io.BufferedReader;
import java.io.IOException;

public class CommunicationHelper {

    public static String readMessage(BufferedReader in) throws IOException {
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
        return sb.toString().trim();
    }
}
