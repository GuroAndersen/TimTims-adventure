package timtim.app.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import timtim.app.core.GameScreen;
import timtim.app.manager.Const;
import timtim.app.manager.EntityWorld;
import timtim.app.manager.GameMap;
import timtim.app.manager.TileMapManager;
import timtim.app.objects.Enemy;
import timtim.app.objects.Friend;
import timtim.app.objects.GameEntity;
import timtim.app.objects.Timtim;

public class GameModel implements IGameModel, EntityWorld {

	private TileMapManager tileMapManager;
	private GameMap currentMap;
	private Timtim timtim;

	private List<GameMap> maps;

	List<Friend> friendList;
	List<GameEntity> entityList;

	public GameModel(GameScreen gameScreen) {
		this.timtim = new Timtim(gameScreen);
		this.tileMapManager = new TileMapManager(this);

		// ENTITY LIST INIT
		friendList = new ArrayList<Friend>();
		entityList = new ArrayList<GameEntity>();

		this.currentMap = tileMapManager.getCurrentMap();
	}

	@Override
	public Timtim getPlayer() {
		return this.timtim;
	}

	public GameMap getCurrentMap() {
		return this.getCurrentMap();
	}

	@Override
	public OrthogonalTiledMapRenderer getMapRenderer() {
		return this.currentMap.getMapRenderer();
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
