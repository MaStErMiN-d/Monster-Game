package de.mastermind.thegoog.project.monstergame.monsters;

import de.mastermind.thegoog.project.monstergame.gui.AccountChangeListener;
import de.mastermind.thegoog.project.monstergame.gui.LevelChangeListener;
import de.mastermind.thegoog.project.monstergame.gui.LifeChangeListener;
import de.mastermind.thegoog.project.monstergame.item.Items;
import de.mastermind.thegoog.project.monstergame.upgrades.Upgrades;
import de.mastermind.thegoog.project.monstergame.utils.Utils;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */

public class Player extends Monsters {

	private long level = 1;
	private long money = 0;
	private long clickDamage = 0;
	private long maxLife = 0;

	// damage-Scaling for elementals
	private double elementalDamage_Air = 1.0;
	private double elementalDamage_Water = 1.0;
	private double elementalDamage_Earth = 1.0;
	private double elementalDamage_Fire = 1.0;

	private Upgrades upgrades;
	private Items items;

	// TODO maxLife + lifeUpgrade sets life to the same percentage as before

	/**
	 * Initializes a Player
	 * 
	 * @param initHealth
	 * @param initDamage
	 * @param initClickDamage
	 */
	public Player(long initHealth, long initPassiveDamage, long initClickDamage) {
		super(initHealth, initPassiveDamage, null, false,
				AppearanceTypes.Invisible, 0);
		if (initClickDamage > 0) {
			this.clickDamage = initClickDamage;
		} else {
			throw new IllegalArgumentException(
					"Player can't have 0 or less Click-Damage!");
		}
		Utils.setLevel(level);

		upgrades = new Upgrades(this);
		items = new Items(this);
		maxLife = initHealth;
	}

	/**
	 * Returns Players maximum current Life
	 */
	public long getMaxLife() {
		return this.maxLife;
	}

	/**
	 * Sets the Players personal Upgrade-Tree
	 * 
	 * @param upgrades
	 */
	public void setUpgrades(Upgrades upgrades) {
		if (upgrades != null) {
			if (Utils.getUpgradesSet()) {
				this.upgrades = upgrades;
				Utils.setUpgrades(false);
			} else {
				Utils.setUpgrades(false);
				throw new IllegalArgumentException(
						"Can't set Upgrades if setting wasn't approved!");
			}
		} else {
			Utils.setUpgrades(false);
			throw new IllegalArgumentException("Upgrades can't be Null!");
		}
	}

	/**
	 * Sets the Players personal Items
	 * 
	 * @param items
	 */
	public void setItems(Items items) {
		if (items != null) {
			if (Utils.getItemsSet()) {
				this.items = items;
				Utils.setItems(false);
			} else {
				Utils.setItems(false);
				throw new IllegalArgumentException(
						"Can't set Items if setting wasn't approved!");
			}
		} else {
			Utils.setItems(false);
			throw new IllegalArgumentException("Items can't be Null!");
		}
	}

	/**
	 * Returns Players personal Upgrades
	 * 
	 * @return upgrades
	 */
	public Upgrades getUpgrades() {
		return this.upgrades;
	}

	/**
	 * Returns Players personal Items
	 * 
	 * @return items
	 */
	public Items getItems() {
		return this.items;
	}

	/**
	 * Adds bounty to current Account
	 * 
	 * @param bounty
	 */
	public void addBounty(long bounty) {
		this.money += bounty;
		AccountChangeListener.stateChanged(money, this);
	}

	/**
	 * Sets the Players Account to new value
	 * 
	 * @param balance
	 */
	public void setAccount(long balance) {
		if (balance >= 0) {
			if (Utils.getAccountUpdated()) {
				this.money = balance;
				AccountChangeListener.stateChanged(money, this);
				Utils.setAccountUpdated(false);
			} else {
				Utils.setAccountUpdated(false);
				throw new IllegalArgumentException(
						"Can't set Account if setting wasn't approved!");
			}
		} else {
			throw new IllegalArgumentException("Account can't be negativ!");
		}
	}

	/**
	 * Player takes damage
	 * 
	 * @param dmg
	 */
	public void applyDamage(long dmg) {
		super.applyDamage(dmg);
		LifeChangeListener.stateChanged(this);
	}

