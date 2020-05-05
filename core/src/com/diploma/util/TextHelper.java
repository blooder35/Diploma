package com.diploma.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class TextHelper {
    public static TextField.TextFieldStyle getTextFieldStyle(String fontFilePath, float fontHeight, String cursorFilePath, String selectionFilePath, Color fontColor) {
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.cursor = new Image(new Texture(Gdx.files.internal(cursorFilePath))).getDrawable();
        textFieldStyle.cursor.setMinHeight(2f);
        textFieldStyle.selection = new Image(new Texture(Gdx.files.internal(selectionFilePath))).getDrawable();
        textFieldStyle.font = getBitmapFont(fontFilePath, fontHeight);
        textFieldStyle.fontColor = fontColor;
        return textFieldStyle;
    }

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

    public static BitmapFont getBitmapFont(String fontFilePath, float fontHeight) {
        BitmapFont font = new BitmapFont(Gdx.files.internal(fontFilePath));
        font.getData().setScale(fontHeight * font.getScaleY() / font.getLineHeight());
        return font;
    }

}
