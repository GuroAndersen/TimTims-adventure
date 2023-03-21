package timtim.app.core;

import com.badlogic.gdx.*;
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
        handleInput();
        // render game in paused state
        gameScreen.render(delta);

        // draw black transparent background
        Gdx.gl.glClearColor(0, 0, 0, 0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // draw pause menu
        batch.begin();
        font.draw(batch, "Game Paused", 100, 200);
        font.draw(batch, "Press 'P' to resume", 100, 150);
        batch.end();
    }

    private void setGameScreen() {
        // switch back to game screen
        gameScreen.paused = false;
        gameScreen.boot.resumeGame();
        Gdx.input.setCursorCatched(true);
        gameScreen.updateCamera();
        gameScreen.update();
        ((Game) Gdx.app.getApplicationListener()).setScreen(gameScreen);
    }


    public void handleInput() {
        // check if 'P' key is pressed
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            setGameScreen();
        }
    }

    @Override
    public void dispose() {
        // dispose SpriteBatch and BitmapFont
        batch.dispose();
        font.dispose();
    }

}