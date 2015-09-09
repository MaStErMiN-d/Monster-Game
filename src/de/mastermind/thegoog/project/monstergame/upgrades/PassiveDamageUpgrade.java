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
		price = 400;
		passiveDamageUpgrade = 50;
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
		long playerAccount = player.getMoney();
		long upgradeCosts = this.getPrice();

		Utils.setAccountUpdated(true);
		player.setAccount(playerAccount - upgradeCosts);

		Utils.setPassiveDamageUpdated(true);
		long passiveDamage = player.getDamage();
		player.setDamage(passiveDamage + this.passiveDamageUpgrade);

		Scaling.updatePassiveDamageUpgrade(this);
		this.level++;
	}

	/**
	 * Returns current Passive-Damage-Upgrades Level
	 * 
	 * @return level
	 */
	protected long getPassiveDamageUpgradeLevel() {
		return this.level;
	}

	/**
	 * Updates the Passive-Damage-Upgrades price
	 */
	protected void updatePrice(long newPrice) {
		this.price = newPrice;
	}

	/**
	 * Updates the Passive-Damage-Upgrades value
	 */
	protected void updatePassiveDamageUpgrade(long newValue) {
		this.passiveDamageUpgrade = newValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		PassiveDamageUpgrade pdu = (PassiveDamageUpgrade) obj;
		return ((this.level == pdu.level)
				&& (this.passiveDamageUpgrade == pdu.passiveDamageUpgrade) && (this.price == pdu.price));
	}
}
