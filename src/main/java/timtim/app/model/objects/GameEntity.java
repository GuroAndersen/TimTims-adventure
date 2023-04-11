package timtim.app.model.objects;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class GameEntity {

	public int[] xMovementCases = { -1, 0, 1 };
	float velX, velY, speed;
	protected Body body;

	protected boolean isJumping;
	private final float maxJumpVel = 25;

	public GameEntity() {
		this.velX = 0;
		this.velY = 0;
		this.speed = 0;
	}

	public GameEntity(Body body) {
		this.velX = 0;
		this.velY = 0;
		this.speed = 0;
		this.body = body;
	}

	/**
	 * Updates the entity
	 */
	public abstract void update(float delta);

	/**
	 * Renders the entity
	 */
	public abstract void render(SpriteBatch batch);

	/**
	 * 
	 * @return body of this entity
	 * @throws Exception
	 */
	public Body getBody() {
		return this.body;
	}

	/**
	 * Set a body for this GameEntity
	 * 
	 * @param body
	 */
	public void setBody(Body body) {
		this.body = body;
	}

	/**
	 * Resets the X and Y velocity of this object.
	 */
	protected void resetVelocity() {
		velX = 0;
		velY = 0;
	}

	/**
	 * Sets the speed of this object.
	 * 
	 * @param speed
	 */
	protected void setSpeed(float speed) {
		this.speed = speed;
	}

	public Vector2 getPosition() {
		return this.body.getPosition();
	}

	/**
	 * Do random movement horizontal movement for this GameEntity object.
	 */
	protected void doRandomXMovement() {
		Random r = new Random();
		int i = r.nextInt(-1, 2);
		body.setLinearVelocity(xMovementCases[i] * speed, 0);
	}

	protected void updateMovement() {
		body.setLinearVelocity(velX * speed,
				body.getLinearVelocity().y < maxJumpVel ? body.getLinearVelocity().y : maxJumpVel);
		if (body.getLinearVelocity().y == 0)
			isJumping = false;
		resetVelocity();
	}
}