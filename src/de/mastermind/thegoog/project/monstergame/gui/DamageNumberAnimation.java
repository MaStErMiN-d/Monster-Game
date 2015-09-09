package de.mastermind.thegoog.project.monstergame.gui;

import java.util.Random;

import de.mastermind.thegoog.project.monstergame.game.MainWindow;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.scene.control.Label;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class DamageNumberAnimation extends Label {

	public DamageNumberAnimation(long dmg, double x, double y) {
		setId("dmgNr");
		setText(MainWindow.formatBigNumbers(dmg));
		setMouseTransparent(true);
		addAnimation(x, y);
	}

	private void addAnimation(double x, double y) {
		/*
		 * Adding random Dispersion for Animation-Height
		 */
		Random ran = new Random();
		double ranNr = Double.parseDouble(Integer.toString(ran.nextInt(120)));// 75)));

		/*
		 * Animation-Line: the way the Label will advance
		 */
		LineTo lineTo = new LineTo();
		lineTo.setX(x);
		lineTo.setY(y - 100 - ranNr);

		/*
		 * Animation-Path: first move Label to a certain position and then send
		 * it on its Animation-Line
		 */
		Path path = new Path();
		path.getElements().add(new MoveTo(x, y));
		path.getElements().add(lineTo);

		/*
		 * Animation-PathTransition: the way the animation should take place,
		 * regulating orientation, cycle-counts, auto-reversing, node, path and
		 * duration(resulting in speed)
		 */
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(1700));
		pathTransition.setNode(this);
		pathTransition.setPath(path);
		pathTransition.setOrientation(OrientationType.NONE);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		pathTransition.play();
	}
}
