package com.evgeny.kravchenko.timeshow.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.evgeny.kravchenko.timeshow.TimeShow;

import java.awt.*;

public class DesktopLauncher {
	public static void main (String[] arg) {

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		config.width = 500;
		config.height = 250;

		config.x = screenSize.width - config.width;
		config.y = 0;

		new LwjglApplication(new TimeShow(), config);
	}
}
