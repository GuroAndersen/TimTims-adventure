package timtim.app.model.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;

import com.badlogic.gdx.physics.box2d.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import timtim.app.core.GameScreen;
import timtim.app.core.state.State;
import timtim.app.model.IGameModel;
import timtim.app.model.MyContactListener;
import timtim.app.model.map.GameMap;
import timtim.app.model.objects.friend.Friend;
import timtim.app.model.objects.inventory.Inventory;
import timtim.app.model.objects.inventory.Item;

public class MyContactListenerTest {

    private IGameModel model;
    private GameScreen game;
    private GameMap gameMap;
    private MyContactListener listener;
    private Contact contact;
    private Fixture fixtureA;
    private Fixture fixtureB;

    @BeforeEach
    public void setUp() {
        model = mock(IGameModel.class);
        game = mock(GameScreen.class);
        gameMap = mock(GameMap.class);
        listener = new MyContactListener(model, game, gameMap);
        contact = mock(Contact.class);
        fixtureA = mock(Fixture.class);
        fixtureB = mock(Fixture.class);
        when(contact.getFixtureA()).thenReturn(fixtureA);
        when(contact.getFixtureB()).thenReturn(fixtureB);
    }

    @Test
    public void testBeginContact_PlayerAndDoor() {
        Player player = mock(Player.class);
        Door door = mock(Door.class);
        when(fixtureA.getUserData()).thenReturn(player);
        when(fixtureB.getUserData()).thenReturn(door);
        when(gameMap.isComplete()).thenReturn(true);

        listener.beginContact(contact);

        verify(game).switchState(State.START);
    }

    @Test
    public void testBeginContact_PlayerAndChest() {
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
    public void testBeginContact_PlayerAndFriend() {
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
    public void testBeginContact_PlayerAndFlora() {
        Player player = mock(Player.class);
        Flora flora = mock(Flora.class);
        int damage = 10;
        when(fixtureA.getUserData()).thenReturn(player);
        when(fixtureB.getUserData()).thenReturn(flora);
        when(flora.damage()).thenReturn(damage);

        listener.beginContact(contact);

        verify(player).takeDamage(damage);
    }
}
