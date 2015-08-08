package de.mastermind.thegoog.project.monstergame.monsters;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */

public class Monsters {
	
	private boolean isBoss;
	
	private long health;
	private long damage;
	
	private ElementTypes element;
	
	
	/**
	 *  Sets the Damage the Monster will inflict upon the Player
	 * @param dmg
	 */
	public void setDamage(long dmg){
		damage = dmg;
	}
	
	
	/**
	 * Returns the Damage Value the Monster can inflict upon the Player
	 * @return Damage Value of the Monster
	 */
	public long getDamage(){
		return damage;
	}
	
	
	/**
	 *  Sets the Amount of HealthPoints of the Monster
	 * @param life
	 */
	public void setLife(long life){
		health = life;
	}
	
	/**
	 * Applies Damage TAKEN BY THE MONSTER to its HealthPoints
	 * @param dmg
	 */
	public void applyDamage(long dmg){
		health = health - dmg;
	}
	
	/**
	 * Returns the ElementType of the Monster
	 * @return ElementType
	 */
	public ElementTypes getElementType(){
		return element;
	}
	
	/**
	 * Returns true if Monster is Boss
	 * @return isBossMonster
	 */
	public boolean isBossMonster(){
		return isBoss;
	}
	

	//TODO Think of more Methods required of Monsters.
	
	
	
}
