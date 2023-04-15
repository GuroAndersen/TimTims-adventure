package timtim.app.model.objects;

import com.badlogic.gdx.physics.box2d.Body;

public class GameObject {
	protected Body body;

    public GameObject(Body body) {
        this.body = body;
    }
    
	/**
	 * 
	 * @return body of this entity
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

    
}
