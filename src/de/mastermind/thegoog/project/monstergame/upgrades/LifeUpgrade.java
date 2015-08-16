package de.mastermind.thegoog.project.monstergame.upgrades;

import de.mastermind.thegoog.project.monstergame.item.Items;
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
		price = 250;
		healthUpgrade = 150;
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
		long playerAccount = player.getMoney();
		long upgradeCosts = this.getPrice();

		Utils.setAccountUpdated(true);
		player.setAccount(playerAccount - upgradeCosts);

		Utils.setLifeUpdated(true);
		long life = player.getLife();
		player.setLife(life + this.healthUpgrade);

		Scaling.updateLifeUpgrade(this);
		this.level++;
	}

	/**
	 * Returns current Life-Upgrades Level
	 * 
	 * @return level
	 */
	protected long getLifeUpgradeLevel() {
		return this.level;
	}

	/**
	 * Updates the Life-Upgrades price
	 */
	protected void updatePrice(long newPrice) {
		this.price = newPrice;
	}

	/**
	 * Updates the Life-Upgrades value
	 */
	protected void updateHealthUpgrade(long newValue) {
		this.healthUpgrade = newValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		LifeUpgrade lu = (LifeUpgrade) obj;
		return ((this.healthUpgrade == lu.healthUpgrade)
				&& (this.level == lu.level) && (this.price == lu.price));
	}
}
