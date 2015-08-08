package de.mastermind.thegoog.project.monstergame.game;

import java.util.LinkedList;
import java.io.*;

import de.mastermind.thegoog.project.monstergame.monsters.*;

public class Loading {

	LinkedList<Monsters> monstersInGame;
	Player player;

	public Loading() {

		load();
	}

	public Player loadPlayer() {
		return player;
	}

	public LinkedList loadMonsters() {
		return monstersInGame;
	}

	public void load() {

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					"Savegame.save"));
			monstersInGame = (LinkedList<Monsters>) ois.readObject();
			player = monstersInGame.removeLast();
			ois.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
