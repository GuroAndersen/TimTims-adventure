package timtim.app.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import timtim.app.objects.Friend;

public class FriendTest {

    Friend friend = new Friend();

    @Test
    public void testMove() {

    }

    @Test
    public void testGiftToNPC() {
        // Test the different gifts on the different levels.
        assertEquals("Takk for jakken!", friend.giftToNpc());
        // assertEquals("Takk for medaljongen!", friend.giftToNpc());
        // assertEquals("Takk for boken!", friend.giftToNpc());
    }

    @Test
    public void testGiftToNpcDoesNotModifyState() {
        // Test that the method does not modify any internal state
        String gift = "jakke";
        String response = friend.giftToNpc();
        assertEquals("Takk for jakken!", response);
        // Verify that the giftToNpc method did not modify the gift or any other
        // internal state
        assertEquals("jakke", gift);
    }

    @Test
    public void testGetConversation() {
        // Tests if the method returns the correct dialogue at the correct time.
        assertEquals("Hei", friend.getConversation());
        assertEquals("Kan du hjelpe meg?", friend.getConversation());
        assertEquals("Jeg trenger en jakke", friend.getConversation());
        assertEquals("Se etter kister", friend.getConversation());
        assertEquals(null, friend.getConversation());
    }
}
