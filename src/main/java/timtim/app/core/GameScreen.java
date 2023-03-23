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
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

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
		centerCameraToPosition(this.model.getPlayer().getBody().getPosition());
		bindCameraToMap();
		camera.update();
	}
	
	private void centerCameraToPosition(Vector2 position) {
		Vector3 pos = camera.position;
		// sets camera to player
		pos.x = Math.round(model.getPlayer().getBody().getPosition().x * Const.PPM * 10) / 10f;
		pos.y = Math.round(model.getPlayer().getBody().getPosition().y * Const.PPM * 10) / 10f;
		camera.position.set(pos);
	}
	
	private void bindCameraToMap() {
		Vector3 position = camera.position;
		
		float startX = camera.viewportWidth / 2;
		float startY = camera.viewportHeight / 2;
		float width = mapRenderer.getMap().getProperties().get("width", Integer.class) * Const.PPM - startX*2;
		float height = mapRenderer.getMap().getProperties().get("height", Integer.class) * Const.PPM - startY*2;
		
		//Leftmost and bottom boundaries
		if (position.x < startX) position.x = startX;
		if (position.y < startY) position.y = startY;
		
		//Rightmost and top boundaries
		if (position.x > startX + width) position.x = startX + width;
		if (position.y > startY + height) position.y = startY + height;
		
		camera.position.set(position);
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
