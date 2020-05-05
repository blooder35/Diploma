package com.diploma.project.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.diploma.project.DiplomaProject;
import com.diploma.project.constants.Resources;
import com.diploma.project.multiplayer.client.Client;
import com.diploma.project.multiplayer.server.Server;
import com.diploma.project.states.MultiplayerStates;

import java.io.IOException;

import static com.diploma.project.constants.MultiplayerConstants.*;

public class MultiplayerScreen implements Screen {
    private DiplomaProject game;
    private MultiplayerStates states;
    private TextField nameField;
    private TextField ipField;
    private TextField portField;
    private TextArea errorArea;
    //todo можно убрать
    private Image ipTextImage;
    private Image portTextImage;
    private Image inputBordersImageForIp;
    private Image inputBordersImageForPort;
    private Image inputBordersImageForName;
    private Button hostButton;
    private Button connectButton;
    private Button backButton;
    private Stage stage;

    public MultiplayerScreen(DiplomaProject game) {
        this.game = game;
        this.states = new MultiplayerStates();
        this.stage = new Stage(game.viewPort, game.batch);
        setButtons();
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
        //todo
    }

    private void setTextFields() {
        //todo вынести в метод одинаковые присваивания
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.fontColor = Color.BLACK;
        textFieldStyle.cursor = new Image(new Texture(Gdx.files.internal(Resources.TEXT_CURSOR))).getDrawable();
        textFieldStyle.cursor.setMinHeight(2f);
        textFieldStyle.selection = new Image(new Texture(Gdx.files.internal(Resources.TEXT_SELECTION))).getDrawable();
        BitmapFont font = new BitmapFont(Gdx.files.internal(Resources.TEXT_FONT));
        font.getData().setScale(FONT_HEIGHT * font.getScaleY() / font.getLineHeight());
        textFieldStyle.font = font;
        TextField.TextFieldStyle errorTextFieldStyle = new TextField.TextFieldStyle(textFieldStyle);
        errorTextFieldStyle.font = new BitmapFont();
        errorTextFieldStyle.fontColor = Color.RED;
        nameField = new TextField("", textFieldStyle);
        ipField = new TextField("", textFieldStyle);
        portField = new TextField("", textFieldStyle);
        errorArea = new TextArea("", errorTextFieldStyle);
        errorArea.setDisabled(true);
        errorArea.setPosition(ERROR_FIELD_X, ERROR_FIELD_Y);
        errorArea.setSize(ERROR_FIELD_WIDTH, ERROR_FIELD_HEIGHT);
        nameField.setPosition(NAME_FIELD_X, NAME_FIELD_Y);
        nameField.setSize(INPUT_FIELD_WIDTH, INPUT_FIELD_HEIGHT);
        ipField.setPosition(IP_ADDRESS_FIELD_X, IP_ADDRESS_FIELD_Y);
        ipField.setSize(INPUT_FIELD_WIDTH, INPUT_FIELD_HEIGHT);
        portField.setPosition(PORT_FIELD_X, PORT_FIELD_Y);
        portField.setSize(INPUT_FIELD_WIDTH, INPUT_FIELD_HEIGHT);
        stage.addActor(nameField);
        stage.addActor(ipField);
        stage.addActor(portField);
        stage.addActor(errorArea);
    }

    private void setNameplates() {
        //todo вынести в метод одинаковые присваивания
        Image nameTextImage = new Image(new Texture(Gdx.files.internal("name.png")));
        nameTextImage.setPosition(NAME_FIELD_NAME_X, NAME_FIELD_NAME_Y);
        ipTextImage = new Image(new Texture(Gdx.files.internal("ipAddress.png")));
        ipTextImage.setPosition(IP_FIELD_NAME_X, IP_FIELD_NAME_Y);
        portTextImage = new Image(new Texture(Gdx.files.internal("port.png")));
        portTextImage.setPosition(PORT_FIELD_NAME_X, PORT_FIELD_NAME_Y);
        inputBordersImageForIp = new Image(new Texture(Gdx.files.internal("fieldBorders.png")));
        inputBordersImageForIp.setPosition(IP_INPUT_FIELD_BORDER_X, IP_INPUT_FIELD_BORDER_Y);
        inputBordersImageForPort = new Image(new Texture(Gdx.files.internal("fieldBorders.png")));
        inputBordersImageForPort.setPosition(PORT_INPUT_FIELD_BORDER_X, PORT_INPUT_FIELD_BORDER_Y);
        inputBordersImageForName = new Image(new Texture(Gdx.files.internal("fieldBorders.png")));
        inputBordersImageForName.setPosition(NAME_INPUT_FIELD_BORDER_X, NAME_INPUT_FIELD_BORDER_Y);
        stage.addActor(nameTextImage);
        stage.addActor(ipTextImage);
        stage.addActor(portTextImage);
        stage.addActor(inputBordersImageForIp);
        stage.addActor(inputBordersImageForPort);
        stage.addActor(inputBordersImageForName);
    }

    private void setButtons() {
        //todo вынести в метод одинаковые присваивания
        Drawable hostButtonDrawable = new Image(new Texture(Gdx.files.internal("hostButton.png"))).getDrawable();
        Drawable hostButtonPressedDrawable = new Image(new Texture(Gdx.files.internal("hostButtonPressed.png"))).getDrawable();
        hostButton = new Button(hostButtonDrawable, hostButtonPressedDrawable);
        hostButton.setPosition(HOST_BUTTON_X, HOST_BUTTON_Y);
        Drawable connectButtonDrawable = new Image(new Texture(Gdx.files.internal("connectButton.png"))).getDrawable();
        Drawable connectButtonPressedDrawable = new Image(new Texture(Gdx.files.internal("connectButtonPressed.png"))).getDrawable();
        connectButton = new Button(connectButtonDrawable, connectButtonPressedDrawable);
        connectButton.setPosition(CONNECT_BUTTON_X, CONNECT_BUTTON_Y);
        Drawable backButtonDrawable = new Image(new Texture(Gdx.files.internal("backButton.png"))).getDrawable();
        Drawable backButtonPressedDrawable = new Image(new Texture(Gdx.files.internal("backButtonPressed.png"))).getDrawable();
        backButton = new Button(backButtonDrawable, backButtonPressedDrawable);
        backButton.setPosition(BACK_BUTTON_X, BACK_BUTTON_Y);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenuScreen(game));
            }
        });
        hostButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (nameField.getText().isEmpty()) {
                    showError("Field name cannot be empty");
                    return;
                }
                try {
                    Server.getInstance().start(Integer.parseInt(portField.getText()));
                } catch (Exception e) {
                    showError("Error while creating a server, please check port");
                    return;
                }
                game.setScreen(new LobbyScreen(game, true, nameField.getText()));
            }
        });
        connectButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (nameField.getText().isEmpty()) {
                    showError("Field name cannot be empty");
                    return;
                }
                try {
                    Client.getInstance().start(ipField.getMessageText(), Integer.parseInt(portField.getText()));
                } catch (Exception e) {
                    showError("Error while connecting to a server, please check ip address and port");
                    return;
                }
                game.setScreen(new LobbyScreen(game, false, nameField.getText()));
            }
        });
        stage.addActor(hostButton);
        stage.addActor(connectButton);
        stage.addActor(backButton);
    }

    private void showError(String message) {
        errorArea.setText(message);
    }
}
