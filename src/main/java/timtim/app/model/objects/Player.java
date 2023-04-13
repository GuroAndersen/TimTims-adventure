package timtim.app.model.objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import timtim.app.core.GameScreen;
import timtim.app.manager.Const;
import timtim.app.model.objects.Inventory.Inventory;
import timtim.app.model.objects.Inventory.ItemFactory;

public class Player extends CombatEntity implements IPlayer {
	
	private Sprite sprite;
	
	
	private Animation<TextureRegion> runAnimation;
	private Array<TextureRegion> jumpCells;
	private TextureRegion standing;
	private float stateTimer;


	private Inventory inventory;

	/**
	 * Testing constructor.
	 * Does not set up the sprite.
	 */
	public Player() {
		super(100, 10);
		baseSetup();
	}
	
	public Player(int health, int strength) {
		super(health, strength);
		baseSetup();
	}
	
	private void baseSetup() {
		this.speed = 4f;
		this.inventory = new Inventory();
	}
	
	public Player(GameScreen gameScreen) {
		super(100, 10);
		baseSetup();
		this.sprite = new Sprite(gameScreen.getAtlas().findRegion("timtim"));
		setupAnimation();
		sprite.setBounds(0, 0, 32 / Const.PPM, Const.PPM);
		sprite.setRegion(standing);
	}

	
	private void setupAnimation() {
		stateTimer = 0;
		// setup run animation
		Array<TextureRegion> frames = new Array<TextureRegion>();
		for (int i = 1; i < 9; i++) {
			frames.add(new TextureRegion(sprite.getTexture(), sprite.getRegionX() + i * 32, sprite.getRegionY() + 0, 32, 32));
		}
		runAnimation = new Animation<TextureRegion>(0.1f, frames);
		frames.clear();
		
		// setup jump animation
		for (int i = 9; i < 13; i++) {
			frames.add(new TextureRegion(sprite.getTexture(),sprite.getRegionX() + i * 32, sprite.getRegionY() + 0, 32, 32));
		}
		jumpCells = new Array<TextureRegion>(frames);
		frames.clear();
		
		standing = new TextureRegion(sprite.getTexture(), sprite.getRegionX(), sprite.getRegionY(), 32, 32);
	}

	@Override
	public void update(float delta) {
		
		updateMovement();
		if (this.sprite != null) updateSprite(delta);
	}

	private void updateSprite(float delta) {
		float spriteX = (body.getPosition().x * Const.PPM - sprite.getWidth()/2);
		float spriteY = (body.getPosition().y * Const.PPM - sprite.getHeight()/2) + 2;
		sprite.setBounds(spriteX, spriteY, sprite.getRegionWidth(), sprite.getRegionHeight());
		sprite.setRegion(getFrame(delta));

	}

	private TextureRegion getFrame(float delta) {
		// jumping cases
		stateTimer += delta;
		
		TextureRegion frame;
		if (this.body.getLinearVelocity().y > -3 && this.body.getLinearVelocity().y < 3 && isJumping) {
			frame = jumpCells.get(2);
	    } else if (this.body.getLinearVelocity().y > 0) {
			frame = jumpCells.get(1);
		} else if (this.body.getLinearVelocity().y < 0){
			frame = jumpCells.get(3);
		} else if (this.body.getLinearVelocity().x != 0) {
			frame = runAnimation.getKeyFrame(stateTimer, true);
		} else {
			frame = standing;
		}
		if (this.body.getLinearVelocity().x < 0 && !frame.isFlipX()) frame.flip(true, false);
		if (this.body.getLinearVelocity().x > 0 && frame.isFlipX()) frame.flip(true, false);
		
		return frame;
	}

	@Override
	public void render(SpriteBatch batch) {
		sprite.draw(batch);
	}

	@Override
	public void move(boolean moveLeft, boolean moveRight) {
		if (moveRight && moveLeft) velX = 0;
		else if (moveLeft) velX = -1;
		else if (moveRight) velX = 1;
		
	}

	@Override
	public void jump() {
		if(!isJumping) {
			float force = body.getMass() * Const.JUMPCONSTANT;
			body.applyLinearImpulse(new Vector2(0, force), body.getPosition(), true);
			isJumping = true;
		}
	}

	@Override
	public Inventory getInventory() {
		return this.inventory;
	}
}
