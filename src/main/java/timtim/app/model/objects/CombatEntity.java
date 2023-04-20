package timtim.app.model.objects;

public abstract class CombatEntity extends GameEntity {

	private int maxHealth;
	private int health;
	/**
	 * The amount of damage this entity can perform on another CombatEntity
	 */
	private int strength;
	
	public CombatEntity() {
		super();
		this.maxHealth = 1;
		this.health = 1;
		this.strength = 0;
	}
	
	/**
	 * Construct a CombatEntity with the given 
	 * maximum health and strength.
	 * @param maxHealth the max health of this entity
	 * @param strength the strength of this entity
	 */
	public CombatEntity(int maxHealth, int strength) {
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.strength = strength;
	}
	
	/**
	 * Enact damage upon the given enemy.
	 * @param enemy the enemy to do damage upon
	 */
	public void doDamage(CombatEntity enemy) {
		enemy.takeDamage(strength);
	}
	
	/**
	 * Makes this CombatEntity take the hitPoints 
	 * amount of damage.
	 * If health reaches 0 or below, health is set to 0.
	 * if negative hitPoints are given, do nothing.
	 * 
	 * @param hitPoints
	 */
	public void takeDamage(int hitPoints) {
		if (hitPoints <= 0) return; 
		int newHealth = (health - hitPoints);
		this.health = newHealth >= 0 ? newHealth : 0;
	}

	/**
	 * @return the current healthPoints (HP) of this CombatEntity.
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * 
	 * @return the max health of this CombatEntity.
	 */
	public int getMaxHealth() {
		return this.maxHealth;
	}
	
	/**
	 * Returns true when the entity's health is above 0.
	 * @return
	 */
	public boolean isAlive() {
		return health > 0;
	}
	
	/**
	 * Resets the health to max health value
	 */
	public void resetHealth() {
		this.health = maxHealth;
	}

 }
