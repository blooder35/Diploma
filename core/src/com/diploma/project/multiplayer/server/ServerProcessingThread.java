package com.diploma.project.multiplayer.server;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.TimeUtils;
import com.diploma.project.multiplayer.communication.CommunicationMessage;

import java.util.List;

public class ServerProcessingThread extends Thread {

    @Override
    public void run() {
        while (Server.getInstance().isStarted()) {
            long startTime = TimeUtils.millis();
            //todo вернуть вызов обратно в скобки
            List<String> temp = Server.getInstance().getClientMessages();
            System.out.println(temp.size());
            processMessages(temp);
            long delta = TimeUtils.timeSinceMillis(startTime);
            if (delta < ServerConstants.SERVER_PROCESSING_CYCLE_TIME) {
                try {
                    sleep(ServerConstants.SERVER_PROCESSING_CYCLE_TIME - delta);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void processMessages(List<String> messages) {
        //todo implementation of message reading
        for (String message : messages) {
            System.out.println("Got a message" + message);
            CommunicationMessage.serverProcess(message);
        }
    }
}
