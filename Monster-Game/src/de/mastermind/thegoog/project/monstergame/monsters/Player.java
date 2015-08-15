package de.mastermind.thegoog.project.monstergame.monsters;

import de.mastermind.thegoog.project.monstergame.utils.Utils;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */

public class Player extends Monsters {

	private long level = 1;
	private long money = 0;
	private long clickDamage = 0;

	// damage-Scaling for elementals
	private double elementalDamage_Air = 1.0;
	private double elementalDamage_Water = 1.0;
	private double elementalDamage_Earth = 1.0;
	private double elementalDamage_Fire = 1.0;

	/**
	 * Initializes a Player
	 * 
	 * @param initHealth
	 * @param initDamage
	 * @param initClickDamage
	 */
	public Player(long initHealth, long initPassiveDamage, long initClickDamage) {
		super(initHealth, initPassiveDamage, null, false,
				AppearanceTypes.Invisible, 0);
		this.clickDamage = initClickDamage;
		Utils.setLevel(level);
	}

	/**
	 * Adds bounty to current Account
	 * 
	 * @param bounty
	 */
	public void addBounty(long bounty) {
		this.money += bounty;
	}

	/**
	 * Sets the Players Account to new value
	 * 
	 * @param balance
	 */
	public void setAccount(long balance) {
		this.money = balance;
	}

	/**
	 * Player takes damage
	 * 
	 * @param dmg
	 */
	public void applyDamage(long dmg) {
		super.applyDamage(dmg);
	}

	/**
	 * Increments the Level-Counter
	 */
	public void incLevel() {
		this.level++;
		Utils.setLevel(this.level);
	}

	/**
	 * Sets the Damage dealt by clicking
	 * 
	 * @param dmg
	 */
	public void setClickDamage(long dmg) {
		if (Utils.getClickDamageUpdated()) {
			this.clickDamage = dmg;
			Utils.setClickDamageUpdated(false);
		} else {
			throw new IllegalArgumentException(
					"Can't update Players Click-Damage if no update was approved!");
		}
	}

	/**
	 * Sets the Level
	 * 
	 * @param level
	 */
	public void setLevel(long level) {
		if (Utils.getLevelUpdated()) {
			this.level = level;
			Utils.setLevel(this.level);
			Utils.setLevelUpdated(false);
		} else {
			throw new IllegalArgumentException(
					"Can't update Level if no update was approved!");
		}
	}

	/**
	 * Sets Damage dealt passively
	 * 
	 * @param dmg
	 */
	public void setDamage(long dmg) {
		if (Utils.getPassiveDamageUpdated()) {
			super.setDamage(dmg);
			Utils.setPassiveDamageUpdated(false);
		} else {
			throw new IllegalArgumentException(
					"Can't update Players passive Damage if no update was approved!");
		}
	}

	/**
	 * Sets the Life of the Player
	 * 
	 * @param life
	 */
	public void setLife(long life) {
		if (Utils.getLifeUpdated()) {
			super.setLife(life);
			Utils.setLifeUpdated(false);
		} else {
			throw new IllegalArgumentException(
					"Can't update Life if no update was approved!");
		}
	}

	/**
	 * Returns the current Level
	 * 
	 * @return level
	 */
	public long getLevel() {
		return this.level;
	}

	/**
	 * Returns current click-Damage
	 * 
	 * @return clickDamage
	 */
	public long getClickDamage() {
		return this.clickDamage;
	}

	/**
	 * Returns current passive Damage
	 * 
	 * @return damage
	 */
	public long getDamage() {
		return super.getDamage();
	}

	/**
	 * Returns current life
	 * 
	 * @return life
	 */
	public long getLife() {
		return super.getLife();
	}

	/**
	 * Returns the current Money of the Player
	 * 
	 * @return money
	 */
	public long getMoney() {
		return this.money;
	}

	/**
	 * Returns the Click-Damage scaled by an Element
	 * 
	 * @param et
	 * @return
	 */
	public long getClickDamage_Elemental(ElementTypes et) {
		long eClickDamage = 0;

		switch (et) {
		case Air_Type:
			eClickDamage = (long) (this.getClickDamage() * this.elementalDamage_Air);
			break;
		case Water_Type:
			eClickDamage = (long) (this.getClickDamage() * this.elementalDamage_Water);
			break;
		case Earth_Type:
			eClickDamage = (long) (this.getClickDamage() * this.elementalDamage_Earth);
			break;
		case Fire_Type:
			eClickDamage = (long) (this.getClickDamage() * this.elementalDamage_Fire);
			break;
		}

		if (eClickDamage > 0) {
			return eClickDamage;
		} else {
			throw new IllegalArgumentException(
					"Elemental Damage can't be 0 or less!");
		}
	}

	/**
	 * Returns the passive Damage scaled by an Element
	 * 
	 * @param et
	 * @return eDamage
	 */
	public long getDamage_Elemental(ElementTypes et) {
		long eDamage = 0;

		switch (et) {
		case Air_Type:
			eDamage = (long) (this.getDamage() * this.elementalDamage_Air);
			break;
		case Water_Type:
			eDamage = (long) (this.getDamage() * this.elementalDamage_Water);
			break;
		case Earth_Type:
			eDamage = (long) (this.getDamage() * this.elementalDamage_Earth);
			break;
		case Fire_Type:
			eDamage = (long) (this.getDamage() * this.elementalDamage_Fire);
			break;
		}

		if (eDamage > 0) {
			return eDamage;
		} else {
			throw new IllegalArgumentException(
					"Elemental Damage can't be 0 or less!");
		}
	}

	/**
	 * Sets the Players elemental Damage-Scale for Air
	 * 
	 * @param newScale
	 */
	public void setElementalDamage_Air(double newScale) {
		this.elementalDamage_Air = newScale;
	}

	/**
	 * Sets the Players elemental Damage-Scale for Water
	 * 
	 * @param newScale
	 */
	public void setElementalDamage_Water(double newScale) {
		this.elementalDamage_Water = newScale;
	}

	/**
	 * Sets the Players elemental Damage-Scale for Earth
	 * 
	 * @param newScale
	 */
	public void setElementalDamage_Earth(double newScale) {
		this.elementalDamage_Earth = newScale;
	}

	/**
	 * Sets the Players elemental Damage-Scale for Fire
	 * 
	 * @param newScale
	 */
	public void setElementalDamage_Fire(double newScale) {
		if (Utils.getElementalDamageUpdated_Fire()) {
			this.elementalDamage_Fire = newScale;
			Utils.setElementalDamageUpdated_Fire(false);
		} else {
			throw new IllegalArgumentException(
					"Can't update elemental Damage if no update was approved!");
		}
	}

	/**
	 * Returns the Players elemental Damage-Scaling for Air-Monsters
	 * 
	 * @return elementalDamage_Air
	 */
	public double getElementalDamage_Air() {
		return this.elementalDamage_Air;
	}

	/**
	 * Returns the Players elemental Damage-Scaling for Water-Monsters
	 * 
	 * @return elementalDamage_Water
	 */
	public double getElementalDamage_Water() {
		return this.elementalDamage_Water;
	}

	/**
	 * Returns the Players elemental Damage-Scaling for Earth-Monsters
	 * 
	 * @return elementalDamage_Earth
	 */
	public double getElementalDamage_Earth() {
		return this.elementalDamage_Earth;
	}

	/**
	 * Returns the Players elemental Damage-Scaling for Fire-Monsters
	 * 
	 * @return elementalDamage_Fire
	 */
	public double getElementalDamage_Fire() {
		return this.elementalDamage_Fire;
	}
}
