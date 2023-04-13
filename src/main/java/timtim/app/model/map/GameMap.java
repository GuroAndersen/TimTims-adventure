package timtim.app.model.map;

import java.util.ArrayList;
import java.util.List;

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
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Fixture;

import timtim.app.core.GameScreen;
import timtim.app.manager.BodyManager;
import timtim.app.manager.Const;
import timtim.app.model.GameModel;
import timtim.app.model.IGameMap;
import timtim.app.model.MyContactListener;
import timtim.app.model.objects.Enemy;
import timtim.app.model.objects.GameEntity;
import timtim.app.model.objects.Player;
import timtim.app.model.objects.Friend.Friend;
import timtim.app.model.objects.Friend.Skeleton;
import timtim.app.model.objects.Friend.Snake;
import timtim.app.model.objects.Friend.Wolf;
import timtim.app.model.objects.GameObjects.Chest;
import timtim.app.model.objects.GameObjects.Door;
import timtim.app.model.objects.GameObjects.Flora;
import timtim.app.model.objects.Inventory.Item;
import timtim.app.model.objects.Inventory.ItemFactory;

public class GameMap implements IGameMap {

	GameScreen gameScreen;
	GameModel model;
	String mapName;
	TiledMap tiledMap;
	World world;
	Body playerBody;

	OrthogonalTiledMapRenderer renderer;

	// objects
	private ArrayList<Door> doors;
	private ArrayList<Flora> floras;
	private ArrayList<Chest> chests;
	private ItemFactory itemFactory;

	// entities
	private ArrayList<Friend> friends;
	private ArrayList<Enemy> enemies;
	private Player player;

	/**
	 * Completion criteria
	 */
	private boolean complete;
	// private boolean isDoorOpen;

	public GameMap(String mapName, GameModel model) {
		this.gameScreen = model.getGameScreen();
		this.model = model;
		this.mapName = mapName;
		this.player = model.getPlayer();
		doors = new ArrayList<Door>();
		chests = new ArrayList<Chest>();
		floras = new ArrayList<Flora>();
		enemies = new ArrayList<Enemy>();
		friends = new ArrayList<Friend>();
		itemFactory = new ItemFactory();
		complete = false;
		// isDoorOpen = false;
		mapSetup();

	}

	public void mapSetup() {
		this.world = new World(new Vector2(0, Const.GRAVITY), false);
		world.setContactListener(new MyContactListener(model, gameScreen));
		tiledMap = new TmxMapLoader().load(mapName + ".tmx"); // gets map from resource folder
		parseStaticMapObjects(tiledMap.getLayers().get("static").getObjects()); // gets objects in the "objects" layer
																				// of the tiledmap.
		parsePlayerObject(tiledMap.getLayers().get("player").getObjects());
		parseDoorObject(tiledMap.getLayers().get("door").getObjects());
		parseChestObject(tiledMap.getLayers().get("chest").getObjects());
		parseFloraObject(tiledMap.getLayers().get("flora").getObjects(), null);
		parseFriendObject(tiledMap.getLayers().get("friends").getObjects());
		parseEnemyObject(tiledMap.getLayers().get("enemies").getObjects());

		renderer = new OrthogonalTiledMapRenderer(tiledMap);
	}

	private void parsePlayerObject(MapObjects objects) {
		MapObject o = objects.get(0);
		if (o instanceof RectangleMapObject) {
			Rectangle rect = ((RectangleMapObject) o).getRectangle();
			playerBody = BodyManager.createBody(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2,
					rect.getWidth(), rect.getHeight(), false, world);
			Fixture fixture = playerBody.getFixtureList().get(0);
			fixture.setUserData(player);
		} else {
			throw new IllegalArgumentException("Player map object not found or is not a RectangleMapObject");
		}
	}

	private void parseEnemyObject(MapObjects objects) {
		// for (MapObject o : objects) {
		// if (o instanceof RectangleMapObject) {
		// Enemy enemy;
		// Rectangle rect = ((RectangleMapObject) o).getRectangle();
		// Body body = BodyManager.createBody(rect.getX() + rect.getWidth() / 2,
		// rect.getY() + rect.getHeight() / 2,
		// rect.getWidth(), rect.getHeight(), false, world);
		// Fixture fixture = playerBody.getFixtureList().get(0);
		// fixture.setUserData(player);
		// enemy = new Enemy(SKELETON)
		// enemies.add(enemy);
		// } else {
		// throw new IllegalArgumentException("Player map object not found or is not a
		// RectangleMapObject");
		// }
		// }
	}

