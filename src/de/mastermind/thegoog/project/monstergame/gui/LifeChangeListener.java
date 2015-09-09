package de.mastermind.thegoog.project.monstergame.gui;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import de.mastermind.thegoog.project.monstergame.game.MainWindow;
import de.mastermind.thegoog.project.monstergame.monsters.Player;

public class LifeChangeListener {
	private static Label l = null;
	private static ProgressBar pb = null;

	public static void stateChanged(Player player) {
		if (l != null && pb != null && player != null) {
			l.setText(MainWindow.formatBigNumbers(player.getLife()) + " HP");
			pb.setProgress((player.getLife() * 1.0) / player.getMaxLife());
			pb.getTooltip().setText(
					ProgressBars.generateLifeBarTooltip(player.getLife(),
							player.getMaxLife()).getText());
		}
	}

	public static void armLabel(Label lifeInfo) {
		l = lifeInfo;
	}

	public static void armProgressBar(ProgressBar lifeBar) {
		pb = lifeBar;
	}
}
