package de.mastermind.thegoog.project.monstergame.item;

import de.mastermind.thegoog.project.monstergame.monsters.Player;
import de.mastermind.thegoog.project.monstergame.utils.Utils;

public class Items {

	private Player player;
	private ABomb aBomb;
	private GodMode godMode;

	/**
	 * Initializes Items for a Players
	 * 
	 * @param player
	 */
	public Items(Player player) {
		this.player = player;
		this.aBomb = new ABomb();
		this.godMode = new GodMode();
	}

	/**
	 * Returns the Price for the Item "Atomic Bomb"
	 * 
	 * @return price
	 */
	public long getPrice_ABomb() {
		return this.aBomb.getPrice();
	}

	/**
	 * Returns the Price for the Item "God-Mode"
	 * 
	 * @return price
	 */
	public long getPrice_GodMode() {
		return this.godMode.getPrice();
	}

	/**
	 * Returns true if the Item "Atomic Bomb" has been purchased successfully
	 * 
	 * @return purchased
	 */
	public boolean purchase_aBomb() {
		if (player.getMoney() < aBomb.getPrice()) {
			return false;
		} else {
			aBomb.purchase_ABomb(player);
			return true;
		}
	}

	/**
	 * Returns true if the Item "God-Mode" has been purchased succesfully
	 * 
	 * @return purchased
	 */
	public boolean purchase_GodMode() {
		if (player.getMoney() < godMode.getPrice()) {
			return false;
		} else {
			godMode.purchase_GodMode(player);
			return true;
		}
	}

	/**
	 * Returns the Players count for the Item "Atomic Bomb"
	 * 
	 * @return abomb_count
	 */
	public long getABombCount() {
		return aBomb.getCount();
	}

	/**
	 * Returns the Players count for the Item "God-Mode"
	 * 
	 * @return godmode_count
	 */
	public long getGodModeCount() {
		return godMode.getCount();
	}

	/**
	 * Returns true if the Item "Atomic Bomb" has been successfully used
	 * 
	 * @return used
	 */
	public boolean use_ABomb() {
		if (aBomb.getCount() < 1) {
			return false;
		} else {
			aBomb.use(player);
			return true;
		}
	}

	/**
	 * Returns true if the Item "God-Mode" has been successfully used
	 * 
	 * @return used
	 */
	public boolean use_GodMode() {
		if (godMode.getCount() < 1) {
			return false;
		} else {
			godMode.use(player);
			return true;
		}
	}

	// TODO getEffect/getDescription

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Items items = (Items) obj;
		return (this.player.equals(items.player))
				&& (this.aBomb.equals(items.aBomb))
				&& (this.godMode.equals(items.godMode));
	}

	// TODO do we really need an overwritten hashCode()?
	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + player.hashCode();
	// result = prime * result + aBomb.hashCode();
	// result = prime * result + godMode.hashCode();
	// return result;
	// }
}
