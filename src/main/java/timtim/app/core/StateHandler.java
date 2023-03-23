package timtim.app.core;

import timtim.app.core.state.State;

public interface StateHandler {


    /**
     * Render this state
     */
    public void render();


    /**
     * Returns the state type
     * @return state
     */
    public State getState();

}
