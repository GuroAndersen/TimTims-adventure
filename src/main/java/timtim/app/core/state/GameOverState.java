package timtim.app.core.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;
import timtim.app.core.GameScreen;
import timtim.app.core.StateHandler;




public class GameOverState implements StateHandler {

    private final GameScreen game;

    SpriteBatch batch;
    BitmapFont font;

    public GameOverState(GameScreen game){
        this.game = game;

        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
    }


    @Override
    public void render(float delta) {
        update();

        batch.begin();
         // Load the image
        Texture imgage = new Texture(Gdx.files.internal("timtimArt.png"));
        Sprite imgSprite = new Sprite(imgage);
 
         // Calculate the center position of the screen
        float imageX = game.getCamera().viewportWidth / 5f;
        float imageY = game.getCamera().viewportHeight / 2f;
 
        // Set the position of the image to be centered on the screen
        imgSprite.setPosition(imageX - imgSprite.getWidth() / 2f -20,
                 imageY - imgSprite.getHeight() / 2f );
 
        // Set the scale of the image
        imgSprite.setScale(0.2f); // Scale the image by half


        // Calculate the center position of the screen
        float centerX = game.getCamera().viewportWidth / 2f;
        float centerY = game.getCamera().viewportHeight / 2f;
        
        //clears the screen 
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw "game over" centered on the screen
        imgSprite.draw(batch);

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
