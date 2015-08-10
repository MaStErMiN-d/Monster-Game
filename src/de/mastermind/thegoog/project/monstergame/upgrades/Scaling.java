package de.mastermind.thegoog.project.monstergame.upgrades;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */

public class Scaling {

	protected static void updateLifeUpgrade(LifeUpgrade lu) {
		lu.updateHealthUpgrade();
		lu.updatePrice();
	}

	protected static void updateClickDamageUpgrade(ClickDamageUpgrade cdu) {
		cdu.updateClickDamageUpgrade();
		cdu.updatePrice();
	}
	
	protected static void updatePassiveDamageUpgrade(PassiveDamageUpgrade pdu) {
		pdu.updatePassiveDamageUpgrade();
		pdu.updatePrice();
	}
}