	/**
	 * Increments the Level-Counter
	 */
	public void incLevel() {
		this.level++;
		Utils.setLevel(this.level);
		LevelChangeListener.stateChanged(level, this);
	}

	/**
	 * Sets the Damage dealt by clicking
	 * 
	 * @param dmg
	 */
	public void setClickDamage(long dmg) {
		if (dmg > 0) {
			if (Utils.getClickDamageUpdated()) {
				this.clickDamage = dmg;
				Utils.setClickDamageUpdated(false);
			} else {
				Utils.setClickDamageUpdated(false);
				throw new IllegalArgumentException(
						"Can't update Players Click-Damage if no update was approved!");
			}
		} else {
			throw new IllegalArgumentException(
					"Click-Damage can't be 0 or less!");
		}
	}

	/**
	 * Sets the Level
	 * 
	 * @param level
	 */
	public void setLevel(long level) {
		if (level > 0) {
			if (Utils.getLevelUpdated()) {
				this.level = level;
				Utils.setLevel(this.level);
				Utils.setLevelUpdated(false);
				LevelChangeListener.stateChanged(level, this);
				;
			} else {
				Utils.setLevelUpdated(false);
				throw new IllegalArgumentException(
						"Can't update Level if no update was approved!");
			}
		} else {
			Utils.setLevelUpdated(false);
			throw new IllegalArgumentException("Level can't be 0 or less!");
		}
	}

	/**
	 * Sets Damage dealt passively
	 * 
	 * @param dmg
	 */
	public void setDamage(long dmg) {
		if (dmg > 0) {
			if (Utils.getPassiveDamageUpdated()) {
				super.setDamage(dmg);
				Utils.setPassiveDamageUpdated(false);
			} else {
				Utils.setPassiveDamageUpdated(false);
				throw new IllegalArgumentException(
						"Can't update Players passive Damage if no update was approved!");
			}
		} else {
			Utils.setPassiveDamageUpdated(false);
			throw new IllegalArgumentException(
					"Passive Damage can't be 0 or less!");
		}
	}
	
	public void setMaxLife(long life) {
		if (Utils.getLifeUpdated()) {
			this.maxLife = life;
			Utils.setLifeUpdated(false);
			LifeChangeListener.stateChanged(this);
		} else {
			Utils.setLifeUpdated(false);
			throw new IllegalArgumentException(
					"Can't update MaxLife if no update was approved!");
		}
	}

	/**
	 * Sets the Life of the Player
	 * 
	 * @param life
	 */
	public void setLife(long life) {
		if (Utils.getLifeUpdated()) {
			super.setLife(life);
			Utils.setLifeUpdated(false);
			LifeChangeListener.stateChanged(this);
		} else {
			Utils.setLifeUpdated(false);
			throw new IllegalArgumentException(
					"Can't update Life if no update was approved!");
		}
	}

	/**
	 * Returns the current Level
	 * 
	 * @return level
	 */
	public long getLevel() {
		return this.level;
	}

	/**
	 * Returns current click-Damage
	 * 
	 * @return clickDamage
	 */
	public long getClickDamage() {
		return this.clickDamage;
	}

	/**
	 * Returns current passive Damage
	 * 
	 * @return damage
	 */
	public long getDamage() {
		return super.getDamage();
	}

	/**
	 * Returns current life
	 * 
	 * @return life
	 */
	public long getLife() {
		return super.getLife();
	}

	/**
	 * Returns the current Money of the Player
	 * 
	 * @return money
	 */
	public long getMoney() {
		return this.money;
	}

	/**
	 * Returns the Click-Damage scaled by an Element
	 * 
	 * @param et
	 * @return
	 */
	public long getClickDamage_Elemental(ElementTypes et) {
		long eClickDamage = 0;

		if (et != null) {
			switch (et) {
			case Air_Type:
				eClickDamage = (long) (this.getClickDamage() * this.elementalDamage_Air);
				break;
			case Water_Type:
				eClickDamage = (long) (this.getClickDamage() * this.elementalDamage_Water);
				break;
			case Earth_Type:
				eClickDamage = (long) (this.getClickDamage() * this.elementalDamage_Earth);
				break;
			case Fire_Type:
				eClickDamage = (long) (this.getClickDamage() * this.elementalDamage_Fire);
				break;
			default:
				eClickDamage = 0;
				break;
			}

			if (eClickDamage > 0) {
				return eClickDamage;
			} else {
				throw new IllegalArgumentException(
						"Elemental Damage can't be 0 or less!");
			}
		} else {
			throw new IllegalArgumentException(
					"Null is no valid elemental Type!");
		}
	}

