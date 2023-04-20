package timtim.app.model.objects.friend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import timtim.app.model.map.GameMap;
import timtim.app.model.objects.inventory.Item;

public class FriendTest {

	private Friend friend;

	@BeforeEach
	public void setUp() {
		Item item = new Item("teddy", "A stuffed bear");
		this.friend = new Friend(item, new GameMap("test")) {
			@Override
			public void update(float delta) {
			}
		};
	}

	/**
	 * Test that the friend, when receiving the correct gift, has recieved a gift.
	 * And that the friend has not received a gift when the incorrect gift is given.
	 */
	@Test
	public void testReceiveGift() {
		assertFalse(friend.hasReceivedGift());
		Item trueItem = new Item("teddy", "A stuffed bear");
		Item falseItem = new Item("trampoline", "Something to jump on");
		assertFalse(friend.receiveGift(falseItem));
		assertFalse(friend.hasReceivedGift());
		assertTrue(friend.receiveGift(trueItem));
		assertTrue(friend.hasReceivedGift());
	}

	/**
	 * Test that a friend changes their outputed conversation when
	 * updateConversation is called, and when the correct gift is given to the
	 * friend.
	 */
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
		friend.updateConversation();
		assertEquals("Thanks for the teddy!", friend.getConversation());
	}

	/**
	 * Test that when the friend is given the correct gift, the map it exists on is
	 * set to complete.
	 */
	@Test
	public void testMapChangeFromGift() {
		Item item = new Item("tooth", "A small bone");
		GameMap map = new GameMap("Testing");
		assertFalse(map.isComplete());
		Friend friend = new Friend(item, map) {
			@Override
			public void update(float delta) {
			}
		};
		Item item2 = new Item("tooth", "A small bone");
		assertTrue(friend.receiveGift(item2));
		friend.receiveGift(item);
		assertTrue(map.isComplete());
	}

}
