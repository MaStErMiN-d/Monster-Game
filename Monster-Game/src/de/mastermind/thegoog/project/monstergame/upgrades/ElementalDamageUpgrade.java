package de.mastermind.thegoog.project.monstergame.upgrades;

import de.mastermind.thegoog.project.monstergame.item.Items;
import de.mastermind.thegoog.project.monstergame.monsters.Player;
import de.mastermind.thegoog.project.monstergame.utils.Utils;

public class ElementalDamageUpgrade {

	// Price
	private long price_Air = 0;
	private long price_Water = 0;
	private long price_Earth = 0;
	private long price_Fire = 0;

	// Scaling
	private double scale_Air = 1.0;
	private double scale_Water = 1.0;
	private double scale_Earth = 1.0;
	private double scale_Fire = 1.0;

	// Level-Counters
	private long level_Air = 0;
	private long level_Water = 0;
	private long level_Earth = 0;
	private long level_Fire = 0;

	/**
	 * Initializes elemental Damage-Upgrades
	 */
	protected ElementalDamageUpgrade() {
		this.price_Air = 250;
		this.price_Water = 250;
		this.price_Earth = 250;
		this.price_Fire = 250;
	}

	/**
	 * Returns current multiplier for Damage dealt to Air-Monsters
	 * 
	 * @return scale_Air
	 */
	protected double getElementalDamageUpgrade_Air() {
		return this.scale_Air;
	}

	/**
	 * Returns current multiplier for Damage dealt to Water-Monsters
	 * 
	 * @return scale_Water
	 */
	protected double getElementalDamageUpgrade_Water() {
		return this.scale_Water;
	}

	/**
	 * Returns current multiplier for Damage dealt to Earth-Monsters
	 * 
	 * @return scale_Earth
	 */
	protected double getElementalDamageUpgrade_Earth() {
		return this.scale_Earth;
	}

	/**
	 * Returns current multiplier for Damage dealt to Fire-Monsters
	 * 
	 * @return scale_Fire
	 */
	protected double getElementalDamageUpgrade_Fire() {
		return this.scale_Fire;
	}

	/**
	 * Returns current price for elemental Damage-Upgrade for Element Air
	 * 
	 * @return price_Air
	 */
	protected long getElementalDamageUpgradePrice_Air() {
		return this.price_Air;
	}

	/**
	 * Returns current price for elemental Damage-Upgrade for Element Water
	 * 
	 * @return price_Water
	 */
	protected long getElementalDamageUpgradePrice_Water() {
		return this.price_Water;
	}

	/**
	 * Returns current price for elemental Damage-Upgrade for Element Earth
	 * 
	 * @return price_Earth
	 */
	protected long getElementalDamageUpgradePrice_Earth() {
		return this.price_Earth;
	}

	/**
	 * Returns current price for elemental Damage-Upgrade for Element Fire
	 * 
	 * @return price_Fire
	 */
	protected long getElementalDamageUpgradePrice_Fire() {
		return this.price_Fire;
	}

	/**
	 * Purchases the elemental Damage-Upgrade for Air-Monsters
	 */
	protected void purchaseUpgrade_Air(Player player) {
		long playerAccount = player.getMoney();
		long upgradeCosts = this.getElementalDamageUpgradePrice_Air();

		Utils.setAccountUpdated(true);
		player.setAccount(playerAccount - upgradeCosts);

		Utils.setElementalDamageUpdated_Air(true);
		this.scale_Air += 0.2;
		player.setElementalDamage_Air(this.scale_Air);

		this.level_Air++;
		Scaling.updateElementalDamageUpgrade_Air(this);
	}

	/**
	 * Purchases the elemental Damage-Upgrade for Water-Monsters
	 */
	protected void purchaseUpgrade_Water(Player player) {
		long playerAccount = player.getMoney();
		long upgradeCosts = this.getElementalDamageUpgradePrice_Water();

		Utils.setAccountUpdated(true);
		player.setAccount(playerAccount - upgradeCosts);

		Utils.setElementalDamageUpdated_Water(true);
		this.scale_Water += 0.2;
		player.setElementalDamage_Water(this.scale_Water);

		this.level_Water++;
		Scaling.updateElementalDamageUpgrade_Water(this);
	}

