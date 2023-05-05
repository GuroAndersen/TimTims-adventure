package timtim.app.core.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import timtim.app.core.AccessibleGame;
import timtim.app.core.StateHandler;

public class PauseState implements StateHandler {

	SpriteBatch batch;
	BitmapFont font;
	private final AccessibleGame game;

	public PauseState(AccessibleGame game) {
		this.game = game;

		this.batch = new SpriteBatch();
		this.font = new BitmapFont();

	}

	@Override
	public void render(float delta) {
		// render game in paused state
		update();

		batch.begin();

		// Load the image
		Texture imgage = new Texture(Gdx.files.internal("timtimArt.png"));
		Sprite imgSprite = new Sprite(imgage);

		// Calculate the center position of the screen
		float imageX = game.getCamera().viewportWidth / 5f;
		float imageY = game.getCamera().viewportHeight / 2f;

		// Set the position of the image to be centered on the screen
		imgSprite.setPosition(imageX - imgSprite.getWidth() / 2f - 20, imageY - imgSprite.getHeight() / 2f);

		// Set the scale of the image
		imgSprite.setScale(0.2f); // Scale the image by half

		// Calculate the center position of the screen
		float centerX = game.getCamera().viewportWidth / 2f;
		float centerY = game.getCamera().viewportHeight / 2f;

		// clears the screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Draw "game over" centered on the screen
		imgSprite.draw(batch);
		// Draw PauseScreen centered on the screen

		font.draw(batch, "TimTim is having a break!", centerX, centerY, 0, Align.center, false);

		font.draw(batch, "Press 'P' to resume", centerX, centerY - 40, 0, Align.center, false);

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
		if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
			resume();
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
			game.switchState(State.START);
		}
	}

	private void resume() {
		game.switchState(State.PLAY);
	}
}
