package de.mastermind.thegoog.project.monstergame.upgrades;

import de.mastermind.thegoog.project.monstergame.monsters.Player;
import de.mastermind.thegoog.project.monstergame.utils.Utils;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */

public class PassiveDamageUpgrade {

	private long level = 0;
	private long price = 0;
	private long passiveDamageUpgrade = 0;

	/**
	 * Initializes the Passive-Damage-Upgrade
	 */
	protected PassiveDamageUpgrade() {
		price = 0;
		passiveDamageUpgrade = 500;
	}

	/**
	 * Returns Price for the Passive-Damage-Upgrade
	 * 
	 * @return price
	 */
	protected long getPrice() {
		return this.price;
	}

	/**
	 * Returns additional passive damage from next Upgrade-Level
	 * 
	 * @return passiveDamageUpgrade
	 */
	protected long getPassiveDamageUpgrade() {
		return this.passiveDamageUpgrade;
	}

	/**
	 * Purchases the Passive-Damage-Upgrade
	 */
	protected void purchaseUpgrade(Player player) {
		level++;
		long playerAccount = player.getMoney();
		long upgradeCosts = this.getPrice();
		Utils.setAccountUpdated(true);
		player.setAccount(playerAccount - upgradeCosts);
	}
	
	/**
	 * Updates the Passive-Damage-Upgrades price
	 */
	protected void updatePrice() {
		
	}
	
	/**
	 * Updates the Passive-Damage-Upgrades value
	 */
	protected void updatePassiveDamageUpgrade() {
		
	}
}
