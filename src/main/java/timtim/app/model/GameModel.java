package timtim.app.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import timtim.app.core.GameScreen;
import timtim.app.manager.Const;
import timtim.app.manager.EntityWorld;
import timtim.app.manager.TileMapManager;
import timtim.app.objects.Enemy;
import timtim.app.objects.Friend;
import timtim.app.objects.GameEntity;
import timtim.app.objects.Player;

public class GameModel implements IGameModel, EntityWorld {

	private GameScreen gameScreen;
	private TileMapManager tileMapManager;
	private OrthogonalTiledMapRenderer currentMapRenderer;
	private World world;
	private Player player;
	
	List<Friend> friendList;
	List<GameEntity> entityList;
	
	public GameModel(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		this.world = new World(new Vector2(0,Const.GRAVITY), false);
		this.tileMapManager = new TileMapManager(this);
		this.player = new Player();
		
		// ENTITY LIST INIT
		 friendList = new ArrayList<Friend>();
		 entityList = new ArrayList<GameEntity>();
		 
		 currentMapRenderer = this.tileMapManager.mapSetup("level_3");
	}
	
	
	@Override
	public World getWorld() {
		return this.world;
	}

	@Override
	public Player getPlayer() {
		return this.player;
	}
	
	@Override
	public OrthogonalTiledMapRenderer getMapRenderer() {
		return this.currentMapRenderer;
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
	public void update() {
		this.player.update();
		updateEntities(entityList);
		this.world.step(Const.FPS, 6, 2);
	}
	
	private void updateEntities(List<GameEntity> entityList) {
		for (GameEntity e : entityList) e.update();
	}
}
