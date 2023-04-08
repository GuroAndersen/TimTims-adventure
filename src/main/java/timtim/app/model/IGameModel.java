package timtim.app.model;

import java.util.List;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.World;

import timtim.app.objects.GameEntity;
import timtim.app.objects.Player;


/**
 * A class to represent the model of this game.
 * Contains a world, player, other objects, maps etc.
 * @author Hilde Jordal
 *
 */
public interface IGameModel {

	/**
	 * get the models Player object
	 * @return player
	 */
	public Player getPlayer();
	
	/**
	 * get the current maps renderer
	 * @return renderer
	 */
	public OrthogonalTiledMapRenderer getMapRenderer();
	
	/**
	 * Update the player, the world and its contents
	 * @param delta, the time since last update in seconds
	 */
	public void update(float delta);

	/**
	 * Get the world of the current game map
	 * @return world
	 */
	public World getCurrentWorld();
	
	/**
	 * Get a list of all entities
	 * contained in this model. 
	 * This includes friends, enemies
	 * and player.
	 * @return list of entities
	 */
	public List<GameEntity> getEntities();
}
