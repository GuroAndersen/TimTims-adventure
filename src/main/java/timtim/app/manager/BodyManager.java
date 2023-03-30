package timtim.app.manager;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class BodyManager {

	public static Body createBody(float x, float y, float width, float height, boolean isStatic, World world) {
		BodyDef bodyDef = new BodyDef(); // set definition to body object
		bodyDef.type = isStatic ? BodyDef.BodyType.StaticBody : BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(x / Const.PPM, y / Const.PPM);
		bodyDef.fixedRotation = true;
		Body body = world.createBody(bodyDef);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(width / 2 / Const.PPM, height / 2 / Const.PPM);

		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.friction = 0; // avoids sticking to walls
		body.createFixture(fixtureDef);
		shape.dispose();

		return body;
	}

}
