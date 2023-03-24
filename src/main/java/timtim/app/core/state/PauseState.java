package timtim.app.core.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
    public void render(float delta) {
        // render game in paused state
        update();
        // draw black transparent background
        game.renderMap();
        Gdx.gl.glClearColor(100, 0, 100, 0.5f);

        // draw pause menu
        batch.begin();

        //shape.setProjectionMatrix(game.getCamera().combined);
        //shape.begin(ShapeRenderer.ShapeType.Line);
        //shape.setColor(Color.RED);
        //shape.rect(0, 0, 100, 100);
        //shape.end();

        font.draw(batch, "Game Paused", 100, 200);
        font.draw(batch, "Press 'P' to resume", 100, 150);
        
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
