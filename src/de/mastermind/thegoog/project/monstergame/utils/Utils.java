package de.mastermind.thegoog.project.monstergame.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */

public class Utils {

	private static boolean lifeUpdated = false;
	private static boolean monsterLifeUpdated = false;
	private static boolean clickDamageUpdated = false;
	private static boolean passiveDamageUpdated = false;
	private static boolean monsterDamageUpdated = false;
	private static boolean levelUpdated = false;
	private static boolean accountUpdated = false;
	private static boolean elementalDamageUpdated_Air = false;
	private static boolean elementalDamageUpdated_Water = false;
	private static boolean elementalDamageUpdated_Earth = false;
	private static boolean elementalDamageUpdated_Fire = false;

	private static boolean setUpgrades = false;
	private static boolean setItems = false;

	private static long level = 0;

	/**
	 * Sets the new Level
	 * 
	 * @param updatedLevel
	 */
	public static void setLevel(long updatedLevel) {
		Utils.level = updatedLevel;
	}

	/**
	 * Sets if Players personal Upgrades have been set
	 * 
	 * @param upgradesSet
	 */
	public static void setUpgrades(boolean upgradesSet) {
		Utils.setUpgrades = upgradesSet;
	}

	/**
	 * Sets if Players personal Items have been set
	 * 
	 * @param itemsSet
	 */
	public static void setItems(boolean itemsSet) {
		Utils.setItems = itemsSet;
	}

	/**
	 * Sets if Players elemental Damage for Air-Monsters has been updated
	 * 
	 * @param elemUpdated
	 */
	public static void setElementalDamageUpdated_Air(boolean elemUpdated) {
		Utils.elementalDamageUpdated_Air = elemUpdated;
	}

	/**
	 * Sets if Players elemental Damage for Water-Monsters has been updated
	 * 
	 * @param elemUpdated
	 */
	public static void setElementalDamageUpdated_Water(boolean elemUpdated) {
		Utils.elementalDamageUpdated_Water = elemUpdated;
	}

	/**
	 * Sets if Players elemental Damage for Earth-Monsters has been updated
	 * 
	 * @param elemUpdated
	 */
	public static void setElementalDamageUpdated_Earth(boolean elemUpdated) {
		Utils.elementalDamageUpdated_Earth = elemUpdated;
	}

	/**
	 * Sets if Players elemental Damage for Fire-Monsters has been updated
	 * 
	 * @param elemUpdated
	 */
	public static void setElementalDamageUpdated_Fire(boolean elemUpdated) {
		Utils.elementalDamageUpdated_Fire = elemUpdated;
	}

	/**
	 * Sets if Players Life has been updated
	 * 
	 * @param updated
	 */
	public static void setLifeUpdated(boolean lifeUpdated) {
		Utils.lifeUpdated = lifeUpdated;
	}

	/**
	 * Sets if Monsters lives have been updated
	 * 
	 * @param monsterlifeUpdated
	 */
	public static void setMonsterLifeUpdated(boolean monsterlifeUpdated) {
		Utils.monsterLifeUpdated = monsterlifeUpdated;
	}

	/**
	 * Sets if Players Click-Damage has been updated
	 * 
	 * @param clickDamageUpdated
	 */
	public static void setClickDamageUpdated(boolean clickDamageUpdated) {
		Utils.clickDamageUpdated = clickDamageUpdated;
	}

	/**
	 * Sets if Players passive Damage has been updated
	 * 
	 * @param passiveDamageUpdated
	 */
	public static void setPassiveDamageUpdated(boolean passiveDamageUpdated) {
		Utils.passiveDamageUpdated = passiveDamageUpdated;
	}

	/**
	 * Sets if Monsters damage has been updated
	 * 
	 * @param monsterDamageUpdated
	 */
	public static void setMonsterDamageUpdated(boolean monsterDamageUpdated) {
		Utils.monsterDamageUpdated = monsterDamageUpdated;
	}

	/**
	 * Sets if Level has been updated
	 * 
	 * @param levelUpdated
	 */
	public static void setLevelUpdated(boolean levelUpdated) {
		Utils.levelUpdated = levelUpdated;
	}

	/**
	 * Sets if Players Account has been updated
	 * 
	 * @param accountUpdated
	 */
	public static void setAccountUpdated(boolean accountUpdated) {
		Utils.accountUpdated = accountUpdated;
	}

