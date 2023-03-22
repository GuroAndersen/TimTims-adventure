package timtim.app.objects.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

public class Door extends GameObject {

    public Fixture fixture;
    public Body body;

    public Door(Body body, float x, float y, float width, float height, String imagePath) {
        super(body, new Texture(imagePath), new Rectangle(x, y, width, height));
        fixture = body.getFixtureList().get(0);
        fixture.setUserData(this);
    }

    public Fixture getFixture() {
        return fixture;
    }

    public Body getBody() {
        return super.body;
    }

    public boolean isSensor() {
        return fixture.isSensor();
    }
    
}
