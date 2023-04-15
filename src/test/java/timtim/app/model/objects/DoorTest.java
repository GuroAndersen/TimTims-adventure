package timtim.app.model.objects;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;

public class DoorTest {
	Door door;
	World world;
	
	@BeforeEach
    void setUp() {
        Box2D.init();
        world = new World(new Vector2(0, -9.81f), true);
        BodyDef doorDef = new BodyDef();
        doorDef.type = BodyDef.BodyType.StaticBody;
        doorDef.position.set(0, 0);
        Body doorBody = world.createBody(doorDef);
        door = new Door(doorBody);
    }
	
    @Test
    void testConstructor() {
        assertNotNull(door.getBody());
        assertFalse(door.isOpen());
    }

    @Test
    void testOpen() {
        assertFalse(door.isOpen());
        door.open();
        assertTrue(door.isOpen());
    }

    @Test
    void testIsOpen() {
        assertFalse(door.isOpen());
        door.open();
        assertTrue(door.isOpen());
        door.open();
        assertTrue(door.isOpen());
    }
	
}