	/**
	 * Returns current Level
	 * 
	 * @return level
	 */
	public static long getLevel() {
		return level;
	}

	/**
	 * Returns true if Account has been updated
	 * 
	 * @return accountUpdated
	 */
	public static boolean getAccountUpdated() {
		return accountUpdated;
	}

	/**
	 * Returns true if Monsters lives have been updated
	 * 
	 * @return monsterLifeUpdated
	 */
	public static boolean getMonsterLifeUpdated() {
		return monsterLifeUpdated;
	}

	/**
	 * Returns true if Players Life has been updated
	 * 
	 * @return lifeUpdated
	 */
	public static boolean getLifeUpdated() {
		return lifeUpdated;
	}

	/**
	 * Returns true if Players Click-Damage has been updated
	 * 
	 * @return clickDamageUpdated
	 */
	public static boolean getClickDamageUpdated() {
		return clickDamageUpdated;
	}

	/**
	 * Returns true if Players passive Damage has been updated
	 * 
	 * @return passiveDamageUpdated
	 */
	public static boolean getPassiveDamageUpdated() {
		return passiveDamageUpdated;
	}

	/**
	 * Return true if Monsters damage has been updated
	 * 
	 * @return monsterDamageUpdated
	 */
	public static boolean getMonsterDamageUpdated() {
		return monsterDamageUpdated;
	}

	/**
	 * Return true if Players elemental Damage for Air-Monsters has been updated
	 * 
	 * @return elemUpdated
	 */
	public static boolean getElementalDamageUpdated_Air() {
		return Utils.elementalDamageUpdated_Air;
	}

	/**
	 * Returns true if Players elemental Damage for Water-Monsters has been
	 * updated
	 * 
	 * @return elemUpdated
	 */
	public static boolean getElementalDamageUpdated_Water() {
		return Utils.elementalDamageUpdated_Water;
	}

	/**
	 * Returns true if Players elemental Damage for Earth-Monsters has been
	 * updated
	 * 
	 * @return elemUpdated
	 */
	public static boolean getElementalDamageUpdated_Earth() {
		return Utils.elementalDamageUpdated_Earth;
	}

	/**
	 * Returns true if Players elemental Damage for Fire-Monsters has been
	 * updated
	 * 
	 * @return elemUpdated
	 */
	public static boolean getElementalDamageUpdated_Fire() {
		return Utils.elementalDamageUpdated_Fire;
	}

	/**
	 * Returns true if Players personal Upgrades have been set
	 * 
	 * @param upgradesSet
	 */
	public static boolean getUpgradesSet() {
		return Utils.setUpgrades;
	}

	/**
	 * Returns true if Players personal Items have been set
	 * 
	 * @param itemsSet
	 */
	public static boolean getItemsSet() {
		return Utils.setItems;
	}

	/**
	 * Returns true if Level has been updated
	 * 
	 * @return levelUpdated
	 */
	public static boolean getLevelUpdated() {
		return levelUpdated;
	}

	/**
	 * Returns bounty for a certain kind of Monster
	 * 
	 * @param isBoss
	 * @param isSpawner
	 * @return bounty
	 */
	public static long getMonsterBounty(boolean isBoss, boolean isSpawner) {
		return Bounty.calcBounty(level, isBoss, isSpawner);
	}

	/**
	 * Returns damage for a certain kind of Monster
	 * 
	 * @param isBoss
	 * @param isSpawner
	 * @return
	 */
	public static long getMonsterDamage(boolean isBoss, boolean isSpawner) {
		return Damage.calcDamage(level, isBoss, isSpawner);
	}

	/**
	 * Returns health for a certain kind of Monster
	 * 
	 * @param isBoss
	 * @param isSpawner
	 * @return
	 */
	public static long getMonsterHealth(boolean isBoss, boolean isSpawner) {
		return Health.calcHealth(level, isBoss, isSpawner);
	}

	// TODO Consider quote to
	// http://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
	/**
	 * Rounds a double to a given Number of places behind the comma. E.g.:
	 * round(1.234567, 2) returns 1.23
	 * 
	 * @param value
	 * @param places
	 * @return
	 */
	public static double round(double value, int places) {
		if (places < 0) {
			throw new IllegalArgumentException(
					"Can't round with less than 0 places after the comma!");
		}

		BigDecimal tmp = new BigDecimal(value);
		tmp = tmp.setScale(places, RoundingMode.HALF_UP);
		return tmp.doubleValue();
	}
}
