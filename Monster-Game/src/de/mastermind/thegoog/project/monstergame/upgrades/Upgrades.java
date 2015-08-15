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
	private ElementalDamageUpgrade edu;

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
		this.edu = new ElementalDamageUpgrade();
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
	 * Returns true if elemental Damage-Upgrade for Air-Monsters was
	 * successfully purchased
	 * 
	 * @return purchased
	 */
	public boolean purchaseElementalDamageUpgrade_Air() {
		if (player.getMoney() < edu.getElementalDamageUpgradePrice_Air()) {
			return false;
		} else {
			edu.purchaseUpgrade_Air(player);
			return true;
		}
	}

	/**
	 * Returns true if elemental Damage-Upgrade for Water-Monsters was
	 * successfully purchased
	 * 
	 * @return purchased
	 */
	public boolean purchaseElementalDamageUpgrade_Water() {
		if (player.getMoney() < edu.getElementalDamageUpgradePrice_Water()) {
			return false;
		} else {
			edu.purchaseUpgrade_Water(player);
			return true;
		}
	}

	/**
	 * Returns true if elemental Damage-Upgrade for Earth-Monsters was
	 * successfully purchased
	 * 
	 * @return purchased
	 */
	public boolean purchaseElementalDamageUpgrade_Earth() {
		if (player.getMoney() < edu.getElementalDamageUpgradePrice_Earth()) {
			return false;
		} else {
			edu.purchaseUpgrade_Earth(player);
			return true;
		}
	}

	/**
	 * Returns true if elemental Damage-Upgrade for Fire-Monsters was
	 * successfully purchased
	 * 
	 * @return purchased
	 */
	public boolean purchaseElementalDamageUpgrade_Fire() {
		if (player.getMoney() < edu.getElementalDamageUpgradePrice_Fire()) {
			return false;
		} else {
			edu.purchaseUpgrade_Fire(player);
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
	 * @return passiveDamageUpgradePrice
	 */
	public long getPassiveDamageUpgradePrice() {
		return pdu.getPrice();
	}

	/**
	 * Returns Value for Click-Damage-Upgrade
	 * 
	 * @return clickDamageUpgrade
	 */
	public long getClickDamageUpgrade() {
		return cdu.getClickDamageUpgrade();
	}

	/**
	 * Returns Value for Life-Upgrade
	 * 
	 * @return lifeUpgrade
	 */
	public long getLifeUpgrade() {
		return lu.getHealthUpgrade();
	}

	/**
	 * Returns Value for Passive-Damage-Upgrade
	 * 
	 * @return passiveDamageUpgrade
	 */
	public long getPassiveDamageUpgrade() {
		return pdu.getPassiveDamageUpgrade();
	}

	/**
	 * Returns current multiplier for Damage dealt to Air-Monsters
	 * 
	 * @return scale_Air
	 */
	public double getElementalDamageUpgrade_Air() {
		return edu.getElementalDamageUpgrade_Air();
	}

	/**
	 * Returns current multiplier for Damage dealt to Water-Monsters
	 * 
	 * @return scale_Water
	 */
	public double getElementalDamageUpgrade_Water() {
		return edu.getElementalDamageUpgrade_Water();
	}

	/**
	 * Returns current multiplier for Damage dealt to Earth-Monsters
	 * 
	 * @return scale_Earth
	 */
	public double getElementalDamageUpgrade_Earth() {
		return edu.getElementalDamageUpgrade_Earth();
	}

	/**
	 * Returns current multiplier for Damage dealt to Fire-Monsters
	 * 
	 * @return scale_Fire
	 */
	public double getElementalDamageUpgrade_Fire() {
		return edu.getElementalDamageUpgrade_Fire();
	}

	/**
	 * Returns current price for elemental Damage-Upgrade for Element Air
	 * 
	 * @return price_Air
	 */
	public long getElementalDamageUpgradePrice_Air() {
		return edu.getElementalDamageUpgradePrice_Air();
	}

	/**
	 * Returns current price for elemental Damage-Upgrade for Element Water
	 * 
	 * @return price_Water
	 */
	public long getElementalDamageUpgradePrice_Water() {
		return edu.getElementalDamageUpgradePrice_Water();
	}

	/**
	 * Returns current price for elemental Damage-Upgrade for Element Earth
	 * 
	 * @return price_Earth
	 */
	public long getElementalDamageUpgradePrice_Earth() {
		return edu.getElementalDamageUpgradePrice_Earth();
	}

	/**
	 * Returns current price for elemental Damage-Upgrade for Element Fire
	 * 
	 * @return price_Fire
	 */
	public long getElementalDamageUpgradePrice_Fire() {
		return edu.getElementalDamageUpgradePrice_Fire();
	}
}
