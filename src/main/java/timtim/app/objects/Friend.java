package timtim.app.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Friend extends GameEntity implements IFriend {

    private String[] dialogueOptions = { "Hei", "Kan du hjelpe meg?", "Jeg trenger en jakke", "Se etter kister" };
    private int dialogueCounter = 0;
    private String[] giftDialogueOptions = { "Takk for jakken!", "Takk for medaljongen", "Takk for boken" };
    private int interactionCounter = 0;

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
        if (interactionCounter > 0) {
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
        // If the player has the item in his inventory then by pressing e while close to
        // Friend will return true.
        // If the player does not have the item it will return false.

        /**
         * If (player has item) {
         * return true;
         * }
         * else {
         * return false;
         * }
         * 
         * 
         */
        return true;
    }

    public String giftToNpc() {

        if (hasRecievedGift() == true)
            return giftDialogueOptions[0];

        return null;
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        // This method is supposed to be a restricted move method where the Friend
        // object can only move a certain way.
        // A starter coordinate and then move x ammount of steps in left and right
        // direction.

        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    public String giftToNpcDialogue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'giftToNpcDialogue'");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void render(SpriteBatch batch) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }
}