	private void parseFriendObject(MapObjects objects) {
		for (MapObject o : objects) {
			if (o instanceof RectangleMapObject) {
				Friend friend = null;
				Rectangle rect = ((RectangleMapObject) o).getRectangle();
				String name = ((RectangleMapObject) o).getName();
				Body body = BodyManager.createBody(rect.getX() + rect.getWidth() / 2,
						rect.getY() + rect.getHeight() / 2, rect.getWidth(), rect.getHeight(), true, world);
				switch (name) {
					case "skeleton":
						friend = new Skeleton(gameScreen, this);
						break;
					case "wolf":
						friend = new Wolf(gameScreen, this);
						break;
					case "snake":
						friend = new Snake(gameScreen, this);
						break;
					default:
						throw new IllegalArgumentException("This friend type is not represented");
				}
				friend.setBody(body);
				Fixture fixture = body.getFixtureList().get(0);
				fixture.setUserData(friend);
				friends.add(friend);
			} else {
				throw new IllegalArgumentException("Friend map object not found or is not a RectangleMapObject");
			}
		}
	}

	private Body createObject(PolygonMapObject o) {
		float[] vertices = o.getPolygon().getTransformedVertices();

		Rectangle bounds = o.getPolygon().getBoundingRectangle();
		float x = bounds.x;
		float y = bounds.y;
		float width = bounds.width;
		float height = bounds.height;
		Body body = BodyManager.createBody(x + width / 2, y + height / 2, width, height, true, world);

		return body;
	}

	private void createDoorObject(PolygonMapObject o) {

		Body body = createObject(o);

		String imagePath = "castledoors.png";
		Door door = new Door(body, o.getPolygon().getTransformedVertices(), imagePath);
		body.setUserData(door);
		Texture doorTexture = new Texture(Gdx.files.internal(imagePath));
		Fixture doorFixture = body.getFixtureList().get(0);
		doorFixture.setUserData(door);
		doorFixture.setSensor(true);
		doors.add(door);
	}

	private void parseDoorObject(MapObjects objects) {
		for (MapObject o : objects) {
			if (o instanceof PolygonMapObject) {
				createDoorObject((PolygonMapObject) o);
			}
		}
	}

	private void createFloraObject(PolygonMapObject o, Texture floraTexture) {
		Body body = createObject(o);

		Flora flora = new Flora(body, o.getPolygon().getTransformedVertices(), floraTexture);
		body.setUserData(flora);
		Fixture floraFixture = body.getFixtureList().get(0);
		floraFixture.setUserData(flora);
		floraFixture.setSensor(true);
		floras.add(flora);
	}

	private void parseFloraObject(MapObjects objects, Texture floraTexture) {
		for (MapObject o : objects) {
			if (o instanceof PolygonMapObject) {
				createFloraObject((PolygonMapObject) o, floraTexture);
			}
		}
	}

	private void createChestObject(PolygonMapObject o) {

		Body body = createObject(o);
		String imagePath = "chest2.png";
		Chest chest = new Chest(body, o.getPolygon().getTransformedVertices(), imagePath, imagePath);

		Item chestItem = ItemFactory.generateItem(mapName);

		chest.setItem(chestItem);
		body.setUserData(chest);
		Fixture chestFixture = body.getFixtureList().get(0);
		chestFixture.setUserData(chest);
		chestFixture.setSensor(true);
		chest.setItem(chestItem);
		chests.add(chest);
	}

	private void parseChestObject(MapObjects objects) {
		for (MapObject o : objects) {
			if (o instanceof PolygonMapObject) {
				createChestObject((PolygonMapObject) o);
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
	public void setComplete() {
		this.complete = true;
		// this.isDoorOpen = true;
	}

	@Override
	public void restart() {
		mapSetup();
		this.model.getPlayer().setBody(this.playerBody);
	}

	@Override
	public OrthogonalTiledMapRenderer getMapRenderer() {
		return renderer;
	}

	public void update(float delta) {
		this.world.step(Const.FPS, 6, 2);
		for (Friend f : friends)
			f.update(delta);
		for (Enemy e : enemies)
			e.update(delta);
	}

	@Override
	public World getWorld() {
		return this.world;
	}

	@Override
	public List<GameEntity> getEntities() {
		List<GameEntity> entityList = new ArrayList<>();
		entityList.addAll(friends);
		entityList.addAll(enemies);
		return entityList;
	}

	@Override
	public Body getPlayerBody() {
		return this.playerBody;
	}

}
