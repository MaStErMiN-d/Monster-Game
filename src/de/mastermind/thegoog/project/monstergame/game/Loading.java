package de.mastermind.thegoog.project.monstergame.game;

import java.util.LinkedList;
import java.io.*;

import de.mastermind.thegoog.project.monstergame.monsters.*;

public class Loading {

	LinkedList<Monsters> monstersInGame;
	Player player;

	//TODO implement final loading variables
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
			
			ois.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
