package com.diploma.project.multiplayerImpl;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Json;
import com.diploma.project.multiplayer.client.Client;
import com.diploma.project.multiplayerImpl.communication.GameCommunicationMessage;
import com.diploma.project.multiplayer.server.Server;

/**
 * Процессор обработки сообещний клиентом
 */
public class ClientMessageProcessor {
    private static ClientMessageProcessor instance;

    /**
     * @return экземпляр класса
     */
    public static ClientMessageProcessor getInstance() {
        if (instance == null) {
            synchronized (Server.class) {
                if (instance == null) {
                    instance = new ClientMessageProcessor();
                }
            }
        }
        return instance;
    }

    /**
     * Обработать сообщения пользователя
     *
     * @param screen экран приложения
     * @param json   экземпляр json парсера
     */
    public void processClientMessages(Screen screen, Json json) {
        for (String message : Client.getInstance().getServerMessages()) {
            GameCommunicationMessage serverMessage = json.fromJson(GameCommunicationMessage.class, message);
            serverMessage.clientProcess(screen, json);
        }
    }
}
