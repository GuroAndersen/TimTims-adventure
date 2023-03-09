package timtim.app.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import timtim.app.objects.Inventory.Item;

public class FriendTest {

    @Test
    public void testMove() {
        // IFriend friend = new IFriend();

        /**
         * Move right.
         * Test if the Friend object moves 6 spaces to the right.
         */
        // friend.move(false, true);
        // assertEquals(6, friend.getX());

        /**
         * Move left.
         * Test if the Friend object moves 6 spaces to the left.
         */
        // friend.move(true, false);
        // assertEquals(6, friend.getX());
    }

    @Test
    public void testGiftToNPC() {
        Item item = new Item("jakke", "grønn jakke");
        IFriend friend = new Friend();
        // Test the different gifts on the different levels.
        assertEquals("Takk for jakke!", friend.giftToNpc(item));
        // assertEquals("Takk for medaljongen!", friend.giftToNpc());
        // assertEquals("Takk for boken!", friend.giftToNpc());
    }

    @Test
    public void testGiftToNpcDoesNotModifyState() {
        // Test that the method does not modify any internal state
        Item item = new Item("jakke", "grønn jakke");
        IFriend friend = new Friend();
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
        IFriend friend = new Friend();
        assertEquals("Hei", friend.getConversation());
        assertEquals("Kan du hjelpe meg?", friend.getConversation());
        assertEquals("Jeg trenger en jakke", friend.getConversation());
        assertEquals("Se etter kister", friend.getConversation());
        assertEquals(null, friend.getConversation());
    }
}
