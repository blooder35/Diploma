package com.diploma.project.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.diploma.project.actors.MapBlockActor;
import com.diploma.project.actors.PlayerActor;
import com.diploma.project.constants.ColorType;
import com.diploma.project.maps.blocks.MapBlock;

/**
 * Класс - помощник по созданию и добавлению актёров на сцену
 */
public class ActorHelper {

    /**
     * Добавить актёра - кнопку
     *
     * @param stage            сцена
     * @param drawableUpPath   путь к ресурсу не нажатой кнопки
     * @param drawableDownPath путь к ресурсу нажатой кнопки
     * @param positionX        х координата левого нижнего угла
     * @param positionY        y координата левого нижнего угла
     * @param visible          видима ли кнопка
     * @param listener         слушатель нажатия кнопки
     * @return Экземпляр кнопки
     */
    public static Button addButtonActor(Stage stage, String drawableUpPath, String drawableDownPath, float positionX, float positionY, boolean visible, ChangeListener listener) {
        Drawable drawableUp = new Image(new Texture(Gdx.files.internal(drawableUpPath))).getDrawable();
        Drawable drawableDown = new Image(new Texture(Gdx.files.internal(drawableDownPath))).getDrawable();
        Button button = new Button(drawableUp, drawableDown);
        button.setPosition(positionX, positionY);
        button.setVisible(visible);
        button.addListener(listener);
        stage.addActor(button);
        return button;
    }

    /**
     * Добавление актёра - текстовой области
     *
     * @param stage       сцена
     * @param initialText начальный текст
     * @param positionX   х координата левого нижнего угла
     * @param positionY   y координата левого нижнего угла
     * @param width       ширина области
     * @param height      высота области
     * @param style       стиль текста области
     * @param disabled    возможно ли выделение текста в области
     * @return экземпляр текстовой области
     */
    public static TextArea addTextAreaActor(Stage stage, String initialText, float positionX, float positionY, float width, float height, TextField.TextFieldStyle style, boolean disabled) {
        TextArea textArea = new TextArea(initialText, style);
        textArea.setPosition(positionX, positionY);
        textArea.setSize(width, height);
        textArea.setDisabled(disabled);
        stage.addActor(textArea);
        return textArea;
    }

    /**
     * Добавление актёра - картинки
     *
     * @param stage         сцена
     * @param imageFilePath путь к ресурсу картинки
     * @param positionX     х координата левого нижнего угла
     * @param positionY     y координата левого нижнего угла
     * @param visible       является ли картинка видимой
     * @return экземпляр актёра картинки
     */
    public static Image addImageActor(Stage stage, String imageFilePath, float positionX, float positionY, boolean visible) {
        Image imageActor = new Image(new Texture(Gdx.files.internal(imageFilePath)));
        imageActor.setPosition(positionX, positionY);
        imageActor.setVisible(visible);
        stage.addActor(imageActor);
        return imageActor;
    }

    /**
     * Добавление актёра - текстового поля
     *
     * @param stage       сцена
     * @param initialText начальный текст
     * @param positionX   х координата левого нижнего угла
     * @param positionY   y координата левого нижнего угла
     * @param width       ширина
     * @param height      высота
     * @param visible     является ли поле видимым
     * @param disabled    возможно ли взаимодействие с текстом в поле
     * @param style       стиль текста поля
     * @return экземпляр текстового поля
     */
    public static TextField addTextField(Stage stage, String initialText, float positionX, float positionY, float width, float height, boolean visible, boolean disabled, TextField.TextFieldStyle style) {
        TextField textField = new TextField(initialText, style);
        textField.setPosition(positionX, positionY);
        textField.setSize(width, height);
        textField.setVisible(visible);
        textField.setDisabled(disabled);
        stage.addActor(textField);
        return textField;
    }

    /**
     * Добавление актёра - выборки
     *
     * @param stage        сцена
     * @param style        стиль выборки
     * @param positionX    х координата левого нижнего угла
     * @param positionY    y координата левого нижнего угла
     * @param width        ширина
     * @param height       высота
     * @param maxListCount максимальное количество элементов в выборке
     * @param items        элементы выборки
     * @return экземпляр актёра - выборки
     */
    public static SelectBox addSelectBox(Stage stage, SelectBox.SelectBoxStyle style, float positionX, float positionY, float width, float height, int maxListCount, String... items) {
        SelectBox<String> selectBox = new SelectBox<String>(style);
        selectBox.setPosition(positionX, positionY);
        selectBox.setSize(width, height);
        selectBox.setMaxListCount(maxListCount);
        selectBox.setItems(items);
        stage.addActor(selectBox);
        return selectBox;
    }

    /**
     * Добавление актёра игрока
     *
     * @param stage         сцена
     * @param imageFilePath путь к файлу с текстурой для отрисовки
     * @param positionX     х координата левого нижнего угла
     * @param positionY     y координата левого нижнего угла
     * @param visible       является ли актёр видимым
     * @return экземпляр актёра игрока
     */
    public static PlayerActor addPlayerActor(Stage stage, String imageFilePath, float positionX, float positionY, boolean visible) {
        PlayerActor playerActor = new PlayerActor(new Texture(imageFilePath), ColorType.BLACK);
        playerActor.setPosition(positionX, positionY);
        playerActor.setVisible(visible);
        stage.addActor(playerActor);
        return playerActor;
    }

    /**
     * Добавление актёра элемента карты
     *
     * @param stage сцена
     * @param block блок карты
     * @return экземпляр актёра блока карты
     */
    public static MapBlockActor addMapBlockActor(Stage stage, MapBlock block) {
        MapBlockActor mapBlockActor = new MapBlockActor(block);
        stage.addActor(mapBlockActor);
        return mapBlockActor;
    }
}
