package com.diploma.project;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.diploma.project.constants.Constants;
import com.diploma.project.screens.MainMenuScreen;


public class DiplomaProject extends Game {
	public SpriteBatch batch;
	public Viewport viewPort;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		viewPort = new StretchViewport(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
