package timtim.app.manager;

import timtim.app.objects.Enemy;
import timtim.app.objects.Friend;

public interface EntityWorld {

	/**
	 * Adds the given enemy to this world.
	 * @param enemy
	 */
	public void addEnemy(Enemy enemy);
	
	/**
	 * Adds the given friend to this world
	 * @param friend
	 */
	public void addFriend(Friend friend);
	
}
