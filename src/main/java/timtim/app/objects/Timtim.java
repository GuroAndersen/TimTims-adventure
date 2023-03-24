package timtim.app.objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import timtim.app.core.GameScreen;
import timtim.app.manager.Const;

public class Timtim extends CombatEntity implements IPlayer {
	
	private Animation timtimRun;
	
	private final float maxJumpVel = 25;
	private boolean isJumping;
	private Sprite sprite;
	
	private GameScreen gameScreen;
	TextureRegion timtimStand;

	public Timtim() {
		super();
		baseSetup();
	}
	
	/**
	 * Testing constructor.
	 * Does not set up the sprite.
	 */
	private void baseSetup() {
		this.speed = 4f;
	}
	
	public Timtim(GameScreen gameScreen) {
		super();
		baseSetup();
		this.gameScreen = gameScreen;
		this.sprite = new Sprite(gameScreen.getAtlas().findRegion("timtimSprite"));
		timtimStand = new TextureRegion(sprite.getTexture(),0,0,32,32);
		sprite.setBounds(0,0,32 / Const.PPM, 32/ Const.PPM);
		sprite.setRegion(timtimStand);
	}

	@Override
	public void update() {
		updateMovement();
		updateSprite();
	}

	private void updateSprite() {
		float spriteX = (body.getPosition().x * Const.PPM - sprite.getWidth()/2);
		float spriteY = (body.getPosition().y * Const.PPM - sprite.getHeight()/2);
		sprite.setBounds(spriteX, spriteY, sprite.getRegionWidth(), sprite.getRegionHeight());
	}

	@Override
	public void render(SpriteBatch batch) {
		sprite.draw(batch);
	}

	private void updateMovement() {
		body.setLinearVelocity(velX * speed, body.getLinearVelocity().y < maxJumpVel ? body.getLinearVelocity().y : maxJumpVel);
		if (body.getLinearVelocity().y == 0) isJumping = false;
		resetVelocity();
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
	
}
