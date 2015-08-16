package de.mastermind.thegoog.project.monstergame.gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class StartMenuGUI {

	JFrame mainFrame;
	JPanel panel;
	JButton newGame;
	JButton loadGame;
	JButton exit;
	JLabel bckgrndImage;
	BufferedImage image;
	public StartMenuGUI(){
		init();
	}
	
	private void init(){
	      try {                
	          image = ImageIO.read(new File("Monster-Game-Title-Screen.png"));
	       } catch (IOException ex) {
	           ex.printStackTrace();
	       }
	      
		mainFrame = new JFrame("Monster Game");
		mainFrame.setSize(500, 500);
		mainFrame.setLocation(350, 150);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		
		JLabel bimage = new JLabel(new ImageIcon(image));
		
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		newGame = new JButton("New Game");
		loadGame =  new JButton("Load Game");
		exit = new JButton("Exit Game");
		
		
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = c.PAGE_START;
		panel.add(newGame,c);
		c.anchor = c.CENTER;
		c.gridy = c.RELATIVE;
		panel.add(loadGame,c);
		c.anchor = c.PAGE_END;
		panel.add(exit,c);
		
		mainFrame.add(panel);
		mainFrame.add(bimage);
		mainFrame.setSize(499, 499);
		mainFrame.setSize(500, 500);
	}
	
}
