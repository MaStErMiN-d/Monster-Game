package de.mastermind.thegoog.project.monstergame.gui;

import java.io.File;

import com.sun.glass.ui.Robot;

import de.mastermind.thegoog.project.monstergame.game.MainWindow;
import javafx.event.EventHandler;
import javafx.scene.CacheHint;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ProgressBars extends ProgressBar {

	private static final String css = new File("resources/css/progressBars.css")
			.toURI().toString();
	private static final Robot robot = com.sun.glass.ui.Application
			.GetApplication().createRobot();

	public static ProgressBar generateLifeBar(long currentHealth,
			long maxHealth, Stage stage) {
		if (currentHealth > maxHealth) {
			throw new IllegalArgumentException(
					"Current Health can't be bigger than possible maximum Health!");
		} else {
			double progress = (currentHealth / (maxHealth * 1.0));
			ProgressBar p = new ProgressBar(progress);
			p.setMinSize(140, 20);
			p.getStylesheets().add(css);
			if (progress <= 0.3) {
				p.getStyleClass().add("red-bar");
			} else if (progress <= 0.55) {
				p.getStyleClass().add("orange-bar");
			} else if (progress <= 0.8) {
				p.getStyleClass().add("yellow-bar");
			} else if (progress <= 1.0) {
				p.getStyleClass().add("green-bar");
			}

			p.setTooltip(generateLifeBarTooltip(currentHealth, maxHealth));
			p.setOnMouseEntered(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent me) {
					p.getTooltip().show(stage, robot.getMouseX() + 10,
							robot.getMouseY() + 10);
				}

			});
			p.setOnMouseExited(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					p.getTooltip().hide();
				}

			});
			p.getStyleClass().add("bar-mockup");
			p.setCache(true);
			p.setCacheHint(CacheHint.SPEED);
			return p;
		}
	}

	public static Tooltip generateLifeBarTooltip(long currentHealth,
			long maxHealth) {
		Tooltip t = new Tooltip(MainWindow.formatBigNumbers(currentHealth)
				+ "HP/" + MainWindow.formatBigNumbers(maxHealth) + "HP");
		t.setAutoHide(true);
		return t;
	}
}
