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
import com.diploma.project.constants.GameConstants;
import com.diploma.project.constants.Resources;
import com.diploma.project.multiplayer.client.Client;
import com.diploma.project.multiplayerImpl.communication.ApplicationState;
import com.diploma.project.multiplayerImpl.communication.messages.client.lobby.LobbyClientGameMessage;
import com.diploma.project.multiplayerImpl.ServerProcessingThreadImpl;
import com.diploma.project.multiplayer.server.Server;
import com.diploma.project.states.MultiplayerStates;

import static com.diploma.project.constants.MultiplayerConstants.*;

public class MultiplayerScreen implements Screen {
    private DiplomaProject game;
    private MultiplayerStates states;
    private TextField nameField;
    private TextField ipField;
    private TextField portField;
    private TextArea errorArea;
    private Image ipTextImage;
    private Image portTextImage;
    private Image inputBordersImageForIp;
    private Image inputBordersImageForPort;
    private Image inputBordersImageForName;
    private Button hostButton;
    private Button connectButton;
    private Button backButton;
    private Image background;
    private Stage stage;

    public MultiplayerScreen(DiplomaProject game) {
        this.game = game;
        this.states = new MultiplayerStates();
        this.stage = new Stage(game.viewPort, game.batch);
        this.background = new Image(new Texture(Gdx.files.internal(Resources.LOBBY_MENU_BACKGROUND)));
        background.setPosition(0, 0);
        stage.addActor(background);
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
    }

    private void setTextFields() {
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
        Drawable hostButtonDrawable = new Image(new Texture(Gdx.files.internal(Resources.Multiplayer.MULTIPLAYER_HOST_BUTTON))).getDrawable();
        Drawable hostButtonPressedDrawable = new Image(new Texture(Gdx.files.internal(Resources.Multiplayer.MULTIPLAYER_HOST_BUTTON_PRESSED))).getDrawable();
        hostButton = new Button(hostButtonDrawable, hostButtonPressedDrawable);
        hostButton.setPosition(HOST_BUTTON_X, HOST_BUTTON_Y);
        Drawable connectButtonDrawable = new Image(new Texture(Gdx.files.internal(Resources.Multiplayer.MULTIPLAYER_CONNECT_BUTTON))).getDrawable();
        Drawable connectButtonPressedDrawable = new Image(new Texture(Gdx.files.internal(Resources.Multiplayer.MULTIPLAYER_CONNECT_BUTTON_PRESSED))).getDrawable();
        connectButton = new Button(connectButtonDrawable, connectButtonPressedDrawable);
        connectButton.setPosition(CONNECT_BUTTON_X, CONNECT_BUTTON_Y);
        Drawable backButtonDrawable = new Image(new Texture(Gdx.files.internal(Resources.Multiplayer.MULTIPLAYER_BACK_BUTTON))).getDrawable();
        Drawable backButtonPressedDrawable = new Image(new Texture(Gdx.files.internal(Resources.Multiplayer.MULTIPLAYER_BACK_BUTTON_PRESSED))).getDrawable();
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
                if (errorInFields()) {
                    return;
                }
                try {
                    String address = ipField.getText();
                    int port = Integer.parseInt(portField.getText());
                    Server.getInstance().start(address, port);
                    new ServerProcessingThreadImpl(ApplicationState.LOBBY_MENU).start();
                    Client.getInstance().start(ipField.getText(), port);
                    LobbyClientGameMessage lobbyClientMessage = new LobbyClientGameMessage(nameField.getText(), false);
                    lobbyClientMessage.sendMessageToServer();
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
                if (errorInFields()) {
                    return;
                }
                try {
                    Client.getInstance().start(ipField.getText(), Integer.parseInt(portField.getText()));
                    new LobbyClientGameMessage(nameField.getText(),false).sendMessageToServer();
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

    private boolean errorInFields() {
        if (nameField.getText().isEmpty() || ipField.getText().isEmpty() || portField.getText().isEmpty()) {
            showError("You should specify all fields");
            return true;
        }
        return false;
    }

    private void showError(String message) {
        errorArea.setText(message);
    }
}
