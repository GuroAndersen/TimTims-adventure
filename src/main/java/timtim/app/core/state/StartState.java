package timtim.app.core.state;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
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

    private boolean level1Selected = true;
    private boolean level2Selected = false;
    private boolean level3Selected = false;



    public StartState (AccessibleGame game) {
        this.game = game;
        shape = new ShapeRenderer();

        this.batch = new SpriteBatch();
        this.font = new BitmapFont();

    }

    @Override
    public void render(float delta) {
        // render game in start state
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

        // Draw the image and the text

        imgSprite.draw(batch);
        // Change the color of the level selection text based on which level is currently selected
        if (level1Selected) {
            font.setColor(Color.RED);
        } else {
            font.setColor(Color.WHITE);
        }
        font.draw(batch, "Level1", centerXtext + 35, centerYtext - 50, 0, Align.center, false);

        if (level2Selected) {
            font.setColor(Color.RED);
            game.getModel().swapLevel("level2");
        } else {
            font.setColor(Color.WHITE);
        }
        font.draw(batch, "Level2", centerXtext + 35, centerYtext - 100, 0, Align.center, false);

        if (level3Selected) {
            font.setColor(Color.RED);
        } else {
            font.setColor(Color.WHITE);
        }
        font.draw(batch, "Level3", centerXtext + 35, centerYtext - 150, 0, Align.center, false);

        font.setColor(Color.WHITE);
        font.draw(batch, "Press ENTER to start TimTim's adventure!", centerXtext + 35, centerYtext + 50, 0, Align.center, false);
        font.draw(batch, "If you ever want to give TimTim a break, just press 'P' !", centerXtext + 55, centerYtext, 0, Align.center, false);

        batch.end();
    }



    @Override
    public State getState() {
        return State.START;
    }

    private void handleInput() {

        // Exit
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) { // Closes game if escape is pressed
            Gdx.app.exit();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            startGame();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            if (level1Selected) {
                level1Selected = false;
                level2Selected = true;
                level3Selected = false;
            } else if (level2Selected) {
                level1Selected = false;
                level2Selected = false;
                level3Selected = true;

            } else if (level3Selected){
                level1Selected = true;
                level2Selected = false;
                level3Selected = false;

            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            if (level1Selected) {
                level1Selected = false;
                level2Selected = false;
                level3Selected = true;
            } else if (level2Selected) {
                level1Selected = true;
                level2Selected = false;
                level3Selected = false;
            } else if (level3Selected) {
                level1Selected = false;
                level2Selected = true;
                level3Selected = false;

            }
        }


        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)){
            //game.getModel();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)){
            //game.getModel();
        }
    }

    private void startGame(){
        game.switchState(State.PLAY);
    }
}


