package com.diploma.project.multiplayerImpl.communication.messages;

import com.diploma.project.multiplayerImpl.communication.ApplicationState;

/**
 * Интерфейс общего вида сообщений с состоянием
 */
public interface CommonGameMessage {

    /**
     * Получить состояние приложения при отправке сообщенияы
     *
     * @return состояние приложения
     */
    ApplicationState getMessageState();
}
