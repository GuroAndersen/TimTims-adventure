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
     * Gives item to friend and returns
     *  a String responce if true
     */
    public String giftToNpc(Item item);
}
