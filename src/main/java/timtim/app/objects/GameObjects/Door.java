package timtim.app.objects.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

public class Door extends GameObject {

    public Fixture fixture;
    public Body body;

    public Door(Body body, float[] vertices, String imagePath) {
        super(body, new Texture(imagePath), vertices);
        fixture = body.getFixtureList().get(0);
        fixture.setUserData(this);
    }

    public Fixture getFixture() {
        return fixture;
    }

    public Body getBody() {
        return super.body;
    }

}
