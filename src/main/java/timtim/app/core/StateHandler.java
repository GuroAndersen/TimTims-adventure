package timtim.app.core;

import timtim.app.core.state.State;

public interface StateHandler {


    /**
     * Render this state.
     * @param delta time in seconds since last render
     */
	void render(float delta);


    /**
     * Returns the state type
     * @return state
     */
    public State getState();

}
