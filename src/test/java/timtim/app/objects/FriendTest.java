package timtim.app.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import timtim.app.objects.Friend;
import timtim.app.objects.Item;

public class FriendTest {

    Friend friend = new Friend();

    /**
     * Should test that the friend only moves a certain ammout to the left and
     * right.
     * Should also test that the Friend is moving at all.
     */
    @Test
    public void testMove() {

    }

    @Test
    public void testGiftToNPC() {
        Item item = new Item("jakke");
        // Test the different gifts on the different levels.
        assertEquals("Takk for jakke!", friend.giftToNpc(item));
        // assertEquals("Takk for medaljongen!", friend.giftToNpc());
        // assertEquals("Takk for boken!", friend.giftToNpc());
    }

    @Test
    public void testGiftToNpcDoesNotModifyState() {
        // Test that the method does not modify any internal state
        Item item = new Item("jakke");
        String response = friend.giftToNpc(item);
        assertEquals("Takk for jakken!", response);
        // Verify that the giftToNpc method did not modify the gift or any other
        // internal state
        assertEquals("jakke", item.name());
    }

    @Test
    public void testGetConversation() {
        // Tests if the method returns the correct dialogue at the correct time.
        // Returns null when list is done.
        // null should make the text box close due to chat end, but this can be changed.
        assertEquals("Hei", friend.getConversation());
        assertEquals("Kan du hjelpe meg?", friend.getConversation());
        assertEquals("Jeg trenger en jakke", friend.getConversation());
        assertEquals("Se etter kister", friend.getConversation());
        assertEquals(null, friend.getConversation());
    }
}
