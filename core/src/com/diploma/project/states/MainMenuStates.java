package com.diploma.project.states;

/**
 * Возможные состояния главного меню
 */
public class MainMenuStates {
    private boolean startPressed;
    private boolean multiplayerPressed;
    private boolean exitPressed;
    private boolean proceesToStart;
    private boolean proceedToMultiplayer;
    private boolean proceedtoExit;

    public void setAllToFalse() {
        startPressed = false;
        multiplayerPressed = false;
        exitPressed = false;
    }

    public boolean isStartPressed() {
        return startPressed;
    }

    public void setStartPressed(boolean startPressed) {
        this.startPressed = startPressed;
    }

    public boolean isMultiplayerPressed() {
        return multiplayerPressed;
    }

    public void setMultiplayerPressed(boolean multiplayerPressed) {
        this.multiplayerPressed = multiplayerPressed;
    }

    public boolean isExitPressed() {
        return exitPressed;
    }

    public void setExitPressed(boolean exitPressed) {
        this.exitPressed = exitPressed;
    }

    public boolean isProceesToStart() {
        return proceesToStart;
    }

    public void setProceesToStart(boolean proceesToStart) {
        this.proceesToStart = proceesToStart;
    }

    public boolean isProceedToMultiplayer() {
        return proceedToMultiplayer;
    }

    public void setProceedToMultiplayer(boolean proceedToMultiplayer) {
        this.proceedToMultiplayer = proceedToMultiplayer;
    }

    public boolean isProceedtoExit() {
        return proceedtoExit;
    }

    public void setProceedtoExit(boolean proceedtoExit) {
        this.proceedtoExit = proceedtoExit;
    }
}
