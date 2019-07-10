package com.missionbit.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.missionbit.deepspace.DeepSpace;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = DeepSpace.WIDTH;
		config.height = DeepSpace.HEIGHT;
		new LwjglApplication(new DeepSpace(), config);
	}
}
