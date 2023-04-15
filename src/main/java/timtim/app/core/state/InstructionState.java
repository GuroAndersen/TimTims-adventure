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
import timtim.app.core.AccessibleGame;
import timtim.app.core.StateHandler;

public class InstructionState implements StateHandler {

    ShapeRenderer shape;
    SpriteBatch batch;
    BitmapFont font;
    private final AccessibleGame game;

    public InstructionState (AccessibleGame game) {
        this.game = game;
        shape = new ShapeRenderer();
        this.batch = new SpriteBatch();
        this.font = new BitmapFont();

    }

    @Override
    public void render(float delta) {
        // render game in how to play state
        handleInput();

        batch.begin();

        // Load the image
        Texture imgage = new Texture(Gdx.files.internal("timtimArt.png"));
        Sprite imgSprite = new Sprite(imgage);

        // Calculate the center position of the screen
        float centerXtext = game.getCamera().viewportWidth / 2f;
        float centerYtext = game.getCamera().viewportHeight / 2f ;
        float imageX = game.getCamera().viewportWidth / 5f;
        float imageY = game.getCamera().viewportHeight / 2f;

        // Set the position of the image to be centered on the screen
        imgSprite.setPosition(imageX - imgSprite.getWidth() / 2f -20,
                imageY - imgSprite.getHeight() / 2f );

        // Set the scale of the image
        imgSprite.setScale(0.2f); // Scale the image by half

        //clears the screen 
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw the image and the text
        imgSprite.draw(batch);
        font.draw(batch, "How to play Timtim's adventure!", centerXtext + 35, centerYtext + 150, 0, Align.center, false);
        font.draw(batch, "Press 'A' to move to the left and 'D' to move right." , centerXtext + 35, centerYtext + 100, 0, Align.center, false);
        font.draw(batch, "Press 'Space' to jump!", centerXtext + 35, centerYtext + 50, 0, Align.center, false);
        font.draw(batch, "If you ever want to give TimTim a break, just press 'P' in game!", centerXtext + 35, centerYtext, 0, Align.center, false);
        font.draw(batch, "Press 'M' to return to Main Menu, and 'Escape' to exit the game", centerXtext + 35, centerYtext - 50, 0, Align.center, false);

        batch.end();
    }


    @Override
    public State getState() {
        return State.INSTRUCTIONS;
    }

    private void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.M)){
            returnToMenu();
        }
    }

    private void returnToMenu(){
        game.switchState(State.START);
    }
    
}
