package timtim.app.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import timtim.app.objects.Item;

public class ItemTest {

    /**
     * Tests if getName gets the correct name.
     */
    @Test
    public void getNameTest() {
        Item item = new Item("jakke");
        assertEquals("jakke", item.getName());
        assertNotEquals("hei", item.getName());
    }
}
