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
        GameScreen gameScreen = mock(GameScreen.class);
        GameMap gameMap = mock(GameMap.class);
        PlayerContactListener playerContactListener = new PlayerContactListener(gameScreen, gameMap);

        Player player = mock(Player.class);
        Door door = mock(Door.class);

        when(fixtureA.getUserData()).thenReturn(player);
        when(fixtureB.getUserData()).thenReturn(door);
        when(gameMap.isComplete()).thenReturn(true);
        playerContactListener.handleDoorContact(fixtureA, fixtureB);

        verify(gameScreen).switchState(State.START);
    }

    @Test
    public void testChestContact() {
        GameScreen gameScreen = mock(GameScreen.class);
        GameMap gameMap = mock(GameMap.class);
        PlayerContactListener playerContactListener = new PlayerContactListener(gameScreen, gameMap);

        Player player = mock(Player.class);
        Chest chest = mock(Chest.class);
        Item item = mock(Item.class);

        when(fixtureA.getUserData()).thenReturn(player);
        when(fixtureB.getUserData()).thenReturn(chest);
        when(chest.isOpen()).thenReturn(false);

        playerContactListener.handleChestContact(fixtureA, fixtureB);

        verify(chest).open();

        verify(player).addItemToInventory(item);
    }

    @Test
    public void testFriendContact() {
        GameScreen gameScreen = mock(GameScreen.class);
        GameMap gameMap = mock(GameMap.class);
        PlayerContactListener playerContactListener = new PlayerContactListener(gameScreen, gameMap);

        Player player = mock(Player.class);
        Friend friend = mock(Friend.class);
        Item item = mock(Item.class);

        when(fixtureA.getUserData()).thenReturn(player);
        when(fixtureB.getUserData()).thenReturn(friend);
        when(player.getInventory()).thenReturn(mock(Inventory.class));
        when(player.getInventory().contains(item)).thenReturn(true);
        when(friend.item).thenReturn(item);
        playerContactListener.handleFriendContact(fixtureA, fixtureB);

        verify(friend).receiveGift(item);
        verify(friend).updateConversation();
    }

    @Test
    public void testFloraContact() {
        GameScreen gameScreen = mock(GameScreen.class);
        GameMap gameMap = mock(GameMap.class);
        PlayerContactListener playerContactListener = new PlayerContactListener(gameScreen, gameMap);

        Player player = mock(Player.class);
        Flora flora = mock(Flora.class);

        when(fixtureA.getUserData()).thenReturn(player);
        when(fixtureB.getUserData()).thenReturn(flora);

        playerContactListener.handleFloraContact(fixtureA, fixtureB);

        verify(player).takeDamage(flora.damage());
    }

    @Test
    public void testDeathzoneContact() {
        GameScreen gameScreen = mock(GameScreen.class);
        GameMap gameMap = mock(GameMap.class);
        PlayerContactListener playerContactListener = new PlayerContactListener(gameScreen, gameMap);

        Player player = mock(Player.class);
        DeathZone deathZone = mock(DeathZone.class);

        when(fixtureA.getUserData()).thenReturn(player);
        when(fixtureB.getUserData()).thenReturn(deathZone);

        playerContactListener.handleDeathzoneContact(fixtureA, fixtureB);

        verify(player).takeDamage(400);
    }

    @Test
    public void testPowerUpContact() {
        GameScreen gameScreen = mock(GameScreen.class);
        GameMap gameMap = mock(GameMap.class);
        PlayerContactListener playerContactListener = new PlayerContactListener(gameScreen, gameMap);

        Player player = mock(Player.class);
        SpeedUp speedUp = mock(SpeedUp.class);

        when(fixtureA.getUserData()).thenReturn(player);
        when(fixtureB.getUserData()).thenReturn(speedUp);
        playerContactListener.handlePowerUpContact(fixtureA, fixtureB);

        verify(speedUp).doPowerupIfActive(player);

    }
}
