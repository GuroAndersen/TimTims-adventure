package timtim.app.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.World;

import timtim.app.core.GameScreen;
import timtim.app.manager.GameMap;
import timtim.app.manager.TileMapManager;
import timtim.app.objects.GameEntity;
import timtim.app.objects.Player;
import timtim.app.objects.Friend.Friend;

public class GameModel implements IGameModel {

	private GameScreen gameScreen;
	private TileMapManager tileMapManager;
	private GameMap currentMap;
	private Player timtim;

	List<Friend> friendList;
	List<GameEntity> entityList;

	public GameModel(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		this.timtim = new Player(gameScreen);
		this.tileMapManager = new TileMapManager(this, timtim);

		// ENTITY LIST INIT
		friendList = new ArrayList<Friend>();
		entityList = new ArrayList<GameEntity>();

		this.currentMap = tileMapManager.getCurrentMap();
	}

	@Override
	public Player getPlayer() {
		return this.timtim;
	}

	public GameMap getCurrentMap() {
		return this.getCurrentMap();
	}
	
	public GameScreen getGameScreen() {
		return this.gameScreen;
	}


	@Override
	public OrthogonalTiledMapRenderer getMapRenderer() {
		return this.currentMap.getMapRenderer();
	}

	@Override
	public void update(float delta) {
		this.timtim.update(delta);
		updateEntities(entityList);
		this.currentMap.update();
	}

	private void updateEntities(List<GameEntity> entityList) {
		for (GameEntity e : entityList)
			e.update(1);
	}

	@Override
	public World getCurrentWorld() {
		return this.currentMap.getWorld();
	}
}
