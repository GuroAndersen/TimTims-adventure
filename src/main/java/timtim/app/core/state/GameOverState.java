package timtim.app.core.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;
import timtim.app.core.GameScreen;
import timtim.app.core.StateHandler;




public class GameOverState implements StateHandler {

    private final GameScreen game;

    ShapeRenderer shape;
    SpriteBatch batch;
    BitmapFont font;

    public GameOverState(GameScreen game){
        this.game = game;
        shape = new ShapeRenderer();

        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
    }


    @Override
    public void render(float delta) {
        update();

        batch.begin();

        // Calculate the center position of the screen
        float centerX = game.getCamera().viewportWidth / 2f;
        float centerY = game.getCamera().viewportHeight / 2f;

        // Draw "game over" centered on the screen

        font.draw(batch, "Game Over!", centerX, centerY, 0, Align.center, false);

        font.draw(batch, "Press ENTER to start new game!", centerX, centerY - 40, 0, Align.center, false);

        font.draw(batch, "Press ESCAPE to exit game", centerX, centerY - 60, 0, Align.center, false);

        batch.end();


    }

    private void update() {
        handleInput();
        game.updateCamera();
    }

    @Override
    public State getState() {
        return State.GAMEOVER;
    }

    private void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            game.switchState(State.START);
        }

    }
}
