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

	@Test
	void testDoDamage() {
		CombatEntity enemy = new Player(10, 2);
		entity.doDamage(enemy);
		assertEquals(5, enemy.getHealth());
	}

	@Test
	void testTakeDamage() {
		entity.takeDamage(3);
		assertEquals(7, entity.getHealth());
		entity.takeDamage(8);
		assertEquals(0, entity.getHealth());
		entity.takeDamage(-1);
		assertEquals(0, entity.getHealth());
	}

	@Test
	void testGetHealth() {
		assertEquals(10, entity.getHealth());
		entity.takeDamage(5);
		assertEquals(5, entity.getHealth());
	}

	@Test
	void testIsAlive() {
		assertTrue(entity.isAlive());
		entity.takeDamage(10);
		assertFalse(entity.isAlive());
	}

	@Test
	void testResetHealth() {
		entity.takeDamage(5);
		assertEquals(5, entity.getHealth());
		entity.resetHealth();
		assertEquals(10, entity.getHealth());
	}

}
