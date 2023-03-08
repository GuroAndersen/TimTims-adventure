package timtim.app.objects;

public class Friend implements IFriend {
    
    private String[] dialogueOptions = {"Hei", "Kan du hjelpe meg?", "Jeg trenger en jakke", "Se etter kister"};
    private int dialogueCounter = 0;
    private String[] giftDialogueOptions = {"Takk for jakken!", "Takk for medaljongen", "Takk for boken"};

    /**
     * getConversation finds a string to show when a conversation with a Friend has been initiated.
     * Gets it from a list of Strings.
     */
    @Override
    public String getConversation() {
        
        
        for (String dialogue : dialogueOptions) {
            if (isEKeyPressed) {
                String currentDialogue = dialogueOptions[dialogueCounter];
                dialogueCounter++;
                if (dialogueCounter >= dialogueOptions.length) {
                    dialogueCounter = 0;
                }
                return currentDialogue;
            } 
            else {
                return null;
            }
        }
    }

    @Override
    public boolean hasRecievedGift() {
        
        if (isFKeyPressed) {
            return true;
        }
        return false;
    }

    @Override
    public String giftToNpc() {
       
        
        if (hasRecievedGift == true)
            return giftDialogueOptions[0];
        
        return null;
    }
}
