package timtim.app.model.objects.Inventory;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class InventoryTest {

    private Inventory inventory;

    @Before
    public void setUp() {
        inventory = new Inventory();
    }

    @Test
    public void testInventoryMaxSize() {
        assertEquals(5, inventory.inventoryMaxSize());
        Inventory inventory2 = new Inventory(10);
        assertEquals(10, inventory2.inventoryMaxSize());
    }

    @Test
    public void testNItemsInInventory() {
        Item item1 = new Item("Sword", "A sharp weapon");
        Item item2 = new Item("Potion", "A healing elixir");

        assertEquals(0, inventory.nItemsInInventory());

        inventory.placeInInventory(item1);
        assertEquals(1, inventory.nItemsInInventory());

        inventory.placeInInventory(item2);
        assertEquals(2, inventory.nItemsInInventory());
    }

    @Test
    public void testContains() {
        Item item1 = new Item("Sword", "A sharp weapon");
        Item item2 = new Item("Potion", "A healing elixir");

        assertFalse(inventory.contains(item1));

        inventory.placeInInventory(item1);
        assertTrue(inventory.contains(item1));

        assertFalse(inventory.contains(item2));

        inventory.placeInInventory(item2);
        assertTrue(inventory.contains(item2));
    }

    @Test
    public void testPlaceInInventory() {
        Item item1 = new Item("Sword", "A sharp weapon");
        Item item2 = new Item("Potion", "A healing elixir");
        Item item3 = new Item("Shield", "A defensive tool");
        Item item4 = new Item("Key", "Unlocks doors");
        Item item5 = new Item("Book", "Contains knowledge");

        assertTrue(inventory.placeInInventory(item1));
        assertTrue(inventory.placeInInventory(item2));
        assertTrue(inventory.placeInInventory(item3));
        assertTrue(inventory.placeInInventory(item4));
        assertTrue(inventory.placeInInventory(item5));

        assertFalse(inventory.placeInInventory(item1));
        assertFalse(inventory.placeInInventory(item2));
        assertFalse(inventory.placeInInventory(item3));
        assertFalse(inventory.placeInInventory(item4));
        assertFalse(inventory.placeInInventory(item5));
    }

    @Test
    public void testTakeOutItem() {
        Item item1 = new Item("Sword", "A sharp weapon");
        Item item2 = new Item("Potion", "A healing elixir");
        Item item3 = new Item("Shield", "A defensive tool");

        assertFalse(inventory.contains(item1));
        assertFalse(inventory.contains(item2));
        assertFalse(inventory.contains(item3));

        inventory.placeInInventory(item1);
        inventory.placeInInventory(item2);
        inventory.placeInInventory(item3);

        assertTrue(inventory.contains(item1));
        assertTrue(inventory.contains(item2));
        assertTrue(inventory.contains(item3));

        Item removedItem = inventory.takeOutItem(item2);

        assertFalse(inventory.contains(item2));
        assertEquals(item2, removedItem);

        try {
            inventory.takeOutItem(item2);
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
            assertEquals("Inventory does not contain this item", e.getMessage());
        }
    }
}
