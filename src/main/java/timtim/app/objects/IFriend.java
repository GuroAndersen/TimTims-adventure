
public interface IFriend {
    
    /**
     * The Friend object will move back and forth based on one tile.
     * It will move a given distance on the x direction.
     */
    public void move(boolean moveLeft, boolean moveRight);

    /**
     * Allows the Friend object to be interacted with
     */
    public void initiateConversation(String conversation);

    /**
     * Friend can recieve gift from user
     */
    public String giftToNpc(String gift);
}
