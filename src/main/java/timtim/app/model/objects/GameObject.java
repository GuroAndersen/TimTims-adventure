package timtim.app.model.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

import timtim.app.manager.Const;

public abstract class GameObject {
	protected float stateTimer;
	protected Body body;
	protected Sprite sprite;

	public GameObject(Body body, Texture texture) {
		this.body = body;
		this.sprite = new Sprite(texture);
	}

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

	public void render(SpriteBatch batch) {
		sprite.draw(batch);
	}

	protected void updateSprite(float delta) {
		float spriteX = (body.getPosition().x * Const.PPM - sprite.getWidth() / 2);
		float spriteY = (body.getPosition().y * Const.PPM - sprite.getHeight() / 2);
		sprite.setBounds(spriteX, spriteY, sprite.getRegionWidth(), sprite.getRegionHeight());
		sprite.setRegion(getFrame(delta));
	}

	/**
	 * Get the current Texture or TextureRegion of this object.
	 * 
	 * @param delta
	 * @return
	 */
	protected abstract TextureRegion getFrame(float delta);

	/**
	 * Updates the object
	 */
	public abstract void update(float delta);

}
