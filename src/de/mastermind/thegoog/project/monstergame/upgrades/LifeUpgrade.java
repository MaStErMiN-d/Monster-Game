package de.mastermind.thegoog.project.monstergame.upgrades;

import de.mastermind.thegoog.project.monstergame.monsters.Player;
import de.mastermind.thegoog.project.monstergame.utils.Utils;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */

public class LifeUpgrade {

	private long level = 0;
	private long price = 0;
	private long healthUpgrade = 0;

	/**
	 * Initializes the Life-Upgrade
	 */
	protected LifeUpgrade() {
		price = 0;
		healthUpgrade = 500;
	}

	/**
	 * Returns Price for the Life-Upgrade
	 * 
	 * @return price
	 */
	protected long getPrice() {
		return this.price;
	}

	/**
	 * Returns additional health from next Upgrade-Level
	 * 
	 * @return passiveDamageUpgrade
	 */
	protected long getHealthUpgrade() {
		return this.healthUpgrade;
	}

	/**
	 * Purchases the Life-Upgrade
	 */
	protected void purchaseUpgrade(Player player) {
		level++;
		long playerAccount = player.getMoney();
		long upgradeCosts = this.getPrice();
		Utils.setAccountUpdated(true);
		player.setAccount(playerAccount - upgradeCosts);
		
	}
	
	/**
	 * Updates the Life-Upgrades price
	 */
	protected void updatePrice() {
		
	}
	
	/**
	 * Updates the Life-Upgrades value
	 */
	protected void updateHealthUpgrade() {
		
	}
}
