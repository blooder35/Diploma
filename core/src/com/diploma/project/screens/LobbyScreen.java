package com.diploma.project.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.diploma.project.DiplomaProject;
import com.diploma.project.constants.Levels;
import com.diploma.project.constants.LobbyConstants;
import com.diploma.project.constants.Resources;
import com.diploma.project.multiplayer.client.Client;
import com.diploma.project.multiplayerImpl.communication.messages.client.lobby.LobbyClientGameMessage;
import com.diploma.project.multiplayerImpl.communication.messages.client.lobby.StartGameGameMessage;
import com.diploma.project.multiplayer.server.Server;
import com.diploma.project.multiplayerImpl.ClientMessageProcessor;
import com.diploma.project.util.ActorHelper;
import com.diploma.project.util.TextHelper;

import static com.diploma.project.constants.LobbyConstants.*;

public class LobbyScreen implements Screen {
    DiplomaProject game;
    boolean isServer;
    String name;
    boolean ready;
    boolean gameStarted;
    int selectedLevel;
    Stage stage;
    TextArea infoTextArea;
    Image player1Border;
    Image player2Border;
    Image player3Border;
    Image player1ReadyBorder;
    Image player2ReadyBorder;
    Image player3ReadyBorder;
    Button player1KickButton;
    Button player2KickButton;
    Button player3KickButton;
    TextField player1Name;
    TextField player2Name;
    TextField player3Name;
    SelectBox levelSelect;


    public LobbyScreen(DiplomaProject game, boolean isServer, String name) {
        this.game = game;
        this.isServer = isServer;
        this.name = name;
        this.ready = false;
        this.stage = new Stage(game.viewPort, game.batch);
        this.gameStarted = false;
        setActors();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
        ClientMessageProcessor.getInstance().processClientMessages(this, game.json);
        if (gameStarted) {
            game.setScreen(new GameScreen(game, isServer, name, selectedLevel));
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

    public void appendInfoMessage(String message) {
        infoTextArea.appendText("\n" + message);
    }

    public void setPlayer1Info(String name, boolean ready) {
        appendPlayerInfo(player1Name, player1Border, player1ReadyBorder, player1KickButton, name, ready);
    }

    public void setPlayer2Info(String name, boolean ready) {
        appendPlayerInfo(player2Name, player2Border, player2ReadyBorder, player2KickButton, name, ready);
    }

    public void setPlayer3Info(String name, boolean ready) {
        appendPlayerInfo(player3Name, player3Border, player3ReadyBorder, player3KickButton, name, ready);
    }

    public void setGameStarted() {
        gameStarted = true;
    }

    public void setSelectedLevel(int selectedLevel) {
        this.selectedLevel = selectedLevel;
    }

    private void setActors() {
        if (isServer) {
            setServerButtons();
        } else {
            setClientButtons();
        }
        ActorHelper.addButtonActor(stage, Resources.Lobby.BACK_BUTTON, Resources.Lobby.BACK_BUTTON_PRESSED, LobbyConstants.BACK_BUTTON_X, LobbyConstants.BACK_BUTTON_Y, true, new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (isServer) {
                    Server.getInstance().stop();
                    Client.getInstance().stop();
                } else {
                    Client.getInstance().stop();
                }
                game.setScreen(new MultiplayerScreen(game));
            }
        });
        TextField.TextFieldStyle infoTextFieldStyle = TextHelper.getTextFieldStyle(Resources.TEXT_FONT, INFO_AREA_TEXT_SIZE, Resources.TEXT_CURSOR, Resources.TEXT_SELECTION, Color.BLACK);
        String initialText = isServer ? "Server is started at:" + Server.getInstance().getServerFullIp() : "You are connected to server";
        infoTextArea = ActorHelper.addTextAreaActor(stage, initialText, INFO_AREA_X, INFO_AREA_Y, INFO_AREA_WIDTH, INFO_AREA_HEIGHT, infoTextFieldStyle, true);
        player1Border = ActorHelper.addImageActor(stage, Resources.Lobby.PLAYER_BACKGROUND, PLAYER_1_BACKGROUND_X, PLAYER_1_BACKGROUND_Y, false);
        player1ReadyBorder = ActorHelper.addImageActor(stage, Resources.Lobby.PLAYER_BACKGROUND_READY, PLAYER_1_BACKGROUND_X, PLAYER_1_BACKGROUND_Y, false);
        player2Border = ActorHelper.addImageActor(stage, Resources.Lobby.PLAYER_BACKGROUND, PLAYER_2_BACKGROUND_X, PLAYER_2_BACKGROUND_Y, false);
        player2ReadyBorder = ActorHelper.addImageActor(stage, Resources.Lobby.PLAYER_BACKGROUND_READY, PLAYER_2_BACKGROUND_X, PLAYER_2_BACKGROUND_Y, false);
        player3Border = ActorHelper.addImageActor(stage, Resources.Lobby.PLAYER_BACKGROUND, PLAYER_3_BACKGROUND_X, PLAYER_3_BACKGROUND_Y, false);
        player3ReadyBorder = ActorHelper.addImageActor(stage, Resources.Lobby.PLAYER_BACKGROUND_READY, PLAYER_3_BACKGROUND_X, PLAYER_3_BACKGROUND_Y, false);
        TextField.TextFieldStyle playerNamesTextFieldStyle = TextHelper.getTextFieldStyle(Resources.TEXT_FONT, PLAYER_NAME_FONT_HEIGHT, Resources.TEXT_CURSOR, Resources.TEXT_SELECTION, Color.BLACK);
        player1Name = ActorHelper.addTextField(stage, "", PLAYER_1_NAME_X, PLAYER_1_NAME_Y, PLAYER_NAME_WIDTH, PLAYER_NAME_HEIGHT, false, true, playerNamesTextFieldStyle);
        player2Name = ActorHelper.addTextField(stage, "", PLAYER_2_NAME_X, PLAYER_2_NAME_Y, PLAYER_NAME_WIDTH, PLAYER_NAME_HEIGHT, false, true, playerNamesTextFieldStyle);
        player3Name = ActorHelper.addTextField(stage, "", PLAYER_3_NAME_X, PLAYER_3_NAME_Y, PLAYER_NAME_WIDTH, PLAYER_NAME_HEIGHT, false, true, playerNamesTextFieldStyle);
    }

