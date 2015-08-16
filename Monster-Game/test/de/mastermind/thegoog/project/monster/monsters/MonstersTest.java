package de.mastermind.thegoog.project.monster.monsters;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.mastermind.thegoog.project.monstergame.monsters.AppearanceTypes;
import de.mastermind.thegoog.project.monstergame.monsters.ElementTypes;
import de.mastermind.thegoog.project.monstergame.monsters.Monsters;

@RunWith(JUnit4.class)
public class MonstersTest {

	private static Monsters m;

	@Before
	public void initMonsters() {
		m = new Monsters(100, 10, ElementTypes.Air_Type, false,
				AppearanceTypes.Standard_Type, 150);
	}

	@Test
	public void monsters_SameAttributesPersistance() {
		Monsters monster = new Monsters(100, 10, ElementTypes.Air_Type, false,
				AppearanceTypes.Standard_Type, 150);
		assertTrue(m.equals(monster));
	}

	@Test
	public void monsters_InRangeInput() {
		Monsters monster = null;
		monster = new Monsters(1, 1, ElementTypes.Air_Type, false,
				AppearanceTypes.Alternative_Type, 1);
		assertNotNull(monster);
	}

	@Test
	public void monsters_Persistance() {
		Monsters monsterBefore = new Monsters(100, 10, ElementTypes.Air_Type,
				false, AppearanceTypes.Standard_Type, 150);
		Monsters monsterAfter = new Monsters(100, 10, ElementTypes.Air_Type,
				false, AppearanceTypes.Standard_Type, 150);
		Random ran = new Random();
		int end = ran.nextInt(10000);

		for (int i = 0; i < end; i++) {
			monsterAfter = new Monsters(100, 10, ElementTypes.Air_Type, false,
					AppearanceTypes.Standard_Type, 150);
		}
		assertTrue(monsterBefore.getAppearance() == monsterAfter
				.getAppearance() ? true : false);
		assertTrue(monsterBefore.getBounty() == monsterAfter.getBounty() ? true
				: false);
		assertTrue(monsterBefore.getDamage() == monsterAfter.getDamage() ? true
				: false);
		assertTrue(monsterBefore.getElementType() == monsterAfter
				.getElementType() ? true : false);
		assertTrue(monsterBefore.getLife() == monsterAfter.getLife() ? true
				: false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void monsters_HealthLessOrEqualToZero() {
		new Monsters(0, 10, ElementTypes.Air_Type, false,
				AppearanceTypes.Standard_Type, 150);
	}

	@Test(expected = IllegalArgumentException.class)
	public void monsters_DamageLessOrEqualToZero() {
		new Monsters(100, 0, ElementTypes.Air_Type, false,
				AppearanceTypes.Standard_Type, 150);
	}

	@Test(expected = IllegalArgumentException.class)
	public void monsters_AppearanceIsNull() {
		new Monsters(100, 10, ElementTypes.Fire_Type, false, null, 150);
	}

	@Test(expected = IllegalArgumentException.class)
	public void monsters_BountyLessThanZero() {
		new Monsters(100, 10, ElementTypes.Air_Type, false,
				AppearanceTypes.Standard_Type, -1);
	}

	@Test
	public void setBounty_InRangeInput() {
		m.setBounty(666);
		long after = m.getBounty();
		assertEquals(666, after);
	}

	@Test
	public void getBounty_Persistance() {
		Random ran = new Random();
		int end = ran.nextInt(10000);
		long bountyBefore = m.getBounty();
		long bountyAfter = 0;

		for (int i = 0; i < end; i++) {
			bountyAfter = m.getBounty();
			if (bountyBefore != bountyAfter) {
				fail();
			}
		}
		assertEquals(bountyBefore, bountyAfter);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setBounty_LessThanZero() {
		Random ran = new Random();
		long bounty = 0;
		while (bounty >= 0) {
			bounty = (long) (ran.nextInt() * (-1));
		}
		m.setBounty(bounty);
	}

	@Test
	public void setAppearance_StandardType() {
		m.setAppearance(AppearanceTypes.Standard_Type);
		assertEquals(AppearanceTypes.Standard_Type, m.getAppearance());
	}

	@Test
	public void setAppearance_Alternative_Type() {
		m.setAppearance(AppearanceTypes.Alternative_Type);
		assertEquals(AppearanceTypes.Alternative_Type, m.getAppearance());
	}

	@Test
	public void setAppearance_Boss_Type() {
		m.setAppearance(AppearanceTypes.Boss_Type);
		assertEquals(AppearanceTypes.Boss_Type, m.getAppearance());
	}

	@Test
	public void setAppearance_Spawner_Type() {
		m.setAppearance(AppearanceTypes.Spawner_Type);
		assertEquals(AppearanceTypes.Spawner_Type, m.getAppearance());
	}

	@Test
	public void setAppearance_SpawnerBoss_Type() {
		m.setAppearance(AppearanceTypes.SpawnerBoss_Type);
		assertEquals(AppearanceTypes.SpawnerBoss_Type, m.getAppearance());
	}

	@Test
	public void setAppearance_Invisible() {
		m.setAppearance(AppearanceTypes.Invisible);
		assertEquals(AppearanceTypes.Invisible, m.getAppearance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void setAppearance_Null() {
		m.setAppearance(null);
	}

	@Test
	public void getAppearance_Persistance() {
		Random ran = new Random();
		int end = ran.nextInt(10000);
		AppearanceTypes appearanceBefore = m.getAppearance();
		AppearanceTypes appearanceAfter = null;

		for (int i = 0; i < end; i++) {
			appearanceAfter = m.getAppearance();
			if (appearanceBefore != appearanceAfter) {
				fail();
			}
		}
		assertEquals(appearanceBefore, appearanceAfter);
	}

	@Test
	public void setDamage_InRangeInput() {
		Random ran = new Random();
		long dmg = 0;

		while (dmg <= 0) {
			dmg = (long) ran.nextInt();
		}

		m.setDamage(dmg);
		assertEquals(dmg, m.getDamage());
	}

	@Test
	public void getDamage_Persistance() {
		Random ran = new Random();
		int end = ran.nextInt(10000);
		long damageBefore = m.getDamage();
		long damageAfter = 0;

		for (int i = 0; i < end; i++) {
			damageAfter = m.getDamage();
			if (damageBefore != damageAfter) {
				fail();
			}
		}
		assertEquals(damageBefore, damageAfter);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setDamage_LessThanZero() {
		Random ran = new Random();
		long dmg = 5;

		while (dmg > 0) {
			dmg = (long) (ran.nextInt() * (-1));
		}

		m.setDamage(dmg);
	}

	@Test
	public void setLife_InRangeInput() {
		Random ran = new Random();
		long health = 0;

		while (health < 0) {
			health = (long) ran.nextInt();
		}

		m.setLife(health);
		assertEquals(health, m.getLife());
	}

	@Test
	public void getLife_Persistance() {
		Random ran = new Random();
		int end = ran.nextInt(10000);
		long lifeBefore = m.getLife();
		long lifeAfter = 0;

		for (int i = 0; i < end; i++) {
			lifeAfter = m.getLife();
			if (lifeBefore != lifeAfter) {
				fail();
			}
		}
		assertEquals(lifeBefore, lifeAfter);
	}

	@Test
	public void setLife_MonsterDies() {
		AppearanceTypes dead = AppearanceTypes.Invisible;
		m.setLife(0);
		assertEquals(dead, m.getAppearance());
	}

	@Test
	public void applyDamage_InRangeInput() {
		Random ran = new Random();
		long dmg = (long) ran.nextInt(100);
		long health = 100 - dmg;
		m.applyDamage(dmg);
		assertEquals(health, m.getLife());
	}

	@Test(expected = IllegalArgumentException.class)
	public void applyDamage_OutOfRange() {
		Random ran = new Random();
		long dmg = 0;

		while (dmg >= 0) {
			dmg = (long) (ran.nextInt() * (-1));
		}

		m.applyDamage(dmg);
	}

	@Test
	public void applyDamage_MonsterDies() {
		AppearanceTypes dead = AppearanceTypes.Invisible;
		long dmg = m.getLife();
		m.applyDamage(dmg);
		assertEquals(dead, m.getAppearance());
	}

	@Test
	public void isBossMonster_Persistance() {
		Random ran = new Random();
		int end = ran.nextInt(10000);
		boolean isBossMonsterBefore = m.isBossMonster();
		boolean isBossMonsterAfter = false;

		for (int i = 0; i < end; i++) {
			isBossMonsterAfter = m.isBossMonster();
			if (isBossMonsterAfter != isBossMonsterBefore) {
				fail();
			}
		}
		assertTrue(isBossMonsterAfter == isBossMonsterBefore ? true : false);
	}

	@Test
	public void isBossMonster_True() {
		Monsters tmp = new Monsters(100, 10, ElementTypes.Air_Type, true,
				AppearanceTypes.Boss_Type, 250);
		assertTrue(tmp.isBossMonster());
	}

	@Test
	public void isBossMonster_False() {
		Monsters tmp = new Monsters(100, 10, ElementTypes.Air_Type, false,
				AppearanceTypes.Standard_Type, 100);
		assertFalse(tmp.isBossMonster());
	}

	@Test
	public void getElementType_Persistance() {
		Random ran = new Random();
		ElementTypes before = m.getElementType();
		ElementTypes after = null;
		int end = ran.nextInt(10000);

		for (int i = 0; i < end; i++) {
			after = m.getElementType();
			if (after != before) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	// TODO equals testen
}
