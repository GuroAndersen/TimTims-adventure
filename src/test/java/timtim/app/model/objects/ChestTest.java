package timtim.app.model.objects;

import static org.junit.Assert.*;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;

import timtim.app.model.objects.inventory.Item;

public class ChestTest {

	/**
	 * Test that the chest, when opened, is open.
	 */
    @Test
    public void testOpen() {
        // Set up Box2D and create a new world
        Box2D.init();
        World world = new World(new Vector2(0, -10), true);

        // Define the body for the chest
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyType.StaticBody;
        bodyDef.position.set(0, 0);
        Body body = world.createBody(bodyDef);

        // Create a new chest object
        Chest chest = new Chest(body);

        // Ensure the chest is initially closed
        assertFalse(chest.isOpen());

        // Open the chest and ensure it is now open
        chest.open();
        assertTrue(chest.isOpen());
    }

    /**
     * Test that you can set and get the chest's item.
     */
    @Test
    public void testGetSetItem() {
        // Set up Box2D and create a new world
        Box2D.init();
        World world = new World(new Vector2(0, -10), true);

        // Define the body for the chest
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyType.StaticBody;
        bodyDef.position.set(0, 0);
        Body body = world.createBody(bodyDef);

        // Create a new chest object
        Chest chest = new Chest(body);

        // Create an item and set it in the chest
        Item item = new Item("Test Item", "Test description");
        chest.setItem(item);

        // Ensure the item returned from getItem() is the same as the one set
        assertEquals(item, chest.getItem());
    }
}
