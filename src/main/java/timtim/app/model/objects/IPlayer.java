package timtim.app.model.objects;

import timtim.app.model.objects.Inventory.Inventory;

public interface IPlayer {

	/**
	 * Sets this players velocity in x direction
	 * @param velX
	 * @param velY
	 */
	public void move(boolean moveLeft, boolean moveRight);
	
	/**
	 * Performs a jump for this player
	 */
	public void jump();
	
	/**
	 * Get the player's inventory
	 * @return
	 */
	public Inventory getInventory();

}
