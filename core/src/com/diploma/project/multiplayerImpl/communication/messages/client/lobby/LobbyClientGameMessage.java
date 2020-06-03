package com.diploma.project.multiplayerImpl.communication.messages.client.lobby;

/**
 * Сообщение пользователя - клиента, находящегося в лобби
 */
public class LobbyClientGameMessage extends LobbyGameMessage {
    private String name;
    private Boolean ready;

    /**
     * Конструктор
     */
    public LobbyClientGameMessage() {

    }

    @Override
    LobbyMessageType getMessageType() {
        return LobbyMessageType.LOBBY_CLIENT_MESSAGE;
    }

    /**
     * Конструктор
     *
     * @param name  имя пользователя
     * @param ready указатель того, что пользователь готов к началу игры
     */
    public LobbyClientGameMessage(String name, Boolean ready) {
        this.name = name;
        this.ready = ready;
    }

    /**
     * @return имя пользователя
     */
    public String getName() {
        return name;
    }

    /**
     * @return true - пользователь готов к началу игры, false - пользователь не готов
     */
    public Boolean isReady() {
        return ready;
    }
}
