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

import timtim.app.controller.GameController;
import timtim.app.controller.IGameController;
import timtim.app.manager.Const;
import timtim.app.manager.TileMapManager;
import timtim.app.model.GameModel;
import timtim.app.model.IGameModel;
import timtim.app.objects.Player;

public class GameScreen extends ScreenAdapter {

	IGameModel model;
	IGameController controller;
	
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Box2DDebugRenderer B2DDebugRenderer;
	
	private OrthogonalTiledMapRenderer mapRenderer;
	
	public GameScreen(OrthographicCamera camera) {
		this.model = new GameModel(this);
		this.controller = new GameController(this);
		this.camera = camera;
		this.batch = new SpriteBatch();

		this.B2DDebugRenderer = new Box2DDebugRenderer();
		
		// MAP INIT
		this.mapRenderer = this.model.getMapRenderer();
	}
	
	@Override
	public void render(float delta) {
		this.controller.update();
		updateCamera();
		
		// Removes all graphics and animations from last frame
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Render map
		mapRenderer.setView(camera);
		mapRenderer.render();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		//render objects
		
		batch.end();
		B2DDebugRenderer.render(model.getWorld(), camera.combined.scl(Const.PPM));
	}

	private void updateCamera() {
		Vector3 pos = camera.position;
		// takes player position and multiply by PPM for real world position, 
		// 		multiply by 10 and divide by 10 for smoother camera movement
		pos.x = Math.round(model.getPlayer().getBody().getPosition().x * Const.PPM * 10) / 10f;
		pos.y = Math.round(model.getPlayer().getBody().getPosition().y * Const.PPM * 10) / 10f;
		camera.position.set(pos);
		camera.update();
	}
	
	public IGameModel getModel() {
		return this.model;
	}
}
