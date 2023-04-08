package timtim.app.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

import timtim.app.core.state.*;
import timtim.app.manager.Const;
import timtim.app.model.GameModel;
import timtim.app.model.IGameModel;
import timtim.app.objects.GameEntity;

import java.util.HashMap;

public class GameScreen extends ScreenAdapter implements AccessibleGame {

	// Model and state variables
	private State state;
	private HashMap<State, StateHandler> states;
	private IGameModel model;

	// Map rendering variables
	private OrthographicCamera camera;
	private Box2DDebugRenderer B2DDebugRenderer;
	private OrthogonalTiledMapRenderer mapRenderer;
	private float zoom = 0.5f;
	
	// Sprite rendering variables
	private TextureAtlas atlas;
	private SpriteBatch batch;

	public GameScreen(OrthographicCamera camera) {
		this.state = State.START;
		this.camera = camera;
		this.batch = new SpriteBatch();
		this.atlas = new TextureAtlas("gameSprites.pack");
		this.camera = camera;
		this.camera.zoom = zoom;
		this.B2DDebugRenderer = new Box2DDebugRenderer();
		this.model = new GameModel(this);

		// MAP INIT
		this.mapRenderer = this.model.getMapRenderer();

		this.states = new HashMap<>();
		initStates();

	}

	private void initStates() {
		states.put(State.PLAY, new PlayState(this));
		states.put(State.PAUSE, new PauseState(this));
		states.put(State.GAMEOVER, new GameOverState(this));
		states.put(State.START, new StartState(this));
	}

	@Override
	public void render(float delta) {
		states.get(state).render(delta);
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
		
		float startX = camera.viewportWidth *zoom/ 2;
		float startY = camera.viewportHeight*zoom / 2;
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
		getBatch().setProjectionMatrix(camera.combined);
		getBatch().begin();
		// render objects
		model.getPlayer().render(getBatch());
		for (GameEntity e : model.getEntities()) e.render(batch);
		getBatch().end();
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

	public SpriteBatch getBatch() {
		return batch;
	}

	public TextureAtlas getAtlas() {
		return atlas;
	}


}
