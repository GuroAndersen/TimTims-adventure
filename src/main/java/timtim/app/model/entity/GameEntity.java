package timtim.app.model.entity;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;

import timtim.app.model.objects.GameObject;

public abstract class GameEntity extends GameObject {

	public int[] xMovementCases = { -1, 0, 1 };
	float velX, velY, speed;

	protected boolean isJumping;
	private final float maxJumpVel = 25;

	/**
	 * Sets the speed of this object.
	 * 
	 * @param speed
	 */
	protected void setSpeed(float speed) {
		this.speed = speed;
	}

	/**
	 * Do random movement horizontal movement for this GameEntity object.
	 */
	protected void doRandomXMovement() {
		Random r = new Random();
		int i = r.nextInt(-1, 2);
		body.setLinearVelocity(xMovementCases[i] * speed, 0);
	}

	/**
	 * Updates the movement of this GameEntity using velocity values.
	 */
	protected void updateMovement() {
		body.setLinearVelocity(velX * speed,
				body.getLinearVelocity().y < maxJumpVel ? body.getLinearVelocity().y : maxJumpVel);
		if (body.getLinearVelocity().y == 0)
			isJumping = false;
		resetVelocity();
	}
	

	/**
	 * Resets the X and Y velocity of this object.
	 */
	private void resetVelocity() {
		velX = 0;
		velY = 0;
	}
}
