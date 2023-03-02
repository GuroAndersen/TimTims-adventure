package timtim.app.model;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.World;

import timtim.app.objects.Player;


/**
 * A class to represent the model of this game.
 * Contains a world, player, other objects, maps etc.
 * @author Hilde Jordal
 *
 */
public interface IGameModel {

	/**
	 * Get the models World object
	 * @return
	 */
	public World getWorld();
	
	/**
	 * get the models Player object
	 * @return
	 */
	public Player getPlayer();
	
	/**
	 * get the current maps renderer
	 * @return
	 */
	public OrthogonalTiledMapRenderer getMapRenderer();
	
	/**
	 * Update the world and its contents
	 */
	public void update();
}