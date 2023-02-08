package inf112.game.core;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setIdleFPS(60);
        cfg.useVsync(true);
        cfg.setTitle("TEAM TEAM :^)");
        cfg.setWindowedMode(480, 320);
        // sets fullscreen
        // cfg.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());

        new Lwjgl3Application(new Boot(), cfg);
    }
}