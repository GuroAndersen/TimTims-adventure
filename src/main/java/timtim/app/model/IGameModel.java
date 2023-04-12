package timtim.app.model;

import java.util.List;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.World;

import timtim.app.model.objects.GameEntity;
import timtim.app.model.objects.IPlayer;
import timtim.app.model.objects.Player;


/**
 * A class to represent the model of this game.
 * Contains a world, player, other objects, maps etc.
 * @author Hilde Jordal
 *
 */
public interface IGameModel {

	///////////////////// PLAYER METHODS
	
	/**
	 * get the models Player object
	 * @return player
	 */
	public Player getPlayer();
	
	/**
     * Move the player left and or right.
     * If both left and right is pressed, nothing happens.
     * @param left
     * @param right
     */
    public void playerMove(boolean left, boolean right);

    /**
     * Make the player jump
     */
    public void playerJump();
	
	
	///////////////////// OTHER
	
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
