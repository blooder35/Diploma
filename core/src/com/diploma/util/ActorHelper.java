package com.diploma.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class ActorHelper {
    public static Button addButtonActor(Stage stage, String drawableUpPath, String drawableDownPath, float positionX, float positionY,boolean visible, ChangeListener listener) {
        Drawable drawableUp = new Image(new Texture(Gdx.files.internal(drawableUpPath))).getDrawable();
        Drawable drawableDown = new Image(new Texture(Gdx.files.internal(drawableDownPath))).getDrawable();
        Button button = new Button(drawableUp, drawableDown);
        button.setPosition(positionX, positionY);
        button.setVisible(visible);
        button.addListener(listener);
        stage.addActor(button);
        return button;
    }

    public static Button addButtonActor(Stage stage, String drawableUpPath, String drawableDownPath, String drawableCheckedPath, float positionX, float positionY, ChangeListener listener) {
        Drawable drawableUp = new Image(new Texture(Gdx.files.internal(drawableUpPath))).getDrawable();
        Drawable drawableDown = new Image(new Texture(Gdx.files.internal(drawableDownPath))).getDrawable();
        Drawable drawableChecked = new Image(new Texture(Gdx.files.internal(drawableCheckedPath))).getDrawable();
        Button button = new Button(drawableUp, drawableDown, drawableChecked);
        button.setPosition(positionX, positionY);
        button.addListener(listener);
        stage.addActor(button);
        return button;
    }

    public static TextArea addTextAreaActor(Stage stage, String initialText, float positionX, float positionY, float width, float height, TextField.TextFieldStyle style,  boolean disabled) {
        TextArea textArea = new TextArea(initialText, style);
        textArea.setPosition(positionX, positionY);
        textArea.setSize(width, height);
        textArea.setDisabled(disabled);
        stage.addActor(textArea);
        return textArea;
    }

    public static Image addImageActor(Stage stage, String imageFilePath, float positionX, float positionY, boolean visible) {
        Image imageActor = new Image(new Texture(Gdx.files.internal(imageFilePath)));
        imageActor.setPosition(positionX, positionY);
        imageActor.setVisible(visible);
        stage.addActor(imageActor);
        return imageActor;
    }

    public static TextField addTextField(Stage stage, String initialText, float positionX, float positionY, float width, float height, boolean visible, boolean disabled, TextField.TextFieldStyle style) {
        TextField textField = new TextField(initialText, style);
        textField.setPosition(positionX, positionY);
        textField.setSize(width, height);
        textField.setVisible(visible);
        textField.setDisabled(disabled);
        stage.addActor(textField);
        return textField;
    }

    public static SelectBox addSelectBox(Stage stage, SelectBox.SelectBoxStyle style, float positionX, float positionY, float width, float height, int maxListCount, String... items) {
        SelectBox<String> selectBox = new SelectBox<String>(style);
        selectBox.setPosition(positionX, positionY);
        selectBox.setSize(width, height);
        selectBox.setMaxListCount(maxListCount);
        selectBox.setItems(items);
        stage.addActor(selectBox);
        return selectBox;
    }
}
