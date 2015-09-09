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

public class Spawner extends Button {
	private de.mastermind.thegoog.project.monstergame.monsters.Spawner spawner = null;
	private Button spawnerButton = null;
	// private AppearanceTypes monsterAppearance = null;
	// private Monster identity = this;
	private boolean isSpawner = false;
	private boolean isDead = false;
	private Player p = null;
	private Stage stage = null;
	private StackPane sp = null;
	private String position = null;
	private final Robot robot = com.sun.glass.ui.Application.GetApplication()
			.createRobot();

	public Spawner(
			de.mastermind.thegoog.project.monstergame.monsters.Spawner spawner,
			boolean isSpawner, Player p, Stage stage, StackPane sp,
			String position) {
		this.spawner = spawner;
		// this.monsterAppearance = this.monster.getAppearance();
		this.spawnerButton = generateSpawnerButton();
		this.isSpawner = isSpawner;
		this.p = p;
		this.stage = stage;
		this.sp = sp;
		this.position = position;
		if (!position.equals("spawner")) {
			throw new IllegalArgumentException(
					"Invalid position  for a Spawner/Boss!");
		}
	}

	private Button generateSpawnerButton() {
		Button spawnerB = new Button();
		spawnerB.setId("Game");
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
		spawnerB.setTooltip(t);
		spawnerB.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				spawnerB.getTooltip().show(stage, robot.getMouseX() + 20,
						robot.getMouseY() + 20);
			}
		});
		spawnerB.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				spawnerB.getTooltip().hide();
			}
		});
		spawnerB.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				if (!isDead) {
					/*
					 * Tooltip
					 */
					spawnerB.getTooltip().hide();
					spawnerB.setText("Spawner/Boss\n*Pressed*");

					/*
					 * Apply Damage
					 */
					long dmg = p.getClickDamage_Elemental(spawner
							.getElementType());
					spawner.applyDamage(dmg);

					if (spawner.getLife() == 0) {
						p.addBounty(spawner.getBounty());
						isDead = true;
						spawnerB.setText("");
						spawnerB.setId("dead");
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
				spawnerB.getTooltip().show(stage, robot.getMouseX() + 20,
						robot.getMouseY() + 20);
			}
		});
		spawnerB.setMinSize(200, 270);
		spawnerB.setMaxSize(200, 270);
		return spawnerB;
	}

	private String generateTooltipString() {
		StringBuilder info = new StringBuilder("Boss: "
				+ spawner.isBossMonster());
		info.append("\nSpawner: " + this.isSpawner);
		info.append("\nLife: " + MainWindow.formatBigNumbers(spawner.getLife()));
		info.append(" HP\nDamage: "
				+ MainWindow.formatBigNumbers(spawner.getDamage()));
		info.append(" DMG\nBounty: "
				+ MainWindow.formatBigNumbers(spawner.getBounty()));
		info.append("€\nElement: " + spawner.getElementType());
		return info.toString();
	}

	public void updateMonsterButtonTooltip() {
		if (spawner.getDamage() > 0) {
			spawnerButton.getTooltip().setText(generateTooltipString());
		} else {
			spawnerButton.getTooltip().setText("Dead");
			spawnerButton.setBackground(Background.EMPTY);
			spawnerButton.setStyle("-fx-fill: TRANSPARENT");
		}
	}

	/**
	 * Returns a Button representing a Spawner from the API-Side of the
	 * Application.
	 * 
	 * @return javafx.scene.control.Button for a specified Spawner in a
	 *         specified state
	 */
	public Button getSpawnerButton() {
		return this.spawnerButton;
	}

	/**
	 * Returns the Spawner which the Object uses
	 * 
	 * @return de.mastermind.thegoog.project.monstergame.monsters.spawner
	 */
	public Monsters getSpawner() {
		return this.spawner;
	}
}