    private void setServerButtons() {
        ActorHelper.addButtonActor(stage, Resources.Lobby.LOBBY_START_BUTTON, Resources.Lobby.LOBBY_START_BUTTON_PRESSED, LobbyConstants.START_BUTTON_X, LobbyConstants.START_BUTTON_Y, true, new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (isEveryoneReady()) {
                    new StartGameGameMessage((String) levelSelect.getSelected()).sendMessageToServer();
                } else {
                    infoTextArea.appendText("Not everyone ready yet");
                }
            }
        });
        //тут добавляются невидимые кнопки, при присоединении пользователя они становятся видимыми
        player1KickButton = ActorHelper.addButtonActor(stage, Resources.Lobby.PLAYER_KICK_BUTTON, Resources.Lobby.PLAYER_KICK_BUTTON_PRESSED, PLAYER_1_KICK_BUTTON_X, PLAYER_1_KICK_BUTTON_Y, false, new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //todo
            }
        });
        player2KickButton = ActorHelper.addButtonActor(stage, Resources.Lobby.PLAYER_KICK_BUTTON, Resources.Lobby.PLAYER_KICK_BUTTON_PRESSED, PLAYER_2_KICK_BUTTON_X, PLAYER_2_KICK_BUTTON_Y, false, new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //todo
            }
        });
        player3KickButton = ActorHelper.addButtonActor(stage, Resources.Lobby.PLAYER_KICK_BUTTON, Resources.Lobby.PLAYER_KICK_BUTTON_PRESSED, PLAYER_3_KICK_BUTTON_X, PLAYER_3_KICK_BUTTON_Y, false, new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //todo
            }
        });

        ActorHelper.addImageActor(stage, Resources.Lobby.LEVEL_NAMEPLATE, LEVEL_SELECTION_NAMEPLATE_X, LEVEL_SELECTION_NAMEPLATE_Y, true);
        BitmapFont font = TextHelper.getBitmapFont(Resources.TEXT_FONT, LEVEL_SELECTION_FONT_HEIGHT);
        levelSelect = ActorHelper.addSelectBox(
                stage,
                TextHelper.getSelectBoxStyle(font, Color.BLACK, Resources.Lobby.SELECT_BOX_BACKGROUND, Color.BLUE, Color.BLACK, Resources.TEXT_SELECTION),
                LEVEL_SELECTION_X,
                LEVEL_SELECTION_Y,
                LEVEL_SELECTION_WIDTH,
                LEVEL_SELECTION_HEIGHT,
                LEVEL_SELECTION_MAX_LIST_COUNT,
                Levels.One.toString(), Levels.Two.toString(), Levels.Three.toString(), Levels.Four.toString(), Levels.Five.toString());
    }

    private void setClientButtons() {
        ActorHelper.addButtonActor(stage, Resources.Lobby.LOBBY_READY_BUTTON, Resources.Lobby.LOBBY_READY_BUTTON_PRESSED, LobbyConstants.START_BUTTON_X, LobbyConstants.START_BUTTON_Y, true, new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                LobbyClientGameMessage lobbyClientMessage = new LobbyClientGameMessage(name, !ready);
                lobbyClientMessage.sendMessageToServer();
                ready = !ready;
            }
        });
    }

    private void appendPlayerInfo(TextField playerName, Image playerBorder, Image playerReadyBorder, Button playerKickButton, String name, boolean ready) {
        if (!"".equals(name)) {
            playerName.setVisible(true);
            playerName.setText(name);
            if (ready) {
                playerReadyBorder.setVisible(true);
                playerBorder.setVisible(false);
            } else {
                playerBorder.setVisible(true);
                playerReadyBorder.setVisible(false);
            }
            if (isServer) {
                playerKickButton.setVisible(true);
            }
        } else if (playerName.isVisible()) {
            playerName.setText("");
            playerName.setVisible(false);
            playerBorder.setVisible(false);
            playerReadyBorder.setVisible(false);
            playerKickButton.setVisible(false);
        }
    }

    private boolean isEveryoneReady() {
        //first is always a server
        if (!"".equals(player2Name.getText()) && !player2ReadyBorder.isVisible())
            return false;
        if (!"".equals(player3Name.getText()) && !player3ReadyBorder.isVisible())
            return false;
        return true;
    }
}
