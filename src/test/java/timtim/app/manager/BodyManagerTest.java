package timtim.app.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public class BodyManagerTest {

	World world;
	
	@BeforeEach
	public void createWorld() {
		this.world = new World(new Vector2(0,Const.GRAVITY), false);
	}
	
	@Test
	public void createStaticBodyTest() {
		Body body = BodyManager.createBody(100,200,0,0,true, world);
		
		float x1 = body.getPosition().x;
		
		assertEquals(100 / Const.PPM, x1);
		assertEquals(200 / Const.PPM, body.getPosition().y);
		
		body.setLinearVelocity(10, 0);
		for (int i = 0; i < 10; i++) {
			this.world.step(Const.FPS, 6, 2);
		}
		
		float x2 = body.getPosition().x;
		assertEquals(x1,x2); // Test that body did not move because body is static
	}
	
}
