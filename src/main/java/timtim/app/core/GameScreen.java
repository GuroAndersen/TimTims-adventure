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
import timtim.app.objects.Player;

public class GameScreen extends ScreenAdapter {

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private World world;
	private Box2DDebugRenderer B2DDebugRenderer;
	
	private OrthogonalTiledMapRenderer mapRenderer;
	private TileMapManager mapManager;
	
	// objects
	Player player;
	
	public GameScreen(OrthographicCamera camera) {
		this.camera = camera;
		this.batch = new SpriteBatch();
		this.world = new World(new Vector2(0,-9.81f), false);
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
		player.update();
		
		batch.setProjectionMatrix(camera.combined);
		mapRenderer.setView(camera);
		
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) { //  Closes game if escape is pressed
			Gdx.app.exit();
		}
	}

	private void updateCamera() {
		Vector3 pos = camera.position;
		// takes player position and multiply by PPM for real world position, 
		// 		multiply by 10 and divide by 10 for smoother camera movement
		pos.x = Math.round(player.getBody().getPosition().x * Const.PPM * 10) / 10f;
		pos.y = Math.round(player.getBody().getPosition().y * Const.PPM * 10) / 10f;
		camera.position.set(pos);
		camera.update();
	}

	/**
	 * @return the world
	 */
	public World getWorld() {
		return world;
	}
	
	public void setPlayer(Player p) {
		this.player = p;
	}
}
