package com.jett.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jett.game.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1900;
		config.height = 1080;
		config.title = "Fantasy Sim Game";
		config.fullscreen = false;
		new LwjglApplication(new Main(), config);
	}
}
