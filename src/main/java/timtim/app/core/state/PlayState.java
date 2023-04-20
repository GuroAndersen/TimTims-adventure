package timtim.app.core.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import timtim.app.core.GameScreen;
import timtim.app.core.StateHandler;
import timtim.app.manager.Const;
import timtim.app.model.HealthBar;
import timtim.app.model.objects.Player;

public class PlayState implements StateHandler {


    private final GameScreen game;
    private final ShapeRenderer shapeRenderer;
    private final SpriteBatch batch;
    private final HealthBar healthBar;


    public PlayState (GameScreen game) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.shapeRenderer = new ShapeRenderer();
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
        healthBar.draw(batch, shapeRenderer);


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
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            moveRight = true;
        if (Gdx.input.isKeyPressed(Input.Keys.A))
            moveLeft = true;
        game.playerMove(moveLeft, moveRight);

        // Jump
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            game.playerJump();
        }


        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            game.switchState(State.PAUSE);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            game.switchState(State.START);
        }

        //remember to edit this if statement when gameover is properly implemented
        if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {
            game.switchState(State.GAMEOVER);
        }
    }

    @Override
    public State getState() {
        return State.PLAY;
    }
}
