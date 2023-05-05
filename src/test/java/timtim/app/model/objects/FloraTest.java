package timtim.app.model.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class FloraTest {
    private Flora flora;

    @BeforeEach
    public void setUp() {
        // Set up Box2D and create a new world
        Box2D.init();
        World world = new World(new Vector2(0, -10), true);

        // Define the body for the chest
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyType.StaticBody;
        bodyDef.position.set(0, 0);
        Body body = world.createBody(bodyDef);
        flora = new Flora(body);
    }

    /**
     * Tests that a player takes the correct damage from a Flora object
     */
    @Test
    public void testDamage() {
        Player p = new Player(20, 5);
        assertEquals(5, flora.damage());
        p.takeDamage(flora.damage());
        assertEquals(15, p.getHealth());
    }
}
