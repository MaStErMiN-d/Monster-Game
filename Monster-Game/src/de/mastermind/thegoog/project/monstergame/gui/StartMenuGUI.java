package de.mastermind.thegoog.project.monstergame.gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class StartMenuGUI extends JFrame {

	BufferedImage img;
	JFrame main;
	JPanel contentPane;
	JLabel bimg;

	JButton newGame;
	JButton loadGame;
	JButton exitGame;

	JPanel newGamePane;
	JPanel loadGamePane;
	JPanel exitGamePane;

	public StartMenuGUI() {

		try {
			img = ImageIO.read(new File("Monster-Game-Title-Screen.png"));
		} catch (IOException e) {
		}

		main = new JFrame();
		main.setSize(500, 500);
		main.setLocation(300, 150);
		main.setVisible(true);
		main.setDefaultCloseOperation(EXIT_ON_CLOSE);
		main.setTitle("Monster Game");

		bimg = new JLabel(new ImageIcon(img));
		bimg.setOpaque(false);
		contentPane = new JPanel();
		contentPane.add(bimg);

		newGamePane = new JPanel();
		newGamePane.setSize(20, 90);
		newGame = new JButton("New Game");
		newGame.setSize(20, 90);
		newGamePane.add(newGame);

		loadGamePane = new JPanel();
		loadGamePane.setSize(20, 90);
		loadGame = new JButton("Load Game");
		loadGame.setSize(20, 90);
		loadGamePane.add(loadGame);

		exitGamePane = new JPanel();
		exitGamePane.setSize(20, 90);
		exitGame = new JButton("Exit Game");
		exitGame.setSize(20, 90);
		exitGamePane.add(exitGame);

		contentPane.add(exitGamePane);
		contentPane.add(loadGamePane);
		contentPane.add(newGamePane);

		main.add(contentPane);
		// main.add(newGamePane);
		// main.add(loadGamePane);
		// main.add(exitGamePane);
	}

	public static void main(String[] args) {
		StartMenuGUI asdf = new StartMenuGUI();
	}
}
