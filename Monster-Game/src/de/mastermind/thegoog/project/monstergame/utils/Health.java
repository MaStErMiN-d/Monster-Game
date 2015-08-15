package de.mastermind.thegoog.project.monstergame.utils;

public class Health {

	/**
	 * Calculates health of a Monster, a Spawner or a Boss relative to the
	 * Games' level
	 * 
	 * @param level
	 * @param isBoss
	 * @param isSpawner
	 * @return health
	 */
	protected static long calcHealth(long level, boolean isBoss,
			boolean isSpawner) {
		long health = 0;

		level--;

		if (level >= 0 && level <= 20) {
			health = 100 + (30 * level);
		} else if (level <= 100) {
			health = (50 * level) - 250;
		} else if (level <= 1000) {
			health = (150 * level) - 7550;
		} else if (level <= 5000) {
			health = (1500 * level) - 1200000;
		} else if (level <= 10000) {
			health = (90000 * level) - 440000000;
		} else if (level <= 20000) {

		} else if (level <= 100000) {

		} else if (level <= 200000) {

		} else if (level <= 500000) {

		} else if (level <= 1000000) {

		} else if (level <= 5000000) {

		} else if (level <= 10000000) {

		} else if (level <= 100000000) {

		} else if (level <= 250000000) {

		} else if (level <= 500000000) {

		} else if (level <= 800000000) {

		} else if (level <= 1000000000) {

		}

		if (isBoss) {
			health = calcBossHealth(health);
		}

		if (isSpawner) {
			health = calcSpawnerHealth(health);
		}

		if (health > 0) {
			return health;
		} else {
			throw new IllegalArgumentException("Health got defined 0 or less!");
		}
	}

	/**
	 * Returns health of a Boss relative to its Monsters' health
	 * 
	 * @param health
	 * @return newHealth
	 */
	private static long calcBossHealth(long health) {
		return 5 * health;
	}

	/**
	 * Returns health of a Spawner relative to its Monsters' health
	 * 
	 * @param health
	 * @return newHealth
	 */
	private static long calcSpawnerHealth(long health) {
		return (long) (2.5 * health);
	}
}
