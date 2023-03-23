package timtim.app.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import timtim.app.manager.Const;
import timtim.app.manager.TileMapManager;
import timtim.app.model.GameModel;
import timtim.app.model.IGameModel;
import timtim.app.objects.Player;

public class GameScreen extends ScreenAdapter {

	IGameModel model;

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Box2DDebugRenderer B2DDebugRenderer;

	private OrthogonalTiledMapRenderer mapRenderer;

	public GameScreen(OrthographicCamera camera) {
		this.model = new GameModel();
		this.camera = camera;
		this.batch = new SpriteBatch();

		this.B2DDebugRenderer = new Box2DDebugRenderer();

		// MAP INIT
		this.mapRenderer = this.model.getMapRenderer();

	}

	private void update() {
		model.update();
		handlePlayerInput();
		updateCamera();
	}

	@Override
	public void render(float delta) {
		update();

		// Removes all graphics and animations from last frame
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Render map
		mapRenderer.setView(camera);
		mapRenderer.render();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		// render objects
		model.getPlayer().render(batch);

		batch.end();
		B2DDebugRenderer.render(model.getCurrentWorld(), camera.combined.scl(Const.PPM));
	}

	private void updateCamera() {
		Vector3 pos = camera.position;

		// sets camera to player
		pos.x = Math.round(model.getPlayer().getBody().getPosition().x * Const.PPM * 10) / 10f;
		pos.y = Math.round(model.getPlayer().getBody().getPosition().y * Const.PPM * 10) / 10f;

		float camViewportHalfX = camera.viewportWidth / 2;
		float camViewportHalfY = camera.viewportHeight / 2;
		MapProperties prop = mapRenderer.getMap().getProperties();
		float mapWidth = Math
				.round(prop.get("width", Integer.class) * prop.get("tilewidth", Integer.class) * Const.PPM * 10) / 10f;
		float mapHeight = Math.round(
				prop.get("height", Integer.class) * prop.get("tileheight", Integer.class) * Const.PPM * 10) / 10f;

		pos.x = MathUtils.clamp(camera.position.x, camViewportHalfX, mapWidth - camViewportHalfX);
		pos.y = MathUtils.clamp(camera.position.y, camViewportHalfY, mapHeight - camViewportHalfY);
		camera.position.set(pos);
		camera.update();
	}

	private void handlePlayerInput() {
		// Exit
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) { // Closes game if escape is pressed
			Gdx.app.exit();
		}

		// Horizontal movement
		boolean moveLeft = false;
		boolean moveRight = false;
		if (Gdx.input.isKeyPressed(Input.Keys.D))
			moveRight = true;
		if (Gdx.input.isKeyPressed(Input.Keys.A))
			moveLeft = true;
		model.getPlayer().move(moveLeft, moveRight);

		// Jump
		if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
			model.getPlayer().jump();
		}
	}
}
