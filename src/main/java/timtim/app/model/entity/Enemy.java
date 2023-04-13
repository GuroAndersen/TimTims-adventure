package timtim.app.model.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

public class Enemy extends CombatEntity {

	public Enemy(Body body, Texture texture, int maxHealth, int strength) {
		super(body, texture, maxHealth, strength);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected TextureRegion getFrame(float delta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

//	private EnemyType type;
//
//	public Enemy(EnemyType type) {
//		this.type = type;
//	}
//	
//	@Override
//	public void update(float delta) {
//		doRandomXMovement();
//	}
//
//	@Override
//	public void render(SpriteBatch batch) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
}
