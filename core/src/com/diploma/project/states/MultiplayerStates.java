package com.diploma.project.states;

/**
 * Состояния меню многопользовательского приложения
 */
public class MultiplayerStates {
    private boolean errorWhileConnecting;
    private boolean errorWhileCreatingServer;

    public boolean isErrorWhileConnecting() {
        return errorWhileConnecting;
    }

    public void setErrorWhileConnecting(boolean errorWhileConnecting) {
        this.errorWhileConnecting = errorWhileConnecting;
    }

    public boolean isErrorWhileCreatingServer() {
        return errorWhileCreatingServer;
    }

    public void setErrorWhileCreatingServer(boolean errorWhileCreatingServer) {
        this.errorWhileCreatingServer = errorWhileCreatingServer;
    }
}
