package timtim.app.model.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class Enemy extends CombatEntity {

	public Enemy(int maxHealth, int strength) {
		super(maxHealth, strength);
	}

	@Override
	public void update(float delta) {
		this.doRandomXMovement();
		this.updateMovement();
	}
	
}