	/**
	 * Purchases the elemental Damage-Upgrade for Earth-Monsters
	 */
	protected void purchaseUpgrade_Earth(Player player) {
		long playerAccount = player.getMoney();
		long upgradeCosts = this.getElementalDamageUpgradePrice_Earth();

		Utils.setAccountUpdated(true);
		player.setAccount(playerAccount - upgradeCosts);

		Utils.setElementalDamageUpdated_Earth(true);
		this.scale_Earth += 0.2;
		player.setElementalDamage_Earth(this.scale_Earth);

		this.level_Earth++;
		Scaling.updateElementalDamageUpgrade_Earth(this);
	}

	/**
	 * Purchases the elemental Damage-Upgrade for Fire-Monsters
	 */
	protected void purchaseUpgrade_Fire(Player player) {
		long playerAccount = player.getMoney();
		long upgradeCosts = this.getElementalDamageUpgradePrice_Fire();

		Utils.setAccountUpdated(true);
		player.setAccount(playerAccount - upgradeCosts);

		Utils.setElementalDamageUpdated_Fire(true);
		this.scale_Fire += 0.2;
		player.setElementalDamage_Fire(this.scale_Fire);

		this.level_Fire++;
		Scaling.updateElementalDamageUpgrade_Fire(this);
	}

	/**
	 * Returns the elemental Damage-Upgrades Level for Air
	 * 
	 * @return level_Air
	 */
	protected long getElementalDamageUpgradeLevel_Air() {
		return this.level_Air;
	}

	/**
	 * Returns the elemental Damage-Upgrades Level for Water
	 * 
	 * @return level_Water
	 */
	protected long getElementalDamageUpgradeLevel_Water() {
		return this.level_Water;
	}

	/**
	 * Returns the elemental Damage-Upgrades Level for Earth
	 * 
	 * @return level_Earth
	 */
	protected long getElementalDamageUpgradeLevel_Earth() {
		return this.level_Earth;
	}

	/**
	 * Returns the elemental Damage-Upgrades Level for Fire
	 * 
	 * @return level_Fire
	 */
	protected long getElementalDamageUpgradeLevel_Fire() {
		return this.level_Fire;
	}

	/**
	 * Sets a new Price for the elemental Damage-Upgrade for Air-Monsters
	 * 
	 * @param newPrice
	 */
	protected void updatePrice_Air(long newPrice) {
		this.price_Air = newPrice;
	}

	/**
	 * Sets a new Price for the elemental Damage-Upgrade for Water-Monsters
	 * 
	 * @param newPrice
	 */
	protected void updatePrice_Water(long newPrice) {
		this.price_Water = newPrice;
	}

	/**
	 * Sets a new Price for the elemental Damage-Upgrade for Earth-Monsters
	 * 
	 * @param newPrice
	 */
	protected void updatePrice_Earth(long newPrice) {
		this.price_Earth = newPrice;
	}

	/**
	 * Sets a new Price for the elemental Damage-Upgrade for Fire-Monsters
	 * 
	 * @param newPrice
	 */
	protected void updatePrice_Fire(long newPrice) {
		this.price_Fire = newPrice;
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		ElementalDamageUpgrade edu = (ElementalDamageUpgrade) obj;
		return ((this.level_Air == edu.level_Air)
				&& (this.level_Water == edu.level_Water)
				&& (this.level_Earth == edu.level_Earth)
				&& (this.level_Fire == edu.level_Fire)
				&& (this.price_Air == edu.price_Air)
				&& (this.price_Water == edu.price_Water)
				&& (this.price_Earth == edu.price_Earth)
				&& (this.price_Fire == edu.price_Fire)
				&& (this.scale_Air == edu.scale_Air)
				&& (this.scale_Water == edu.scale_Water)
				&& (this.scale_Earth == edu.scale_Earth) && (this.scale_Fire == edu.scale_Fire));
	}
}
