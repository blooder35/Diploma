package com.diploma.project.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.diploma.project.DiplomaProject;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Diploma";
		config.height = 1080;
		config.width = 1920;
		config.vSyncEnabled = true;
		new LwjglApplication(new DiplomaProject(), config);
	}
}
