package timtim.app.model.objects.friend;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

import timtim.app.manager.Const;
import timtim.app.model.map.GameMap;
import timtim.app.model.objects.inventory.Item;

public class FriendTest {

	private Friend friend;
	
	@BeforeEach
	public void setUp() {
        Item item = new Item("teddy", "A stuffed bear");
		this.friend = new Friend(item) {
            @Override
            public void update(float delta) {}
        };
	}
	
    @Test
    public void testReceiveGift() {
        assertFalse(friend.hasRecievedGift());
        Item trueItem = new Item("teddy", "A stuffed bear");
        Item falseItem = new Item("trampoline", "Something to jump on");
        assertFalse(friend.receiveGift(falseItem));
        assertFalse(friend.hasRecievedGift());
        assertTrue(friend.receiveGift(trueItem));
        assertTrue(friend.hasRecievedGift());
    }

    @Test
    public void testGetConversation() {
    	assertEquals("", friend.getConversation());
        friend.updateConversation();
        assertEquals("Hi, I need a teddy", friend.getConversation());
        friend.updateConversation();
        assertEquals("Can you help me look for a chest?", friend.getConversation());
        friend.updateConversation();
        assertEquals("Can you help me look for a chest?", friend.getConversation());
        
        Item item = new Item("teddy", "A stuffed bear");
        assertTrue(friend.receiveGift(item));
        assertEquals("Thanks for the teddy!", friend.getConversation());
    }

    @Test
    public void testMapChangeFromGift() {
        Item item = new Item("tooth", "A small bone");
        GameMap map = new GameMap("Testing");
        assertFalse(map.isComplete());
        Friend friend = new Friend(map, item) {
            @Override
            public void update(float delta) {}
        };
        Item item2 = new Item("tooth", "A small bone");
        assertTrue(friend.receiveGift(item2));
        friend.receiveGift(item);
        assertTrue(map.isComplete());
    }

}
