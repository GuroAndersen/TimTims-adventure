package timtim.app.objects;

import timtim.app.objects.Inventory.Item;

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
     * Generates a string responce with the relevant item
     */
    public String giftDialogue();

    /**
     * Gives item to friend and returns a String responce if true
     */
    public String giftToNpc(Item item);
}
