package com.diploma.project.multiplayerImpl.communication;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.SerializationException;
import com.diploma.project.multiplayerImpl.communication.messages.client.game.GameCycleClientGameMessage;
import com.diploma.project.multiplayerImpl.communication.messages.client.lobby.LobbyGameMessage;
import com.diploma.project.multiplayerImpl.communication.messages.server.lobby.LobbyStateGameMessage;
import com.diploma.project.multiplayerImpl.communication.processing.GameClientProcessor;
import com.diploma.project.multiplayerImpl.communication.processing.GameServerProcessor;
import com.diploma.project.multiplayerImpl.communication.processing.LobbyClientProcessor;
import com.diploma.project.multiplayerImpl.communication.processing.LobbyServerProcessor;
import com.diploma.project.multiplayerImpl.communication.messages.server.game.GameStateGameMessage;
import com.diploma.project.screens.GameScreen;
import com.diploma.project.screens.LobbyScreen;

/**
 * Класс для обработки и компановки сообщений с состоянием, содержит методы обработки сообщений как сервера, так и клиента.
 */
public class GameCommunicationMessage {
    private com.diploma.project.multiplayerImpl.communication.ApplicationState state;
    private String message;

    /**
     * Конструктор
     */
    public GameCommunicationMessage() {

    }

    /**
     * Конструктор
     *
     * @param state   состояние пользователя (приложения)
     * @param message Строка - сообщение для отправки
     */
    public GameCommunicationMessage(com.diploma.project.multiplayerImpl.communication.ApplicationState state, String message) {
        this.state = state;
        this.message = message;
    }

    /**
     * метод для серверной обработки сообщений
     *
     * @param clientIdentificator идентификатор клиента
     * @param message             строка - сообщение
     * @param json                экземпляр json парсера
     */
    public static void serverProcess(Integer clientIdentificator, String message, Json json) {
        try {
            GameCommunicationMessage gameCommunicationMessage = json.fromJson(GameCommunicationMessage.class, message);
            switch (gameCommunicationMessage.state) {
                case LOBBY_MENU:
                    LobbyServerProcessor.process(clientIdentificator, json.fromJson(LobbyGameMessage.class, gameCommunicationMessage.message));
                    break;
                case IN_GAME:
                    GameServerProcessor.process(clientIdentificator, json.fromJson(GameCycleClientGameMessage.class, gameCommunicationMessage.message));
                    break;
            }
        } catch (SerializationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, для обработки сообщений клиентом
     *
     * @param screen экран приложения
     * @param json   экземпляр json парсера
     */
    public void clientProcess(Screen screen, Json json) {
        switch (state) {
            case LOBBY_MENU:
                if (screen instanceof LobbyScreen) {
                    LobbyClientProcessor.process((LobbyScreen) screen, json.fromJson(LobbyStateGameMessage.class, message));
                }
            case IN_GAME:
                if (screen instanceof GameScreen) {
                    GameClientProcessor.process((GameScreen) screen, json.fromJson(GameStateGameMessage.class, message));
                }
        }
    }

    /**
     * Получить состояние пользователя (приложения)
     *
     * @return состояние пользователя (приложения)
     */
    public com.diploma.project.multiplayerImpl.communication.ApplicationState getState() {
        return state;
    }

    /**
     * Установить состояние пользователя (приложения)
     *
     * @param state состояние пользователя (приложения)
     */
    public void setState(ApplicationState state) {
        this.state = state;
    }

    /**
     * Получить строку - сообщение
     *
     * @return строка - сообщение
     */
    public String getMessage() {
        return message;
    }

    /**
     * Установить строку - сообщение
     *
     * @param message строка - сообщение
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
