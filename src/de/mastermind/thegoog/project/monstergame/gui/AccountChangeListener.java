package de.mastermind.thegoog.project.monstergame.gui;

import javafx.scene.control.Label;
import de.mastermind.thegoog.project.monstergame.game.MainWindow;
import de.mastermind.thegoog.project.monstergame.monsters.Player;

public class AccountChangeListener {
	private static Label l;

	public static void stateChanged(long account, Player player) {
		if (l != null) {
			l.setText(MainWindow.formatBigNumbers(account) + " €");
		}
	}

	public static void armLabel(Label account) {
		l = account;
	}
}
