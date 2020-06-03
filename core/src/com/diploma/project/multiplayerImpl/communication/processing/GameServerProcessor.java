package com.diploma.project.multiplayerImpl.communication.processing;

import com.diploma.project.multiplayerImpl.communication.messages.client.game.GameCycleClientGameMessage;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.PlayerInfoServerSaver;

/**
 * Обработчик сообщения пришедшего от пользователя, находящегося в игре
 */
public class GameServerProcessor {
    private GameServerProcessor() {

    }

    /**
     * Обработать сообщение пользователя, находящегося в игре
     *
     * @param clientIdentificator идентификатор пользователя
     * @param message             сообщение игрового цилка клиента
     */
    public static void process(int clientIdentificator, GameCycleClientGameMessage message) {
        if (!PlayerInfoServerSaver.getInstance().getPlayerAttributes(clientIdentificator).isFinished()) {
            changePlayerVector(clientIdentificator, message.getVectorX(), message.getVectorY());
        }
        if (message.isInteracting()) {
            PlayerInfoServerSaver.getInstance().setPlayerInteracting(clientIdentificator);
        }
    }

    /**
     * Изменить вектор игрока
     *
     * @param playerId идентификатор игрока
     * @param vectorX  компонента x
     * @param vectorY  компонента y
     */
    private static void changePlayerVector(int playerId, float vectorX, float vectorY) {
        PlayerInfoServerSaver.getInstance().addPlayerVector(playerId, vectorX, vectorY);
    }
}
