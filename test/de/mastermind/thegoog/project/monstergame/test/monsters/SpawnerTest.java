package de.mastermind.thegoog.project.monstergame.test.monsters;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.mastermind.thegoog.project.monstergame.monsters.AppearanceTypes;
import de.mastermind.thegoog.project.monstergame.monsters.ElementTypes;
import de.mastermind.thegoog.project.monstergame.monsters.Monsters;
import de.mastermind.thegoog.project.monstergame.monsters.Spawner;

@RunWith(JUnit4.class)
public class SpawnerTest {

	private static Spawner s;

	@Before
	public void initSpawner() {
		s = new Spawner(100, 10, ElementTypes.Air_Type, false, 3, true, 150);
	}

	@Test
	public void spawner_SameAttributesPersistance() {
		Spawner spawner = new Spawner(100, 10, ElementTypes.Air_Type, false, 3,
				true, 150);
		assertTrue(s.equals(spawner));
	}

	@Test
	public void spawner_InRangeInput() {
		Spawner spawner = null;
		spawner = new Spawner(1, 1, ElementTypes.Fire_Type, false, 1, true, 150);
		assertNotNull(spawner);
	}

	@Test
	public void isOneTimeSpawner_Persistance() {
		Random ran = new Random();
		boolean before = s.isOneTimeSpawner();
		boolean after = true;
		int end = ran.nextInt(10000);

		for (int i = 0; i < end; i++) {
			after = s.isOneTimeSpawner();
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	public void isOneTimeSpawner_True() {
		Spawner spawner = new Spawner(1, 1, ElementTypes.Water_Type, false, 1,
				false, 1);
		assertTrue(spawner.isOneTimeSpawner());
	}

	@Test
	public void isOneTimeSpawner_False() {
		Spawner spawner = new Spawner(1, 1, ElementTypes.Water_Type, false, 1,
				true, 1);
		assertFalse(spawner.isOneTimeSpawner());
	}

	@Ignore
	// Test
	public void spawnMonsters_working() {
		List<Monsters> l = s.getMonsters();
		// Initial status: 0 Monsters
		assertEquals(0, l.size(), 0);

		s.spawnMonsters();
		l = s.getMonsters();
		assertEquals(3, l.size(), 0);
	}

	@Ignore
	// Test
	public void spawnMonsters_CountPersistance() {
		Random ran = new Random();
		List<Monsters> l = s.getMonsters();
		int end = ran.nextInt(10000);

		for (int i = 0; i < end; i++) {
			s.spawnMonsters();
			l = s.getMonsters();
		}
		assertEquals(3, l.size(), 0);
	}

	@Ignore
	// Test
	public void getMonsters_Persistance() {
		Random ran = new Random();
		s.spawnMonsters();
		List<Monsters> before = s.getMonsters();
		List<Monsters> after = null;
		int end = ran.nextInt(10000);

		for (int i = 0; i < end; i++) {
			after = s.getMonsters();
			if (!before.equals(after)) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getElementType_Persistance() {
		Random ran = new Random();
		int end = ran.nextInt(10000);
		ElementTypes before = s.getElementType();
		ElementTypes after = null;

		for (int i = 0; i < end; i++) {
			after = s.getElementType();
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void applyDamage_InRangeInput() {
		Random ran = new Random();
		long dmg = (long) ran.nextInt(100);
		long health = 100 - dmg;
		s.applyDamage(dmg);
		assertEquals(health, s.getLife());
	}

	@Test(expected = IllegalArgumentException.class)
	public void applyDamage_OutOfRange() {
		Random ran = new Random();
		long dmg = 0;

		while (dmg >= 0) {
			dmg = (long) (ran.nextInt() * (-1));
		}

		s.applyDamage(dmg);
	}

	@Test
	public void applyDamage_SpawnerDies() {
		AppearanceTypes dead = AppearanceTypes.Invisible;
		long dmg = s.getLife();
		s.applyDamage(dmg);
		assertEquals(dead, s.getAppearance());
	}

	@Test
	public void getAppearance_Persistance() {
		Random ran = new Random();
		AppearanceTypes before = s.getAppearance();
		AppearanceTypes after = null;
		int end = ran.nextInt(10000);

		for (int i = 0; i < end; i++) {
			after = s.getAppearance();
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void setAppearance_StandardType() {
		s.setAppearance(AppearanceTypes.Standard_Type);
		assertEquals(AppearanceTypes.Standard_Type, s.getAppearance());
	}

	@Test
	public void setAppearance_Alternative_Type() {
		s.setAppearance(AppearanceTypes.Alternative_Type);
		assertEquals(AppearanceTypes.Alternative_Type, s.getAppearance());
	}

	@Test
	public void setAppearance_Boss_Type() {
		s.setAppearance(AppearanceTypes.Boss_Type);
		assertEquals(AppearanceTypes.Boss_Type, s.getAppearance());
	}

	@Test
	public void setAppearance_Spawner_Type() {
		s.setAppearance(AppearanceTypes.Spawner_Type);
		assertEquals(AppearanceTypes.Spawner_Type, s.getAppearance());
	}

	@Test
	public void setAppearance_SpawnerBoss_Type() {
		s.setAppearance(AppearanceTypes.SpawnerBoss_Type);
		assertEquals(AppearanceTypes.SpawnerBoss_Type, s.getAppearance());
	}

	@Test
	public void setAppearance_Invisible() {
		s.setAppearance(AppearanceTypes.Invisible);
		assertEquals(AppearanceTypes.Invisible, s.getAppearance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void setAppearance_Null() {
		s.setAppearance(null);
	}

	@Test
	public void setBounty_InRangeInput() {
		s.setBounty(666);
		long after = s.getBounty();
		assertEquals(666, after);
	}

	@Test
	public void getBounty_Persistance() {
		Random ran = new Random();
		int end = ran.nextInt(10000);
		long bountyBefore = s.getBounty();
		long bountyAfter = 0;

		for (int i = 0; i < end; i++) {
			bountyAfter = s.getBounty();
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
		s.setBounty(bounty);
	}

	@Test
	public void setDamage_InRangeInput() {
		Random ran = new Random();
		long dmg = 0;

		while (dmg <= 0) {
			dmg = (long) ran.nextInt();
		}

		s.setDamage(dmg);
		assertEquals(dmg, s.getDamage());
	}

	@Test
	public void getDamage_Persistance() {
		Random ran = new Random();
		int end = ran.nextInt(10000);
		long damageBefore = s.getDamage();
		long damageAfter = 0;

		for (int i = 0; i < end; i++) {
			damageAfter = s.getDamage();
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

		s.setDamage(dmg);
	}

	@Test
	public void setLife_InRangeInput() {
		Random ran = new Random();
		long health = 0;

		while (health < 0) {
			health = (long) ran.nextInt();
		}

		s.setLife(health);
		assertEquals(health, s.getLife());
	}

	@Test
	public void getLife_Persistance() {
		Random ran = new Random();
		int end = ran.nextInt(10000);
		long lifeBefore = s.getLife();
		long lifeAfter = 0;

		for (int i = 0; i < end; i++) {
			lifeAfter = s.getLife();
			if (lifeBefore != lifeAfter) {
				fail();
			}
		}
		assertEquals(lifeBefore, lifeAfter);
	}

	@Test
	public void setLife_SpawnerDies() {
		AppearanceTypes dead = AppearanceTypes.Invisible;
		s.setLife(0);
		assertEquals(dead, s.getAppearance());
	}

	@Test
	public void getVisability_True() {
		Spawner s = new Spawner(1, 1, ElementTypes.Air_Type, false, 3, true, 1);
		assertTrue(s.getVisibility());
	}

	@Test
	public void getVisability_False() {
		Spawner s = new Spawner(1, 1, ElementTypes.Air_Type, false, 3, false, 1);
		assertFalse(s.getVisibility());
	}

	@Test
	public void getVisability_Persistance() {
		Random ran = new Random();
		Spawner s = new Spawner(1, 1, ElementTypes.Air_Type, false, 3, true, 1);
		boolean before = s.getVisibility();
		boolean after = false;
		int end = ran.nextInt(10000);

		for (int i = 0; i < end; i++) {
			after = s.getVisibility();
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test
	public void isBossSpawner_Persistance() {
		Random ran = new Random();
		boolean before = s.isBossSpawner();
		boolean after = true;
		int end = ran.nextInt(10000);

		for (int i = 0; i < end; i++) {
			after = s.isBossSpawner();
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test
	public void isBossSpawner_True() {
		Spawner spawner = new Spawner(1, 1, ElementTypes.Air_Type, true, 3,
				true, 1);
		assertTrue(spawner.isBossSpawner());
	}

	@Test
	public void isBossSpawner_False() {
		Spawner spawner = new Spawner(1, 1, ElementTypes.Air_Type, false, 3,
				true, 1);
		assertFalse(spawner.isBossSpawner());
	}

	// TODO equals testen
}
