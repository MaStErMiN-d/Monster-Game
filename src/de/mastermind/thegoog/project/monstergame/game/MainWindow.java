package de.mastermind.thegoog.project.monstergame.game;

import java.io.File;

import de.mastermind.thegoog.project.monstergame.gui.*;
import de.mastermind.thegoog.project.monstergame.monsters.AppearanceTypes;
import de.mastermind.thegoog.project.monstergame.monsters.ElementTypes;
import de.mastermind.thegoog.project.monstergame.monsters.Monsters;
import de.mastermind.thegoog.project.monstergame.monsters.Player;
import de.mastermind.thegoog.project.monstergame.utils.Utils;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// TODO dialog, maybe: http://stackoverflow.com/questions/25534204/how-do-i-create-a-javafx-transparent-stage-with-shadows-on-only-the-border
public class MainWindow extends Application {
	private static GameLogicThread gameLogic = null;
	private final static String iconPath = new File("resources/images/icon.png")
			.toURI().toString();
	private final static String buttonsCSS = new File(
			"resources/css/buttons.css").toURI().toString();

	// private static StackPane background = new StackPane();

	// private final static RemoveDamageAnimationService dmgRem = new
	// RemoveDamageAnimationService();
	// JavaFX application still use the main method.
	// It should only ever contain the call to the launch method
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.gc();

		/*
		 * Stage-Initialization
		 */
		primaryStage.setTitle("Monster-Game");
		primaryStage.setResizable(false);

		/*
		 * Icon
		 */
		Image icon = new Image(iconPath);
		primaryStage.getIcons().add(icon);

		/*
		 * Layout
		 */
		BorderPane componentLayout = new BorderPane();
		componentLayout.setPadding(new Insets(100));
		componentLayout.setStyle("-fx-background-color: TOMATO");
		BorderPane totalLayout = new BorderPane();
		totalLayout.setPadding(new Insets(0));
		totalLayout.setStyle("-fx-background-color: TOMATO");

		/*
		 * Digital-Clock in the Top-Left-Corner
		 */
		final VBox digitalClock = new VBox(1);
		DigitalClock clock = new DigitalClock();
		digitalClock.getChildren().add(clock);// new DigitalClock());
		digitalClock.setAlignment(Pos.TOP_LEFT);

		/*
		 * Buttons
		 */
		Button newGame = new Button("New Game");
		newGame.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				// TODO newGame
				newGame(primaryStage);
			}
		});
		newGame.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					// TODO newGame
					newGame(primaryStage);
				}
			}

		});

		Button loadGame = new Button("Load Game");
		loadGame.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				// TODO loadGame
			}
		});
		loadGame.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					// TODO loadGame
				}
			}

		});

		Button exit = new Button("Exit");
		exit.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				areyousureExitGame();
			}
		});
		exit.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					areyousureExitGame();
				}
			}

		});

		/*
		 * Button-IDs
		 */
		newGame.setId("menu");
		loadGame.setId("menu");
		exit.setId("menu");

		/*
		 * Button-Size
		 */
		double width = 150;// 100;
		double height = 50;// 50;

		newGame.setMinSize(width, height);
		loadGame.setMinSize(width, height);
		exit.setMinSize(width, height);

		newGame.setMaxSize(width, height);
		loadGame.setMaxSize(width, height);
		exit.setMaxSize(width, height);

		/*
		 * Labeling-Section on the Top
		 */
		VBox nameContainer = new VBox();

		Label name = new Label("Monster-Game");
		name.setStyle("-fx-text-fill: black;" + "-fx-font-size: 30;"
				+ "-fx-font-weight: bold;" + "-fx-alignment: CENTER");
		Label blurrTitle = new Label("Monster-Game");
		blurrTitle.setStyle("-fx-text-fill: lightgrey;" + "-fx-font-size: 30;"
				+ "-fx-font-weight: bold;" + "-fx-alignment: Center");
		blurrTitle.setEffect(new GaussianBlur(20));
		StackPane titlePane = new StackPane();
		titlePane.getChildren().addAll(blurrTitle, name);

		nameContainer.getChildren().add(titlePane);
		nameContainer.setAlignment(Pos.CENTER);

		componentLayout.setTop(nameContainer);

		/*
		 * Caching
		 */
		blurrTitle.setCache(true);
		blurrTitle.setCacheHint(CacheHint.SPEED);
		blurrTitle.setCacheShape(true);
		newGame.setCache(true);
		newGame.setCacheHint(CacheHint.SPEED);
		newGame.setCacheShape(true);
		loadGame.setCache(true);
		loadGame.setCacheHint(CacheHint.SPEED);
		loadGame.setCacheShape(true);
		exit.setCache(true);
		exit.setCacheHint(CacheHint.SPEED);
		exit.setCacheShape(true);

		/*
		 * Button-Section in the Middle
		 */
		VBox buttonContainer = new VBox();
		VBox.setMargin(newGame, new Insets(50, 0, 0, 0));
		VBox.setMargin(loadGame, new Insets(20, 0, 0, 0));
		VBox.setMargin(exit, new Insets(20, 0, 0, 0));

		buttonContainer.getChildren().addAll(newGame, loadGame, exit);
		buttonContainer.setAlignment(Pos.CENTER);

		componentLayout.setCenter(buttonContainer);

		/*
		 * Create Scene and apply CSS
		 */
		// Scene appScene = new Scene(componentLayout, 600, 500);
		totalLayout.setTop(digitalClock);
		totalLayout.setCenter(componentLayout);
		Scene appScene = new Scene(totalLayout, 600, 500);
		appScene.getStylesheets().add(buttonsCSS);
		primaryStage.setScene(appScene);

		/*
		 * Show Scene
		 */
		primaryStage.show();
	}

	public void newGame(Stage stage) {
		System.gc();

		/*
		 * Experimental
		 */
		StackPane background = new StackPane();
		BorderPane totalLayout = new BorderPane();
		totalLayout.setPadding(new Insets(0));
		totalLayout.setStyle("-fx-background-color: WHITE");

		/*
		 * Icon
		 */
		Image icon = new Image(iconPath);
		stage.getIcons().add(icon);

		/*
		 * Buttons
		 */
		Button leftU = new Button("Empty");
		leftU.setMinSize(200, 210);
		leftU.setMaxSize(200, 210);

		Monsters monster = new Monsters(11000, 1000000, ElementTypes.Air_Type,
				false, AppearanceTypes.Standard_Type, 25);
		Monsters monster1 = new Monsters(11000, 1000000, ElementTypes.Air_Type,
				false, AppearanceTypes.Standard_Type, 50);
		Monsters monster2 = new Monsters(500, 1000000, ElementTypes.Air_Type,
				false, AppearanceTypes.Standard_Type, 75);
		de.mastermind.thegoog.project.monstergame.monsters.Spawner spawner = new de.mastermind.thegoog.project.monstergame.monsters.Spawner(
				10000, 10, ElementTypes.Air_Type, false, 3, true, 100);
		Player p = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		p.setAccount(50000000);

		gameLogic = new GameLogicThread(p);
		Thread gameBackgroundService = new Thread(gameLogic);

		Button leftB = new Button("Empty");
		leftB.setMinSize(200, 70);
		leftB.setMaxSize(200, 70);

		Button middleB = new Button("Empty");
		middleB.setMinSize(200, 10);
		middleB.setMaxSize(200, 10);

		Button rightU = new Button("Empty");
		rightU.setMinSize(200, 210);
		rightU.setMaxSize(200, 210);

		Button rightB = new Button("Empty");
		rightB.setMinSize(200, 70);
		rightB.setMaxSize(200, 70);

		/*
		 * Button-IDs
		 */
		leftU.setId("dead");
		leftU.getStyleClass().add("Empty");
		leftB.setId("Empty");
		middleB.setId("Empty");
		rightU.setId("Empty");
		rightB.setId("Empty");

		/*
		 * Layout
		 */
		BorderPane componentLayout = new BorderPane();
		componentLayout.setPadding(new Insets(0));
		HBox layout = new HBox(3);

		/*
		 * Button-Section on the Left
		 */
		VBox left = new VBox(3);
		left.getChildren().addAll(
				leftU,
				new Monster(monster, p, stage, background, "left")
						.getMonsterButton(), leftB);
		layout.getChildren().add(left);

		/*
		 * Button-Section in the Middle
		 */
		VBox middle = new VBox(3);
		// middle.setPadding(new Insets(0, 1, 0, 1));
		middle.getChildren()
				.addAll(new Spawner(spawner, true, p, stage, background,
						"spawner").getSpawnerButton(),
						new Monster(monster1, p, stage, background, "middle")
								.getMonsterButton(), middleB);
		layout.getChildren().add(middle);

		/*
		 * Button-Section on the Right
		 */
		VBox right = new VBox(3);
		right.getChildren().addAll(
				rightU,
				new Monster(monster2, p, stage, background, "right")
						.getMonsterButton(), rightB);
		layout.getChildren().add(right);

		// layout.setPadding(new Insets(9, 0, 0, 0));
		layout.setPadding(new Insets(0, 0, 0, 1));

		/*
		 * Access Pause-Menu
		 */
		totalLayout.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ESCAPE)) {
					pauseMenu(stage);
				}
			}

		});

		/*
		 * Adding Buttons-Layout to Component-Layout
		 */
		componentLayout.setCenter(layout);

		/*
		 * Adding Component-Layout to Total-Layout
		 */
		totalLayout.setCenter(componentLayout);

		/*
		 * Drawing Info-Panels
		 */
		BorderPane leftPanel = upgradesItemsElementalSidePanel(p, stage);
		totalLayout.setLeft(leftPanel);//upgradesItemsElementalSidePanel(p, stage));
		totalLayout.setBottom(infoBottomPanel(p, stage));

		/*
		 * Create Scene and apply CSS
		 */
		// stage.setScene(new Scene(componentLayout, 600, 500));
		// stage.setScene(new Scene(totalLayout, 700, 600));
		BorderPane.setAlignment(leftPanel, Pos.TOP_RIGHT);
		background.getChildren().add(totalLayout);
		

		background.setCache(true);
		background.setCacheHint(CacheHint.QUALITY);
		background.setCacheShape(true);
		
		BorderPane.setAlignment(totalLayout, Pos.TOP_RIGHT);
		
		stage.setScene(new Scene(background, 700, 600));//708, 600));
		File css = new File("resources/css/monsterButtons.css");
		stage.getScene().getStylesheets().add(css.toURI().toString());

		/*
		 * Show Scene
		 */
		stage.show();
		gameBackgroundService.start();

		// weak workaround for info-Panel on the left
