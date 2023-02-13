package timtim.app.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import timtim.app.manager.Const;
import timtim.app.manager.TileMapManager;

public class GameScreen extends ScreenAdapter {

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private World world;
	private Box2DDebugRenderer B2DDebugRenderer;
	
	private OrthogonalTiledMapRenderer mapRenderer;
	private TileMapManager mapManager;
	
	public GameScreen(OrthographicCamera camera) {
		this.camera = camera;
		this.batch = new SpriteBatch();
		this.world = new World(new Vector2(0,0), false);
		this.B2DDebugRenderer = new Box2DDebugRenderer();
		
		// MAP INIT
		this.mapManager = new TileMapManager(this);
		this.mapRenderer = mapManager.mapSetup();
	}
	
	@Override
	public void render(float delta) {
		this.update();
		
		// Removes all graphics and animations from last frame
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Render map
		mapRenderer.render();
		
		batch.begin();
		//render objects
		
		batch.end();
		B2DDebugRenderer.render(world, camera.combined.scl(Const.PPM));
	}

	
	private void update() {
		world.step(1/60f, 6, 2);
		updateCamera();
		
		batch.setProjectionMatrix(camera.combined);
		mapRenderer.setView(camera);
		
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) { //  Closes game if escape is pressed
			Gdx.app.exit();
		}
	}

	private void updateCamera() {
		camera.position.set(new Vector3(0,0,0));
		camera.update();
	}

	/**
	 * @return the world
	 */
	public World getWorld() {
		return world;
	}
}
