package timtim.app.manager;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.World;


public interface IGameMap {

	/**
	 * Get the map's renderer
	 * @return
	 */
	public OrthogonalTiledMapRenderer getMapRenderer();
	
	/**
	 * Check if this map has reached 
	 * completion
	 * @return true if map is complete
	 */
	public boolean isComplete();
	
	/**
	 * Restart this map to its original
	 * state. This does not set completion
	 * to false
	 */
	public void restart();
	
	/**
	 * Get the map's world object
	 */
	public World getWorld();
	
}
