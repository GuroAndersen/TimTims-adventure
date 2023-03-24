package timtim.app.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import timtim.app.manager.Const;

public class Timtim extends CombatEntity implements IPlayer {
	
	private final float maxJumpVel = 25;
	private boolean isJumping;
	private Sprite sprite;

	public Timtim() {
		super();
		this.speed  = 4f;
		this.sprite = new Sprite();
	}

	@Override
	public void update() {
		updateMovement();
	}

	private void updateSprite() {
		float spriteX = (body.getPosition().x - sprite.getWidth()/2) * Const.PPM;
		float spriteY = (body.getPosition().y - sprite.getHeight()/2) * Const.PPM;
		sprite.setPosition(spriteX, spriteY);
	}

	@Override
	public void render(SpriteBatch batch, TextureAtlas atlas) {
		sprite.setRegion(atlas.findRegion("timtimSprite"));
		sprite.setBounds(0, 0, 32 / Const.PPM, 32 / Const.PPM);
		updateSprite();
		TextureRegion timtimStand = new TextureRegion(sprite.getTexture(),0,0,32,32);
		batch.draw(timtimStand, sprite.getX(), sprite.getY());
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
