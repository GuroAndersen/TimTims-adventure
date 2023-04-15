package timtim.app.model.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

import timtim.app.model.map.GameMap;

public class Door extends GameObject {

    public Fixture fixture;
    public Body body;
    private boolean isOpen;

    public Door(Body body) {
        super(body);
        isOpen = false;
    }

    public Fixture getFixture() {
        return fixture;
    }

    public Body getBody() {
        return super.body;
    }

    public void open() {
        isOpen = true;
        // gameMap.setComplete();
    }

}
