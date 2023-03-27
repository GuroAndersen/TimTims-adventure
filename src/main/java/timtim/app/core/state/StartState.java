package timtim.app.core.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;
import timtim.app.core.AccessibleGame;
import timtim.app.core.StateHandler;

public class StartState implements StateHandler {

    ShapeRenderer shape;
    SpriteBatch batch;
    BitmapFont font;
    private final AccessibleGame game;

    public StartState (AccessibleGame game) {
        this.game = game;
        shape = new ShapeRenderer();

        this.batch = new SpriteBatch();
        this.font = new BitmapFont();

    }

    @Override
    public void render() {
        // render game in paused state
        handleInput();

        batch.begin();

        // Calculate the center position of the screen
        float centerX = game.getCamera().viewportWidth / 2f;
        float centerY = game.getCamera().viewportHeight / 2f;

        // Draw PauseScreen centered on the screen

        font.draw(batch, "TimTim is having a break!", centerX, centerY, 0, Align.center, false);

        font.draw(batch, "Press 'P' to resume", centerX, centerY - 40, 0, Align.center, false);

        batch.end();
    }



    @Override
    public State getState() {
        return State.START;
    }

    private void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            startGame();
        }
    }

    private void startGame(){
        game.switchState(State.PLAY);
    }
}
