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
	private Player timtim;

	public GameModel(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		this.timtim = new Player(gameScreen);
		this.tileMapManager = new TileMapManager(this, timtim);
	}

	@Override
	public Player getPlayer() {
		return this.timtim;
	}

	public GameMap getCurrentMap() {
		return tileMapManager.getCurrentMap();
	}
	
	public GameScreen getGameScreen() {
		return this.gameScreen;
	}


	@Override
	public OrthogonalTiledMapRenderer getMapRenderer() {
		return this.tileMapManager.getCurrentMap().getMapRenderer();
	}

	@Override
	public void update(float delta) {
		this.timtim.update(delta);
		this.tileMapManager.update(delta);
		
		if (!this.timtim.isAlive()) tileMapManager.getCurrentMap().restart();
	}
	
	@Override
	public List<GameEntity> getEntities() {
		List<GameEntity> entities = getCurrentMap().getEntities();
		entities.add(getPlayer());
		return entities;
		
	}

	@Override
	public World getCurrentWorld() {
		return this.tileMapManager.getCurrentMap().getWorld();
	}
}
