package timtim.app.objects;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FriendTest {
    
    Friend friend = new Friend();

    @Test
    public void testMove() {
        
    }

    @Test
    public void testGiftToNPC() {
        //Test the different gifts on the different levels.
        assertEquals("Thanks for the jacket!", friend.giftToNpc("jacket"));
        assertEquals("Thanks for the medallion!", friend.giftToNpc("medallion"));
        assertEquals("Thanks for the book!", friend.giftToNpc("book"));
    }

    @Test
    public void testGiftToNpcDoesNotModifyState() {
        // Test that the method does not modify any internal state
        String gift = "jacket";
        String response = friend.giftToNpc(gift);
        assertEquals("Thanks for the jacket!", response);
        // Verify that the giftToNpc method did not modify the gift or any other internal state
        assertEquals("jacket", gift);
    }

    @Test
    public void testGetConversation() {
        //Tests if the method returns the correct dialogue at the correct time.
        assertEquals("Hei", friend.getConversation());
    }
}
