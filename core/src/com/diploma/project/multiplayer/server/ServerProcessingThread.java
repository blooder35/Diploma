package com.diploma.project.multiplayer.server;

import com.badlogic.gdx.utils.TimeUtils;
import com.diploma.project.multiplayer.configuration.Configuration;

import java.util.List;
import java.util.Map;

public abstract class ServerProcessingThread extends Thread {

    protected ServerProcessingThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        long delta = 0;
        long startTime = TimeUtils.millis();
        long prevCycleTime = 0;
        while (Server.getInstance().isStarted()) {
            prevCycleTime = TimeUtils.timeSinceMillis(startTime);
            startTime = TimeUtils.millis();
            Map<Integer, List<String>> temp = Server.getInstance().getClientMessages();
            processMessages(temp, prevCycleTime/1000f);
            delta = TimeUtils.timeSinceMillis(startTime);
            if (delta < Configuration.getInstance().getServerProcessingCycleTime()) {
                try {
                    sleep(Configuration.getInstance().getServerProcessingCycleTime() - delta);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected abstract void processMessages(Map<Integer, List<String>> messages, float delta);
}