	/**
	 * Returns the passive Damage scaled by an Element
	 * 
	 * @param et
	 * @return eDamage
	 */
	public long getDamage_Elemental(ElementTypes et) {
		long eDamage = 0;

		if (et != null) {
			switch (et) {
			case Air_Type:
				eDamage = (long) (this.getDamage() * this.elementalDamage_Air);
				break;
			case Water_Type:
				eDamage = (long) (this.getDamage() * this.elementalDamage_Water);
				break;
			case Earth_Type:
				eDamage = (long) (this.getDamage() * this.elementalDamage_Earth);
				break;
			case Fire_Type:
				eDamage = (long) (this.getDamage() * this.elementalDamage_Fire);
				break;
			}

			if (eDamage > 0) {
				return eDamage;
			} else {
				throw new IllegalArgumentException(
						"Elemental Damage can't be 0 or less!");
			}
		} else {
			throw new IllegalArgumentException(
					"Null is no valid elemental Type!");
		}
	}

	/**
	 * Sets the Players elemental Damage-Scale for Air
	 * 
	 * @param newScale
	 */
	public void setElementalDamage_Air(double newScale) {
		if (newScale >= 1) {
			if (Utils.getElementalDamageUpdated_Air()) {
				this.elementalDamage_Air = Utils.round(newScale, 2);
				Utils.setElementalDamageUpdated_Air(false);
			} else {
				Utils.setElementalDamageUpdated_Air(false);
				throw new IllegalArgumentException(
						"Can't update elemental Damage if no update was approved!");
			}
		} else {
			throw new IllegalArgumentException(
					"Elemental Damage-Scale can't be less than 1.0!");
		}
	}

	/**
	 * Sets the Players elemental Damage-Scale for Water
	 * 
	 * @param newScale
	 */
	public void setElementalDamage_Water(double newScale) {
		if (newScale >= 1) {
			if (Utils.getElementalDamageUpdated_Water()) {
				this.elementalDamage_Water = Utils.round(newScale, 2);
				Utils.setElementalDamageUpdated_Water(false);
			} else {
				Utils.setElementalDamageUpdated_Water(false);
				throw new IllegalArgumentException(
						"Can't update elemental Damage if no update was approved!");
			}
		} else {
			throw new IllegalArgumentException(
					"Elemental Damage-Scale can't be less than 1.0!");
		}
	}

	/**
	 * Sets the Players elemental Damage-Scale for Earth
	 * 
	 * @param newScale
	 */
	public void setElementalDamage_Earth(double newScale) {
		if (newScale >= 1) {
			if (Utils.getElementalDamageUpdated_Earth()) {
				this.elementalDamage_Earth = Utils.round(newScale, 2);
				Utils.setElementalDamageUpdated_Earth(false);
			} else {
				Utils.setElementalDamageUpdated_Earth(false);
				throw new IllegalArgumentException(
						"Can't update elemental Damage if no update was approved!");
			}
		} else {
			throw new IllegalArgumentException(
					"Elemental Damage-Scale can't be less than 1.0!");
		}
	}

	/**
	 * Sets the Players elemental Damage-Scale for Fire
	 * 
	 * @param newScale
	 */
	public void setElementalDamage_Fire(double newScale) {
		if (newScale >= 1) {
			if (Utils.getElementalDamageUpdated_Fire()) {
				this.elementalDamage_Fire = Utils.round(newScale, 2);
				Utils.setElementalDamageUpdated_Fire(false);
			} else {
				Utils.setElementalDamageUpdated_Fire(false);
				throw new IllegalArgumentException(
						"Can't update elemental Damage if no update was approved!");
			}
		} else {
			throw new IllegalArgumentException(
					"Elemental Damage-Scale can't be less than 1.0!");
		}
	}

