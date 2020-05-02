package com.diploma.project.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.diploma.project.DiplomaProject;
import com.diploma.project.input_processors.MainMenuInputProcessor;
import com.diploma.project.states.MainMenuStates;

import static com.diploma.project.constants.MainMenuConstants.*;

public class MainMenuScreen implements Screen {
    final DiplomaProject game;
    private MainMenuStates states;
    private Texture startButton;
    private Texture startButtonPressed;
    private Texture multiplayerButton;
    private Texture multiplayerButtonPressed;
    private Texture exitButton;
    private Texture exitButtonPressed;
    private OrthographicCamera camera;

    public MainMenuScreen(final DiplomaProject game) {
        this.game = game;
        states = new MainMenuStates();
        //todo load images for the main menu
        startButton = new Texture(Gdx.files.internal("startButton.png"));
        startButtonPressed = new Texture(Gdx.files.internal("startButtonPressed.png"));
        multiplayerButton = new Texture(Gdx.files.internal("multiplayerButton.png"));
        multiplayerButtonPressed = new Texture(Gdx.files.internal("multiplayerButtonPressed.png"));
        exitButton = new Texture(Gdx.files.internal("exitButton.png"));
        exitButtonPressed = new Texture(Gdx.files.internal("exitButtonPressed.png"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920,1080);
        Gdx.input.setInputProcessor(new MainMenuInputProcessor(states,camera));
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        Texture buttonToDraw = states.isStartPressed() ? startButtonPressed : startButton;
        game.batch.draw(buttonToDraw,START_BUTTON_X_POS, START_BUTTON_Y_POS);
        buttonToDraw = states.isMultiplayerPressed() ? multiplayerButtonPressed : multiplayerButton;
        game.batch.draw(buttonToDraw,MULTIPLAYER_BUTTON_X_POS, MULTIPLAYER_BUTTON_Y_POS);
        buttonToDraw = states.isExitPressed() ? exitButtonPressed : exitButton;
        game.batch.draw(buttonToDraw,EXIT_BUTTON_X_POS, EXIT_BUTTON_Y_POS);
        game.batch.end();
        proceedScreenChangeEvents();
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        //todo dispose of all used things
    }

    private void proceedScreenChangeEvents() {
        if (states.isProceesToStart()) {
            //todo
        } else if (states.isProceedToMultiplayer()) {
            game.setScreen(new MultiplayerScreen(game));
        } else if (states.isProceedtoExit()) {
            //todo
        }
    }
}