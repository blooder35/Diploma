package com.diploma.project.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.diploma.project.DiplomaProject;
import com.diploma.project.constants.Resources;
import com.diploma.project.multiplayer.client.Client;
import com.diploma.project.multiplayer.server.Server;
import com.diploma.project.util.ActorHelper;
import com.diploma.project.util.TextHelper;

public class GameCompletedScreen implements Screen {
    private DiplomaProject game;
    private boolean isServer;
    String name;
    Stage stage;


    public GameCompletedScreen(DiplomaProject game, boolean isServer, String name) {
        this.game = game;
        this.isServer = isServer;
        this.name = name;
        Client.getInstance().stop();
        if (isServer) {
            Server.getInstance().stop();
        }
        this.stage = new Stage(game.viewPort, game.batch);
        Gdx.input.setInputProcessor(stage);
        ActorHelper.addImageActor(stage, Resources.MAIN_MENU_BACKGROUND, 0, 0, true);
        ActorHelper.addTextField(stage, "Thanks for playing!", 960, 460, 960, 160, true, false, TextHelper.getDefaultTextFieldStyle());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            game.setScreen(new LobbyScreen(game, isServer, name));
        }
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

    }
}
