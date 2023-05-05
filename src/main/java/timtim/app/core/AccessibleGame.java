package timtim.app.core;

import com.badlogic.gdx.graphics.OrthographicCamera;
import timtim.app.core.state.State;
import timtim.app.model.IGameModel;

public interface AccessibleGame {

    /**
     * Get the game's model
     * @return
     */
    IGameModel getModel();

    /**
     * Move the player left and or right.
     * If both left and right is pressed, nothing happens.
     * @param left
     * @param right
     */
    void playerMove(boolean left, boolean right);

    /**
     * Make the player jump
     */
    void playerJump();

    /**
     * Update the camera
     */
    void updateCamera();

    /**
     * Renders the map in this game's model
     */
    void renderMap();

    /**
     * Switches the state of the game
     * to the given state
     */
    void switchState(State state);

    /**
     * Get the game's camera
     */
    OrthographicCamera getCamera();

}
