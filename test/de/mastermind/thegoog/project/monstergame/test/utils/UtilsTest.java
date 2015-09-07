package de.mastermind.thegoog.project.monstergame.test.utils;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.mastermind.thegoog.project.monstergame.monsters.Player;
import de.mastermind.thegoog.project.monstergame.utils.Utils;

/**
 * 
 * @author Michael Zigldrum
 * @author Andreas Knipl
 *
 */

@RunWith(JUnit4.class)
public class UtilsTest {

	@Test
	public void level() {
		Random ran = new Random();
		long level = ran.nextLong();
		Utils.setLevel(level);
		assertEquals(level, Utils.getLevel(), 0);
	}

	@Test
	public void levelUpdated_True() {
		Utils.setLevelUpdated(true);
		assertTrue(Utils.getLevelUpdated());
	}

	@Test
	public void levelUpdated_False() {
		Utils.setLevelUpdated(false);
		assertFalse(Utils.getLevelUpdated());
	}

	@Test
	public void upgradesUpdated_True() {
		Utils.setUpgrades(true);
		assertTrue(Utils.getUpgradesSet());
	}

	@Test
	public void upgradesUpdated_False() {
		Utils.setUpgrades(false);
		assertFalse(Utils.getUpgradesSet());
	}

	@Test
	public void itemsUpdated_True() {
		Utils.setItems(true);
		assertTrue(Utils.getItemsSet());
	}

	@Test
	public void itemsUpdated_False() {
		Utils.setItems(false);
		assertFalse(Utils.getItemsSet());
	}

	@Test
	public void elementalDamageUpdated_Air_True() {
		Utils.setElementalDamageUpdated_Air(true);
		assertTrue(Utils.getElementalDamageUpdated_Air());
	}

	@Test
	public void elementalDamageUpdated_Air_False() {
		Utils.setElementalDamageUpdated_Air(false);
		assertFalse(Utils.getElementalDamageUpdated_Air());
	}

	@Test
	public void elementalDamageUpdated_Water_True() {
		Utils.setElementalDamageUpdated_Water(true);
		assertTrue(Utils.getElementalDamageUpdated_Water());
	}

	@Test
	public void elementalDamageUpdated_Water_False() {
		Utils.setElementalDamageUpdated_Water(false);
		assertFalse(Utils.getElementalDamageUpdated_Water());
	}

	@Test
	public void elementalDamageUpdated_Earth_True() {
		Utils.setElementalDamageUpdated_Earth(true);
		assertTrue(Utils.getElementalDamageUpdated_Earth());
	}

	@Test
	public void elementalDamageUpdated_Earth_False() {
		Utils.setElementalDamageUpdated_Earth(false);
		assertFalse(Utils.getElementalDamageUpdated_Earth());
	}

	@Test
	public void elementalDamageUpdated_Fire_True() {
		Utils.setElementalDamageUpdated_Fire(true);
		assertTrue(Utils.getElementalDamageUpdated_Fire());
	}

	@Test
	public void elementalDamageUpdated_Fire_False() {
		Utils.setElementalDamageUpdated_Fire(false);
		assertFalse(Utils.getElementalDamageUpdated_Fire());
	}

	@Test
	public void lifeUpdated_True() {
		Utils.setLifeUpdated(true);
		assertTrue(Utils.getLifeUpdated());
	}

	@Test
	public void lifeUpdated_False() {
		Utils.setLifeUpdated(false);
		assertFalse(Utils.getLifeUpdated());
	}

	@Test
	public void monsterLifeUpdated_True() {
		Utils.setMonsterLifeUpdated(true);
		assertTrue(Utils.getMonsterLifeUpdated());
	}

	@Test
	public void monsterLifeUpdated_False() {
		Utils.setMonsterLifeUpdated(false);
		assertFalse(Utils.getMonsterLifeUpdated());
	}

	@Test
	public void clickDamageUpdated_True() {
		Utils.setClickDamageUpdated(true);
		assertTrue(Utils.getClickDamageUpdated());
	}

	@Test
	public void clickDamageUpdated_False() {
		Utils.setClickDamageUpdated(false);
		assertFalse(Utils.getClickDamageUpdated());
	}