	/**
	 * Returns the Players elemental Damage-Scaling for Air-Monsters
	 * 
	 * @return elementalDamage_Air
	 */
	public double getElementalDamage_Air() {
		return this.elementalDamage_Air;
	}

	/**
	 * Returns the Players elemental Damage-Scaling for Water-Monsters
	 * 
	 * @return elementalDamage_Water
	 */
	public double getElementalDamage_Water() {
		return this.elementalDamage_Water;
	}

	/**
	 * Returns the Players elemental Damage-Scaling for Earth-Monsters
	 * 
	 * @return elementalDamage_Earth
	 */
	public double getElementalDamage_Earth() {
		return this.elementalDamage_Earth;
	}

	/**
	 * Returns the Players elemental Damage-Scaling for Fire-Monsters
	 * 
	 * @return elementalDamage_Fire
	 */
	public double getElementalDamage_Fire() {
		return this.elementalDamage_Fire;
	}

	/**
	 * Returns the Players elemental Damage-Scaling for a certain elemental
	 * Monster
	 * 
	 * @param et
	 * @return elementalDamage
	 */
	public double getElementalDamageByType(ElementTypes et) {
		double dmg = 0;

		if (et != null) {
			switch (et) {
			case Air_Type:
				dmg = this.elementalDamage_Air;
				break;
			case Water_Type:
				dmg = this.elementalDamage_Water;
				break;
			case Earth_Type:
				dmg = this.elementalDamage_Earth;
				break;
			case Fire_Type:
				dmg = this.elementalDamage_Fire;
				break;
			}

			if (dmg > 0) {
				return dmg;
			} else {
				throw new IllegalArgumentException(
						"Elemental damage-Scaling can't be 0 or less!");
			}
		} else {
			throw new IllegalArgumentException(
					"Null is no valid elemental Type!");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Player player = (Player) obj;
		return ((this.clickDamage == player.clickDamage)
				&& (this.elementalDamage_Air == player.elementalDamage_Air)
				&& (this.elementalDamage_Water == player.elementalDamage_Water)
				&& (this.elementalDamage_Earth == player.elementalDamage_Earth)
				&& (this.elementalDamage_Fire == player.elementalDamage_Fire)
				&& (this.level == player.level)
				&& (this.money == player.money)
				&& (this.items.getABombCount() == player.items.getABombCount())
				&& (this.items.getGodModeCount() == player.items
						.getGodModeCount())
				&& (this.upgrades.getClickDamageUpgrade() == player.upgrades
						.getClickDamageUpgrade())
				&& (this.upgrades.getClickDamageUpgradePrice() == player.upgrades
						.getClickDamageUpgradePrice())
				&& (this.upgrades.getElementalDamageUpgrade_Air() == player.upgrades
						.getElementalDamageUpgrade_Air())
				&& (this.upgrades.getElementalDamageUpgrade_Water() == player.upgrades
						.getElementalDamageUpgrade_Water())
				&& (this.upgrades.getElementalDamageUpgrade_Earth() == player.upgrades
						.getElementalDamageUpgrade_Earth())
				&& (this.upgrades.getElementalDamageUpgrade_Fire() == player.upgrades
						.getElementalDamageUpgrade_Fire())
				&& (this.upgrades.getElementalDamageUpgradePrice_Air() == player.upgrades
						.getElementalDamageUpgradePrice_Air())
				&& (this.upgrades.getElementalDamageUpgradePrice_Water() == player.upgrades
						.getElementalDamageUpgradePrice_Water())
				&& (this.upgrades.getElementalDamageUpgradePrice_Earth() == player.upgrades
						.getElementalDamageUpgradePrice_Earth())
				&& (this.upgrades.getElementalDamageUpgradePrice_Fire() == player.upgrades
						.getElementalDamageUpgradePrice_Fire())
				&& (this.upgrades.getLifeUpgrade() == player.upgrades
						.getLifeUpgrade())
				&& (this.upgrades.getLifeUpgradePrice() == player.upgrades
						.getLifeUpgradePrice())
				&& (this.upgrades.getPassiveDamageUpgrade() == player.upgrades
						.getPassiveDamageUpgrade())
				&& (this.upgrades.getPassiveDamageUpgradePrice() == player.upgrades
						.getPassiveDamageUpgradePrice()) && (super
					.equals(player)));

	}
}
