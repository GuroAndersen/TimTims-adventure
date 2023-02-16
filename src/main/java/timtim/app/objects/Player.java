package timtim.app.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
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
		
		checkUserInput();
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}

	private void checkUserInput() {
		velX = 0;
		if (Gdx.input.isKeyPressed(Input.Keys.D)) velX = 1;
		if (Gdx.input.isKeyPressed(Input.Keys.A)) velX = -1;
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) { // iskeyjustpressed for when you only want a tap of the key to be registered
			float force = body.getMass() * 6;
			body.applyLinearImpulse(new Vector2(0, force), body.getPosition(), true);
		}
		
		body.setLinearVelocity(velX * speed, body.getLinearVelocity().y < 25 ? body.getLinearVelocity().y : 25);
	}
	
}
