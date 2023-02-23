package timtim.app.controller;

import timtim.app.core.GameScreen;

public interface IGameController {
	
	/**
	 * Checks user input and updates the game model and camera
	 * in the GameScreen given as input to the constructor 
	 * of the controller
	 * @param gs GameScreen
	 */
	public void update();
	
}
