package timtim.app.objects.Friend;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import timtim.app.manager.Const;
import timtim.app.manager.GameMap;
import timtim.app.objects.GameEntity;
import timtim.app.objects.Inventory.Item;

public abstract class Friend extends GameEntity implements IFriend {

    public Item item;
  
    private int dialogueCounter = 0;
    private int interactionCounter = 0;
    
    private boolean itemReceived;
    
	protected Sprite sprite;
	protected Animation<TextureRegion> idleAnimation;
	protected int stateTimer;

	private GameMap map;

    public Friend(GameMap map, Item newItem) {
    	this.map = map;
		this.item = newItem;
	}
    
    /**
     * Testing constructor.
     * @param item
     */
    public Friend(Item item) {
    	this.item = item;
    }

	/**
     * getConversation finds a string to show when a conversation with a Friend has
     * been initiated.
     * Gets it from a list of Strings.
     */
    @Override
    public String getConversation() {
    	
    	if (itemReceived) return "Thanks for the gift!";
    	
        // First interaction between Player and Friend
        // Will go through the whole list of conversation options
        if (interactionCounter == 0) {
            String currentDialogue = getDialogueOptions()[dialogueCounter];
            dialogueCounter++;
            if (dialogueCounter >= getDialogueOptions().length) {
                dialogueCounter = 0;
                return "";
            }
            return currentDialogue;
        }

        // Second or more interaction between Player and Friend
        // Will only show the relevant parts of dialogue needed
        if (interactionCounter > 0 && hasRecievedGift() == false) {
            int relevantDialogueCounter = 3;
            String relevantDialogue = getDialogueOptions()[relevantDialogueCounter];
            relevantDialogueCounter++;
            if (relevantDialogueCounter >= getDialogueOptions().length) {
                relevantDialogueCounter = 3;
                return "";
            }
            return relevantDialogue;
        }

        interactionCounter++;
        return "";
    }

    @Override
    public boolean hasRecievedGift() {
    	return itemReceived;
    }
    
    private String[] getDialogueOptions() {
    	 String[] dialogueOptions = 
    		 	{ "Hi", 
    		 		"Can you help me?",
    				"I need a " + item.name(),
    				"Look for chests" };
    	 return dialogueOptions;
    }

    private String giftDialogue() {
        return "Thanks for the " + item.name() + "!";
    }

    @Override
    public boolean receiveGift(Item item) {
        if (this.item.equals(item)) {
        	itemReceived = true;
        	
        	return true;
    	} else {
    		return false;
    	}
    }
	
	private void updateSprite(float delta) {
		float spriteX = (body.getPosition().x * Const.PPM - sprite.getWidth()/2);
		float spriteY = (body.getPosition().y * Const.PPM - sprite.getHeight()/2);
		sprite.setBounds(spriteX, spriteY, sprite.getRegionWidth(), sprite.getRegionHeight());
		sprite.setRegion(getFrame(delta));
	}
	
	private TextureRegion getFrame(float delta) {
		// jumping cases
		stateTimer += delta;
		
		TextureRegion frame = idleAnimation.getKeyFrame(stateTimer, true);
		if (this.body.getLinearVelocity().x < 0 && !frame.isFlipX()) frame.flip(true, false);
		if (this.body.getLinearVelocity().x > 0 && frame.isFlipX()) frame.flip(true, false);
		
		return frame;
	}

	@Override
	public void render(SpriteBatch batch) {
		sprite.draw(batch);
	}
	
	@Override
	public void update(float delta) {
		updateSprite(delta);
	}

}