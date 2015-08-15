package de.mastermind.thegoog.project.monstergame.utils;

import java.awt.event.MouseEvent;

import de.mastermind.thegoog.project.monstergame.monsters.Monsters;

public class GlobalVariableHandler {

	private static boolean leftClickHappend = false;
	private static boolean lifeUpdated = false;
	
	public Monsters getMonsterClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftClickHappend = true;
			int x = e.getX();
			int y = e.getY();
		}
		return null;
	}
	
	public static void setLifeUpdated(boolean updated) {
		lifeUpdated = updated;
	}
	
	public static boolean getLifeUpdated() {
		return lifeUpdated;
	}
	
	public long getBounty (long level, boolean isBoss, boolean isSpawner) throws IllegalArgumentException {
		long bounty = 0;
		
		level--;
		
		if(level <= 20) {
			bounty = 50 + (25*level);
		} else if (level <= 100) {
			bounty = (36*level);
		} else if (level <= 1000) {
			bounty = (45*level) - 550;
		} else if (level <= 5000) {
			bounty = (60*level) - 11000;
		} else if (level <= 10000) {
			bounty = (165*level) - 225000;
		} else if (level <= 20000) {
			bounty = (210*level) - 600000;
		} else if (level <= 100000) {
			bounty = (300*level) - 2000000;
		} else if (level <= 200000) {
			
		} else if (level <= 500000) {
			
		} else if (level <= 1000000) {
			
		} else if (level <= 5000000) {
			
		} else if (level <= 10000000) {
			
		} else if (level <= 100000000) {
			
		} else if (level <= 250000000) {
			
		} else if (level <= 500000000) {
			
		} else if (level <= 800000000) {
			
		} else if (level <= 1000000000) {
			
		}
		
		if(bounty > 0) {
			return bounty;
		} else {
			throw new IllegalArgumentException("Bounty got defined 0 or less!");
		}
	}
	
}
