package timtim.app.objects;


public interface IFriend {
    
    /**
     * The Friend object will move back and forth based on one tile.
     * It will move a given distance on the x direction.
     */
    public void move();

    /**
     * After interaction is started getConversation will get strings 
     * to be printed from a list of string options.
     */
    public String getConversation();

    /**
     * 
     * 
     */
    public boolean hasRecievedGift();

    /**
     * Friend can recieve gift from user
     */
    public String giftToNpcDialogue();
}
