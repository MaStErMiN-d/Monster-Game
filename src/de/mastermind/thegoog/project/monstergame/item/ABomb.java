package de.mastermind.thegoog.project.monstergame.item;

import de.mastermind.thegoog.project.monstergame.gui.ABombCountChangeListener;
import de.mastermind.thegoog.project.monstergame.monsters.Player;
import de.mastermind.thegoog.project.monstergame.utils.Utils;

public class ABomb {

	private long price;
	private long count;

	/**
	 * Initializes the Item "Atomic Bomb"
	 */
	protected ABomb() {
		this.price = 500000;
		this.count = 0;
	}

	/**
	 * Purchases the Item "Atomic Bomb" for a specific Player
	 * 
	 * @param player
	 */
	protected void purchase_ABomb(Player player) {
		long money = player.getMoney();
		Utils.setAccountUpdated(true);
		player.setAccount(money - price);
		this.count++;
		ABombCountChangeListener.stateChanged(count, player);
	}

	/**
	 * Uses the Item "Atomic Bomb" for a specific Player
	 * 
	 * @param player
	 */
	protected void use(Player player) {
		this.count--;
		ABombCountChangeListener.stateChanged(count, player);
	}

	/**
	 * Returns the Price for the Item "Atomic Bomb"
	 * 
	 * @return price
	 */
	protected long getPrice() {
		return this.price;
	}

	/**
	 * Returns the Counter for the Item "Atomic Bomb"
	 * 
	 * @return count
	 */
	protected long getCount() {
		return this.count;
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		ABomb abomb = (ABomb) obj;
		return ((abomb.count == this.count) && (abomb.price == this.price));
	}
}
