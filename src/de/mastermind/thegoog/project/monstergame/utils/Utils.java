package de.mastermind.thegoog.project.monstergame.utils;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */

public class Utils {

	private static boolean lifeUpdated = false;
	private static boolean monsterlifeUpdated = false;
	private static boolean clickDamageUpdated = false;
	private static boolean passiveDamageUpdated = false;
	private static boolean monsterDamageUpdated = false;
	private static boolean levelUpdated = false;
	private static boolean accountUpdated = false;

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
	public static void setMonsterlifeUpdated(boolean monsterlifeUpdated) {
		Utils.monsterlifeUpdated = monsterlifeUpdated;
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
	public static boolean getMonsterlifeUpdated() {
		return monsterlifeUpdated;
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
	public static long getBounty(boolean isBoss, boolean isSpawner) {
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
}
