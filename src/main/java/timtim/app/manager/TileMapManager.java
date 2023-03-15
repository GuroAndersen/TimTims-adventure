package timtim.app.manager;

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

import timtim.app.model.GameModel;

public class TileMapManager {

	private TiledMap tiledMap;
	private GameModel model;
	
	public TileMapManager(GameModel model) {
		this.model = model;
	}
	
	public OrthogonalTiledMapRenderer mapSetup(String mapName) {
		tiledMap = new TmxMapLoader().load(mapName + ".tmx"); // gets map from resource folder
		parseStaticMapObjects(tiledMap.getLayers().get("static").getObjects()); //gets objects in the "objects" layer of the tiledmap.
		parsePlayerObject(tiledMap.getLayers().get("player").getObjects());
		return new OrthogonalTiledMapRenderer(tiledMap);
	}
	
	private void parseStaticMapObjects(MapObjects objects) {
		for (MapObject o : objects) {
			if (o instanceof PolygonMapObject) {
				createStaticBody((PolygonMapObject) o);
			}
		}
	}

	private void parsePlayerObject(MapObjects objects){
		MapObject o = objects.get(0);
		if (o instanceof RectangleMapObject) {
			Rectangle rect = ((RectangleMapObject) o).getRectangle();
			String rectName = o.getName();
			Body body  = BodyManager.createBody(
					rect.getX() + rect.getWidth() / 2,
					rect.getY() + rect.getHeight() / 2,
					rect.getWidth(), 
					rect.getHeight(), 
					false, 
					model.getWorld()
				);
			model.getPlayer().setBody(body, rect.getWidth(), rect.getHeight());
		} else {
			throw new IllegalArgumentException("Player map object not found or is not a RectangleMapObject");
		}
	}
	
	private void createStaticBody(PolygonMapObject o) {
		BodyDef bodydef = new BodyDef();
		bodydef.type = BodyDef.BodyType.StaticBody;
		Body body = model.getWorld().createBody(bodydef);
		Shape shape = createPolyShape(o);
		body.createFixture(shape, 1000);
		shape.dispose();
	}

	private Shape createPolyShape(PolygonMapObject o) {
		float[] vertices = o.getPolygon().getTransformedVertices();
		Vector2[] worldVertices = new Vector2[vertices.length/2];
		
		for (int i = 0; i < vertices.length / 2; i++) {
			Vector2 current = new Vector2(vertices[i*2] / Const.PPM, vertices[i*2 + 1] / Const.PPM); //Calculations to match BOX2D world
			worldVertices[i] = current;
		}
		
		PolygonShape shape = new PolygonShape();
		shape.set(worldVertices);
		return shape;
	}
}
