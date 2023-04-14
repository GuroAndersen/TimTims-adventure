package timtim.app.model.objects;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import timtim.app.model.objects.GameObjects.GameObject;

public abstract class GameEntity extends GameObject {

	public int[] xMovementCases = { -1, 0, 1 };
	protected float velX, velY, speed;

	protected boolean isJumping;
	private final float maxJumpVel = 25;

	/**
	 * Initialise a GameEntity without a body.
	 * Body must be set with setBody after the fact.
	 */
	public GameEntity() {
		super(null);
		baseSetup();
	}

	/**
	 * Initialise a GameEntity with a body.
	 * @param body
	 */
	public GameEntity(Body body) {
		super(body);
		baseSetup();
	}
	
	private void baseSetup() {
		this.velX = 0;
		this.velY = 0;
		this.speed = 0;
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
