package timtim.app.objects;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class GameEntity {

	public int[] xMovementCases = {-1,0,1};
	float velX, velY, speed;
	float width, height;
	Body body;
	
	public GameEntity() {
		this.velX = 0;
		this.velY = 0;
		this.speed = 0;
	}
	
	public GameEntity(Body body, float w, float h) {
		this.width = w;
		this.height = h;
		this.velX = 0;
		this.velY = 0;
		this.speed = 0;
		this.body = body;
	}
	 /**
	  * Updates the entity
	  */
	public abstract void update();
	
	/**
	 * Renders the entity
	 */
	public abstract void render(SpriteBatch batch, TextureAtlas atlas);
	
	/**
	 * 
	 * @return body of this entity
	 * @throws Exception 
	 */
	public Body getBody() {
		return this.body;
	}
	
	 /**
	  * Set a body for this GameEntity along with width and height
	  * @param body
	  * @param w
	  * @param h
	  */
	public void setBody(Body body, float w, float h) {
		this.width = w;
		this.height = h;
		this.velX = 0;
		this.velY = 0;
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
	 * @param speed
	 */
	protected void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public Vector2 getPosition() {
		return this.body.getPosition();
	}
	
	/**
	 * Do random movement horizontal movement
	 * for this GameEntity object.
	 */
	protected void doRandomXMovement() {
		Random r = new Random();
		int i = r.nextInt(-1, 2);
		body.setLinearVelocity(xMovementCases[i] * speed, 0);
	}
}
