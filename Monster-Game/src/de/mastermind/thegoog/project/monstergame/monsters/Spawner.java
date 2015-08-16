package de.mastermind.thegoog.project.monstergame.monsters;

import java.util.LinkedList;
import java.util.Random;

import de.mastermind.thegoog.project.monstergame.item.Items;
import de.mastermind.thegoog.project.monstergame.utils.Utils;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */

public class Spawner extends Monsters {

	private int maximumMonsters = 0;

	private boolean continuousSpawning = false;
	// private boolean isVisible;

	private LinkedList<Monsters> monsterList = new LinkedList<Monsters>();

	/**
	 * Initializes a new Spawner that can spawn Monsters frequently or
	 * one-time-only
	 * 
	 * @param initHealth
	 * @param initDamage
	 * @param initElement
	 * @param initIsBoss
	 * @param initMaximumMonsters
	 * @param initContinousSpawning
	 * @param initBounty
	 */
	public Spawner(long initHealth, long initDamage, ElementTypes initElement,
			boolean initIsBoss, int initMaximumMonsters,
			boolean initContinousSpawning, long initBounty) {

		super(initHealth, initDamage, initElement, initIsBoss,
				AppearanceTypes.Spawner_Type, initBounty);

		if (initMaximumMonsters <= 3 && initMaximumMonsters >= 0) {
			this.maximumMonsters = initMaximumMonsters;
		} else {
			throw new IllegalArgumentException(
					"Maximum Monsters too big or too small");
		}

		this.continuousSpawning = initContinousSpawning;
		// this.isVisible = initIsVisible;

		if (this.isOneTimeSpawner()) {
			super.setAppearance(AppearanceTypes.Invisible);
		} else {
			if (this.isBossSpawner()) {
				Random ran = new Random();
				super.setAppearance(AppearanceTypes.getBosses(ran.nextInt(2)));
			}
		}
	}

	/**
	 * Applies Damage TAKEN BY THE SPAWNER to its HealthPoints
	 */
	public void applyDamage(long dmg) {
		if (dmg < 0) {
			throw new IllegalArgumentException();
		} else {
			super.applyDamage(dmg);
		}
	}

	/**
	 * Sets the Bounty of the Spawner
	 * 
	 * @param bounty
	 */
	public void setBounty(long bounty) {
		if (bounty < 0) {
			throw new IllegalArgumentException();
		} else {
			super.setBounty(bounty);
		}
	}

	/**
	 * Sets the Damage the Spawner will inflict upon the Player
	 * 
	 * @param dmg
	 */
	public void setDamage(long dmg) {
		if (dmg < 0) {
			throw new IllegalArgumentException();
		} else {
			super.setDamage(dmg);
		}
	}

	/**
	 * Sets the Amount of HealthPoints of the Spawner
	 * 
	 * @param life
	 */
	public void setLife(long life) {
		if (life < 0) {
			throw new IllegalArgumentException();
		} else {
			super.setLife(life);
		}
	}

	/**
	 * Sets the AppearanceTypes of the Spawner
	 * 
	 * @param appearance
	 */
	public void setAppearance(AppearanceTypes appearance) {
		if (appearance != null) {
			super.setAppearance(appearance);
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Returns AppearanceTypes of the Monster
	 * 
	 * @return appearance
	 */
	public AppearanceTypes getAppearance() {
		return super.getAppearance();
	}

	/**
	 * Returns the Bounty of the Spawner
	 * 
	 * @return bounty
	 */
	public long getBounty() {
		return super.getBounty();
	}

	/**
	 * Return the remaining Health of the Monster
	 * 
	 * @return health
	 */
	public long getLife() {
		return super.getLife();
	}

	/**
	 * Returns the Damage Value the Spawner can inflict upon the Player
	 * 
	 * @return Damage Value of the Monster
	 */
	public long getDamage() {
		return super.getDamage();
	}

	/**
	 * Return ArrayList of all Monsters dominated by the Spawner
	 * 
	 * @return monsterList
	 */
	public LinkedList<Monsters> getMonsters() {
		return monsterList;
	}

	/**
	 * Returns true if Spawner is Visible
	 * 
	 * @return isVisible
	 */
	public boolean getVisibility() {
		// return isVisible;
		return super.getAppearance() == AppearanceTypes.Invisible ? false
				: true;
	}

	/**
	 * Returns the ElementType of the Spawner
	 * 
	 * @return ElementType
	 */
	public ElementTypes getElementType() {
		return super.getElementType();
	}

	/**
	 * Returns true if Spawner is just to initialize Monsters
	 * 
	 * @return continousSpawning
	 */
	public boolean isOneTimeSpawner() {
		return !continuousSpawning;
	}

	/**
	 * Lets the Spawner spawn Monsters if not already maximum Count
	 */
	public void spawnMonsters() {
		int monsterCount = monsterList.size();

		if (monsterCount < maximumMonsters) {
			Random ran = new Random();
			int counter = maximumMonsters - monsterCount;

			do {
				Monsters tmp = new Monsters(
						Utils.getMonsterHealth(false, false),
						Utils.getMonsterDamage(false, false),
						ElementTypes.get(ran.nextInt(4)), false,
						AppearanceTypes.getMonsters(ran.nextInt(2)),
						Utils.getMonsterBounty(false, false));

				monsterList.add(tmp);
				counter--;
			} while (counter > 0);
		}
	}

	/**
	 * Returns true if Spawner is a Boss
	 * 
	 * @return isBoss
	 */
	public boolean isBossSpawner() {
		return super.isBossMonster();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Spawner s = (Spawner) obj;
		return (this.continuousSpawning == s.continuousSpawning)
				&& (this.maximumMonsters == s.maximumMonsters)
				&& (this.monsterList.equals(s.monsterList) && super.equals(s));
	}
}
