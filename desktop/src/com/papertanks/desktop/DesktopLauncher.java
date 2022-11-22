package com.papertanks.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.papertanks.desktop.PaperTanks;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
//		config.setForegroundFPS(60);
		config.setWindowedMode(PaperTanks.WIDTH,PaperTanks.HEIGHT);
//		config.title=PaperTanks.TITLE;
		config.setTitle(PaperTanks.TITLE);
		config.setWindowIcon("paperTanks_assets/icon.png");
		new Lwjgl3Application(new PaperTanks(), config);
	}
}
