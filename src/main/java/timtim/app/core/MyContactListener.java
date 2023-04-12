package timtim.app.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.*;

import timtim.app.objects.Player;
import timtim.app.objects.GameObjects.Chest;
import timtim.app.objects.GameObjects.Door;
import timtim.app.objects.GameObjects.Flora;
import timtim.app.objects.Inventory.Item;

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
            // System.out.println("Fixture A user data: " + fa.getUserData());
            // System.out.println("Fixture B user data: " + fb.getUserData());

            // Here we need to have a key pressed to either open the menu or to continue
            // directly to the next level.
        }
        if ((fa.getUserData() instanceof Player && fb.getUserData() instanceof Chest)
                || (fa.getUserData() instanceof Chest && fb.getUserData() instanceof Player)) {

            // if (Gdx.input.isKeyPressed(Input.Keys.F)) {
            Chest chest = (Chest) (fa.getUserData() instanceof Chest ? fa.getUserData() : fb.getUserData());
            if (!chest.isOpen()) {
                chest.open();
                Item item = chest.getItem();
                if (fa.getUserData() instanceof Player) {
                    Player p = (Player) fa.getUserData();
                    p.addItemToInventory(item);

                } else if (fb.getUserData() instanceof Player) {
                    Player p = (Player) fb.getUserData();
                    p.addItemToInventory(item);
                }
                System.out.println(chest.getItem() + " added to the inventory!");
            }

            // }
            // This also needs a restriction where the open option is only given when the
            // chest is closed and after it has no reaction.
        }
        if ((fa.getUserData() instanceof Player && fb.getUserData() instanceof Flora)
                || (fa.getUserData() instanceof Flora && fb.getUserData() instanceof Player)) {
            System.out.println("OH NO I HAVE A POLLEN ALLERGY!");
            if (fa.getUserData() instanceof Player) {
                Player p = (Player) fa.getUserData();
                p.takeDamage(1);
            } else if (fb.getUserData() instanceof Player) {
                Player p = (Player) fb.getUserData();
                p.takeDamage(1);
            }
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
