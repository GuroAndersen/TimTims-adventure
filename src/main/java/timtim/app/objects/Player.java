package timtim.app.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import timtim.app.manager.Const;

public class Player extends CombatEntity implements IPlayer {
	
	final float maxJumpVel = 25;
	private boolean isJumping;

	public Player() {
		super();
		this.speed  = 4f;
	}

	@Override
	public void update() {
		updateMovement();
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
	}

	private void updateMovement() {
		x = body.getPosition().x * Const.PPM;
		y = body.getPosition().y * Const.PPM;
		body.setLinearVelocity(velX * speed, body.getLinearVelocity().y < maxJumpVel ? body.getLinearVelocity().y : maxJumpVel);
		if (body.getLinearVelocity().y == 0) isJumping = false;
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
			float force = body.getMass() * 6;
			body.applyLinearImpulse(new Vector2(0, force), body.getPosition(), true);
			isJumping = true;
		}
	}
	
}
