package com.diploma.project.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.diploma.project.DiplomaProject;
import com.diploma.project.states.MultiplayerStates;

import static com.diploma.project.constants.MultiplayerConstants.*;

public class MultiplayerScreen implements Screen {
    private DiplomaProject game;
    private MultiplayerStates states;
    private TextField ipField;
    private TextField portField;
    private Image ipTextImage;
    private Image portTextImage;
    private Image inputBordersImageForIp;
    private Image inputBordersImageForPort;
    private Stage stage;

    public MultiplayerScreen(DiplomaProject game) {
        this.game = game;
        this.states = new MultiplayerStates();
        this.stage = new Stage(game.viewPort, game.batch);
        setNameplates();
        setTextFields();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
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

    private void setTextFields() {
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.fontColor = Color.BLACK;
        textFieldStyle.cursor = new Image(new Texture(Gdx.files.internal("cursor.png"))).getDrawable();
        textFieldStyle.cursor.setMinHeight(2f);
        textFieldStyle.selection = new Image(new Texture(Gdx.files.internal("selection.png"))).getDrawable();
        BitmapFont font = new BitmapFont(Gdx.files.internal("diplomaFont.fnt"));
        font.getData().setScale(FONT_HEIGHT * font.getScaleY() / font.getLineHeight());
        textFieldStyle.font = font;
        ipField = new TextField("TEST", textFieldStyle);
        portField = new TextField("TEST", textFieldStyle);
        ipField.setPosition(IP_ADDRESS_FIELD_X, IP_ADDRESS_FIELD_Y);
        ipField.setSize(INPUT_FIELD_WIDTH, INPUT_FIELD_HEIGHT);
        portField.setPosition(PORT_FIELD_X, PORT_FIELD_Y);
        portField.setSize(INPUT_FIELD_WIDTH, INPUT_FIELD_HEIGHT);
        stage.addActor(ipField);
        stage.addActor(portField);
    }

    private void setNameplates() {
        ipTextImage = new Image(new Texture(Gdx.files.internal("ipAddress.png")));
        ipTextImage.setPosition(IP_FIELD_NAME_X, IP_FIELD_NAME_Y);
        portTextImage = new Image(new Texture(Gdx.files.internal("port.png")));
        portTextImage.setPosition(PORT_FIELD_NAME_X, PORT_FIELD_NAME_Y);
        inputBordersImageForIp = new Image(new Texture(Gdx.files.internal("fieldBorders.png")));
        inputBordersImageForIp.setPosition(IP_INPUT_FIELD_BORDER_X, IP_INPUT_FIELD_BORDER_Y);
        inputBordersImageForPort = new Image(new Texture(Gdx.files.internal("fieldBorders.png")));
        inputBordersImageForPort.setPosition(PORT_INPUT_FIELD_BORDER_X, PORT_INPUT_FIELD_BORDER_Y);
        stage.addActor(ipTextImage);
        stage.addActor(portTextImage);
        stage.addActor(inputBordersImageForIp);
        stage.addActor(inputBordersImageForPort);
    }
}
