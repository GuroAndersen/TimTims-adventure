
public interface IFriend {
    
    /**
     * The Friend object will move back and forth based on one tile.
     * It will move a given distance on the x direction.
     */
    public void move();

    /**
     * After interaction is started a conversation will be started.
     */
    public void getConversation();

    /**
     * Friend can recieve gift from user
     */
    public String giftToNpc(String gift);
}
