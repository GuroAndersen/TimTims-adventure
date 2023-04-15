package timtim.app.model.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import timtim.app.manager.BodyManager;
import timtim.app.manager.Const;
import timtim.app.model.objects.inventory.Item;

public class PlayerTest {

	private static World world;
	private Player player;

	@BeforeAll
	public static void worldSetup() {
		world = new World(new Vector2(0, -9.81f), false);
	}

	@BeforeEach
	public void playerSetup() {
		player = new Player(100, 10);
		Body body = BodyManager.createBody(0, 0, 0, 0, false, world);
		player.setBody(body);
	}

	////////////////////
	// MOVEMENT TESTS //
	////////////////////

	/**
	 * Tests that the Y velocity of the player changes when jump is called.
	 */
	@Test
	public void testJumpVelocityChange() {
		Vector2 playerVel1 = new Vector2(player.getBody().getLinearVelocity());
		player.jump();
		Vector2 playerVel2 = new Vector2(player.getBody().getLinearVelocity());

		assertEquals(playerVel1.x, playerVel2.x);
		assertNotEquals(playerVel1.y, playerVel2.y);
	}

	/**
	 * Tests that the the Y velocity of the player changes when jump is called once,
	 * but if called twice in a row (without the player hitting the ground) it
	 * should not change.
	 */
	@Test
	public void testNoDoubleJump() {
		Vector2 playerVel0 = new Vector2(player.getBody().getLinearVelocity());
		player.jump();
		Vector2 playerVel1 = new Vector2(player.getBody().getLinearVelocity());
		player.jump();
		Vector2 playerVel2 = new Vector2(player.getBody().getLinearVelocity());

		assertEquals(playerVel0, Vector2.Zero);
		assertNotEquals(playerVel0, playerVel1);
		assertEquals(playerVel2.y, playerVel1.y);
	}

	/**
	 * Tests that the player velocity changes to go right when it should.
	 */
	@Test
	public void testPlayerMoveRight() {
		float playerVelX1 = player.body.getLinearVelocity().x;
		player.move(false, true);
		player.update(Const.FPS);
		float playerVelX2 = player.body.getLinearVelocity().x;
		assertNotEquals(playerVelX1, playerVelX2);
		assertEquals(playerVelX1, 0);
		assertEquals(playerVelX2, player.speed);
	}

	/**
	 * Tests that the player velocity changes to go left when it should.
	 */
	@Test
	public void testPlayerMoveLeft() {
		float playerVelX1 = player.body.getLinearVelocity().x;
		player.move(true, false);
		player.update(Const.FPS);
		float playerVelX2 = player.body.getLinearVelocity().x;
		assertNotEquals(playerVelX1, playerVelX2);
		assertEquals(playerVelX1, 0);
		assertEquals(playerVelX2, -player.speed);
	}

	/**
	 * Tests that the player does not move when both left and right is pressed.
	 */
	@Test
	public void testPlayerMoveBoth() {
		float playerVelX1 = player.body.getLinearVelocity().x;
		player.move(true, true);
		player.update(Const.FPS);
		float playerVelX2 = player.body.getLinearVelocity().x;
		assertEquals(playerVelX1, playerVelX2);
		assertEquals(playerVelX1, 0);
	}

	/**
	 * Tests that giving a player an item leads to the item ending up in the
	 * player's inventory.
	 */
	@Test
	public void giveItemPlayerTest() {
		Item item = new Item("Apple", "A tasty fruit");
		player.addItemToInventory(item);
		Item item2= new Item("Apple", "A tasty fruit");
		assertTrue(player.getInventory().contains(item2));
	}

}
