package de.mastermind.thegoog.project.monstergame.gui;

//import java.io.File;

import com.sun.glass.ui.Robot;

import de.mastermind.thegoog.project.monstergame.game.MainWindow;
import de.mastermind.thegoog.project.monstergame.monsters.Monsters;
import de.mastermind.thegoog.project.monstergame.monsters.Player;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */
public class Monster extends Button {// StackPane {

	private Monsters monster = null;
	private Button monsterButton = null;
	// private AppearanceTypes monsterAppearance = null;
	// private Monster identity = this;
	private boolean isDead = false;
	private Player p = null;
	private Stage stage = null;
	private StackPane sp = null;
	private String position = null;
	private final Robot robot = com.sun.glass.ui.Application.GetApplication()
			.createRobot();

	public Monster(Monsters monster, Player p, Stage stage, StackPane sp,
			String position) {
		this.monster = monster;
		// this.monsterAppearance = this.monster.getAppearance();
		this.monsterButton = generateMonsterButton();
		this.p = p;
		this.stage = stage;
		this.sp = sp;
		this.position = position;
		Thread checkPosition = new Thread(new Runnable() {

			@Override
			public void run() {
				if (position != null) {
					if (!position.equals("left") && !position.equals("middle")
							&& !position.equals("right")) {
						throw new IllegalArgumentException(
								"Monster-Position not specified right!");
					}
				}
			}
		});
		checkPosition.start();
	}

	private Button generateMonsterButton() {
		Button monsterB = new Button();
		monsterB.setId("Game");
		// File f = new File("resources/images/icon.png");
		// Image img = new Image(f.toURI().toString());//
		// ImageTypes.getImageFromAppearance(this.monsterAppearance);
		// if(img.equals(null)) {
		// System.out.println("a");
		// }

		// Background background = new Background(new BackgroundImage(img,
		// BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
		// BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
		// monsterB.setBackground(background);
		Tooltip t = new Tooltip(generateTooltipString());
		t.setAutoHide(true);
		monsterB.setTooltip(t);
		monsterB.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				monsterB.getTooltip().show(stage, robot.getMouseX() + 20,
						robot.getMouseY() + 20);
			}
		});
		monsterB.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				monsterB.getTooltip().hide();
			}
		});
		monsterB.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				if (!isDead) {
					/*
					 * Tooltip
					 */
					monsterB.getTooltip().hide();
					if (!isDead) {
						monsterB.setText("Monster1\n*Pressed*");
					}

					/*
					 * Apply Damage
					 */
					long dmg = p.getClickDamage_Elemental(monster
							.getElementType());
					monster.applyDamage(dmg);

					if (monster.getLife() == 0) {
						p.addBounty(monster.getBounty());
						isDead = true;
						monsterB.setText("");
						monsterB.setId("dead");
					}
					Thread damageNumberAnimation = new Thread(
							new DamageNumberAnimationService(sp, me, dmg,
									position));
					damageNumberAnimation.start();

					/*
					 * Update and show Tooltip
					 */
					updateMonsterButtonTooltip();
				}
				monsterB.getTooltip().show(stage, robot.getMouseX() + 20,
						robot.getMouseY() + 20);
			}
		});
		monsterB.setMinSize(200, 220);
		monsterB.setMaxSize(200, 220);
		return monsterB;
	}

	private String generateTooltipString() {
		StringBuilder info = new StringBuilder("Boss: "
				+ monster.isBossMonster());
		info.append("\nSpawner: false");// + this.isSpawner);
		info.append("\nLife: " + MainWindow.formatBigNumbers(monster.getLife()));
		info.append(" HP\nDamage: "
				+ MainWindow.formatBigNumbers(monster.getDamage()));
		info.append(" DMG\nBounty:\t"
				+ MainWindow.formatBigNumbers(monster.getBounty()));
		info.append("€\nElement:\t" + monster.getElementType());
		return info.toString();
	}

	public void updateMonsterButtonTooltip() {
		if (monster.getDamage() > 0) {
			monsterButton.getTooltip().setText(generateTooltipString());
		} else {
			monsterButton.getTooltip().setText("Dead");
			monsterButton.setBackground(Background.EMPTY);
			monsterButton.setStyle("-fx-fill: TRANSPARENT");
		}
	}

	/**
	 * Returns a Button representing a Monster from the API-Side of the
	 * Application.
	 * 
	 * @return javafx.scene.control.Button for a specified Monster in a
	 *         specified state
	 */
	public Button getMonsterButton() {
		return this.monsterButton;
	}

	/**
	 * Returns the Monster which the Object uses
	 * 
	 * @return de.mastermind.thegoog.project.monstergame.monsters.monsters
	 */
	public Monsters getMonster() {
		return this.monster;
	}
}
