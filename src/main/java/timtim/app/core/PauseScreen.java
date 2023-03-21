package timtim.app.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PauseScreen extends ScreenAdapter {
    private GameScreen gameScreen;
    private SpriteBatch batch;
    private BitmapFont font;

    public PauseScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;

        // create SpriteBatch and BitmapFont
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        // render game in paused state
        gameScreen.render(delta);

        // draw black transparent background
        Gdx.gl.glClearColor(0, 0, 0, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // draw pause menu
        batch.begin();
        font.draw(batch, "Game Paused", 100, 200);
        font.draw(batch, "Press 'P' to resume", 100, 150);
        batch.end();
    }

    @Override
    public void dispose() {
        // dispose SpriteBatch and BitmapFont
        batch.dispose();
        font.dispose();
    }

}