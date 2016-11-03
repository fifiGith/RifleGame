package com.rifle.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.rifle.game.RifleGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = RifleGame.WIDTH;
        config.height = RifleGame.HEIGHT;
        new LwjglApplication(new RifleGame(), config);
	}
}
