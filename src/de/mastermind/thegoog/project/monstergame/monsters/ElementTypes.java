/**
 * 
 */
package de.mastermind.thegoog.project.monstergame.monsters;

/**
 * @author Michael Zigldrum
 * @author Andreas Knipl
 * 
 */
public enum ElementTypes {

	Water_Type, Fire_Type, Earth_Type, Air_Type;

	/**
	 * Returns ElementType by Index, starting at 0
	 * 
	 * @param pos
	 * @return ElementTypes
	 */
	public static ElementTypes get(int pos) {
		ElementTypes elem;
		switch (pos) {
		case 0:
			elem = ElementTypes.Air_Type;
			break;
		case 1:
			elem = ElementTypes.Earth_Type;
			break;
		case 2:
			elem = ElementTypes.Fire_Type;
			break;
		case 3:
			elem = ElementTypes.Water_Type;
			break;
		default:
			elem = null;
			break;
		}
		return elem;
	}
}
