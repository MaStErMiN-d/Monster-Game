package de.mastermind.thegoog.project.monstergame.monsters;

import java.io.Serializable;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */

public class Monsters implements Serializable {

	private boolean isBoss = false;

	private long health = 0;
	private long damage = 0;
	private long bounty = 0;

	private ElementTypes element;

	private AppearanceTypes appearance;

	/**
	 * Initializes a new Monster
	 * 
	 * @param initHealth
	 * @param initDamage
	 * @param initElement
	 * @param initIsBoss
	 * @param initAppearance
	 * @param initBounty
	 */
	public Monsters(long initHealth, long initDamage, ElementTypes initElement,
			boolean initIsBoss, AppearanceTypes initAppearance, long initBounty) {
		if (initHealth <= 0) {
			throw new IllegalArgumentException("Health is too low!");
		} else if (initDamage <= 0) {
			throw new IllegalArgumentException(
					"No Monster with 0 or less Damage allowed!");
		} else if (initAppearance == null) {
			throw new IllegalArgumentException("Appearance must be defined!");
		} else if (initBounty < 0) {
			throw new IllegalArgumentException("Bounty must be 0 or higher!");
		} else {
			this.isBoss = initIsBoss;
			this.health = initHealth;
			this.damage = initDamage;
			this.element = initElement;
			this.appearance = initAppearance;
			this.bounty = initBounty;
		}
	}

	/**
	 * Sets the Bounty of the Monster
	 * 
	 * @param bounty
	 */
	public void setBounty(long bounty) {
		if (bounty < 0) {
			throw new IllegalArgumentException("Bounty must be 0 or higher!");
		} else {
			this.bounty = bounty;
		}
	}

	/**
	 * Returns the Bounty of the Monster
	 * 
	 * @return bounty
	 */
	public long getBounty() {
		return this.bounty;
	}

	/**
	 * Sets the AppearanceTypes of the Monster
	 * 
	 * @param appearance
	 */
	public void setAppearance(AppearanceTypes appearance) {
		if (appearance == null) {
			throw new IllegalArgumentException("Appearance must be defined!");
		} else {
			this.appearance = appearance;
		}
	}

	/**
	 * Returns AppearanceTypes of the Monster
	 * 
	 * @return appearance
	 */
	public AppearanceTypes getAppearance() {
		return appearance;
	}

	/**
	 * Sets the Damage the Monster will inflict upon the Player
	 * 
	 * @param dmg
	 */
	public void setDamage(long dmg) {
		if (dmg <= 0) {
			throw new IllegalArgumentException(
					"No Monster with 0 or less Damage allowed!");
		} else {
			this.damage = dmg;
		}
	}

	/**
	 * Returns the Damage Value the Monster can inflict upon the Player
	 * 
	 * @return Damage Value of the Monster
	 */
	public long getDamage() {
		return damage;
	}

	/**
	 * Sets the Amount of HealthPoints of the Monster
	 * 
	 * @param life
	 */
	public void setLife(long life) {
		if (life < 0) {
			throw new IllegalArgumentException("Health is too low!");
		} else {
			this.health = life;

			if (health == 0) {
				this.die();
			}
		}
	}

	/**
	 * Return the remaining Health of the Monster
	 * 
	 * @return health
	 */
	public long getLife() {
		return health;
	}

	/**
	 * Applies Damage TAKEN BY THE MONSTER to its HealthPoints
	 * 
	 * @param dmg
	 */
	public void applyDamage(long dmg) {
		if (dmg <= 0) {
			throw new IllegalArgumentException(
					"No Monster with 0 or less Damage allowed!");
		} else {
			this.health = health - dmg;

			if (health <= 0) {
				this.die();
			}
		}
	}

	/**
	 * Returns the ElementType of the Monster
	 * 
	 * @return ElementType
	 */
	public ElementTypes getElementType() {
		return element;
	}

	/**
	 * Returns true if Monster is Boss
	 * 
	 * @return isBossMonster
	 */
	public boolean isBossMonster() {
		return isBoss;
	}

	/**
	 * Routine when the Monster dies
	 */
	private void die() {
		appearance = AppearanceTypes.Invisible;
		// TODO Monster dies
	}

	// TODO Think of more Methods required of Monsters.

}
