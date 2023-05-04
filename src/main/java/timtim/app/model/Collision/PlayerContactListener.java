package timtim.app.model.Collision;

import com.badlogic.gdx.physics.box2d.*;

import timtim.app.core.GameScreen;
import timtim.app.core.state.State;
import timtim.app.model.map.GameMap;
import timtim.app.model.objects.Chest;
import timtim.app.model.objects.DeathZone;
import timtim.app.model.objects.Door;
import timtim.app.model.objects.Flora;
import timtim.app.model.objects.Player;
import timtim.app.model.objects.enemy.Enemy;
import timtim.app.model.objects.friend.Friend;
import timtim.app.model.objects.inventory.Item;
import timtim.app.model.objects.powerup.SpeedUp;
import timtim.app.model.sound.SoundEffect;

public class PlayerContactListener implements ContactListener {

    private GameMap gameMap;
    private GameScreen game;

    public PlayerContactListener(GameScreen game, GameMap gameMap) {
        this.game = game;
        this.gameMap = gameMap;
    }

    // Handles contact between player and power up.
    public void handlePowerUpContact(Fixture fa, Fixture fb) {
        if ((fa.getUserData() instanceof Player && fb.getUserData() instanceof SpeedUp)
                || (fa.getUserData() instanceof SpeedUp && fb.getUserData() instanceof Player)) {
            Player p = (Player) (fa.getUserData() instanceof Player ? fa.getUserData() : fb.getUserData());
            SpeedUp s = (SpeedUp) (fa.getUserData() instanceof SpeedUp ? fa.getUserData() : fb.getUserData());
            s.doPowerupIfActive(p);
            game.getModel().playSound(SoundEffect.POWERUP);
        }

    }

    // Handles contact between player and door.
    public void handleDoorContact(Fixture fa, Fixture fb) {
        if ((fa.getUserData() instanceof Player && fb.getUserData() instanceof Door)
                || (fa.getUserData() instanceof Door && fb.getUserData() instanceof Player)) {

            if (gameMap.isComplete())
                game.switchState(State.START);

        }
    }

    // Handles contact between player and chest.
    public void handleChestContact(Fixture fa, Fixture fb) {
        if ((fa.getUserData() instanceof Player && fb.getUserData() instanceof Chest)
                || (fa.getUserData() instanceof Chest && fb.getUserData() instanceof Player)) {

            Chest chest = (Chest) (fa.getUserData() instanceof Chest ? fa.getUserData() : fb.getUserData());
            if (!chest.isOpen()) {
                chest.open();
                game.getModel().playSound(SoundEffect.CHEST);
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

        }
    }

    // Handles contact between player and friend.
    public void handleFriendContact(Fixture fa, Fixture fb) {
        if ((fa.getUserData() instanceof Player && fb.getUserData() instanceof Friend)
                || (fa.getUserData() instanceof Friend && fb.getUserData() instanceof Player)) {
            Friend f = (Friend) (fa.getUserData() instanceof Friend ? fa.getUserData() : fb.getUserData());
            Player p = (Player) (fa.getUserData() instanceof Player ? fa.getUserData() : fb.getUserData());

            Item friendItem = f.getItem();
            if (p.getInventory().contains(friendItem))
                f.receiveGift(p.getInventory().takeOutItem(friendItem));

            f.updateConversation();
        }
    }

    public void handleFloraContact(Fixture fa, Fixture fb) {
        if ((fa.getUserData() instanceof Player && fb.getUserData() instanceof Flora)
                || (fa.getUserData() instanceof Flora && fb.getUserData() instanceof Player)) {
            Flora f = (Flora) (fa.getUserData() instanceof Flora ? fa.getUserData() : fb.getUserData());
            Player p = (Player) (fa.getUserData() instanceof Player ? fa.getUserData() : fb.getUserData());
            p.takeDamage(f.damage());
            game.getModel().playSound(SoundEffect.HIT);
        }
    }

    public void handleDeathzoneContact(Fixture fa, Fixture fb) {
        // Check if player has made contact with the deathzone
        // If true then player will take full damage
        if ((fa.getUserData() instanceof Player && fb.getUserData() instanceof DeathZone)
                || (fa.getUserData() instanceof DeathZone && fb.getUserData() instanceof Player)) {

            Player p = (Player) (fa.getUserData() instanceof Player ? fa.getUserData() : fb.getUserData());
            p.takeDamage(400);
            game.getModel().playSound(SoundEffect.GAMEOVER);
        }
    }

    public void handleEnemyContact(Fixture fa, Fixture fb) {
        if ((fa.getUserData() instanceof Player && fb.getUserData() instanceof Enemy)
                || (fa.getUserData() instanceof Enemy && fb.getUserData() instanceof Player)) {
            Enemy f = (Enemy) (fa.getUserData() instanceof Enemy ? fa.getUserData() : fb.getUserData());
            Player p = (Player) (fa.getUserData() instanceof Player ? fa.getUserData() : fb.getUserData());

            f.doDamage(p);
            game.getModel().playSound(SoundEffect.HIT);
        }
        if (!game.getModel().getPlayer().isAlive()) {
            game.getModel().playSound(SoundEffect.GAMEOVER);
        }
    }

    // Gets activated when two objects make contact with eachother.
    @Override
    public void beginContact(Contact contact) {

        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        if ((fa.getUserData() == null || fb.getUserData() == null) || fa == null || fb == null) {

            return;
        }

        handleDoorContact(fa, fb);

        handleChestContact(fa, fb);

        handleFriendContact(fa, fb);

        handleFloraContact(fa, fb);

        handleDeathzoneContact(fa, fb);

        handleEnemyContact(fa, fb);

        handlePowerUpContact(fa, fb);
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
