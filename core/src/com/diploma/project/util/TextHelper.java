package com.diploma.project.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.diploma.project.constants.Resources;

import static com.diploma.project.constants.LobbyConstants.PLAYER_NAME_FONT_HEIGHT;

/**
 * Класс - помощник для работы с текстом
 */
public class TextHelper {

    /**
     * Получить стиль текста
     *
     * @param fontFilePath      путь к ресурсу шрифта
     * @param fontHeight        высота шрифта
     * @param cursorFilePath    путь к ресурсу курсора
     * @param selectionFilePath путь к ресурсу выделения текста
     * @param fontColor         цвет шрифта
     * @return экземлпяр стиля текста
     */
    public static TextField.TextFieldStyle getTextFieldStyle(String fontFilePath, float fontHeight, String cursorFilePath, String selectionFilePath, Color fontColor) {
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.cursor = new Image(new Texture(Gdx.files.internal(cursorFilePath))).getDrawable();
        textFieldStyle.cursor.setMinHeight(2f);
        textFieldStyle.selection = new Image(new Texture(Gdx.files.internal(selectionFilePath))).getDrawable();
        textFieldStyle.font = getBitmapFont(fontFilePath, fontHeight);
        textFieldStyle.fontColor = fontColor;
        return textFieldStyle;
    }

    /**
     * Получить стиль выборки
     *
     * @param font                        шрифт
     * @param fontColor                   цвет шрифта
     * @param selectBoxBackgroundFilePath путь к ресурсу заднего фона выборки
     * @param fontColorSelected           цвет шрифта выбранного элемента
     * @param fontColorUnselected         цвет шрифта не выбранного элемента
     * @param dropBoxSelectionFilePath    путь к ресурсу выделения текста для выпадающего списка
     * @return экземпляр стиля выборки
     */
    public static SelectBox.SelectBoxStyle getSelectBoxStyle(BitmapFont font, Color fontColor, String selectBoxBackgroundFilePath, Color fontColorSelected, Color fontColorUnselected, String dropBoxSelectionFilePath) {
        SelectBox.SelectBoxStyle selectBoxStyle = new SelectBox.SelectBoxStyle(
                font,
                fontColor,
                new Image(new Texture(selectBoxBackgroundFilePath)).getDrawable(),
                new ScrollPane.ScrollPaneStyle(),
                new List.ListStyle(font, fontColorSelected, fontColorUnselected, new Image(new Texture(dropBoxSelectionFilePath)).getDrawable())
        );
        return selectBoxStyle;
    }

    /**
     * Получить шрифт
     *
     * @param fontFilePath путь к ресурсу шрифта
     * @param fontHeight   высота шрифта
     * @return экземпляр шрифта
     */
    public static BitmapFont getBitmapFont(String fontFilePath, float fontHeight) {
        BitmapFont font = new BitmapFont(Gdx.files.internal(fontFilePath));
        font.getData().setScale(fontHeight * font.getScaleY() / font.getLineHeight());
        return font;
    }

    /**
     * Получить стандартный стиль шрифта для приложения
     *
     * @return стиль ширфта
     */
    public static TextField.TextFieldStyle getDefaultTextFieldStyle() {
        return getTextFieldStyle(Resources.TEXT_FONT, PLAYER_NAME_FONT_HEIGHT, Resources.TEXT_CURSOR, Resources.TEXT_SELECTION, Color.BLACK);
    }

}
