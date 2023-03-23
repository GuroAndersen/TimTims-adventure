package timtim.app.core;

import com.badlogic.gdx.physics.box2d.*;

import timtim.app.objects.Player;
import timtim.app.objects.GameObjects.Door;

public class MyContactListener implements ContactListener {

    // Gets activated when two objects make contact with eachother.
    @Override
    public void beginContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        // System.out.println("a: " + fa.getBody().getPosition() + ", " + "b: " +
        // fb.getBody().getPosition());

        if ((fa.getUserData() == null || fb.getUserData() == null) || fa == null || fb == null) {
            // System.out.println("fa: " + fa.getUserData());
            // System.out.println("fb: " + fb.getUserData());
            return;
        }

        if ((fa.getUserData() instanceof Player && fb.getUserData() instanceof Door)
                || (fa.getUserData() instanceof Door && fb.getUserData() instanceof Player)) {
            System.out.println("Player and door collided!");
            System.out.println("Fixture A user data: " + fa.getUserData());
            System.out.println("Fixture B user data: " + fb.getUserData());
        } else {
            System.out.println("A collision happened!");

        }

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
