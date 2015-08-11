package de.mastermind.thegoog.project.monstergame.upgrades;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */

public class Scaling {

	/**
	 * Scales the given Value of an Upgrade to the next Level
	 * 
	 * @param value
	 * @param upgradeLevel
	 * @return value * scale
	 */
	private static long scale(long value, long upgradeLevel) {
		upgradeLevel = upgradeLevel % 9;

		if (upgradeLevel == 0) {
			value *= 2.5;
		} else if (upgradeLevel == 1) {
			value *= 2;
		} else if (upgradeLevel == 2) {
			value *= 3;
		} else if (upgradeLevel == 3) {
			value *= 3.5;
		} else if (upgradeLevel == 4) {
			value *= 2;
		} else if (upgradeLevel == 5) {
			value *= 5;
		} else if (upgradeLevel == 6) {
			value *= 4;
		} else if (upgradeLevel == 7) {
			value *= 2.5;
		} else if (upgradeLevel == 8) {
			value *= 2.4;
		}

		return value;
	}

	/**
	 * Updates elemental Damage-Upgrades Price for Air-Monsters
	 * 
	 * @param edu
	 */
	protected static void updateElementalDamageUpgrade_Air(
			ElementalDamageUpgrade edu) {
		edu.updatePrice_Air(scale(edu.getElementalDamageUpgradePrice_Air(),
				edu.getElementalDamageUpgradeLevel_Air()));
	}

	/**
	 * Updates elemental Damage-Upgrades Price for Water-Monsters
	 * 
	 * @param edu
	 */
	protected static void updateElementalDamageUpgrade_Water(
			ElementalDamageUpgrade edu) {
		edu.updatePrice_Water(scale(edu.getElementalDamageUpgradePrice_Water(),
				edu.getElementalDamageUpgradeLevel_Water()));
	}

	/**
	 * Updates elemental Damage-Upgrades Price for Earth-Monsters
	 * 
	 * @param edu
	 */
	protected static void updateElementalDamageUpgrade_Earth(
			ElementalDamageUpgrade edu) {
		edu.updatePrice_Earth(scale(edu.getElementalDamageUpgradePrice_Earth(),
				edu.getElementalDamageUpgradeLevel_Earth()));
	}

	/**
	 * Updates elemental Damage-Upgrades Price for Fire-Monsters
	 * 
	 * @param edu
	 */
	protected static void updateElementalDamageUpgrade_Fire(
			ElementalDamageUpgrade edu) {
		edu.updatePrice_Fire(scale(edu.getElementalDamageUpgradePrice_Fire(),
				edu.getElementalDamageUpgradeLevel_Fire()));
	}

	/**
	 * Updates Life-Upgrades Price and Value
	 * 
	 * @param lu
	 */
	protected static void updateLifeUpgrade(LifeUpgrade lu) {
		lu.updateHealthUpgrade(scale(lu.getHealthUpgrade(),
				lu.getLifeUpgradeLevel()));
		lu.updatePrice(scale(lu.getPrice(), lu.getLifeUpgradeLevel()));
	}

	/**
	 * Updates Click-Damage-Upgrades Price and Value
	 * 
	 * @param cdu
	 */
	protected static void updateClickDamageUpgrade(ClickDamageUpgrade cdu) {
		cdu.updateClickDamageUpgrade(scale(cdu.getClickDamageUpgrade(),
				cdu.getClickDamageUpgradeLevel()));
		cdu.updatePrice(scale(cdu.getPrice(), cdu.getClickDamageUpgradeLevel()));
	}

	/**
	 * Updates Passive-Damage-Upgrades Price and Value
	 * 
	 * @param pdu
	 */
	protected static void updatePassiveDamageUpgrade(PassiveDamageUpgrade pdu) {
		pdu.updatePassiveDamageUpgrade(scale(pdu.getPassiveDamageUpgrade(),
				pdu.getPassiveDamageUpgradeLevel()));
		pdu.updatePrice(scale(pdu.getPrice(),
				pdu.getPassiveDamageUpgradeLevel()));
	}
}
