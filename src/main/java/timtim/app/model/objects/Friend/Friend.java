package timtim.app.model.objects.Friend;

import java.awt.Font;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Align;

import timtim.app.manager.Const;
import timtim.app.model.map.GameMap;
import timtim.app.model.objects.GameEntity;
import timtim.app.model.objects.Inventory.Item;

public abstract class Friend extends GameEntity implements IFriend {

    public Item item;
  
    private int dialogueCounter = 0;
    private int interactionCounter = 0;
    private String currentDialogue = "";
    
    private boolean itemReceived;
    
	protected Sprite sprite;
    protected BitmapFont font;
	protected float spriteXOffset;
	protected float spriteYOffset;
	protected Animation<TextureRegion> idleAnimation;
	protected int stateTimer;

	private GameMap map;

	/**
	 * Constructor used in game.
	 * @param map
	 * @param newItem
	 */
    public Friend(GameMap map, Item newItem) {
    	this.map = map;
		this.item = newItem;
		this.font = new BitmapFont();
		font.setColor(Color.BLACK);
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
    public void updateConversation() {
    	
    	if (itemReceived) this.currentDialogue = giftDialogue();
    	
        // First interaction between Player and Friend
        // Will go through the whole list of conversation options
        if (interactionCounter == 0) {
            String dialogue = getDialogueOptions()[dialogueCounter];
            dialogueCounter++;
            if (dialogueCounter >= getDialogueOptions().length) {
                dialogueCounter = 0;
                this.currentDialogue = "";
            }
        }

        // Second or more interaction between Player and Friend
        // Will only show the relevant parts of dialogue needed
        if (interactionCounter > 0 && hasRecievedGift() == false) {
            int relevantDialogueCounter = 3;
            String relevantDialogue = getDialogueOptions()[relevantDialogueCounter];
            relevantDialogueCounter++;
            if (relevantDialogueCounter >= getDialogueOptions().length) {
                relevantDialogueCounter = 3;
                this.currentDialogue = "";
            }
            this.currentDialogue = relevantDialogue;
        }

        interactionCounter++;
    }
    
    @Override
	public String getConversation() {
    	return this.currentDialogue;
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
        	map.setComplete();
        	return true;
    	} else {
    		return false;
    	}
    }
	
	private void updateSprite(float delta) {
		float spriteX = (body.getPosition().x * Const.PPM - sprite.getWidth()/2) + spriteXOffset;
		float spriteY = (body.getPosition().y * Const.PPM - sprite.getHeight()/2) + spriteYOffset;
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
		font.draw(batch, currentDialogue, sprite.getX(), sprite.getY() + 2 * Const.PPM, sprite.getWidth()*2, Align.center, true);
	}
	
	@Override
	public void update(float delta) {
		updateSprite(delta);
	}
	
}
