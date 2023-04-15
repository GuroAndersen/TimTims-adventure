package timtim.app.model.objects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CombatEntityTest {

	private CombatEntity entity;

	@BeforeEach
	void setUp() throws Exception {
		entity = new Player(10, 5);
	}

	/**
	 * Checks that an entity can do damage to another. Passing criteria is that the
	 * entity taking damage takes the correct amount of damage.
	 */
	@Test
	void testDoDamage() {
		CombatEntity enemy = new Player(10, 2);
		entity.doDamage(enemy);
		assertEquals(5, enemy.getHealth());
	}

	/**
	 * Tests that an entity can take damage. Passes if the enemy takes the correct
	 * amount of damage and cannot take negative damage.
	 */
	@Test
	void testTakeDamage() {
		entity.takeDamage(3);
		assertEquals(7, entity.getHealth());
		entity.takeDamage(8);
		assertEquals(0, entity.getHealth());
		entity.takeDamage(-1);
		assertEquals(0, entity.getHealth());
	}

	/**
	 * Tests that getHealth returns the correct health value for the entity.
	 */
	@Test
	void testGetHealth() {
		assertEquals(10, entity.getHealth());
		entity.takeDamage(5);
		assertEquals(5, entity.getHealth());
	}

	/**
	 * Tests that isAlive() returns the correct boolean value for when an entity
	 * should be alive, and when an entity takes too much damage and should be dead.
	 */
	@Test
	void testIsAlive() {
		assertTrue(entity.isAlive());
		entity.takeDamage(10);
		assertFalse(entity.isAlive());
	}

	/**
	 * Tests that resetHealth sets the health to the original value after taking
	 * damage.
	 */
	@Test
	void testResetHealth() {
		entity.takeDamage(5);
		assertEquals(5, entity.getHealth());
		entity.resetHealth();
		assertEquals(10, entity.getHealth());
	}

}
