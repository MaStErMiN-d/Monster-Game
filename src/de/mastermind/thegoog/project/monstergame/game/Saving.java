package de.mastermind.thegoog.project.monstergame.game;

import java.util.LinkedList;
import java.io.*;

import de.mastermind.thegoog.project.monstergame.monsters.*;

public class Saving {

	// TODO Implement final saving variables
	LinkedList<Monsters> monstersInGame;

	public Saving(LinkedList<Monsters> monstersInGame, Player player) {
		this.monstersInGame = monstersInGame;
		this.monstersInGame.addLast(player);
	}

	public boolean saveGame() {
		try {

			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("Savegame.save"));
			oos.writeObject(monstersInGame);
			oos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}