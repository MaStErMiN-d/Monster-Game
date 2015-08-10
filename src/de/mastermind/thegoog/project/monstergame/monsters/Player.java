package de.mastermind.thegoog.project.monstergame.monsters;

import de.mastermind.thegoog.project.monstergame.utils.Utils;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */

public class Player extends Monsters {

	long level = 0;
	long money = 0;
	long clickDamage = 0;

	/**
	 * Initializes a Player
	 * 
	 * @param initHealth
	 * @param initDamage
	 * @param initClickDamage
	 */
	public Player(long initHealth, long initPassiveDamage, long initClickDamage) {
		super(initHealth, initPassiveDamage, null, false, AppearanceTypes.Invisible, 0);
		this.clickDamage = initClickDamage;
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
			Utils.setLifeUpdated(false);
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
}
