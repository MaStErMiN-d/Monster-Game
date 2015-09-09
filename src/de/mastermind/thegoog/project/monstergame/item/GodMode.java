package de.mastermind.thegoog.project.monstergame.item;

import de.mastermind.thegoog.project.monstergame.gui.GodModeCountChangeListener;
import de.mastermind.thegoog.project.monstergame.monsters.Player;
import de.mastermind.thegoog.project.monstergame.utils.Utils;

public class GodMode {

	private long price;
	private long count;

	// in milliseconds
	private long duration;

	/**
	 * Initializes the Item "God-Mode"
	 */
	protected GodMode() {
		this.price = 5000;
		this.count = 0;
		this.duration = 3000;
	}

	/**
	 * Purchases the Item "God-Mode" for a specific Player
	 * 
	 * @param player
	 */
	protected void purchase_GodMode(Player player) {
		long money = player.getMoney();
		Utils.setAccountUpdated(true);
		player.setAccount(money - price);
		this.count++;
		GodModeCountChangeListener.stateChanged(count, player);
	}

	/**
	 * Uses the Item "God-Mode" for a specific Player
	 * 
	 * @param player
	 */
	protected void use(Player player) {
		this.count--;
		GodModeCountChangeListener.stateChanged(count, player);
	}

	/**
	 * Returns the Price for the Item "God-Mode"
	 * 
	 * @return price
	 */
	protected long getPrice() {
		return this.price;
	}

	/**
	 * Returns the Counter for the Item "God-Mode"
	 * 
	 * @return count
	 */
	protected long getCount() {
		return this.count;
	}

	/**
	 * Returns duration of the Item "God-Mode" in MilliSeconds
	 * 
	 * @return duration
	 */
	protected long getDuration() {
		return this.duration;
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		GodMode g = (GodMode) obj;
		return ((g.count == this.count) && (g.duration == this.duration) && (g.price == this.price));
	}
}
