package timtim.app.model;

import java.util.List;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.World;

import timtim.app.objects.GameEntity;


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
	
	/**
	 * Get the map's entities
	 */
	public List<GameEntity> getEntities();

	/**
	 * Sets the map as complete
	 * @return
	 */
	public void setComplete();
}
