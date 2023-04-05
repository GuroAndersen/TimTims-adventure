package timtim.app.objects.Friend;

import timtim.app.objects.GameEntity;
import timtim.app.objects.Inventory.Item;

public abstract class Friend extends GameEntity implements IFriend {

    public Item item;

    private String[] dialogueOptions = { "Hi", "Can you help me?", "I need a " + item.name(),
            "Look for chests" };
    private int dialogueCounter = 0;
    private int interactionCounter = 0;
    
    private boolean itemReceived;

    /**
     * getConversation finds a string to show when a conversation with a Friend has
     * been initiated.
     * Gets it from a list of Strings.
     */
    @Override
    public String getConversation() {
        // First interaction between Player and Friend
        // Will go through the whole list of conversation options
        if (interactionCounter == 0) {
            String currentDialogue = dialogueOptions[dialogueCounter];
            dialogueCounter++;
            if (dialogueCounter >= dialogueOptions.length) {
                dialogueCounter = 0;
                return null;
            }
            return currentDialogue;
        }

        // Second or more interaction between Player and Friend
        // Will only show the relevant parts of dialogue needed
        if (interactionCounter > 0 && hasRecievedGift() == false) {
            int relevantDialogueCounter = 3;
            String relevantDialogue = dialogueOptions[relevantDialogueCounter];
            relevantDialogueCounter++;
            if (relevantDialogueCounter >= dialogueOptions.length) {
                relevantDialogueCounter = 3;
                return null;
            }
            return relevantDialogue;
        }

        interactionCounter++;
        return null;
    }

    @Override
    public boolean hasRecievedGift() {
    	return itemReceived;
    }

    private String giftDialogue() {
        return "Thanks for the " + item.name() + "!";
    }

    @Override
    public String giftToNpc(Item item) {
        this.item = item;
        if (hasRecievedGift() == true)
            return giftDialogue();

        return null;
    }

}