//		stage.hide();
//		stage.show();
	}

	public static synchronized void addDamageNumberAnimation(Label l,
			StackPane sPane) {
		Platform.runLater(() -> {
			sPane.getChildren().add(l);
		});
	}

	public void pauseMenu(final Stage primaryStage) {
		primaryStage.hide();

		/*
		 * Stage-Initialization
		 */
		final Stage menuStage = new Stage();
		menuStage.setResizable(false);
		menuStage.setTitle("Pause-Menu");

		/*
		 * Icon
		 */
		Image icon = new Image(iconPath);
		menuStage.getIcons().add(icon);

		/*
		 * Layout
		 */
		BorderPane componentLayout = new BorderPane();
		componentLayout.setPadding(new Insets(100, 100, 100, 100));
		componentLayout.setStyle("-fx-background-color: LIGHTGREY");
		BorderPane totalLayout = new BorderPane();
		totalLayout.setPadding(new Insets(0));
		totalLayout.setStyle("-fx-background-color: LIGHTGREY");

		/*
		 * Digital-Clock in the Top-Left-Corner
		 */
		VBox digitalClock = new VBox();
		digitalClock.getChildren().add(new DigitalClock());
		digitalClock.setAlignment(Pos.TOP_LEFT);
		totalLayout.setTop(digitalClock);

		/*
		 * Labeling-Section on the Top
		 */
		VBox topLayout = new VBox();

		Label title = new Label("Monster-Game");
		Label subtitle = new Label("Pause-Menu");
		title.setStyle("-fx-text-fill: black;" + "-fx-font-size: 30;"
				+ "-fx-font-weight: bold;" + "-fx-alignment: CENTER");
		subtitle.setStyle("-fx-text-fill: black;" + "-fx-font-size: 20;"
				+ "-fx-font-weight: bold;" + "-fx-alignment: CENTER");

		Label blurrTitle = new Label("Monster-Game");
		Label blurrSubtitle = new Label("Pause-Menu");
		blurrTitle.setCache(true);
		blurrTitle.setCacheHint(CacheHint.SPEED);
		blurrSubtitle.setCache(true);
		blurrSubtitle.setCacheHint(CacheHint.SPEED);
		blurrSubtitle.setCacheShape(true);
		blurrTitle.setStyle("-fx-text-fill: darkturquoise;"
				+ "-fx-font-size: 30;" + "-fx-font-weight: bold;"
				+ "-fx-alignment: Center");
		blurrTitle.setEffect(new GaussianBlur(100));
		blurrSubtitle.setStyle("-fx-text-fill: darkturquoise;"
				+ "-fx-font-size: 20;" + "-fx-font-weight: bold;"
				+ "-fx-alignment: Center");
		blurrSubtitle.setEffect(new GaussianBlur(100));
		StackPane titlePane = new StackPane();
		titlePane.getChildren().addAll(blurrTitle, title);
		StackPane subtitlePane = new StackPane();
		subtitlePane.getChildren().addAll(blurrSubtitle, subtitle);

		topLayout.getChildren().addAll(titlePane, subtitlePane);// (title,
																// subtitle);
		topLayout.setAlignment(Pos.CENTER);

		componentLayout.setTop(topLayout);

		/*
		 * Buttons
		 */
		Button resumeGame = new Button("Resume Game");
		resumeGame.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				menuStage.close();
				primaryStage.show();
			}
		});
		resumeGame.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					menuStage.close();
					System.gc();
					primaryStage.show();
				}
			}

		});

		Button loadGame = new Button("Load Game");
		loadGame.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				areyousureLoadGame(primaryStage, menuStage);
			}
		});
		loadGame.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					areyousureLoadGame(primaryStage, menuStage);
				}
			}

		});

		Button saveGame = new Button("Save Game");
		saveGame.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				// TODO saveGame
				areyousureSaveGame();
			}
		});
		saveGame.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					areyousureSaveGame();
				}
			}

		});

		Button mainMenu = new Button("Exit & Main-Menu");// ("Exit & Back to Main Menu");
		mainMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				areyousureMainMenu(primaryStage, menuStage);
			}
		});
		mainMenu.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					areyousureMainMenu(primaryStage, menuStage);
				}
			}

		});

		Button exitGame = new Button("Exit Game");
		exitGame.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				// TODO saveGame
				areyousureExitGame();
			}
		});
		exitGame.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					areyousureExitGame();
				}
			}

		});
		componentLayout.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ESCAPE)) {
					menuStage.close();
					primaryStage.show();
				}
			}

		});

		/*
		 * Button-IDs
		 */
		String menuID = "menu";
		resumeGame.setId(menuID);
		saveGame.setId(menuID);
		loadGame.setId(menuID);
		mainMenu.setId(menuID);
		exitGame.setId(menuID);

		/*
		 * Button-Size
		 */
		double width = 200;
		double height = 50;
		resumeGame.setMinSize(width, height);
		saveGame.setMinSize(width, height);
		loadGame.setMinSize(width, height);
		mainMenu.setMinSize(width, height);
		exitGame.setMinSize(width, height);

		resumeGame.setMaxSize(width, height);
		saveGame.setMaxSize(width, height);
		loadGame.setMaxSize(width, height);
		mainMenu.setMaxSize(width, height);
		exitGame.setMaxSize(width, height);

		/*
		 * Caching
		 */
		resumeGame.setCache(true);
		resumeGame.setCacheHint(CacheHint.SPEED);
		resumeGame.setCacheShape(true);

		saveGame.setCache(true);
		saveGame.setCacheHint(CacheHint.SPEED);
		saveGame.setCacheShape(true);

		loadGame.setCache(true);
		loadGame.setCacheHint(CacheHint.SPEED);
		loadGame.setCacheShape(true);

		mainMenu.setCache(true);
		mainMenu.setCacheHint(CacheHint.SPEED);
		mainMenu.setCacheShape(true);

		exitGame.setCache(true);
		exitGame.setCacheHint(CacheHint.SPEED);
		exitGame.setCacheShape(true);

		/*
		 * Button-Section in the Center
		 */
		VBox buttonLayout = new VBox();
		buttonLayout.getChildren().addAll(resumeGame, saveGame, loadGame,
				mainMenu, exitGame);
		VBox.setMargin(resumeGame, new Insets(30, 0, 0, 0));
		buttonLayout.setAlignment(Pos.CENTER);

		componentLayout.setCenter(buttonLayout);

		/*
		 * Create Scene and apply CSS
		 */
		// menuStage.setScene(new Scene(componentLayout, 500, 500));
		totalLayout.setCenter(componentLayout);
		menuStage.setScene(new Scene(totalLayout, 500, 510));
		menuStage.getScene().getStylesheets().add(buttonsCSS);

		/*
		 * Show Scene
		 */
		menuStage.show();
	}

	public void areyousureSaveGame() {
		/*
		 * Stage-Initialization
		 */
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setTitle("Are you sure?");

		/*
		 * Icon
		 */
		Image icon = new Image(iconPath);
		stage.getIcons().add(icon);

		/*
		 * Buttons
		 */
		Button yes = new Button("YES");
		yes.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				// TODO saveGame
			}
		});
		yes.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					// TODO saveGame
				}
			}

		});
		Button no = new Button("NO");
		no.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				stage.close();
			}
		});
		no.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					stage.close();
				}
			}

		});

		/*
		 * Button-Size
		 */
		double width = 37.0;// 36.0;
		double height = 25.0;
		yes.setMinSize(width, height);
		no.setMinSize(width, height);
		yes.setMaxSize(width, height);
		no.setMaxSize(width, height);

		/*
		 * Layout
		 */
		BorderPane componentLayout = new BorderPane();
		componentLayout.setPadding(new Insets(10, 10, 0, 10));
		componentLayout.setStyle("-fx-background-color: LIGHTGREY");

		/*
		 * Text-Section on the Top
		 */
		VBox text = new VBox(2);

		Text warning1 = new Text("This will overwrite your old Save-File!");
		Text warning2 = new Text("Are you sure?");
		warning1.setStyle("-fx-font-weight: bold");
		warning2.setStyle("-fx-font-weight: bold");

		text.getChildren().addAll(warning1, warning2);
		text.setAlignment(Pos.CENTER);

		componentLayout.setTop(text);

		/*
		 * Button-Section on the Bottom
		 */
		HBox buttons = new HBox(2);

		buttons.getChildren().addAll(yes, no);
		buttons.setAlignment(Pos.CENTER);

		componentLayout.setCenter(buttons);

		/*
		 * Create Scene and apply CSS
		 */
		stage.setScene(new Scene(componentLayout, 225, 80));
		stage.getScene().getStylesheets().add(buttonsCSS);
		/*
		 * Show Scene
		 */
		stage.show();
	}

	public void areyousureLoadGame(Stage primaryStage, Stage menuStage) {
		/*
		 * Stage-Initialization
		 */
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setTitle("Are you sure?");

		/*
		 * Icon
		 */
		Image icon = new Image(iconPath);
		stage.getIcons().add(icon);

		/*
		 * Buttons
		 */
		Button yes = new Button("YES");
		yes.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				// TODO loadGame
			}
		});
		yes.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					// TODO loadGame
				}
			}

		});
		Button no = new Button("NO");
		no.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				stage.close();
			}
		});
		no.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					stage.close();
				}
			}

		});

		/*
		 * Button-Size
		 */
		double width = 37.0;// 36.0;
		double height = 25.0;
		yes.setMinSize(width, height);
		no.setMinSize(width, height);
		yes.setMaxSize(width, height);
		no.setMaxSize(width, height);

		/*
		 * Layout
		 */
		BorderPane componentLayout = new BorderPane();
		componentLayout.setPadding(new Insets(10, 10, 0, 10));
		componentLayout.setStyle("-fx-background-color: LIGHTGREY");

		/*
		 * Text-Section on the Top
		 */
		VBox text = new VBox(2);

		Text warning1 = new Text(
				"All your current progress, that is not saved, will be lost!");
		Text warning2 = new Text("Are you sure?");
		warning1.setStyle("-fx-font-weight: bold");
		warning2.setStyle("-fx-font-weight: bold");

		text.getChildren().addAll(warning1, warning2);
		text.setAlignment(Pos.CENTER);

		componentLayout.setTop(text);

		/*
		 * Button-Section on the Bottom
		 */
		HBox buttons = new HBox(2);

		buttons.getChildren().addAll(yes, no);
		buttons.setAlignment(Pos.CENTER);

		componentLayout.setCenter(buttons);

		/*
		 * Create Scene and apply CSS
		 */
		stage.setScene(new Scene(componentLayout, 330, 80));
		stage.getScene().getStylesheets().add(buttonsCSS);

		/*
		 * Show Scene
		 */
		stage.show();
	}

	public void areyousureMainMenu(Stage primaryStage, Stage menuStage) {
		/*
		 * Stage-Initialization
		 */
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setTitle("Are you sure?");

		/*
		 * Icon
		 */
		Image icon = new Image(iconPath);
		stage.getIcons().add(icon);

		/*
		 * Buttons
		 */
		Button yes = new Button("YES");
		yes.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				stage.close();
				menuStage.close();
				try {
					start(primaryStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		yes.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					((Stage) menuStage.getScene().getWindow()).close();
					// menuStage.close();
					stage.close();
					try {
						start(primaryStage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		});
		Button no = new Button("NO");
		no.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				stage.close();
			}
		});
		no.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					stage.close();
				}
			}

		});

		/*
		 * Button-Size
		 */
		double width = 37.0;// 36.0;
		double height = 25.0;
		yes.setMinSize(width, height);
		no.setMinSize(width, height);
		yes.setMaxSize(width, height);
		no.setMaxSize(width, height);

		/*
		 * Layout
		 */
		BorderPane componentLayout = new BorderPane();
		componentLayout.setPadding(new Insets(10, 10, 0, 10));
		componentLayout.setStyle("-fx-background-color: LIGHTGREY");

		/*
		 * Text-Section on the Top
		 */
		VBox text = new VBox(2);

		Text warning1 = new Text(
				"All your current progress, that is not saved, will be lost!");
		Text warning2 = new Text("Are you sure?");
		warning1.setStyle("-fx-font-weight: bold");
		warning2.setStyle("-fx-font-weight: bold");

		text.getChildren().addAll(warning1, warning2);
		text.setAlignment(Pos.CENTER);

		componentLayout.setTop(text);

		/*
		 * Button-Section on the Bottom
		 */
		HBox buttons = new HBox(2);

		buttons.getChildren().addAll(yes, no);
		buttons.setAlignment(Pos.CENTER);

		componentLayout.setCenter(buttons);

		/*
		 * Create Scene and apply CSS
		 */
		stage.setScene(new Scene(componentLayout, 330, 80));
		stage.getScene().getStylesheets().add(buttonsCSS);

		/*
		 * Show Scene
		 */
		stage.show();
	}

	public void areyousureExitGame() {
		/*
		 * Stage-Initialization
		 */
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setTitle("Are you sure?");

		/*
		 * Icon
		 */
		Image icon = new Image(iconPath);
		stage.getIcons().add(icon);

		/*
		 * Buttons
		 */
		Button yes = new Button("YES");
		yes.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				System.exit(0);
			}
		});
		yes.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					System.exit(0);
				}
			}

		});
		Button no = new Button("NO");
		no.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				stage.close();
			}
		});
		no.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					stage.close();
				}
			}

		});

		/*
		 * Button-Size
		 */
		double width = 37.0;// 36.0;
		double height = 25.0;
		yes.setMinSize(width, height);
		no.setMinSize(width, height);
		yes.setMaxSize(width, height);
		no.setMaxSize(width, height);

		/*
		 * Layout
		 */
		BorderPane componentLayout = new BorderPane();
		componentLayout.setPadding(new Insets(15, 10, 0, 10));// (15, 0, 0, 0));
		componentLayout.setStyle("-fx-background-color: LIGHTGREY");

		/*
		 * Text-Section on the Top
		 */
		final VBox text = new VBox(1);

		Text warning = new Text("Do you really want to quit the Game?");
		warning.setId("Menu-Label");

		text.getChildren().add(warning);
		text.setAlignment(Pos.CENTER);

		componentLayout.setTop(text);

		/*
		 * Button-Section on the Bottom
		 */
		final HBox buttons = new HBox(2);

		buttons.getChildren().addAll(yes, no);
		buttons.setAlignment(Pos.CENTER);

		componentLayout.setCenter(buttons);

		/*
		 * Create Scene and apply CSS
		 */
		stage.setScene(new Scene(componentLayout, 240, 80));// 220, 80));
		stage.getScene().getStylesheets().add(buttonsCSS);

		/*
		 * Show Scene
		 */
		stage.show();
	}

	private static BorderPane upgradesItemsElementalSidePanel(Player p, Stage stage) {
		/*
		 * Layout
		 */
		BorderPane leftPanel = new BorderPane();
		leftPanel.setPadding(new Insets(0));
		leftPanel.setStyle("-fx-background-color: TOMATO");

		/*
		 * Containers
		 */
		VBox panelLayout = new VBox();
		HBox upperElementals = new HBox();
		HBox lowerElementals = new HBox();

		/*
		 * Labels
		 */
		Label upgrades = new Label("Upgrades:");
		Label items = new Label("Items:");
		Label elements = new Label("Elemental:");
		elements.setId("Menu-Label");
		upgrades.setId("Menu-Label");
		items.setId("Menu-Label");

		/*
		 * Buttons
		 */
		Button lifeUpgrade = generateLifeUpgradeButton(p, stage);
		Button clickDamageUpgrade = generateClickDamageUpgradeButton(p, stage);
		Button passiveDamageUpgrade = generatePassiveDamageUpgradeButton(p,
				stage);
		Button abomb = generateABombButton(p, stage);
		ABombCountChangeListener.armButton(abomb);
		Button godmode = generateGodModeButton(p, stage);
		GodModeCountChangeListener.armButton(godmode);
		Button air = generateAirElementalButton(p, stage);
		Button water = generateWaterElementalButton(p, stage);
		Button earth = generateEarthElementalButton(p, stage);
		Button fire = generateFireElementalButton(p, stage);

		/*
		 * Button-IDs
		 */
		lifeUpgrade.setId("Menu");
		clickDamageUpgrade.setId("Menu");
		passiveDamageUpgrade.setId("Menu");
		abomb.setId("Menu");
		godmode.setId("Menu");
		air.setId("Menu");
		water.setId("Menu");
		earth.setId("Menu");
		fire.setId("Menu");

		/*
		 * Adding Elements to Layout
		 */
		upperElementals.getChildren().addAll(air, water);
		lowerElementals.getChildren().addAll(earth, fire);
		// panelLayout.getChildren().addAll(generatePlaceHolder(100, 5),
		// upgrades,
		// lifeUpgrade, clickDamageUpgrade, passiveDamageUpgrade,
		// generatePlaceHolder(100, 15), generatePlaceHolder(100, 5),
		// items, abomb, godmode, generatePlaceHolder(100, 15), elements,
		// generatePlaceHolder(100, 5), upperElementals, lowerElementals);
		panelLayout.getChildren().addAll(upgrades, lifeUpgrade,
				clickDamageUpgrade, passiveDamageUpgrade, items, abomb,
				godmode, elements, upperElementals, lowerElementals);
		VBox.setMargin(lifeUpgrade, new Insets(5, 0, 0, 0));
		VBox.setMargin(upgrades, new Insets(10, 0, 0, 2));
		VBox.setMargin(items, new Insets(0, 0, 0, 2));
		VBox.setMargin(elements, new Insets(0, 0, 0, 2));
		BorderPane.setAlignment(panelLayout, Pos.TOP_RIGHT);
		leftPanel.setRight(panelLayout);

		/*
		 * Caching
		 */
		leftPanel.setCache(true);
		leftPanel.setCacheHint(CacheHint.SPEED);
		leftPanel.setCacheShape(true);

		leftPanel.setMinSize(100, 500);
		return leftPanel;
	}

	/**
	 * Formats a number to an Output-String with a dot after each 3 coherent
	 * numbers in the number.<br>
	 * E.g.: 1000 -> 1.000;<br>
	 * or: 10000000 -> 10.000.000;<br>
	 * and: 10 -> 10;
	 * 
	 * @param number
	 * @return numberToFormattedString
	 */
	public static String formatBigNumbers(long number) {
		StringBuilder nrBuild = new StringBuilder(Long.toString(number))
				.reverse();

		// One Dot after 3 coherent numbers
		for (int i = 3; i < nrBuild.length(); i += 3) {
			nrBuild.insert(i, ".");
			i++;
		}
		return nrBuild.reverse().toString();
	}

	private static Tooltip generateLifeUpgradeTooltip(Player p) {
		StringBuilder info = new StringBuilder("Purchaseable Upgrades Stats:");
		info.append("\nLevel:\t" + (p.getUpgrades().getLifeUpgradeLevel() + 1));
		info.append("\nNew Life: \t"
				+ formatBigNumbers(p.getUpgrades().getLifeUpgrade()) + " HP");
		info.append("\nCurrent Life:\t" + formatBigNumbers(p.getLife()) + " HP");
		info.append("\nPrice:\t"
				+ formatBigNumbers(p.getUpgrades().getLifeUpgradePrice()) + "€");

		Tooltip t = new Tooltip(info.toString());
		t.setAutoHide(true);
		return t;
	}

	private static Tooltip generateClickDamageUpgradeTooltip(Player p) {
		StringBuilder info = new StringBuilder("Purchaseable Upgrades Stats:");
		info.append("\nLevel:\t"
				+ (p.getUpgrades().getClickDamageUpgradeLevel() + 1));
		info.append("\nNew Damage: \t"
				+ formatBigNumbers(p.getUpgrades().getClickDamageUpgrade()
						+ p.getClickDamage()) + " DMG");
		info.append("\nCurrent Damage:\t"
				+ formatBigNumbers(p.getClickDamage()) + " DMG");
		info.append("\nPrice:\t"
				+ formatBigNumbers(p.getUpgrades().getClickDamageUpgradePrice())
				+ "€");

		Tooltip t = new Tooltip(info.toString());
		t.setAutoHide(true);
		return t;
	}

	private static Tooltip generatePassiveDamageUpgradeTooltip(Player p) {
		StringBuilder info = new StringBuilder("Purchaseable Upgrades Stats:");
		info.append("\nLevel:\t"
				+ (p.getUpgrades().getPassiveDamageUpgradeLevel() + 1));
		info.append("\nNew Damage: \t"
				+ formatBigNumbers(p.getUpgrades().getPassiveDamageUpgrade()
						+ p.getDamage()) + " DMG");
		info.append("\nCurrent Damage:\t" + formatBigNumbers(p.getDamage())
				+ " DMG");
		info.append("\nPrice:\t"
				+ formatBigNumbers(p.getUpgrades()
						.getPassiveDamageUpgradePrice()) + "€");

		Tooltip t = new Tooltip(info.toString());
		t.setAutoHide(true);
		return t;
	}

	private static Button generatePassiveDamageUpgradeButton(Player p,
			Stage stage) {
		String info = "Passive-\nDamage:\n\t"
				+ formatBigNumbers(p.getUpgrades()
						.getPassiveDamageUpgradePrice()) + "€";
		Button passiveDamageUpgrade = new Button(info);
		passiveDamageUpgrade.setTooltip(generatePassiveDamageUpgradeTooltip(p));
		passiveDamageUpgrade.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				passiveDamageUpgrade.getTooltip().show(stage,
						stage.getX() + 100, stage.getY() + 157);
			}
		});

		passiveDamageUpgrade.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				passiveDamageUpgrade.getTooltip().hide();
			}
		});

		passiveDamageUpgrade.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				passiveDamageUpgrade.getTooltip().hide();
				if (p.getUpgrades().purchasePassiveDamageUpgrade()) {
					Button tmp = generatePassiveDamageUpgradeButton(p, stage);
					passiveDamageUpgrade.setText(tmp.getText());
					passiveDamageUpgrade.setTooltip(tmp.getTooltip());
				}
				passiveDamageUpgrade.getTooltip().show(stage,
						stage.getX() + 100, stage.getY() + 157);
			}
		});
		passiveDamageUpgrade.setMinSize(100, 60);
		passiveDamageUpgrade.setMaxSize(100, 60);
		passiveDamageUpgrade.setCache(true);
		passiveDamageUpgrade.setCacheHint(CacheHint.SPEED);
		return passiveDamageUpgrade;
	}

	private static Button generateClickDamageUpgradeButton(Player p, Stage stage) {
		String info = "Click-Damage:\n\t"
				+ formatBigNumbers(p.getUpgrades().getClickDamageUpgradePrice())
				+ "€";
		Button clickDamageUpgrade = new Button(info);
		clickDamageUpgrade.setTooltip(generateClickDamageUpgradeTooltip(p));
		clickDamageUpgrade.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				clickDamageUpgrade.getTooltip().show(stage, stage.getX() + 100,
						stage.getY() + 95);
				Utils.setLevelUpdated(true);
			}
		});

		clickDamageUpgrade.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				clickDamageUpgrade.getTooltip().hide();
			}
		});

		clickDamageUpgrade.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				clickDamageUpgrade.getTooltip().hide();
				if (p.getUpgrades().purchaseClickDamageUpgrade()) {
					Button tmp = generateClickDamageUpgradeButton(p, stage);
					clickDamageUpgrade.setText(tmp.getText());
					clickDamageUpgrade.setTooltip(tmp.getTooltip());
				}
				clickDamageUpgrade.getTooltip().show(stage, stage.getX() + 100,
						stage.getY() + 95);
			}
		});
		clickDamageUpgrade.setMinSize(100, 60);
		clickDamageUpgrade.setMaxSize(100, 60);
		clickDamageUpgrade.setCache(true);
		clickDamageUpgrade.setCacheHint(CacheHint.SPEED);
		return clickDamageUpgrade;
	}

	private static Button generateLifeUpgradeButton(Player p, Stage stage) {
		String info = "Life:\n\t"
				+ formatBigNumbers(p.getUpgrades().getLifeUpgradePrice()) + "€";
		Button lifeUpgrade = new Button(info);
		// lifeUpgrade.setContentDisplay(ContentDisplay.LEFT);
		// lifeUpgrade.setTextAlignment(TextAlignment.LEFT);
		lifeUpgrade.setTooltip(generateLifeUpgradeTooltip(p));
		lifeUpgrade.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				lifeUpgrade.getTooltip().show(stage, stage.getX() + 100,
						stage.getY() + 35);
			}
		});

		lifeUpgrade.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				lifeUpgrade.getTooltip().hide();
			}
		});

		lifeUpgrade.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				lifeUpgrade.getTooltip().hide();
				if (p.getUpgrades().purchaseLifeUpgrade()) {
					Button tmp = generateLifeUpgradeButton(p, stage);
					lifeUpgrade.setText(tmp.getText());
					lifeUpgrade.setTooltip(tmp.getTooltip());
				}
				lifeUpgrade.getTooltip().show(stage, stage.getX() + 100,
						stage.getY() + 35);
			}
		});
		lifeUpgrade.setMinSize(100, 60);
		lifeUpgrade.setMaxSize(100, 60);
		lifeUpgrade.setCache(true);
		lifeUpgrade.setCacheHint(CacheHint.SPEED);
		return lifeUpgrade;
	}

	public static Tooltip generateABombTooltip(Player p) {
		Tooltip abombItemTooltip = new Tooltip(
				"A tactical nuclear Bomb explodes\nover the Battlefield\n\nDamage dealt:\t1.000.000\nPrice:\t\t\t"
						+ formatBigNumbers(p.getItems().getPrice_ABomb())
						+ "€\nCount:\t\t\t"
						+ formatBigNumbers(p.getItems().getABombCount()));
		abombItemTooltip.setAutoHide(true);
		return abombItemTooltip;
	}

	private static Button generateABombButton(Player p, Stage stage) {
		Button abomb = new Button("A-Bomb:\n\t"
				+ formatBigNumbers(p.getItems().getPrice_ABomb()) + "€");
		Tooltip abombItemTooltip = generateABombTooltip(p);
		abomb.setTooltip(abombItemTooltip);
		abomb.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				abomb.getTooltip().show(stage, stage.getX() + 100,
						stage.getY() + 250);
			}
		});
		abomb.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				abomb.getTooltip().hide();
			}
		});
		abomb.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				abomb.getTooltip().hide();
				if (p.getItems().purchase_aBomb()) {
					// Button tmp = generateABombButton(p, stage);
					// abomb.setText(tmp.getText());
					// abomb.setTooltip(tmp.getTooltip());
					// ABombCountChangeListener.armTooltip(abomb);
				}
				abomb.getTooltip().show(stage, stage.getX() + 100,
						stage.getY() + 250);
			}
		});
		abomb.setMinSize(100, 60);
		abomb.setMaxSize(100, 60);
		abomb.setCache(true);
		abomb.setCacheHint(CacheHint.SPEED);
		return abomb;
	}

	public static Tooltip generateGodModeTooltip(Player p) {
		Tooltip godmodeItemTooltip = new Tooltip(
				"Player gets invulnerable for 5sec.\n\nPrice:\t"
						+ formatBigNumbers(p.getItems().getPrice_GodMode())
						+ "€\nCount:\t"
						+ formatBigNumbers(p.getItems().getGodModeCount()));
		godmodeItemTooltip.setAutoHide(true);
		return godmodeItemTooltip;
	}

	private static Button generateGodModeButton(Player p, Stage stage) {
		Button godmode = new Button("God-Mode:\n\t"
				+ formatBigNumbers(p.getItems().getPrice_GodMode()) + "€");
		Tooltip godmodeItemTooltip = generateGodModeTooltip(p);
		godmode.setTooltip(godmodeItemTooltip);
		godmode.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				godmode.getTooltip().show(stage, stage.getX() + 100,
						stage.getY() + 320);
			}
		});
		godmode.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				godmode.getTooltip().hide();
			}
		});
		godmode.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				godmode.getTooltip().hide();
				if (p.getItems().purchase_GodMode()) {
					// Button tmp = generateGodModeButton(p, stage);
					// godmode.setText(tmp.getText());
					// godmode.setTooltip(tmp.getTooltip());
				}
				godmode.getTooltip().show(stage, stage.getX() + 100,
						stage.getY() + 320);
			}
		});
		godmode.setMinSize(100, 60);
		godmode.setMaxSize(100, 60);
		godmode.setCache(true);
		godmode.setCacheHint(CacheHint.SPEED);
		return godmode;
	}

	private static Button generateAirElementalButton(Player p, Stage stage) {
		Button air = new Button("A");
		Tooltip t = new Tooltip(
				"Upgrades the elemental Damage\nagainst Air-Monsters.\n\nPurchaseable Upgrades Stats:\nLevel: "
						+ p.getUpgrades().getElementalDamageUpgradeLevel_Air()
						+ "\nNew Multiplier: "
						+ Utils.round((p.getUpgrades()
								.getElementalDamageUpgrade_Air() + 0.2), 2)
						+ "\nCurrent Multiplier: "
						+ Utils.round(p.getUpgrades()
								.getElementalDamageUpgrade_Air(), 2)
						+ "\nPrice: "
						+ p.getUpgrades().getElementalDamageUpgradePrice_Air()
						+ "€");
		t.setAutoHide(true);
		air.setTooltip(t);
		air.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				air.getTooltip().show(stage, stage.getX() + 50,
						stage.getY() + 400);
			}
		});
		air.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				air.getTooltip().hide();
			}
		});
		air.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				air.getTooltip().hide();
				if (p.getUpgrades().purchaseElementalDamageUpgrade_Air()) {
					Button tmp = generateAirElementalButton(p, stage);
					air.setText(tmp.getText());
					air.setTooltip(tmp.getTooltip());
				}
			}
		});
		air.setMinSize(50, 50);
		air.setMaxSize(50, 50);
		air.setCache(true);
		air.setCacheHint(CacheHint.SPEED);
		return air;
	}

	private static Button generateWaterElementalButton(Player p, Stage stage) {
		Button water = new Button("W");
		Tooltip t = new Tooltip(
				"Upgrades the elemental Damage\nagainst Water-Monsters.\n\nPurchaseable Upgrades Stats:\nLevel: "
						+ p.getUpgrades()
								.getElementalDamageUpgradeLevel_Water()
						+ "\nNew Multiplier: "
						+ Utils.round((p.getUpgrades()
								.getElementalDamageUpgrade_Water() + 0.2), 2)
						+ "\nCurrent Multiplier: "
						+ Utils.round(p.getUpgrades()
								.getElementalDamageUpgrade_Water(), 2)
						+ "\nPrice: "
						+ p.getUpgrades()
								.getElementalDamageUpgradePrice_Water() + "€");
		t.setAutoHide(true);
		water.setTooltip(t);
		water.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				water.getTooltip().show(stage, stage.getX() + 100,
						stage.getY() + 400);
			}
		});
		water.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				water.getTooltip().hide();
			}
		});
		water.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				water.getTooltip().hide();
				if (p.getUpgrades().purchaseElementalDamageUpgrade_Water()) {
					Button tmp = generateWaterElementalButton(p, stage);
					water.setText(tmp.getText());
					water.setTooltip(tmp.getTooltip());
				}
			}
		});
		water.setMinSize(50, 50);
		water.setMaxSize(50, 50);
		water.setCache(true);
		water.setCacheHint(CacheHint.SPEED);
		return water;
	}

	private static Button generateEarthElementalButton(Player p, Stage stage) {
		Button earth = new Button("E");
		Tooltip t = new Tooltip(
				"Upgrades the elemental Damage\nagainst Earth-Monsters.\n\nPurchaseable Upgrades Stats:\nLevel: "
						+ p.getUpgrades()
								.getElementalDamageUpgradeLevel_Earth()
						+ "\nNew Multiplier: "
						+ Utils.round((p.getUpgrades()
								.getElementalDamageUpgrade_Earth() + 0.2), 2)
						+ "\nCurrent Multiplier: "
						+ Utils.round(p.getUpgrades()
								.getElementalDamageUpgrade_Earth(), 2)
						+ "\nPrice: "
						+ p.getUpgrades()
								.getElementalDamageUpgradePrice_Earth() + "€");
		t.setAutoHide(true);
		earth.setTooltip(t);
		earth.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				earth.getTooltip().show(stage, stage.getX() + 50,
						stage.getY() + 440);
			}
		});
		earth.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				earth.getTooltip().hide();
			}
		});
		earth.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				earth.getTooltip().hide();
				if (p.getUpgrades().purchaseElementalDamageUpgrade_Earth()) {
					Button tmp = generateEarthElementalButton(p, stage);
					earth.setText(tmp.getText());
					earth.setTooltip(tmp.getTooltip());
				}
			}
		});
		earth.setMinSize(50, 50);
		earth.setMaxSize(50, 50);
		earth.setCache(true);
		earth.setCacheHint(CacheHint.SPEED);
		return earth;
	}

	private static Button generateFireElementalButton(Player p, Stage stage) {
		Button fire = new Button("F");
		Tooltip t = new Tooltip(
				"Upgrades the elemental Damage\nagainst Fire-Monsters.\n\nPurchaseable Upgrades Stats:\nLevel: "
						+ p.getUpgrades().getElementalDamageUpgradeLevel_Fire()
						+ "\nNew Multiplier: "
						+ Utils.round((p.getUpgrades()
								.getElementalDamageUpgrade_Fire() + 0.2), 2)
						+ "\nCurrent Multiplier: "
						+ Utils.round(p.getUpgrades()
								.getElementalDamageUpgrade_Fire(), 2)
						+ "\nPrice: "
						+ p.getUpgrades().getElementalDamageUpgradePrice_Fire()
						+ "€");
		t.setAutoHide(true);
		fire.setTooltip(t);
		fire.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				fire.getTooltip().show(stage, stage.getX() + 100,
						stage.getY() + 440);
			}
		});
		fire.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				fire.getTooltip().hide();
			}
		});
		fire.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				fire.getTooltip().hide();
				if (p.getUpgrades().purchaseElementalDamageUpgrade_Fire()) {
					Button tmp = generateFireElementalButton(p, stage);
					fire.setText(tmp.getText());
					fire.setTooltip(tmp.getTooltip());
				}
			}
		});
		fire.setMinSize(50, 50);
		fire.setMaxSize(50, 50);
		fire.setCache(true);
		fire.setCacheHint(CacheHint.SPEED);
		return fire;
	}

	private static Button generatePlaceHolder(double width, double height) {
		Button b = new Button();
		b.setMinSize(width, height);
		b.setMaxSize(width, height);
		b.setStyle("-fx-background-color: transparent");
		b.setCache(true);
		b.setCacheHint(CacheHint.SPEED);
		return b;
	}

	private static Button generateUseABombButton(Label abombCount, Player p) {
		Button useABomb = new Button("AB");
		useABomb.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				if (p.getItems().use_ABomb()) {
					// TODO or not?
				}
			}
		});
		useABomb.setId("Menu");
		useABomb.setMinSize(60, 30);
		useABomb.setMaxSize(60, 30);
		return useABomb;
	}

	private static Button generateUseGodModeButton(Label godmodeCount, Player p) {
		Button useGodMode = new Button("GM");
		useGodMode.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				if (p.getItems().use_GodMode()) {
					// TODO or not?
				}
			}
		});
		useGodMode.setId("Menu");
		useGodMode.setMinSize(60, 30);
		useGodMode.setMaxSize(60, 30);
		return useGodMode;
	}

	private static BorderPane infoBottomPanel(Player p, Stage stage) {
		/*
		 * Layout-Initialization
		 */
		final BorderPane componentLayout = new BorderPane();
		componentLayout.setPadding(new Insets(0));
		componentLayout.setStyle("-fx-background-color: TOMATO");

		/*
		 * Container-Initialization and Padding-Adjustments
		 */
		final HBox componentsContainer = new HBox(5);
		final VBox labels1Container = new VBox(2);
		final VBox info1Container = new VBox(2);
		final VBox healthBox = new VBox(2);
		final VBox itemsContainer = new VBox(2);
		final HBox healthText = new HBox(2);
		final HBox itemsBox = new HBox(3);
		final VBox itemCounts = new VBox(2);
		labels1Container.setPadding(new Insets(13, 0, 0, 0));
		healthBox.setPadding(new Insets(14, 0, 0, 15));
		info1Container.setPadding(new Insets(15.35, 0, 0, 15));
		itemsBox.setPadding(new Insets(14, 0, 0, 15));
		itemsContainer.setPadding(new Insets(0, 0, 0, 15));
		itemCounts.setPadding(new Insets(14, 0, 0, 15));

		/*
		 * Item-Initialization
		 */
		ProgressBar life = ProgressBars.generateLifeBar(p.getLife(),
				p.getMaxLife(), stage);
		Label money = new Label("Money:");
		Label level = new Label("Level:");
		Label moneyInfo = new Label(formatBigNumbers(p.getMoney()) + " €");
		Label levelInfo = new Label(formatBigNumbers(p.getLevel()));
		Label lifeLabel = new Label("Life:");
		Label lifeInfo = new Label(formatBigNumbers(p.getLife()) + " HP");
		Label items = new Label("Items:");
		Label abombCount = new Label("Count: "
				+ Long.toString(p.getItems().getABombCount()));
		Label godModeCount = new Label("Count: "
				+ Long.toString(p.getItems().getGodModeCount()));

		/*
		 * Setting IDs for Headings
		 */
		money.setId("Menu-Label");
		level.setId("Menu-Label");
		items.setId("Menu-Label");

		/*
		 * Arming ChangeListeners
		 */
		// TODO update tooltips only when viewed?
		AccountChangeListener.armLabel(moneyInfo);
		ABombCountChangeListener.armLabel(abombCount);
		GodModeCountChangeListener.armLabel(godModeCount);
		LevelChangeListener.armLabel(levelInfo);
		LifeChangeListener.armLabel(lifeInfo);
		LifeChangeListener.armProgressBar(life);

		/*
		 * Adding Items to Containers
		 */
		labels1Container.getChildren().addAll(money, level);
		info1Container.getChildren().addAll(moneyInfo, levelInfo);
		healthText.getChildren().addAll(lifeLabel, lifeInfo);
		healthBox.getChildren().addAll(healthText, life);
		itemsContainer.getChildren().addAll(
				generateUseABombButton(abombCount, p),
				generateUseGodModeButton(godModeCount, p));
		itemCounts.getChildren().addAll(abombCount, godModeCount);
		itemsBox.getChildren().addAll(items, itemsContainer, itemCounts);
		componentsContainer.getChildren().addAll(generatePlaceHolder(20, 100),
				labels1Container, info1Container, healthBox, itemsBox);

		/*
		 * Item-Adjustments
		 */
		lifeLabel.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 13");
		itemsContainer.setSpacing(5);
		HBox.setMargin(lifeInfo, new Insets(0.5, 0, 0, 10));
		VBox.setMargin(abombCount, new Insets(-7, 0, 0, 0));
		VBox.setMargin(godModeCount, new Insets(16, 0, 0, 0));

		/*
		 * Finalize Layout
		 */
		componentLayout.setCenter(componentsContainer);

		/*
		 * Caching
		 */
		componentLayout.setCache(true);
		componentLayout.setCacheHint(CacheHint.SPEED);
		componentLayout.setCacheShape(true);

		return componentLayout;
	}

	// //starting point for the application
	// //this is where we put the code for the user interface
	// @Override
	// public void start(Stage primaryStage) {
	//
	// //The primaryStage is the top-level container
	// primaryStage.setTitle("example Gui");
	//
	// //The BorderPane has the same areas laid out as the
	// //BorderLayout layout manager
	// BorderPane componentLayout = new BorderPane();
	// componentLayout.setPadding(new Insets(20,0,20,20));
	//
	// //The FlowPane is a conatiner that uses a flow layout
	// final FlowPane choicePane = new FlowPane();
	// choicePane.setHgap(100);
	// Label choiceLbl = new Label("Fruits");
	//
	// //The choicebox is populated from an observableArrayList
	// ChoiceBox fruits = new
	// ChoiceBox(FXCollections.observableArrayList("Asparagus", "Beans",
	// "Broccoli", "Cabbage"
	// , "Carrot", "Celery", "Cucumber", "Leek", "Mushroom"
	// , "Pepper", "Radish", "Shallot", "Spinach", "Swede"
	// , "Turnip"));
	//
	// //Add the label and choicebox to the flowpane
	// choicePane.getChildren().add(choiceLbl);
	// choicePane.getChildren().add(fruits);
	//
	// //put the flowpane in the top area of the BorderPane
	// componentLayout.setTop(choicePane);
	//
	// final FlowPane listPane = new FlowPane();
	// listPane.setHgap(100);
	// Label listLbl = new Label("Vegetables");
	//
	// ListView vegetables = new
	// ListView(FXCollections.observableArrayList("Apple", "Apricot", "Banana"
	// ,"Cherry", "Date", "Kiwi", "Orange", "Pear", "Strawberry"));
	// listPane.getChildren().add(listLbl);
	// listPane.getChildren().add(vegetables);
	// listPane.setVisible(false);
	//
	// componentLayout.setCenter(listPane);
	//
	// //The button uses an inner class to handle the button click event
	// Button vegFruitBut = new Button("Fruit or Veg");
	// vegFruitBut.setOnAction(new EventHandler() {
	//
	// @Override
	// public void handle(Event event) {
	// //switch the visibility for each FlowPane
	// choicePane.setVisible(!choicePane.isVisible());
	// listPane.setVisible(!listPane.isVisible());
	// }
	// });
	//
	// componentLayout.setBottom(vegFruitBut);
	//
	// //Add the BorderPane to the Scene
	// Scene appScene = new Scene(componentLayout,500,500);
	//
	// //Add the Scene to the Stage
	// primaryStage.setScene(appScene);
	// primaryStage.show();
	// }

	public static synchronized void removeDamageAnimationLater(StackPane p,
			DamageNumberAnimation dna) {
		Platform.runLater(() -> {
			if (p.getChildrenUnmodifiable().contains(dna)) {
				p.getChildren().remove(dna);
			}
		});
	}
}
