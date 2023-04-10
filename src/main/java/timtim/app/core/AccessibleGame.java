package timtim.app.core;

import com.badlogic.gdx.graphics.OrthographicCamera;
import timtim.app.core.state.State;
import timtim.app.model.GameModel;
import timtim.app.model.IGameModel;

public interface AccessibleGame {

    /**
     * Get the game's model
     * @return
     */
    public IGameModel getModel();

    /**
     * Move the player left and or right.
     * If both left and right is pressed, nothing happens.
     * @param left
     * @param right
     */
    public void playerMove(boolean left, boolean right);

    /**
     * Make the player jump
     */
    public void playerJump();
    
    /**
     * Activate player interaction
     */
    public void playerInteract();

    /**
     * Update the camera
     */
    public void updateCamera();

    /**
     * Renders the map in this game's model
     */
    public void renderMap();

    /**
     * Switches the state of the game
     * to the given state
     */
    public void switchState(State state);

    /**
     * Get the game's camera
     */
    public OrthographicCamera getCamera();
}
