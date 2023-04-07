package timtim.app.objects.Friend;

import timtim.app.objects.Inventory.Item;

public interface IFriend {

    /**
     * After interaction is started getConversation will get strings
     * to be printed from a list of string options.
     */
    public String getConversation();

    /**
     * Returns true if the NPC has recieved
     * the gift it wanted
     */
    public boolean hasRecievedGift();

    /**
     * Friend recieves a gift. If this
     * was the correct gift, return true
     * Else, return false.
     */
    public boolean receiveGift(Item item);
}
