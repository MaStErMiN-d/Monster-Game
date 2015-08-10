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
	
	public static void main(String[] args){
		Game.game();
		StartMenuGUI startMenu = new StartMenuGUI();
		
	}
	
	public static void loadGame(){
		
		Loading loadGame = new Loading();
		Game.player = loadGame.loadPlayer();
		Game.monstersInGame = loadGame.loadMonsters();
		//TODO loading upgrades into object
		upgrades = new Upgrades(Game.player);
		Game.game();
	}
	public static void newGame(){
		
		//TODO Add Init Health etc.
		Game.player = new Player(0, 0, 0);
		Game.upgrades = new Upgrades(Game.player);
		
		//TODO Think of initclickdamage and adjust Spawner Health
		Game.spawnerInGame.add(new Spawner(1, 1, ElementTypes.Air_Type, false, 3, true, 50));
		Game.spawnerInGame.getFirst().spawnMonsters();
		Game.monstersInGame.addAll(Game.spawnerInGame.getFirst().getMonsters());
		Game.game();
	}
	public static void game(){
		TimerTask task = new PassiveTimerTask();
		Timer t = new Timer();
		t.schedule(task, 1500, 1500);
		
		while(true){
			//TODO check if Player is dead
			if(true){
				
			}
			if(ActionVariables.saveGame){
				Saving save = new Saving(monstersInGame, player);
				save.saveGame();
			}
			if(ActionVariables.endGame){
				Saving save = new Saving(monstersInGame, player);
				save.saveGame();
				break;
			}
			
			for(int i = 0; i < monstersInGame.size();i++){
				if(monstersInGame.get(i).getLife() == 0){
					Monsters m = monstersInGame.get(i);
					monstersInGame.remove(i);
					Game.spawnerInGame.getFirst().removeMonsters(m);
				}
			}
			
			Game.spawnerInGame.getFirst().spawnMonsters();
			Game.newMonsters = Game.spawnerInGame.getFirst().getMonsters();
			
			for(int i = 0; i<newMonsters.size();i++){
				if(!monstersInGame.contains(newMonsters.get(i))){
					monstersInGame.add(newMonsters.get(i));
				}
			}
			
			if(ActionVariables.passiveDamage == true){
				for(int i = 0;i < monstersInGame.size();i++){
					monstersInGame.get(i).applyDamage(player.getDamage());
				}
			}
			if(ActionVariables.clickDamage == true){
				//TODO do clickdamage and hitboxes
				
			}
			if(ActionVariables.monsterDamage == true){
				for(int i = 0;i<monstersInGame.size();i++){
					player.applyDamage(monstersInGame.get(i).getDamage());
				}
				
			}
			if(ActionVariables.activeUpgrade == true){
				if(upgrades.purchaseClickDamageUpgrade()){
					
				}else{
					//TODO Return Message that player does not have enough money
				}
			}
			if(ActionVariables.healthUpgrade == true){
				if(upgrades.purchaseLifeUpgrade()){
					
				}else{
					//TODO return message that player does not have enough money
				}
			}
			if(ActionVariables.passiveUpgrade == true){
				if(upgrades.purchasePassiveDamageUpgrade()){
					
				}else{
					//TODO return message that player does not have enough money
				}
			}
			

			
			
			
		}
		
		t.cancel();
		
	}
	

}
