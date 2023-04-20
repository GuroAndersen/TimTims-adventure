package timtim.app.model.objects.friend;

import timtim.app.model.objects.inventory.Item;

public interface IFriend {

	/**
	 * This method returns the conversation this friend is speaking
	 */
	public String getConversation();

	/**
	 * This method updates the conversation shown by this friend
	 */
	public void updateConversation();

	/**
	 * Returns true if the NPC has recieved the gift it wanted
	 */
	public boolean hasReceivedGift();

	/**
	 * Friend recieves a gift. If this was the correct gift, return true Else,
	 * return false.
	 */
	public boolean receiveGift(Item item);
}
