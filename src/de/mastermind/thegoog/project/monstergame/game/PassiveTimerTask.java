package de.mastermind.thegoog.project.monstergame.game;

import java.util.*;

import de.mastermind.thegoog.project.monstergame.gui.ActionVariables;

public class PassiveTimerTask extends TimerTask{

	@Override
	public void run() {
		ActionVariables.passiveDamage = true;
		ActionVariables.monsterDamage = true;
	}
	

}
