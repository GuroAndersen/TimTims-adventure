package timtim.app.objects;

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

public class PlayerTest {

	static World world;
	Player player;
	
	@BeforeAll
	public static void worldSetup() {
		world = new World(new Vector2(0,-9.81f), false);
	}
	
	@BeforeEach
	public void playerSetup() {
		player = new Player();
		Body body = BodyManager.createBody(
				0,
				0,
				0, 
				0, 
				false, 
				world
			);
		player.setBody(body);
	}

	
	////////////////////
	// MOVEMENT TESTS //
	////////////////////
	
	@Test
	public void testJumpVelocityChange() {
		Vector2 playerVel1 = new Vector2(player.getBody().getLinearVelocity());
		player.jump();
		Vector2 playerVel2 = new Vector2(player.getBody().getLinearVelocity());
		
		assertEquals(playerVel1.x,playerVel2.x);
		assertNotEquals(playerVel1.y, playerVel2.y);
	}
	
	@Test
	public void testNoDoubleJump() {
		Vector2 playerVel0 = new Vector2(player.getBody().getLinearVelocity());
		player.jump();
		Vector2 playerVel1 = new Vector2(player.getBody().getLinearVelocity());
		player.jump();
		Vector2 playerVel2 = new Vector2(player.getBody().getLinearVelocity());
		
		assertEquals(playerVel0,Vector2.Zero);
		assertNotEquals(playerVel0, playerVel1);
		assertEquals(playerVel2.y,playerVel1.y);
	}
	
	
	@Test
	public void testPlayerMoveRight() {
		float playerVelX1 = player.body.getLinearVelocity().x;
		player.move(false, true);
		player.update();
		float playerVelX2 = player.body.getLinearVelocity().x;
		assertNotEquals(playerVelX1, playerVelX2);
		assertEquals(playerVelX1, 0);
		assertEquals(playerVelX2,player.speed);
	}
	
	@Test
	public void testPlayerMoveLeft() {
		float playerVelX1 = player.body.getLinearVelocity().x;
		player.move(true, false);
		player.update();
		float playerVelX2 = player.body.getLinearVelocity().x;
		assertNotEquals(playerVelX1, playerVelX2);
		assertEquals(playerVelX1, 0);
		assertEquals(playerVelX2,-player.speed);
	}
	
	@Test
	public void testPlayerMoveBoth() {
		float playerVelX1 = player.body.getLinearVelocity().x;
		player.move(true, true);
		player.update();
		float playerVelX2 = player.body.getLinearVelocity().x;
		assertEquals(playerVelX1, playerVelX2);
		assertEquals(playerVelX1, 0);
	}
}
