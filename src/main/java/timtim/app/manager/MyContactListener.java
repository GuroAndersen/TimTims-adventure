package timtim.app.manager;

import com.badlogic.gdx.physics.box2d.*;

import timtim.app.objects.Player;
import timtim.app.objects.GameObjects.Chest;
import timtim.app.objects.GameObjects.Door;
import timtim.app.objects.GameObjects.Flora;
import timtim.app.model.IGameModel;

public class MyContactListener implements ContactListener {

	private IGameModel model;

	public MyContactListener(IGameModel model) {
		this.model = model;
	}
	
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
            // System.out.println("Fixture A user data: " + fa.getUserData());
            // System.out.println("Fixture B user data: " + fb.getUserData());

            // Here we need to have a key pressed to either open the menu or to continue
            // directly to the next level.
        }
        if ((fa.getUserData() instanceof Player && fb.getUserData() instanceof Chest)
                || (fa.getUserData() instanceof Chest && fb.getUserData() instanceof Player)) {
            System.out.println("Item added to the inventory!");
            // if (Gdx.input.isKeyPressed(Input.Keys.F)) {
            Chest chest = (Chest) (fa.getUserData() instanceof Chest ? fa.getUserData() : fb.getUserData());
            chest.open();
            // }
            // This also needs a restriction where the open option is only given when the
            // chest is closed and after it has no reaction.
        }
        if ((fa.getUserData() instanceof Player && fb.getUserData() instanceof Flora)
                || (fa.getUserData() instanceof Flora && fb.getUserData() instanceof Player)) {
        	System.out.println("POLLEN AHHHHHH");
        	Flora f;
            if (fa.getUserData() instanceof Player) {
            	f = (Flora) (fb.getUserData());
            } else {
            	f = (Flora) (fa.getUserData());
            }
            model.getPlayer().takeDamage(f.damage());
        } else {

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
