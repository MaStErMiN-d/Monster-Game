package de.mastermind.thegoog.project.monstergame.gui;

import javafx.scene.control.Label;
import de.mastermind.thegoog.project.monstergame.game.MainWindow;
import de.mastermind.thegoog.project.monstergame.monsters.Player;

public class LevelChangeListener {

	private static Label l = null;

	public static void stateChanged(long level, Player player) {
		if (l != null && player != null) {
			if (level < 1000) {
				l.setText(Long.toString(level));
			} else {
				l.setText(MainWindow.formatBigNumbers(level));
			}
		}
	}

	public static void armLabel(Label levelInfo) {
		l = levelInfo;
	}
}
