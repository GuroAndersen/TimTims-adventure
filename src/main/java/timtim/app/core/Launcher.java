package timtim.app.core;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Launcher {

	public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("TimTim's adventure in Wonderland");
        cfg.setWindowedMode(480, 320);
        cfg.useVsync(true);

        new Lwjgl3Application(new Boot(), cfg);
	}

}
