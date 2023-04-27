package timtim.app.model.objects.powerup;

import timtim.app.model.objects.CombatEntity;

public interface Powerup {

	/**
	 * Perform the relevant powerup on the CombatEntity. Can only be used once, so
	 * when this method is called twice it should not have any effect on the second
	 * occurance.
	 */
	public void doPowerupIfActive(CombatEntity entity);
}