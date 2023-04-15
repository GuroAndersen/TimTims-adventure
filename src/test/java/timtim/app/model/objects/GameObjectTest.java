package timtim.app.model.objects;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;

public class GameObjectTest {

    private World world;
    private Body body;
    private GameObject gameObject;

    @Before
    public void setUp() throws Exception {
        Box2D.init();
        world = new World(new Vector2(0, -9.8f), true);
        body = world.createBody(new BodyDef());
        gameObject = new GameObject(body);
    }

    @Test
    public void testGetBody() {
        assertEquals(body, gameObject.getBody());
    }

    @Test
    public void testSetBody() {
        Body newBody = world.createBody(new BodyDef());
        gameObject.setBody(newBody);
        assertEquals(newBody, gameObject.getBody());
    }

}
