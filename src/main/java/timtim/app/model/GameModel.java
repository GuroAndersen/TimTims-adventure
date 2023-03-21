package timtim.app.model;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import timtim.app.core.GameScreen;
import timtim.app.core.MyContactListener;
import timtim.app.manager.Const;
import timtim.app.manager.TileMapManager;
import timtim.app.objects.Player;

public class GameModel implements IGameModel {

	private GameScreen gameScreen;
	private TileMapManager tileMapManager;
	private World world;
	private Player player;

	public GameModel(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		this.world = new World(new Vector2(0, Const.GRAVITY), false);
		this.world.setContactListener(new MyContactListener());
		this.tileMapManager = new TileMapManager(this);
		this.player = new Player();
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
		return this.tileMapManager.mapSetup();
	}

	@Override
	public void update() {
		this.player.update();
		this.world.step(Const.FPS, 6, 2);
	}
}
