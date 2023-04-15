package timtim.app.model.objects.enemy;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import timtim.app.model.objects.CombatEntity;
import timtim.app.model.objects.EnemyType;

public class Enemy extends CombatEntity {

	private EnemyType type;

	public Enemy(EnemyType type) {
		this.type = type;
	}
	
	@Override
	public void update(float delta) {
		doRandomXMovement();
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}
	
	
}
