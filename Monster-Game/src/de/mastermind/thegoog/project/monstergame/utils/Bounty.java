package de.mastermind.thegoog.project.monstergame.utils;

public class Bounty {

	/**
	 * Calculates Bounty for a certain kind of Enemy
	 * 
	 * @param level
	 * @param isBoss
	 * @param isSpawner
	 * @return bounty
	 * @throws IllegalArgumentException
	 */
	protected static long calcBounty(long level, boolean isBoss, boolean isSpawner)
			throws IllegalArgumentException {
		long bounty = 0;

		level--;

		if (level >= 0 && level <= 20) {
			bounty = 50 + (25 * level);
		} else if (level <= 100) {
			bounty = (36 * level);
		} else if (level <= 1000) {
			bounty = (45 * level) - 550;
		} else if (level <= 5000) {
			bounty = (60 * level) - 11000;
		} else if (level <= 10000) {
			bounty = (165 * level) - 225000;
		} else if (level <= 20000) {
			bounty = (210 * level) - 600000;
		} else if (level <= 100000) {
			bounty = (300 * level) - 2000000;
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

		if (bounty > 0) {
			return bounty;
		} else {
			throw new IllegalArgumentException("Bounty got defined 0 or less!");
		}
	}

}
