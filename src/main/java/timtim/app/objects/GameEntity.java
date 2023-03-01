package timtim.app.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class GameEntity {

	float x, y, velX, velY, speed;
	float width, height;
	Body body;
	
	public GameEntity() {
		this.velX = 0;
		this.velY = 0;
		this.speed = 0;
	}
	
	public GameEntity(Body body, float w, float h) {
		this.x = body.getPosition().x;
		this.y = body.getPosition().y;
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
	public abstract void render(SpriteBatch batch);
	
	/**
	 * 
	 * @return body of this entity
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
		this.x = body.getPosition().x;
		this.y = body.getPosition().y;
		this.width = w;
		this.height = h;
		this.velX = 0;
		this.velY = 0;
		this.body = body;
	}
}
