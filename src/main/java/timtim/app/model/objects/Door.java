package timtim.app.model.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

public class Door extends GameObject {

    public Body body;
    private boolean isOpen;

    public Door(Body body, Texture texture) {
        isOpen = false;
    }

    public void open() {
        isOpen = true;
    }

	@Override
	protected TextureRegion getFrame(float delta) {
		return sprite;
	}

	@Override
	public void update(float delta) {
		
	}

}
