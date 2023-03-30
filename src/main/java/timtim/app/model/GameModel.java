package timtim.app.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.World;

import timtim.app.core.GameScreen;
import timtim.app.manager.EntityWorld;
import timtim.app.manager.GameMap;
import timtim.app.manager.TileMapManager;
import timtim.app.objects.Enemy;
import timtim.app.objects.Friend;
import timtim.app.objects.GameEntity;
import timtim.app.objects.Player;

public class GameModel implements IGameModel, EntityWorld {

	private TileMapManager tileMapManager;
	private Player timtim;

	private List<GameMap> maps;

	List<Friend> friendList;
	List<GameEntity> entityList;

	public GameModel(GameScreen gameScreen) {
		this.timtim = new Player(gameScreen);
		this.tileMapManager = new TileMapManager(this);

		// ENTITY LIST INIT
		friendList = new ArrayList<Friend>();
		entityList = new ArrayList<GameEntity>();
	}

	public void swapLevels(){
		tileMapManager.swapLevels();
	}

	@Override
	public Player getPlayer() {
		return this.timtim;
	}

	public GameMap getCurrentMap() {
		return this.tileMapManager.getCurrentMap();
	}

	@Override
	public OrthogonalTiledMapRenderer getMapRenderer() {
		return this.tileMapManager.getCurrentMap().getMapRenderer();
	}

	@Override
	public void addFriend(Friend friend) {
		this.friendList.add(friend);
		this.entityList.add(friend);
	}

	@Override
	public void addEnemy(Enemy enemy) {
		this.entityList.add(enemy);
	}

	@Override
	public void update(float delta) {
		this.timtim.update(delta);
		updateEntities(entityList);
		this.tileMapManager.getCurrentMap().update();
	}

	private void updateEntities(List<GameEntity> entityList) {
		for (GameEntity e : entityList)
			e.update(1);
	}

	@Override
	public World getCurrentWorld() {
		return this.tileMapManager.getCurrentMap().getWorld();
	}
}
