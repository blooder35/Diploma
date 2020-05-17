package com.diploma.project.multiplayerImpl.communication.processing;

import com.diploma.project.multiplayerImpl.communication.messages.client.game.GameCycleClientGameMessage;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerInfoServerSaver;

public class GameServerProcessor {
    private GameServerProcessor() {

    }

    public static void process(int clientIdentificator, GameCycleClientGameMessage message) {
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
