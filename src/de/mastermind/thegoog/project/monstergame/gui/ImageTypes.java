package de.mastermind.thegoog.project.monstergame.gui;

import de.mastermind.thegoog.project.monstergame.monsters.AppearanceTypes;
import javafx.scene.image.Image;

public class ImageTypes {

	public static Image getImageFromAppearance(AppearanceTypes at) {
		Image img = null;
		switch(at) {
		case Standard_Type:
			img = null;
			break;
		case Alternative_Type:
			img = null;
			break;
		case Spawner_Type:
			img = null;
			break;
		case Boss_Type:
			img = null;
			break;
		case SpawnerBoss_Type:
			img = null;
			break;
		case Invisible:
			img = null;
			break;
		default:
			break;
		}
		
		if(img != null) {
			return img;
		} else {
			throw new IllegalArgumentException("No valid AppearanceType was given!");
		}
	}
}
