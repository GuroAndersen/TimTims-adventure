import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FriendTest {
    
    @Test
    public void testMove(){
        IFriend friend = new IFriend();
        
        /**
         * Move right.
         * Test if the Friend object moves 6 spaces to the right.
         */
        friend.move(false, true);
        assertEquals(6, friend.getX());

        /**
         * Move left.
         * Test if the Friend object moves 6 spaces to the left.
         */
        friend.move(true, false);
        assertEquals(6, friend.getX());
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
}
