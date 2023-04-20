package timtim.app.model;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.*;

import timtim.app.core.GameScreen;
import timtim.app.core.state.PlayState;
import timtim.app.core.state.State;
import timtim.app.model.map.GameMap;
import timtim.app.model.objects.Chest;
import timtim.app.model.objects.Door;
import timtim.app.model.objects.Flora;
import timtim.app.model.objects.Player;
import timtim.app.model.objects.friend.Friend;
import timtim.app.model.objects.inventory.Item;

public class MyContactListener implements ContactListener {

    private IGameModel model;
    private GameMap gameMap;
    private GameScreen game;
    private PlayState playState;

    public MyContactListener(IGameModel model, GameScreen game, GameMap gameMap) {
        this.model = model;
        this.game = game;
        this.gameMap = gameMap;
    }

    // Gets activated when two objects make contact with eachother.
    @Override
    public void beginContact(Contact contact) {

        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        // fb.getBody().getPosition());

        if ((fa.getUserData() == null || fb.getUserData() == null) || fa == null || fb == null) {
            // System.out.println("fa: " + fa.getUserData());
            // System.out.println("fb: " + fb.getUserData());
            return;
        }

        if ((fa.getUserData() instanceof Player && fb.getUserData() instanceof Door)
                || (fa.getUserData() instanceof Door && fb.getUserData() instanceof Player)) {
            Player p = (Player) (fa.getUserData() instanceof Player ? fa.getUserData() : fb.getUserData());
            Door d = (Door) (fa.getUserData() instanceof Door ? fa.getUserData() : fb.getUserData());

            if (gameMap.isComplete())
                game.switchState(State.START);

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
        if ((fa.getUserData() instanceof Player && fb.getUserData() instanceof Friend)
                || (fa.getUserData() instanceof Friend && fb.getUserData() instanceof Player)) {
            Friend f = (Friend) (fa.getUserData() instanceof Friend ? fa.getUserData() : fb.getUserData());
            Player p = (Player) (fa.getUserData() instanceof Player ? fa.getUserData() : fb.getUserData());

            if (p.getInventory().contains(f.item))
                f.receiveGift(p.getInventory().takeOutItem(f.item));

            f.updateConversation();
        }
        if ((fa.getUserData() instanceof Player && fb.getUserData() instanceof Flora)
                || (fa.getUserData() instanceof Flora && fb.getUserData() instanceof Player)) {
            Flora f = (Flora) (fa.getUserData() instanceof Flora ? fa.getUserData() : fb.getUserData());
            Player p = (Player) (fa.getUserData() instanceof Player ? fa.getUserData() : fb.getUserData());
            p.takeDamage(f.damage());
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
