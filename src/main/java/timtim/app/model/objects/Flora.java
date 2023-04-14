package timtim.app.model.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

import timtim.app.model.entity.CombatEntity;

public class Flora extends CombatEntity {

    public Flora() {
        super(50, 5);
    }
    
	@Override
	protected TextureRegion getFrame(float delta) {
		return sprite;
	}

	@Override
	public void update(float delta) {
		
	}

}