	@Test
	public void passiveDamageUpdated_True() {
		Utils.setPassiveDamageUpdated(true);
		assertTrue(Utils.getPassiveDamageUpdated());
	}

	@Test
	public void passiveDamageUpdated_False() {
		Utils.setPassiveDamageUpdated(false);
		assertFalse(Utils.getPassiveDamageUpdated());
	}

	@Test
	public void monsterDamageUpdated_True() {
		Utils.setMonsterDamageUpdated(true);
		assertTrue(Utils.getMonsterDamageUpdated());
	}

	@Test
	public void monsterDamageUpdated_False() {
		Utils.setMonsterDamageUpdated(false);
		assertFalse(Utils.getMonsterDamageUpdated());
	}

	@Test
	public void accountUpdated_True() {
		Utils.setAccountUpdated(true);
		assertTrue(Utils.getAccountUpdated());
	}

	@Test
	public void accountUpdated_False() {
		Utils.setAccountUpdated(false);
		assertFalse(Utils.getAccountUpdated());
	}

	@Test
	// 0 < MonsterHealthLevelBefore < MonsterHealthLevelAfter
	public void monsterHealthIncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(10000);
		}
		long before = 0;
		long after = 0;
		Player p = new Player(100, 10, 25);
		for (long i = 1; i < end; i++) {
			Utils.setLevelUpdated(true);
			p.setLevel(i);
			after = Utils.getMonsterHealth(false, false);
			if (after > before) {
				before = after;
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	// 0 < SpawnerHealthLevelBefore < SpawnerHealthLevelAfter
	public void spawnerHealthIncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(10000);
		}
		long before = 0;
		long after = 0;
		Player p = new Player(100, 10, 25);
		for (long i = 1; i < end; i++) {
			Utils.setLevelUpdated(true);
			p.setLevel(i);
			after = Utils.getMonsterHealth(false, true);
			if (after > before) {
				before = after;
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	// 0 < bossMonsterHealthLevelBefore < bossMonsterHealthLevelAfter
	public void bossMonsterHealthIncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(10000);
		}
		long before = 0;
		long after = 0;
		Player p = new Player(100, 10, 25);
		for (long i = 1; i < end; i++) {
			Utils.setLevelUpdated(true);
			p.setLevel(i);
			after = Utils.getMonsterHealth(true, false);
			if (after > before) {
				before = after;
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	// 0 < bossSpawnerHealthLevelBefore < bossSpawnerHealthLevelAfter
	public void bossSpawnerHealthIncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(10000);
		}
		long before = 0;
		long after = 0;
		Player p = new Player(100, 10, 25);
		for (long i = 1; i < end; i++) {
			Utils.setLevelUpdated(true);
			p.setLevel(i);
			after = Utils.getMonsterHealth(true, true);
			if (after > before) {
				before = after;
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void monsterHealthFalseLevel() {
		Player p = new Player(100, 10, 25);
		Utils.setLevelUpdated(true);
		p.setLevel(0);
		Utils.getMonsterHealth(false, false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void spawnerHealthFalseLevel() {
		Player p = new Player(100, 10, 25);
		Utils.setLevelUpdated(true);
		p.setLevel(0);
		Utils.getMonsterHealth(false, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void bossMonsterHealthFalseLevel() {
		Player p = new Player(100, 10, 25);
		Utils.setLevelUpdated(true);
		p.setLevel(0);
		Utils.getMonsterHealth(true, false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void bossSpawnerHealthFalseLevel() {
		Player p = new Player(100, 10, 25);
		Utils.setLevelUpdated(true);
		p.setLevel(0);
		Utils.getMonsterHealth(true, true);
	}

	@Ignore
	// Test // 0 < bossSpawnerDamageLevelBefore < bossSpawnerDamageLevelAfter
	public void monsterDamageIncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(10000);
		}
		long before = 0;
		long after = 0;
		Player p = new Player(100, 10, 25);
		for (long i = 1; i < end; i++) {
			Utils.setLevelUpdated(true);
			p.setLevel(i);
			after = Utils.getMonsterDamage(false, false);
			if (after > before) {
				before = after;
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Ignore
	// Test // 0 < bossSpawnerDamageLevelBefore < bossSpawnerDamageLevelAfter
	public void spawnerDamageIncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(10000);
		}
		long before = 0;
		long after = 0;
		Player p = new Player(100, 10, 25);
		for (long i = 1; i < end; i++) {
			Utils.setLevelUpdated(true);
			p.setLevel(i);
			after = Utils.getMonsterDamage(false, true);
			if (after > before) {
				before = after;
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Ignore
	// Test // 0 < bossSpawnerDamageLevelBefore < bossSpawnerDamageLevelAfter
	public void bossMonsterDamageIncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(10000);
		}
		long before = 0;
		long after = 0;
		Player p = new Player(100, 10, 25);
		for (long i = 1; i < end; i++) {
			Utils.setLevelUpdated(true);
			p.setLevel(i);
			after = Utils.getMonsterDamage(true, false);
			if (after > before) {
				before = after;
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Ignore
	// Test // 0 < bossSpawnerDamageLevelBefore < bossSpawnerDamageLevelAfter
	public void bossSpawnerDamageIncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(10000);
		}
		long before = 0;
		long after = 0;
		Player p = new Player(100, 10, 25);
		for (long i = 1; i < end; i++) {
			Utils.setLevelUpdated(true);
			p.setLevel(i);
			after = Utils.getMonsterDamage(true, true);
			if (after > before) {
				before = after;
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Ignore
	// Test(expected = IllegalArgumentException.class)
	public void monsterDamageFalseLevel() {
		Player p = new Player(100, 10, 25);
		Utils.setLevelUpdated(true);
		p.setLevel(0);
		Utils.getMonsterDamage(false, false);
	}

	@Ignore
	// Test(expected = IllegalArgumentException.class)
	public void spawnerDamageFalseLevel() {
		Player p = new Player(100, 10, 25);
		Utils.setLevelUpdated(true);
		p.setLevel(0);
		Utils.getMonsterDamage(false, true);
	}

	@Ignore
	// Test(expected = IllegalArgumentException.class)
	public void bossMonsterDamageFalseLevel() {
		Player p = new Player(100, 10, 25);
		Utils.setLevelUpdated(true);
		p.setLevel(0);
		Utils.getMonsterDamage(true, false);
	}

	@Ignore
	// Test(expected = IllegalArgumentException.class)
	public void bossSpawnerDamageFalseLevel() {
		Player p = new Player(100, 10, 25);
		Utils.setLevelUpdated(true);
		p.setLevel(0);
		Utils.getMonsterDamage(true, true);
	}

	@Test
	// 0 < monsterBountyLevelBefore < monsterBountyLevelAfter
	public void monsterBountyIncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(10000);
		}
		long before = 0;
		long after = 0;
		Player p = new Player(100, 10, 25);
		for (long i = 1; i < end; i++) {
			Utils.setLevelUpdated(true);
			p.setLevel(i);
			after = Utils.getMonsterBounty(false, false);
			if (after > before) {
				before = after;
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	// 0 < spawnerBountyLevelBefore < spawnerBountyLevelAfter
	public void spawnerBountyIncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(10000);
		}
		long before = 0;
		long after = 0;
		Player p = new Player(100, 10, 25);
		for (long i = 1; i < end; i++) {
			Utils.setLevelUpdated(true);
			p.setLevel(i);
			after = Utils.getMonsterBounty(false, true);
			if (after > before) {
				before = after;
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	// 0 < bossMonsterBountyLevelBefore < bossMonsterBountyLevelAfter
	public void bossMonsterBountyIncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(10000);
		}
		long before = 0;
		long after = 0;
		Player p = new Player(100, 10, 25);
		for (long i = 1; i < end; i++) {
			Utils.setLevelUpdated(true);
			p.setLevel(i);
			after = Utils.getMonsterBounty(true, false);
			if (after > before) {
				before = after;
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	// 0 < bossSpawnerBountyLevelBefore < bossSpawnerBountyLevelAfter
	public void bossSpawnerBountyIncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(10000);
		}
		long before = 0;
		long after = 0;
		Player p = new Player(100, 10, 25);
		for (long i = 1; i < end; i++) {
			Utils.setLevelUpdated(true);
			p.setLevel(i);
			after = Utils.getMonsterBounty(true, true);
			if (after > before) {
				before = after;
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void monsterBountyFalseLevel() {
		Player p = new Player(100, 10, 25);
		Utils.setLevelUpdated(true);
		p.setLevel(0);
		Utils.getMonsterBounty(false, false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void spawnerBountyFalseLevel() {
		Player p = new Player(100, 10, 25);
		Utils.setLevelUpdated(true);
		p.setLevel(0);
		Utils.getMonsterBounty(false, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void bossMonsterBountyFalseLevel() {
		Player p = new Player(100, 10, 25);
		Utils.setLevelUpdated(true);
		p.setLevel(0);
		Utils.getMonsterBounty(true, false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void bossSpawnerBountyFalseLevel() {
		Player p = new Player(100, 10, 25);
		Utils.setLevelUpdated(true);
		p.setLevel(0);
		Utils.getMonsterBounty(true, true);
	}

	@Test
	public void getLevel_Persistance() {
		Random ran = new Random();
		Player p = new Player(1, 1, 1);
		Utils.setLevelUpdated(true);
		p.setLevel(42);
		long before = Utils.getLevel();
		;
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getLevel();
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getAccountUpdated_Persistance() {
		Random ran = new Random();
		Utils.setAccountUpdated(true);
		boolean before = Utils.getAccountUpdated();
		boolean after = false;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getAccountUpdated();
			if (before != after) {
				fail();
			}
		}
		Utils.setAccountUpdated(false);
		assertEquals(before, after);
	}

	@Test
	public void getMonsterLifeUpdated_Persistance() {
		Random ran = new Random();
		Utils.setMonsterLifeUpdated(true);
		boolean before = Utils.getMonsterLifeUpdated();
		boolean after = false;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getMonsterLifeUpdated();
			if (before != after) {
				fail();
			}
		}
		Utils.setMonsterLifeUpdated(false);
		assertEquals(before, after);
	}

	@Test
	public void getLifeUpdated_Persistance() {
		Random ran = new Random();
		Utils.setLifeUpdated(true);
		boolean before = Utils.getLifeUpdated();
		boolean after = false;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getLifeUpdated();
			if (before != after) {
				fail();
			}
		}
		Utils.setLifeUpdated(false);
		assertEquals(before, after);
	}

	@Test
	public void getClickDamageUpdated_Persistance() {
		Random ran = new Random();
		Utils.setClickDamageUpdated(true);
		boolean before = Utils.getClickDamageUpdated();
		boolean after = false;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getClickDamageUpdated();
			if (before != after) {
				fail();
			}
		}
		Utils.setClickDamageUpdated(false);
		assertEquals(before, after);
	}

	@Test
	public void getPassiveDamageUpdated_Persistance() {
		Random ran = new Random();
		Utils.setPassiveDamageUpdated(true);
		boolean before = Utils.getPassiveDamageUpdated();
		boolean after = false;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getPassiveDamageUpdated();
			if (before != after) {
				fail();
			}
		}
		Utils.setPassiveDamageUpdated(false);
		assertEquals(before, after);
	}

	@Test
	public void getMonsterDamageUpdated_Persistance() {
		Random ran = new Random();
		Utils.setMonsterDamageUpdated(true);
		boolean before = Utils.getMonsterDamageUpdated();
		boolean after = false;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getMonsterDamageUpdated();
			if (before != after) {
				fail();
			}
		}
		Utils.setMonsterDamageUpdated(false);
		assertEquals(before, after);
	}

	@Test
	public void getElementalDamageUpdated_Air_Persistance() {
		Random ran = new Random();
		Utils.setElementalDamageUpdated_Air(true);
		boolean before = Utils.getElementalDamageUpdated_Air();
		boolean after = false;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getElementalDamageUpdated_Air();
			if (before != after) {
				fail();
			}
		}
		Utils.setElementalDamageUpdated_Air(false);
		assertEquals(before, after);
	}

	@Test
	public void getElementalDamageUpdated_Water_Persistance() {
		Random ran = new Random();
		Utils.setElementalDamageUpdated_Water(true);
		boolean before = Utils.getElementalDamageUpdated_Water();
		boolean after = false;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getElementalDamageUpdated_Water();
			if (before != after) {
				fail();
			}
		}
		Utils.setElementalDamageUpdated_Water(false);
		assertEquals(before, after);
	}

	@Test
	public void getElementalDamageUpdated_Earth_Persistance() {
		Random ran = new Random();
		Utils.setElementalDamageUpdated_Earth(true);
		boolean before = Utils.getElementalDamageUpdated_Earth();
		boolean after = false;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getElementalDamageUpdated_Earth();
			if (before != after) {
				fail();
			}
		}
		Utils.setElementalDamageUpdated_Earth(false);
		assertEquals(before, after);
	}

	@Test
	public void getElementalDamageUpdated_Fire_Persistance() {
		Random ran = new Random();
		Utils.setElementalDamageUpdated_Fire(true);
		boolean before = Utils.getElementalDamageUpdated_Fire();
		boolean after = false;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getElementalDamageUpdated_Fire();
			if (before != after) {
				fail();
			}
		}
		Utils.setElementalDamageUpdated_Fire(false);
		assertEquals(before, after);
	}

	@Test
	public void getUpgradesSet_Persistance() {
		Random ran = new Random();
		Utils.setUpgrades(true);
		boolean before = Utils.getUpgradesSet();
		boolean after = false;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getUpgradesSet();
			if (before != after) {
				fail();
			}
		}
		Utils.setUpgrades(false);
		assertEquals(before, after);
	}

	@Test
	public void getItemsSet_Persistance() {
		Random ran = new Random();
		Utils.setItems(true);
		boolean before = Utils.getItemsSet();
		boolean after = false;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getItemsSet();
			if (before != after) {
				fail();
			}
		}
		Utils.setItems(false);
		assertEquals(before, after);
	}

	@Test
	public void getLevelUpdated_Persistance() {
		Random ran = new Random();
		Utils.setLevelUpdated(true);
		boolean before = Utils.getLevelUpdated();
		boolean after = false;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getLevelUpdated();
			if (before != after) {
				fail();
			}
		}
		Utils.setLevelUpdated(false);
		assertEquals(before, after);
	}

	@Test
	public void getMonsterBounty_NormalMonster_Persistance() {
		Random ran = new Random();
		Player p = new Player(100, 10, 25);
		long level = 0;

		while (level < 1) {
			level = (long) ran.nextInt(10000);
		}
		Utils.setLevelUpdated(true);
		p.setLevel(level);

		long before = Utils.getMonsterBounty(false, false);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getMonsterBounty(false, false);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getMonsterBounty_NormalSpawner_Persistance() {
		Random ran = new Random();
		Player p = new Player(100, 10, 25);
		long level = 0;

		while (level < 1) {
			level = (long) ran.nextInt(10000);
		}
		Utils.setLevelUpdated(true);
		p.setLevel(level);

		long before = Utils.getMonsterBounty(false, true);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getMonsterBounty(false, true);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getMonsterBounty_BossMonster_Persistance() {
		Random ran = new Random();
		Player p = new Player(100, 10, 25);
		long level = 0;

		while (level < 1) {
			level = (long) ran.nextInt(10000);
		}
		Utils.setLevelUpdated(true);
		p.setLevel(level);

		long before = Utils.getMonsterBounty(true, false);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getMonsterBounty(true, false);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getMonsterBounty_BossSpawner_Persistance() {
		Random ran = new Random();
		Player p = new Player(100, 10, 25);
		long level = 0;

		while (level < 1) {
			level = (long) ran.nextInt(10000);
		}
		Utils.setLevelUpdated(true);
		p.setLevel(level);

		long before = Utils.getMonsterBounty(true, true);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getMonsterBounty(true, true);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Ignore
	// Test
	public void getMonsterDamage_NormalMonster_Persistance() {
		Random ran = new Random();
		Player p = new Player(100, 10, 25);
		long level = 0;

		while (level < 1) {
			level = (long) ran.nextInt(10000);
		}
		Utils.setLevelUpdated(true);
		p.setLevel(level);

		long before = Utils.getMonsterDamage(false, false);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getMonsterDamage(false, false);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Ignore
	// Test
	public void getMonsterDamage_NormalSpawner_Persistance() {
		Random ran = new Random();
		Player p = new Player(100, 10, 25);
		long level = 0;

		while (level < 1) {
			level = (long) ran.nextInt(10000);
		}
		Utils.setLevelUpdated(true);
		p.setLevel(level);

		long before = Utils.getMonsterDamage(false, true);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getMonsterDamage(false, true);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Ignore
	// Test
	public void getMonsterDamage_BossMonster_Persistance() {
		Random ran = new Random();
		Player p = new Player(100, 10, 25);
		long level = 0;

		while (level < 1) {
			level = (long) ran.nextInt(10000);
		}
		Utils.setLevelUpdated(true);
		p.setLevel(level);

		long before = Utils.getMonsterDamage(true, false);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getMonsterDamage(true, false);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Ignore
	// Test
	public void getMonsterDamage_BossSpawner_Persistance() {
		Random ran = new Random();
		Player p = new Player(100, 10, 25);
		long level = 0;

		while (level < 1) {
			level = (long) ran.nextInt(10000);
		}
		Utils.setLevelUpdated(true);
		p.setLevel(level);

		long before = Utils.getMonsterDamage(true, true);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getMonsterDamage(true, true);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getMonsterHealth_NormalMonster_Persistance() {
		Random ran = new Random();
		Player p = new Player(100, 10, 25);
		long level = 0;

		while (level < 1) {
			level = (long) ran.nextInt(10000);
		}
		Utils.setLevelUpdated(true);
		p.setLevel(level);

		long before = Utils.getMonsterHealth(false, false);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getMonsterHealth(false, false);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getMonsterHealth_NormalSpawner_Persistance() {
		Random ran = new Random();
		Player p = new Player(100, 10, 25);
		long level = 0;

		while (level < 1) {
			level = (long) ran.nextInt(10000);
		}
		Utils.setLevelUpdated(true);
		p.setLevel(level);

		long before = Utils.getMonsterHealth(false, true);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getMonsterHealth(false, true);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getMonsterHealth_BossMonster_Persistance() {
		Random ran = new Random();
		Player p = new Player(100, 10, 25);
		long level = 0;

		while (level < 1) {
			level = (long) ran.nextInt(10000);
		}
		Utils.setLevelUpdated(true);
		p.setLevel(level);

		long before = Utils.getMonsterHealth(true, false);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getMonsterHealth(true, false);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getMonsterHealth_BossSpawner_Persistance() {
		Random ran = new Random();
		Player p = new Player(100, 10, 25);
		long level = 0;

		while (level < 1) {
			level = (long) ran.nextInt(10000);
		}
		Utils.setLevelUpdated(true);
		p.setLevel(level);

		long before = Utils.getMonsterHealth(true, true);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.getMonsterHealth(true, true);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void round_Persistance() {
		Random ran = new Random();
		double beforeE = Math.E;
		double beforePi = Math.PI;
		double afterE = 0;
		double afterPi = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			afterE = Utils.round(beforeE, 2);
			afterPi = Utils.round(beforePi, 2);
			if (afterE != 2.72 && afterPi != 3.14) {
				fail();
			}
		}
		assertTrue(2.72 == afterE);
		assertTrue(3.14 == afterPi);
	}

	@Test
	public void round_NegativeNumbers_Persistance() {
		Random ran = new Random();
		double before = (-1) * Math.E;
		double after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = Utils.round(before, 3);
			if (-2.718 != after) {
				fail();
			}
		}
		assertTrue(-2.718 == after);
	}

	@Test(expected = IllegalArgumentException.class)
	public void round_LessThanZeroPlaces() {
		Random ran = new Random();
		int places = 0;

		while (places >= 0) {
			places = ran.nextInt();
		}
		Utils.round(Math.PI, places);
	}
}
