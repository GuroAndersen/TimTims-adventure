package timtim.app.core.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;
import timtim.app.core.AccessibleGame;
import timtim.app.core.StateHandler;
import com.badlogic.gdx.graphics.Color;

import java.awt.*;

public class PauseState implements StateHandler {

    ShapeRenderer shape;
    SpriteBatch batch;
    BitmapFont font;
    private final AccessibleGame game;

    public PauseState (AccessibleGame game) {
        this.game = game;
        shape = new ShapeRenderer();

        this.batch = new SpriteBatch();
        this.font = new BitmapFont();

    }
    @Override
    public void render() {
        // render game in paused state
        update();

        // draw black transparent background
        game.renderMap();
        Gdx.gl.glClearColor(100, 0, 100, 0.5f);

        // draw pause menu
        batch.begin();

        // Calculate the center position of the screen
        float centerX = game.getCamera().viewportWidth / 2f;
        float centerY = game.getCamera().viewportHeight / 2f;

        // Draw "game over" centered on the screen

        font.draw(batch, "Game Over", centerX, centerY, 0, Align.center, false);
    
        font.draw(batch, "Press 'P' to resume", centerX, centerY - 20, 0, Align.center, false);

        batch.end();
        }

    @Override
    public State getState() {
        return State.PAUSE;
    }

    private void update() {
        handleInput();
        game.updateCamera();
    }

    private void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)){
            resume();
        }
    }

    private void resume() {
        game.switchState(State.PLAY);
    }
}
