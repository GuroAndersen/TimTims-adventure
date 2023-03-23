package timtim.app.manager;

import java.util.ArrayList;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;

import timtim.app.core.MyContactListener;
import timtim.app.objects.Player;
import timtim.app.objects.GameObjects.Door;

public class GameMap implements IGameMap {

	String mapName;
	TiledMap tiledMap;
	World world;
	Player player;
	// Chest chest;
	OrthogonalTiledMapRenderer renderer;
	private ArrayList<Door> doors;

	private Box2DDebugRenderer debugRenderer;
	private OrthographicCamera camera;

	/**
	 * Completion criteria
	 */
	private boolean complete;

	public GameMap(String mapName, Player player) {
		this.player = player;
		this.mapName = mapName;
		doors = new ArrayList<Door>();
		complete = false;
		mapSetup();

	}

	public void mapSetup() {
		this.world = new World(new Vector2(0, Const.GRAVITY), false);
		world.setContactListener(new MyContactListener());
		tiledMap = new TmxMapLoader().load(mapName + ".tmx"); // gets map from resource folder
		parseStaticMapObjects(tiledMap.getLayers().get("static").getObjects()); // gets objects in the "objects" layer
																				// of the tiledmap.
		parsePlayerObject(tiledMap.getLayers().get("player").getObjects());
		parseDoorObject(tiledMap.getLayers().get("door").getObjects());
		// createDoorObject();
		renderer = new OrthogonalTiledMapRenderer(tiledMap);
		debugRenderer = new Box2DDebugRenderer();
		camera = new OrthographicCamera();
	}

	private void createDoorObject(PolygonMapObject o) {
		System.out.println("createDoorObject called");
		float[] vertices = o.getPolygon().getTransformedVertices();

		Rectangle bounds = o.getPolygon().getBoundingRectangle();
		float x = bounds.x;
		float y = bounds.y;
		float width = bounds.width;
		float height = bounds.height;
		Body body = BodyManager.createBody(x + width / 2, y + height / 2, width, height, true, world);
		// Body body = BodyManager.createBody(1000, 1000, 10, 10, true, world);
		// System.out.println(x + ", " + y + ", " + width + ", " + height);

		System.out.println(body.getPosition());
		String imagePath = "castledoors.png";
		Door door = new Door(body, vertices, imagePath);
		body.setUserData(door);
		Texture doorTexture = new Texture(Gdx.files.internal(imagePath));
		Fixture doorFixture = body.getFixtureList().get(0);
		doorFixture.setUserData(door);
		doorFixture.setSensor(true);
		doors.add(door);
	}

	private void parseDoorObject(MapObjects objects) {
		for (MapObject o : objects) {
			System.out.println("Parsing door object...");
			System.out.println(o.getClass().getName());
			if (o instanceof PolygonMapObject) {
				createDoorObject((PolygonMapObject) o);
			}
		}
	}

	private void parseStaticMapObjects(MapObjects objects) {
		for (MapObject o : objects) {
			if (o instanceof PolygonMapObject) {
				createStaticBody((PolygonMapObject) o);
			}
		}
	}

	private void parsePlayerObject(MapObjects objects) {
		MapObject o = objects.get(0);
		if (o instanceof RectangleMapObject) {
			Rectangle rect = ((RectangleMapObject) o).getRectangle();
			// Body body = BodyManager.createBody(rect.getX() + rect.getWidth() / 2,
			// rect.getY() + rect.getHeight() / 2,
			// rect.getWidth(), rect.getHeight(), false, world);
			Body body = BodyManager.createBody(100 * 30.4f, 37 * 30.4f,
					rect.getWidth(), rect.getHeight(), false, world);
			player.setBody(body, rect.getWidth(), rect.getHeight());
			Fixture fixture = body.getFixtureList().get(0);
			fixture.setUserData(player);
		} else {
			throw new IllegalArgumentException("Player map object not found or is not a RectangleMapObject");
		}
	}

	private void createStaticBody(PolygonMapObject o) {
		BodyDef bodydef = new BodyDef();
		bodydef.type = BodyDef.BodyType.StaticBody;
		Body body = world.createBody(bodydef);
		Shape shape = createPolyShape(o);
		body.createFixture(shape, 1000);
		shape.dispose();
	}

	private Shape createPolyShape(PolygonMapObject o) {
		float[] vertices = o.getPolygon().getTransformedVertices();
		Vector2[] worldVertices = new Vector2[vertices.length / 2];

		for (int i = 0; i < vertices.length / 2; i++) {
			Vector2 current = new Vector2(vertices[i * 2] / Const.PPM, vertices[i * 2 + 1] / Const.PPM); // Calculations
																											// to match
																											// BOX2D
																											// world
			worldVertices[i] = current;
		}

		PolygonShape shape = new PolygonShape();
		shape.set(worldVertices);
		return shape;
	}

	@Override
	public boolean isComplete() {
		return complete;
	}

	@Override
	public void restart() {
		mapSetup();
	}

	@Override
	public OrthogonalTiledMapRenderer getMapRenderer() {
		return renderer;
	}

	public void update() {
		this.world.step(Const.FPS, 6, 2);
		camera.update();
	}

	@Override
	public World getWorld() {
		return this.world;
	}

}
