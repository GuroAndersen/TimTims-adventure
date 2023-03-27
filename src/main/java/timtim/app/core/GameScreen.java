package timtim.app.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

import timtim.app.core.state.GameOverState;
import timtim.app.core.state.PauseState;
import timtim.app.core.state.PlayState;
import timtim.app.core.state.State;
import timtim.app.manager.Const;
import timtim.app.model.GameModel;
import timtim.app.model.IGameModel;

import java.util.HashMap;

public class GameScreen extends ScreenAdapter implements AccessibleGame {

	private HashMap<State, StateHandler> states;
	private IGameModel model;

	private State state;

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Box2DDebugRenderer B2DDebugRenderer;

	private OrthogonalTiledMapRenderer mapRenderer;

	public GameScreen(OrthographicCamera camera) {
		this.state = State.PLAY; // currently PLAY but should be START
		this.model = new GameModel();
		this.camera = camera;
		this.batch = new SpriteBatch();

		this.B2DDebugRenderer = new Box2DDebugRenderer();

		// MAP INIT
		this.mapRenderer = this.model.getMapRenderer();

		this.states = new HashMap<>();
		initStates();

	}

	private void initStates() {
		states.put(State.PLAY, new PlayState(this));
		states.put(State.PAUSE, new PauseState(this));
		states.put(State.GAMEOVER, new GameOverState(this));
	}

	@Override
	public void render(float delta) {
		states.get(state).render();
	}

	@Override
	public IGameModel getModel() {
		return this.model;
	}

	@Override
	public void playerMove(boolean left, boolean right) {
		model.getPlayer().move(left, right);
	}

	@Override
	public void playerJump() {
		model.getPlayer().jump();
	}

	@Override
	public void updateCamera() {
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

	@Override
	public void renderMap() {
		mapRenderer.setView(camera);
		mapRenderer.render();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		// render objects
		model.getPlayer().render(batch);

		batch.end();
		B2DDebugRenderer.render(model.getCurrentWorld(), camera.combined.scl(Const.PPM));
	}

	@Override
	public void switchState(State state) {
		this.state = state;
	}

	@Override
	public OrthographicCamera getCamera() {
		return this.camera;
	}


}
