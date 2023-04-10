package timtim.app.model.objects;

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
	 * Handles interaction for this player.
	 */
	public void interact();
	
	/**
	 * True if player is interacting
	 * @return 
	 */
	public boolean isInteracting();
	

}
