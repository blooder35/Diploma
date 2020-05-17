package com.diploma.project.multiplayer.communication.processing;

import com.diploma.project.multiplayer.communication.messages.client.game.GameCycleClientMessage;
import com.diploma.project.multiplayer.communication.messages.server.game.PlayerInfoServerSaver;

public class GameServerProcessor {
    private GameServerProcessor() {

    }

    public static void process(int clientIdentificator, GameCycleClientMessage message) {
        if (!PlayerInfoServerSaver.getInstance().getPlayerAttributes(clientIdentificator).isFinished()) {
            changePlayerVector(clientIdentificator, message.getVectorX(), message.getVectorY());
        }
        if (message.isInteracting()) {
            PlayerInfoServerSaver.getInstance().setPlayerInteracting(clientIdentificator);
        }
    }

    private static void changePlayerVector(int playerId,float vectorX, float vectorY){
        PlayerInfoServerSaver.getInstance().addPlayerVector(playerId, vectorX, vectorY);
    }
}
