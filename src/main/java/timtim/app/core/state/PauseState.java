package timtim.app.core.state;

import timtim.app.core.AccessibleGame;
import timtim.app.core.StateHandler;

public class PauseState implements StateHandler {

    private final AccessibleGame game;

    public PauseState (AccessibleGame game) {
        this.game = game;
    }
    @Override
    public void render() {

    }

    @Override
    public State getState() {
        return State.PAUSE;
    }

    private void handleInput() {
    }

    private void resume() {
        game.switchState(State.PLAY);
    }
}
