package timtim.app.model.objects;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import timtim.app.core.GameScreen;
import timtim.app.core.state.State;
import timtim.app.model.GameModel;
import timtim.app.model.Collision.PlayerContactListener;
import timtim.app.model.map.GameMap;
import timtim.app.model.objects.friend.Friend;
import timtim.app.model.objects.inventory.Inventory;
import timtim.app.model.objects.inventory.Item;
import timtim.app.model.objects.powerup.Powerup;
import timtim.app.model.objects.powerup.SpeedUp;

public class PlayerContactListenerTest {

    private GameScreen game;
    private GameMap gameMap;
    private GameModel gameModel;
    private PlayerContactListener listener;
    private Contact contact;
    private Fixture fixtureA;
    private Fixture fixtureB;

    @BeforeEach
    public void setUp() {
        game = mock(GameScreen.class);
        gameMap = mock(GameMap.class);
        gameModel = mock(GameModel.class);
        listener = new PlayerContactListener(game, gameMap);
        contact = mock(Contact.class);
        fixtureA = mock(Fixture.class);
        fixtureB = mock(Fixture.class);
        when(contact.getFixtureA()).thenReturn(fixtureA);
        when(contact.getFixtureB()).thenReturn(fixtureB);
    }

    @Test
    public void testHandleDoorContact() {
        Player player = mock(Player.class);
        Door door = mock(Door.class);
        when(fixtureA.getUserData()).thenReturn(player);
        when(fixtureB.getUserData()).thenReturn(door);
        when(gameMap.isComplete()).thenReturn(true);

        listener.beginContact(contact);

        verify(game).switchState(State.START);
    }

    @Test
    public void testChestContact() {
        Player player = mock(Player.class);
        Chest chest = mock(Chest.class);
        Item item = new Item(null, null);
        when(fixtureA.getUserData()).thenReturn(player);
        when(fixtureB.getUserData()).thenReturn(chest);
        when(chest.isOpen()).thenReturn(false);
        when(chest.getItem()).thenReturn(item);

        listener.beginContact(contact);

        verify(chest).open();
        verify(player).addItemToInventory(item);
    }

    @Test
    public void testFriendContact() {
        Player player = mock(Player.class);
        Friend friend = mock(Friend.class);
        Item item = new Item(null, null);
        Inventory inventory = mock(Inventory.class);
        when(player.getInventory()).thenReturn(inventory);
        when(fixtureA.getUserData()).thenReturn(player);
        when(fixtureB.getUserData()).thenReturn(friend);
        when(inventory.contains(friend.item)).thenReturn(true);
        when(inventory.takeOutItem(friend.item)).thenReturn(item);

        listener.beginContact(contact);

        verify(friend).receiveGift(item);
        verify(friend).updateConversation();
    }

    @Test
    public void testFloraContact() {
        Player player = mock(Player.class);
        Flora flora = mock(Flora.class);
        int damage = 10;
        when(fixtureA.getUserData()).thenReturn(player);
        when(fixtureB.getUserData()).thenReturn(flora);
        when(flora.damage()).thenReturn(damage);

        listener.beginContact(contact);

        verify(player).takeDamage(damage);
    }

    @Test
    public void testDeathzoneContact() {
        Player player = mock(Player.class);
        DeathZone deathZone = mock(DeathZone.class);
        when(fixtureA.getUserData()).thenReturn(player);
        when(fixtureB.getUserData()).thenReturn(deathZone);

        listener.beginContact(contact);

        verify(player).takeDamage(400);
    }

    @Test
    public void testPowerUpContact() {
        Player player = mock(Player.class);
        Powerup powerUp = mock(Powerup.class);
        when(fixtureA.getUserData()).thenReturn(player);
        when(fixtureB.getUserData()).thenReturn(powerUp);

        listener.beginContact(contact);
    }
}
