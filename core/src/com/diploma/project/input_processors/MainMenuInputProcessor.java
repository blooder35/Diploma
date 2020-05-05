package com.diploma.project.input_processors;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.diploma.project.states.MainMenuStates;

import static com.diploma.project.constants.MainMenuConstants.*;

public class MainMenuInputProcessor implements InputProcessor {
    MainMenuStates states;
    OrthographicCamera camera;

    public MainMenuInputProcessor(MainMenuStates states, OrthographicCamera camera) {
        this.states = states;
        this.camera = camera;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            Vector3 input = new Vector3(screenX, screenY, 0);
            input = camera.unproject(input);
            if (onStartButton(input.x,input.y)) {
                states.setStartPressed(true);
            } else if (onMultiplayerButton(input.x, input.y)) {
                states.setMultiplayerPressed(true);
            } else if (onExitButton(input.x, input.y)) {
                states.setExitPressed(true);
            } else {
                states.setAllToFalse();
            }
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            Vector3 input = new Vector3(screenX, screenY, 0);
            input = camera.unproject(input);
            if (onStartButton(input.x, input.y) && states.isStartPressed()) {
                states.setProceesToStart(true);
            } else if (onMultiplayerButton(input.x, input.y) && states.isMultiplayerPressed()) {
                states.setProceedToMultiplayer(true);
            } else if (onExitButton(input.x, input.y) && states.isExitPressed()) {
                states.setProceedtoExit(true);
            } else {
                states.setAllToFalse();
            }
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private boolean onStartButton(float x, float y) {
        if (x > START_BUTTON_X_POS && x < START_BUTTON_X_POS + BUTTON_WIDTH &&
                y > START_BUTTON_Y_POS && y < START_BUTTON_Y_POS + BUTTON_HEIGHT) {
            return true;
        }
        return false;
    }

    private boolean onMultiplayerButton(float x, float y) {
        if (x > MULTIPLAYER_BUTTON_X_POS && x < MULTIPLAYER_BUTTON_X_POS + BUTTON_WIDTH &&
                y > MULTIPLAYER_BUTTON_Y_POS && y < MULTIPLAYER_BUTTON_Y_POS + BUTTON_HEIGHT) {
            return true;
        }
        return false;
    }

    private boolean onExitButton(float x, float y) {
        if (x > EXIT_BUTTON_X_POS && x < EXIT_BUTTON_X_POS + BUTTON_WIDTH &&
                y > EXIT_BUTTON_Y_POS && y < EXIT_BUTTON_Y_POS + BUTTON_HEIGHT) {
            return true;
        }
        return false;
    }
}
