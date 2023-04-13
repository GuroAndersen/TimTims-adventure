package timtim.app.model.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class CombatEntity extends GameEntity {

	private int maxHealth;
	private int health;
	/**
	 * The amount of damage this entity can perform on another CombatEntity
	 */
	private int strength;
	
	/**
	 * Construct a CombatEntity with the given 
	 * maximum health and strength.
	 * @param maxHealth the max health of this entity
	 * @param strength the strength of this entity
	 */
	public CombatEntity(Body body, Texture texture, int maxHealth, int strength) {
		super(body, texture);
		this.maxHealth = 1;
		this.health = 1;
		this.strength = 0;
	}
	
	/**
	 * Testing constructur. Body and sprite in GameObject remain null.
	 * @param maxHealth
	 * @param strength
	 */
	public CombatEntity(int maxHealth, int strength) {
		super(null,null);
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
