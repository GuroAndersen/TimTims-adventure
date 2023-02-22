package timtim.app.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import timtim.app.core.GameScreen;

public class GameController implements IGameController {

	GameScreen gameScreen;
	
	public GameController(GameScreen gs) {
		this.gameScreen = gs;
	}
	
	@Override
	public void update() {
		gameScreen.getModel().update();
		handlePlayerInput();
	}
	
	private void handlePlayerInput() {
		// Exit
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) { //  Closes game if escape is pressed
			Gdx.app.exit();
		}
		
		// Horizontal movement
		boolean moveLeft = false;
		boolean moveRight = false;
		if (Gdx.input.isKeyPressed(Input.Keys.D)) moveRight = true;
		if (Gdx.input.isKeyPressed(Input.Keys.A)) moveLeft = true;
		gameScreen.getModel().getPlayer().move(moveLeft, moveRight);
		
		// Jump
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			gameScreen.getModel().getPlayer().jump();
		}
	}
	
}
