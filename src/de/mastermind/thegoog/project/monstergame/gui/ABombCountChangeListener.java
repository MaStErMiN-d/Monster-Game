package de.mastermind.thegoog.project.monstergame.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;

import de.mastermind.thegoog.project.monstergame.game.MainWindow;
import de.mastermind.thegoog.project.monstergame.monsters.Player;

public class ABombCountChangeListener {

	private static Button b;
	private static Label l;
	
	public static void stateChanged(long count, Player player) {
		Tooltip t = MainWindow.generateABombTooltip(player);
		b.setTooltip(t);
		l.setText("Count: " + Long.toString(count));
	}
	
	public static void armButton(Button purchaseButton) {
		b = purchaseButton;
	}
	
	public static void armLabel(Label itemCount) {
		l = itemCount;
	}

}
