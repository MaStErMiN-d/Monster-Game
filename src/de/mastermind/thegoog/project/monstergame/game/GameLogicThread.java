package de.mastermind.thegoog.project.monstergame.game;

import de.mastermind.thegoog.project.monstergame.monsters.Player;

/**
 * @author Michael Zigldrum
 * @author Andreas Knipl
 */
public class GameLogicThread implements Runnable {

	private Player p = null;

	public GameLogicThread(Player p) {
		this.p = p;
	}

	@Override
	public void run() {
		System.out.println("Background started");
		System.out.println("Background ended");
	}
}
