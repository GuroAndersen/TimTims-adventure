package timtim.app.core.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import timtim.app.core.GameScreen;
import timtim.app.core.StateHandler;
import timtim.app.model.HealthBar;

public class PlayState implements StateHandler {


    private final GameScreen game;
    private final SpriteBatch batch;
    private final HealthBar healthBar;


    public PlayState (GameScreen game) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.healthBar =  new HealthBar(30, 40, 100, 40, Color.BLACK, Color.GREEN, game.getModel().getPlayer());
    }

    @Override
    public void render(float delta) {
        update(delta);

        // Removes all graphics and animations from last frame
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Render map and player and objects
        game.renderMap();
        //draws the healthbar on screen
        healthBar.draw(batch);
    }
    
    private void update(float delta) {
        handleInput();
        game.getModel().update(delta);
        game.updateCamera();
    }

    private void handleInput() {

        // Horizontal movement
        boolean moveLeft = false;
        boolean moveRight = false;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            moveRight = true;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            moveLeft = true;
        game.playerMove(moveLeft, moveRight);

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            game.playerJump();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            game.switchState(State.PAUSE);
        }

    }

    @Override
    public State getState() {
        return State.PLAY;
    }
}
