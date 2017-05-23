package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MainGame;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = MainGame.HEIGHT;
		config.width = MainGame.WIGHT;

		config.title = MainGame.TITLE;
		config.useGL30 = false;
		config.resizable = false;
		new LwjglApplication(new MainGame(), config);

	}
}
