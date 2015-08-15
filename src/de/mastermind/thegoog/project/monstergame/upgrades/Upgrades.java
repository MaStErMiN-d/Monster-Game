package de.mastermind.thegoog.project.monstergame.upgrades;

import de.mastermind.thegoog.project.monstergame.monsters.Player;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */

public class Upgrades {

	private Player player;
	private ClickDamageUpgrade cdu;
	private LifeUpgrade lu;
	private PassiveDamageUpgrade pdu;

	/**
	 * Initializes Upgrades for a certain Player
	 * 
	 * @param player
	 */
	public Upgrades(Player player) {
		this.player = player;
		this.cdu = new ClickDamageUpgrade();
		this.lu = new LifeUpgrade();
		this.pdu = new PassiveDamageUpgrade();
	}

	/**
	 * Returns true if Life-Upgrade was successfully purchased
	 * 
	 * @return purchased
	 */
	public boolean purchaseLifeUpgrade() {
		if (player.getMoney() < lu.getPrice()) {
			return false;
		} else {
			lu.purchaseUpgrade(player);
			return true;
		}
	}

	/**
	 * Returns true if Click-Damage-Upgrade was successfully purchased
	 * 
	 * @return purchased
	 */
	public boolean purchaseClickDamageUpgrade() {
		if (player.getMoney() < cdu.getPrice()) {
			return false;
		} else {
			cdu.purchaseUpgrade(player);
			return true;
		}
	}

	/**
	 * Returns true if Passive-Damage-Upgrade was successfully purchased
	 * 
	 * @return purchased
	 */
	public boolean purchasePassiveDamageUpgrade() {
		if (player.getMoney() < pdu.getPrice()) {
			return false;
		} else {
			pdu.purchaseUpgrade(player);
			return true;
		}
	}

	/**
	 * Returns Price of the Click-Damage-Upgrade
	 * 
	 * @return clickDamageUpgradePrice
	 */
	public long getClickDamageUpgradePrice() {
		return cdu.getPrice();
	}

	/**
	 * Returns Price of the Life-Upgrade
	 * 
	 * @return lifeUpgradePrice
	 */
	public long getLifeUpgradePrice() {
		return lu.getPrice();
	}

	/**
	 * Returns Price of the Passive-Damage-Upgrade
	 * 
	 * @return passiveDamageUpgrade
	 */
	public long getPassiveDamageUpgradePrice() {
		return pdu.getPrice();
	}
}
