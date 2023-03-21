package timtim.app.core;

import com.badlogic.gdx.physics.box2d.*;

public class MyContactListener implements ContactListener {

    // Gets activated when two objects make contact with eachother.
    @Override
    public void beginContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        if (fa == null || fb == null)
            return;
        if (fa.getUserData() == null || fb.getUserData() == null)
            return;

        System.out.println("A collision happened!");
    }

    // Gets activated when two objects stop having contact with eachother.
    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
