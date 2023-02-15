package timtim.app.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

import timtim.app.manager.Const;

public class Player extends GameEntity {

	public Player(Body body, float w, float h) {
		super(body, w, h);
		this.speed  = 4f;
	}

	@Override
	public void update() {
		x = body.getPosition().x * Const.PPM;
		y = body.getPosition().y * Const.PPM;
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}

	
	
}
