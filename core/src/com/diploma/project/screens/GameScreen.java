package com.diploma.project.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.diploma.project.DiplomaProject;
import com.diploma.project.actors.PlayerActor;
import com.diploma.project.constants.ColorType;
import com.diploma.project.constants.Resources;
import com.diploma.project.maps.Level;
import com.diploma.project.maps.MapManager;
import com.diploma.project.maps.blocks.InteractingMapBlock;
import com.diploma.project.maps.blocks.MapBlock;
import com.diploma.project.multiplayer.client.Client;
import com.diploma.project.multiplayer.communication.messages.client.game.GameCycleClientMessage;
import com.diploma.project.multiplayer.server.ServerConstants;
import com.diploma.project.screens.storage.PlayerTextureStorage;
import com.diploma.project.util.ActorHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameScreen implements Screen {
    DiplomaProject game;
    boolean isServer;
    String name;
    int currentLevel;
    Stage stage;
    Image redPlayerImage;
    List<PlayerActor> playerActors;
    PlayerTextureStorage playerTextureStorage;
    float x = 0;
    float y = 0;
    boolean levelFinished;
    boolean interacting;

    public GameScreen(DiplomaProject game, boolean isServer, String name, int currentLevel) {
        this.game = game;
        this.isServer = isServer;
        this.name = name;
        this.currentLevel = currentLevel;
        this.stage = new Stage(game.viewPort, game.batch);
        Gdx.input.setInputProcessor(stage);
        this.playerActors = new ArrayList<>(ServerConstants.MAXIMUM_PLAYERS);
        playerTextureStorage = new PlayerTextureStorage();
        prepareImages();
        addInputListeners();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.act();
        inputProcessing();
        Client.getInstance().processClientMessages(this, game.json);
        if (levelFinished) {
            game.setScreen(new GameCompletedScreen(game, isServer, name));
        }
        stage.draw();
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

    public void movePlayer(int index, float posX, float posY) {
        playerActors.get(index).setPosition(posX, posY);
    }

    public void changePlayerColorType(int index, ColorType colorType) {
        PlayerActor playerActor = playerActors.get(index);
        if (playerActor.getColorType() != colorType) {
            playerActor.setColorType(colorType);
            playerActor.setTexture(playerTextureStorage.getPlayerTexture(colorType));
        }
    }

    public void setLevelFinished() {
        levelFinished = true;
    }

    private void prepareImages() {
        Level level = MapManager.getInstance().getLevel(currentLevel);
        for (int i = 0; i < ServerConstants.MAXIMUM_PLAYERS; i++) {
            playerActors.add(i, ActorHelper.addPlayerActor(stage, Resources.Game.BLACK_PLAYER_CIRCLE_IMAGE, level.getPlayerStartPosition(i).x, level.getPlayerStartPosition(i).y, true));
        }
        for (InteractingMapBlock block : level.getInteractingMapBlocks()) {
            ActorHelper.addMapBlockActor(stage, block);
        }
        for (MapBlock block : level.getMapBlocks()) {
            ActorHelper.addMapBlockActor(stage, block);
        }
    }

    private void addInputListeners() {
        //todo
    }

    private void inputProcessing() {
        x = 0;
        y = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            y += 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            x -= 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            y -= 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            x += 1;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            interacting = true;
        }
        if (x != 0 || y != 0 || interacting) {
            new GameCycleClientMessage(x, y, interacting).sendMessageToServer();
        }
        interacting = false;
    }
}
