package timtim.app.objects;

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
}
