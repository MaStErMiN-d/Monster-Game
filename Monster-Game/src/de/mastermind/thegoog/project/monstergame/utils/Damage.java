package de.mastermind.thegoog.project.monstergame.utils;

public class Damage {

	/**
	 * Calculates damage of a Monster, a Spawner or a Boss relative to the
	 * Games' level
	 * 
	 * @param level
	 * @param isBoss
	 * @param isSpawner
	 * @return damage
	 */
	protected static long calcDamage(long level, boolean isBoss,
			boolean isSpawner) {
		long damage = 0;

		if (isBoss) {
			damage = calcBossDamage(damage);
		}

		if (isSpawner) {
			damage = calcSpawnerDamage(damage);
		}

		if (damage > 0) {
			return damage;
		} else {
			throw new IllegalArgumentException("Damage got defined 0 or less!");
		}
	}

	/**
	 * Returns damage of a Boss relative to its Monsters' damage
	 * 
	 * @param damage
	 * @return newDamage
	 */
	private static long calcBossDamage(long damage) {
		return 4 * damage;
	}

	/**
	 * Returns damage of a Spawner relative to its Monsters' damage
	 * 
	 * @param damage
	 * @return newDamage
	 */
	private static long calcSpawnerDamage(long damage) {
		return (long) (1.75 * damage);
	}
}
