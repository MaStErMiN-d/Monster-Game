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

public class ClickDamageUpgrade {

	private long level = 0;
	private long price = 0;
	private long clickDamageUpgrade = 0;

	/**
	 * Initializes the Click-Damage-Upgrade
	 */
	protected ClickDamageUpgrade() {
		price = 250;
		clickDamageUpgrade = 200;
	}

	/**
	 * Returns Price for the Click-Damage-Upgrade
	 * 
	 * @return price
	 */
	protected long getPrice() {
		return this.price;
	}

	/**
	 * Returns additional click damage from next Upgrade-Level
	 * 
	 * @return passiveDamageUpgrade
	 */
	protected long getClickDamageUpgrade() {
		return this.clickDamageUpgrade;
	}

	/**
	 * Purchases the Click-Damage-Upgrade
	 */
	protected void purchaseUpgrade(Player player) {
		long playerAccount = player.getMoney();
		long upgradeCosts = this.getPrice();

		Utils.setAccountUpdated(true);
		player.setAccount(playerAccount - upgradeCosts);

		Utils.setClickDamageUpdated(true);
		long clickDamage = player.getClickDamage();
		player.setClickDamage(clickDamage + this.clickDamageUpgrade);

		Scaling.updateClickDamageUpgrade(this);
		this.level++;
	}

	/**
	 * Returns current Click-Damage-Upgrades Level
	 * 
	 * @return level
	 */
	protected long getClickDamageUpgradeLevel() {
		return this.level;
	}

	/**
	 * Updates the Click-Damage-Upgrades price
	 */
	protected void updatePrice(long newPrice) {
		this.price = newPrice;
	}

	/**
	 * Updates the Click-Damage-Upgrades value
	 */
	protected void updateClickDamageUpgrade(long newValue) {
		this.clickDamageUpgrade = newValue;
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		ClickDamageUpgrade cdu = (ClickDamageUpgrade) obj;
		return ((this.clickDamageUpgrade == cdu.clickDamageUpgrade)
				&& (this.level == cdu.level) && (this.price == cdu.price));
	}
}
