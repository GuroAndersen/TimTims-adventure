package timtim.app.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Enemy extends CombatEntity {

	private EnemyType type;

	public Enemy(EnemyType type) {
		this.type = type;
	}
	
	@Override
	public void update() {
		doRandomXMovement();
	}

	@Override
	public void render(SpriteBatch batch, TextureAtlas atlas) {
		// TODO Auto-generated method stub
		
	}
	
	
}
