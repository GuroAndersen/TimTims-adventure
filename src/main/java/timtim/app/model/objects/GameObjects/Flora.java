package timtim.app.model.objects.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

public class Flora extends GameObject {

    public Fixture fixture;
    public Body body;

    public Flora(Body body, float[] vertices, Texture floraTexture) {
        super(body, floraTexture, vertices);
        fixture = body.getFixtureList().get(0);
        fixture.setUserData(this);
    }

    public Fixture getFixture() {
        return fixture;
    }

    public Body getBody() {
        return super.body;
    }
    
    public int damage() {
    	return 50;
    }

}
