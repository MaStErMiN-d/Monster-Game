package de.mastermind.thegoog.project.monstergame.gui;

import java.io.File;

import javafx.application.Platform;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import de.mastermind.thegoog.project.monstergame.game.MainWindow;

public class DamageNumberAnimationService implements Runnable {

	private StackPane sp = null;
	private MouseEvent me = null;
	private long dmg;
	private String position = null;
	private String css = new File("resources/css/DmgNrAnimation.css").toURI()
			.toString();

	public DamageNumberAnimationService(StackPane sp, MouseEvent me, long dmg,
			String position) {
		this.sp = sp;
		this.me = me;
		this.dmg = dmg;
		this.position = position;
	}

	@Override
	public void run() {
		/*
		 * Creation new DamageNumberAnimation
		 */
		DamageNumberAnimation tmp = new DamageNumberAnimation(dmg,
				me.getSceneX() - 351, me.getSceneY() - 291);

		/*
		 * Applying style according to the animations position
		 */
		if (position.equalsIgnoreCase("left")) {
			tmp.setId("dmgNrLeft");
		} else if (position.equalsIgnoreCase("middle")) {
			tmp.setId("dmgNrMiddle");
		} else if (position.equalsIgnoreCase("right")) {
			tmp.setId("dmgNrRight");
		} else if (position.equalsIgnoreCase("spawner")) {
			tmp.setId("dmgNrSpawner");
		}
		tmp.getStylesheets().add(css);

		/*
		 * Adding animation to the Scene and actively dimming its opacity
		 */
		MainWindow.addDamageNumberAnimation(tmp, sp);
		try {
			/*
			 * No loop, because strangely loop lets the Application get quite
			 * laggy
			 */
			Thread.sleep(250);
			dimDamageAnimation(tmp, 1);
			Thread.sleep(250);
			dimDamageAnimation(tmp, 2);
			Thread.sleep(250);
			dimDamageAnimation(tmp, 3);
			Thread.sleep(250);
			dimDamageAnimation(tmp, 4);
			Thread.sleep(250);
			dimDamageAnimation(tmp, 5);
			Thread.sleep(250);
			dimDamageAnimation(tmp, 6);
			Thread.sleep(205);
			// Thread.sleep(1705);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		/*
		 * Animation finished - removing Label from Scene
		 */
		MainWindow.removeDamageAnimationLater(sp, tmp);
	}

	public static void dimDamageAnimation(DamageNumberAnimation dna, int stage) {
		Platform.runLater(() -> {
			switch (stage) {
			case 1:
				dna.setOpacity(0.9);
				break;
			case 2:
				dna.setOpacity(0.8);
				break;
			case 3:
				dna.setOpacity(0.7);
				break;
			case 4:
				dna.setOpacity(0.6);
				break;
			case 5:
				dna.setOpacity(0.5);
				break;
			case 6:
				dna.setOpacity(0.4);
				break;
			default:
				break;
			}
		});
	}
}
