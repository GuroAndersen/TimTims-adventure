package timtim.app.model.objects.friend;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Align;

import timtim.app.manager.Const;
import timtim.app.model.map.GameMap;
import timtim.app.model.objects.GameEntity;
import timtim.app.model.objects.inventory.Item;

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
    protected float stateTimer;

    private GameMap map;

    /**
     * Create a friend that wants the given item
     * and lives in the given map.
     * Constructor used in game.
     * 
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
     * 
     * @param item
     */
    public Friend(Item item, GameMap testMap) {
        this.item = item;
        this.map = testMap;
    }

    /**
     * getConversation finds a string to show when a conversation with a Friend has
     * been initiated.
     * Gets it from a list of Strings.
     */
    @Override
    public void updateConversation() {

        if (itemReceived)
            currentDialogue = giftDialogue();

        // First interaction between Player and Friend
        // Will go through the whole list of conversation options
        if (interactionCounter == 0) {
            String[] dialogueOptions = getDialogueOptions();
            String dialogue = dialogueOptions[dialogueCounter];
            currentDialogue = dialogue;
            dialogueCounter++;
            if (dialogueCounter >= getDialogueOptions().length) {
                dialogueCounter = 0;
            }
        }

        // Second or more interaction between Player and Friend
        // Will only show the relevant parts of dialogue needed
        else if (interactionCounter > 0 && hasReceivedGift() == false) {
            int relevantDialogueCounter = 1;
            String relevantDialogue = getDialogueOptions()[relevantDialogueCounter];
            relevantDialogueCounter++;
            if (relevantDialogueCounter >= getDialogueOptions().length) {
                relevantDialogueCounter = 1;
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
    public boolean hasReceivedGift() {
        return itemReceived;
    }

    private String[] getDialogueOptions() {
        String[] dialogueOptions = {
                "Hi, I need a " + item.name(),
                "Can you help me look for a chest?" };
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
        float spriteX = (body.getPosition().x * Const.PPM - sprite.getWidth() / 2) + spriteXOffset;
        float spriteY = (body.getPosition().y * Const.PPM - sprite.getHeight() / 2) + spriteYOffset;
        sprite.setBounds(spriteX, spriteY, sprite.getRegionWidth(), sprite.getRegionHeight());
        sprite.setRegion(getFrame(delta));
    }

    private TextureRegion getFrame(float delta) {

        this.stateTimer += delta;
        TextureRegion frame = idleAnimation.getKeyFrame(stateTimer, true);
        if (this.body.getLinearVelocity().x < 0 && !frame.isFlipX())
            frame.flip(true, false);
        if (this.body.getLinearVelocity().x > 0 && frame.isFlipX())
            frame.flip(true, false);

        return frame;
    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
        font.draw(batch, currentDialogue, sprite.getX(), sprite.getY() + 2 * Const.PPM, sprite.getWidth() * 2,
                Align.center, true);
    }

    @Override
    public void update(float delta) {
        updateSprite(delta);
    }

    public Item getItem() {
        return this.item;
    }

}
