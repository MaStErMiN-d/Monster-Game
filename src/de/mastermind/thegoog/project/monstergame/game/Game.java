package de.mastermind.thegoog.project.monstergame.game;

import de.mastermind.thegoog.project.monstergame.monsters.*;
import de.mastermind.thegoog.project.monstergame.upgrades.Upgrades;

import java.util.*;

import de.mastermind.thegoog.project.monstergame.gui.*;

public class Game {

	private static LinkedList<Monsters> monstersInGame = new LinkedList<Monsters>();
	private static LinkedList<Spawner> spawnerInGame = new LinkedList<Spawner>();
	private static Player player;
	private static LinkedList<Monsters> newMonsters = new LinkedList<Monsters>();
	private static Upgrades upgrades;

	public static void main(String[] args) {
		Game.game();
		StartMenuGUI startMenu = new StartMenuGUI();

	}

	public static void loadGame() {

		Loading loadGame = new Loading();
		Game.player = loadGame.loadPlayer();
		Game.monstersInGame = loadGame.loadMonsters();
		// TODO loading upgrades into object
		upgrades = new Upgrades(Game.player);
		Game.game();
	}

	public static void newGame() {

		// TODO Add Init Health etc.
		Game.player = new Player(0, 0, 0);
		Game.upgrades = new Upgrades(Game.player);

		// TODO Think of initclickdamage and adjust Spawner Health
		Game.spawnerInGame.add(new Spawner(1, 1, ElementTypes.Air_Type, false,
				3, true, 50));
		Game.spawnerInGame.getFirst().spawnMonsters();
		Game.monstersInGame.addAll(Game.spawnerInGame.getFirst().getMonsters());
		Game.game();
	}

	/**
	 * runs the main game logic and functions.
	 * 
	 * Tells the GuiHandler to repaint.
	 */

	public static void game() {
		TimerTask task = new PassiveTimerTask();
		Timer t = new Timer();
		t.schedule(task, 1500, 1500);

		while (true) {
			// TODO check if Player is dead
			if (true) {

			}
			if (ActionVariables.saveGame) {
				Saving save = new Saving(monstersInGame, player);
				save.saveGame();
			}
			if (ActionVariables.endGame) {

				Saving save = new Saving(monstersInGame, player);
				save.saveGame();
				break;
			}

			/**
			 * removes any dead monsters from MonsterList
			 * 
			 */
			for (int i = 0; i < monstersInGame.size(); i++) {
				if (monstersInGame.get(i).getLife() == 0) {

					Monsters m = monstersInGame.get(i);
					monstersInGame.remove(i);
					// Game.spawnerInGame.getFirst().removeMonsters(m);
					// TODO talk with andi about remove monsters method
				}
			}

			for (int i = 0; i < monstersInGame.size(); i++) {
				if (monstersInGame.get(i).getLife() == 0) {

					Monsters m = monstersInGame.get(i);
					monstersInGame.remove(i);
					Game.spawnerInGame.getFirst().removeMonsters(m);
				}
			}

			/**
			 * removes any dead Spawner from Spawner List
			 */
			if (Game.spawnerInGame.getFirst().getLife() == 0) {
				Game.spawnerInGame.removeFirst();
			}

			/**
			 * Increases Level and spawns new Spawner IF No Monsters and no
			 * spawner is alive
			 */
			if (Game.monstersInGame.isEmpty() && Game.spawnerInGame.isEmpty()) {
				Game.player.incLevel();
				// TODO implement Spawner Health scaling
				Game.spawnerInGame.add(new Spawner(0, 0, null, false, 0, false,
						0));
			}

			/**
			 * Tells the Spawner to Spawn new Monsters if a Spawner is alive
			 */
			if (!Game.spawnerInGame.isEmpty()) {

				Game.spawnerInGame.getFirst().spawnMonsters();
				Game.newMonsters = Game.spawnerInGame.getFirst().getMonsters();

			}

			/**
			 * Adds newly spawned Monsters to Ingame Monster List
			 */
			for (int i = 0; i < newMonsters.size(); i++) {
				if (!monstersInGame.contains(newMonsters.get(i))) {
					monstersInGame.add(newMonsters.get(i));
				}
			}

			/**
			 * Checks if various Action Variables are true and executes eventual
			 * orders and methods
			 */

			if (ActionVariables.passiveDamage == true) {
				for (int i = 0; i < monstersInGame.size(); i++) {
					monstersInGame.get(i).applyDamage(player.getDamage());
				}

				ActionVariables.passiveDamage = false;
			}

			if (ActionVariables.clickDamage1 == true) {
				// TODO do clickdamage and hitboxes
				ActionVariables.clickDamage1 = false;
			}

			if (ActionVariables.clickDamage2 == true) {
				// TODO do clickdamage and hitboxes
				ActionVariables.clickDamage2 = false;
			}

			if (ActionVariables.clickDamage3 == true) {
				// TODO do clickdamage and hitboxes
				ActionVariables.clickDamage3 = false;
			}

			if (ActionVariables.clickDamage4 == true) {
				// TODO do clickdamage and hitboxes
				ActionVariables.clickDamage4 = false;
			}

			if (ActionVariables.clickDamage5 == true) {
				// TODO do clickdamage and hitboxes
				ActionVariables.clickDamage5 = false;
			}

			if (ActionVariables.clickDamage == true) {
				// TODO do clickdamage and hitboxes

			}

			if (ActionVariables.monsterDamage == true) {
				for (int i = 0; i < monstersInGame.size(); i++) {
					player.applyDamage(monstersInGame.get(i).getDamage());
				}

				ActionVariables.monsterDamage = false;

			}

			if (ActionVariables.activeUpgrade == true) {
				if (upgrades.purchaseClickDamageUpgrade()) {

				} else {
					// TODO Return Message that player does not have enough
					// money
				}

				ActionVariables.activeUpgrade = false;
			}

			if (ActionVariables.healthUpgrade == true) {
				if (upgrades.purchaseLifeUpgrade()) {

				} else {
					// TODO return message that player does not have enough
					// money
				}

				ActionVariables.healthUpgrade = false;
			}

			if (ActionVariables.passiveUpgrade == true) {
				if (upgrades.purchasePassiveDamageUpgrade()) {

				} else {
					// TODO return message that player does not have enough
					// money
				}

				ActionVariables.passiveUpgrade = false;

			}

		}

		t.cancel();

	}

}
