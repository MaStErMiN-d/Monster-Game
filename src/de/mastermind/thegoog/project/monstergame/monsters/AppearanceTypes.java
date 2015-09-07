package de.mastermind.thegoog.project.monstergame.monsters;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */

public enum AppearanceTypes {

	Standard_Type, Alternative_Type, Boss_Type, Spawner_Type, SpawnerBoss_Type, Invisible;

	/**
	 * Returns the AppearanceType at Index, starting at 0
	 * 
	 * @param pos
	 * @return AppearanceTypes
	 */
	public static AppearanceTypes get(int pos) {
		AppearanceTypes answer;
		switch (pos) {
		case 0:
			answer = AppearanceTypes.Standard_Type;
			break;
		case 1:
			answer = AppearanceTypes.Alternative_Type;
			break;
		case 2:
			answer = AppearanceTypes.Boss_Type;
			break;
		case 3:
			answer = AppearanceTypes.Spawner_Type;
			break;
		case 4:
			answer = AppearanceTypes.SpawnerBoss_Type;
			break;
		case 5:
			answer = AppearanceTypes.Invisible;
			break;
		default:
			answer = null;
			break;
		}
		return answer;
	}

	/**
	 * Returns the AppearanceType for Monsters at Index, starting at 0
	 * 
	 * @param pos
	 * @return AppearanceTypes
	 */
	public static AppearanceTypes getMonsters(int pos) {
		AppearanceTypes monsterSkin;
		switch (pos) {
		case 0:
			monsterSkin = AppearanceTypes.Standard_Type;
			break;
		case 1:
			monsterSkin = AppearanceTypes.Alternative_Type;
			break;
		default:
			monsterSkin = null;
			break;
		}
		return monsterSkin;
	}

	/**
	 * Returns AppearanceType for Bosses at Index, starting at Index 0
	 * 
	 * @param pos
	 * @return AppearanceTypes
	 */
	public static AppearanceTypes getBosses(int pos) {
		AppearanceTypes bossSkin;
		switch (pos) {
		case 0:
			bossSkin = AppearanceTypes.Boss_Type;
			break;
		case 1:
			bossSkin = AppearanceTypes.SpawnerBoss_Type;
			break;
		default:
			bossSkin = null;
		}
		return bossSkin;
	}

}
