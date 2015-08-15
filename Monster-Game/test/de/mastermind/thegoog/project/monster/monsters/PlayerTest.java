package de.mastermind.thegoog.project.monster.monsters;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.mastermind.thegoog.project.monstergame.item.Items;
import de.mastermind.thegoog.project.monstergame.monsters.AppearanceTypes;
import de.mastermind.thegoog.project.monstergame.monsters.ElementTypes;
import de.mastermind.thegoog.project.monstergame.monsters.Player;
import de.mastermind.thegoog.project.monstergame.upgrades.Upgrades;
import de.mastermind.thegoog.project.monstergame.utils.Utils;

@RunWith(JUnit4.class)
public class PlayerTest {

	private static Player p;

	@Before
	public void initPlayer() {
		p = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		p.setAccount(5000000);
	}

	@Test
	public void player_SameAttributesPersistance() {
		Player player = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		player.setAccount(5000000);
		assertTrue(p.equals(player));
	}

	@Test
	public void player_InRangeInput() {
		Player q = new Player(1, 1, 1);
		assertNotNull(q);
	}

	@Test(expected = IllegalArgumentException.class)
	public void player_Health_ZeroOrLess() {
		Random ran = new Random();
		long health = 1;

		while (health > 0) {
			health = (long) ((-1) * ran.nextInt());
		}
		Utils.setLifeUpdated(true);
		new Player(health, 1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void player_PassiveDamage_ZeroOrLess() {
		Random ran = new Random();
		long dmg = 1;

		while (dmg > 0) {
			dmg = (long) ((-1) * ran.nextInt());
		}
		new Player(1, dmg, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void player_ClickDamage_ZeroOrLess() {
		Random ran = new Random();
		long dmg = 1;

		while (dmg > 0) {
			dmg = (long) ((-1) * ran.nextInt());
		}
		new Player(1, 1, dmg);
	}

	@Test
	public void getUpgrades_Persistance() {
		Random ran = new Random();
		Upgrades before = p.getUpgrades();
		Upgrades after = null;
		int end = ran.nextInt(10000);

		for (int i = 0; i < end; i++) {
			after = p.getUpgrades();
			if (!before.equals(after)) {
				fail();
			}
			assertTrue(before.equals(after));
		}
	}

	@Test
	public void setUpgrades_InRangeInput() {
		Upgrades uPlayer = p.getUpgrades();
		uPlayer.purchaseClickDamageUpgrade();
		Upgrades u = new Upgrades(p);
		Utils.setUpgrades(true);
		p.setUpgrades(u);

		// assertNotEquals(uPlayer, u);
		// assertEquals(u, p.getUpgrades());
		assertFalse(u.equals(uPlayer));
		assertTrue(u.equals(p.getUpgrades()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void setUpgrades_Null() {
		Upgrades u = null;
		Utils.setUpgrades(true);
		p.setUpgrades(u);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setUpgrades_NoUpdateApproved() {
		Upgrades u = new Upgrades(p);
		p.setUpgrades(u);
	}

	@Test
	public void setUpgrades_UtilsSetUpgradesFalseAfterSetting() {
		boolean before = Utils.getUpgradesSet();
		assertFalse(before);
		Upgrades u = new Upgrades(p);
		Utils.setUpgrades(true);
		p.setUpgrades(u);
		boolean after = Utils.getUpgradesSet();
		assertFalse(after);
		assertTrue(before == after);
	}

	@Test
	public void getItems_Persistance() {
		Random ran = new Random();
		Items before = p.getItems();
		Items after = null;
		int end = ran.nextInt(10000);

		for (int i = 0; i < end; i++) {
			after = p.getItems();
			if (!before.equals(after)) {
				fail();
			}
		}
		assertTrue(before.equals(after));
	}

	@Test
	public void setItems_InRangeInput() {
		Items itemsPlayer = p.getItems();
		itemsPlayer.purchase_GodMode();
		Items i = new Items(p);
		Utils.setItems(true);
		p.setItems(i);

		assertFalse(itemsPlayer.equals(i));
		assertTrue(i.equals(p.getItems()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void setItems_Null() {
		Items i = null;
		Utils.setItems(true);
		p.setItems(i);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setItems_NoUpdateApproved() {
		Items i = new Items(p);
		p.setItems(i);
	}

	@Test
	public void setItems_UtilsSetItemsFalseAfterSetting() {
		Items i = new Items(p);
		boolean before = Utils.getItemsSet();
		assertFalse(before);
		Utils.setItems(true);
		p.setItems(i);
		boolean after = Utils.getItemsSet();
		assertFalse(after);
		assertTrue(before == after);
	}

	@Test
	public void addBounty_Persistance() {
		Random ran = new Random();
		long addition = 5;
		long before = p.getMoney();
		long after = 0;
		int end = ran.nextInt(10000);

		for (int i = 0; i < end; i++) {
			Utils.setAccountUpdated(true);
			p.setAccount(p.getMoney() + addition);
			after = p.getMoney() - ((i + 1) * addition);
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test
	public void getMoney_Persistance() {
		Random ran = new Random();
		long before = p.getMoney();
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getMoney();
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void setAccount_Persistance() {
		Random ran = new Random();
		long before = p.getMoney();
		long after = 0;
		int end = ran.nextInt(10000);

		for (int i = 0; i < end; i++) {
			after = p.getMoney();
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test
	public void setAccount_InRangeInput() {
		/*
		 * Player player = null; player = new Player(100, 10, 25);
		 * assertNotNull(player);
		 */

		Utils.setAccountUpdated(true);
		p.setAccount(100);
		long account = p.getMoney();
		assertEquals(100, account);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setAccount_LessThanZero() {
		Random ran = new Random();
		long balance = 0;

		while (balance >= 0) {
			balance = (long) ((-1) * ran.nextInt());
		}
		Utils.setAccountUpdated(true);
		p.setAccount(balance);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setAccount_NoUpdateApproved() {
		p.setAccount(42);
	}

	@Test
	public void setAccount_UtilsSetAccountFalseAfterSetting() {
		boolean before = Utils.getAccountUpdated();
		assertFalse(before);
		Utils.setAccountUpdated(true);
		p.setAccount(42);
		boolean after = Utils.getAccountUpdated();
		assertFalse(after);
		assertTrue(before == after);
	}

	@Test
	public void applyDamage_InRangeInput() {
		Random ran = new Random();
		long before = p.getLife();
		long after = 0;
		long dmg = (long) ran.nextInt(100);
		p.applyDamage(dmg);
		after = p.getLife() + dmg;
		assertTrue(before == after);
	}

	@Test(expected = IllegalArgumentException.class)
	public void applyDamage_LessThanZero() {
		Random ran = new Random();
		long dmg = 0;

		while (dmg >= 0) {
			dmg = (long) ((-1) * ran.nextInt());
		}
		p.applyDamage(dmg);
	}

	@Test
	public void applyDamage_PlayerDies() {
		AppearanceTypes dead = AppearanceTypes.Invisible;
		long dmg = p.getLife();
		p.applyDamage(dmg);
		assertEquals(dead, p.getAppearance());
	}

	@Test
	public void incLevel_Persistance() {
		Random ran = new Random();
		long before = p.getLevel();
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 1; i < end; i++) {
			p.incLevel();
			after = p.getLevel() - i;
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getLevel_Persistance() {
		Random ran = new Random();
		long before = p.getLevel();
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getLevel();
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getClickDamage_Persistance() {
		Random ran = new Random();
		long before = p.getClickDamage();
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getClickDamage();
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void setClickDamage_Persistance() {
		Random ran = new Random();
		long before = p.getClickDamage();
		long dmg = p.getClickDamage();
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			Utils.setClickDamageUpdated(true);
			p.setClickDamage(dmg);
			after = p.getClickDamage();
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void setClickDamage_InRangeInput() {
		Utils.setClickDamageUpdated(true);
		p.setClickDamage(100);
		assertEquals(100, p.getClickDamage());
	}

	@Test(expected = IllegalArgumentException.class)
	public void setClickDamage_ZeroOrLess() {
		Random ran = new Random();
		long dmg = 1;

		while (dmg > 0) {
			dmg = (long) ((-1) * ran.nextInt());
		}
		Utils.setClickDamageUpdated(true);
		p.setClickDamage(dmg);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setClickDamage_UpdateNotApproved() {
		p.setClickDamage(42);
	}

	@Test
	public void setClickDamge_UtilsClickDamageUpdatedFalseAfterSetting() {
		boolean before = Utils.getClickDamageUpdated();
		assertFalse(before);
		Utils.setClickDamageUpdated(true);
		p.setClickDamage(42);
		boolean after = Utils.getClickDamageUpdated();
		assertFalse(after);
		assertTrue(before == after);
	}

	@Test
	public void setLevel_Persistance() {
		Random ran = new Random();
		long after = 0;
		long before = p.getLevel();
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 1; i < end; i++) {
			Utils.setLevelUpdated(true);
			p.setLevel((long) i);
			after = p.getLevel() - (i - 1);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void setLevel_InRangeInput() {
		Utils.setLevelUpdated(true);
		p.setLevel(42);
		assertEquals(42, p.getLevel());
	}

	@Test(expected = IllegalArgumentException.class)
	public void setLevel_ZeroOrLess() {
		Random ran = new Random();
		long level = 1;

		while (level > 0) {
			level = (long) ((-1) * ran.nextInt());
		}
		Utils.setLevelUpdated(true);
		p.setLevel(level);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setLeve_UpdateNotApproved() {
		p.setLevel(42);
	}

	@Test
	public void setLevel_UtilsSetLevelUpdatedFalseAfterSetting() {
		boolean before = Utils.getLevelUpdated();
		assertFalse(before);
		Utils.setLevelUpdated(true);
		p.setLevel(42);
		boolean after = Utils.getLevelUpdated();
		assertFalse(after);
		assertTrue(before == after);
	}

	@Test
	public void getDamage_Persistance() {
		Random ran = new Random();
		long before = p.getDamage();
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getDamage();
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void setDamage_Persistance() {
		Random ran = new Random();
		long before = p.getDamage();
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 1; i < end; i++) {
			Utils.setPassiveDamageUpdated(true);
			p.setDamage(p.getDamage() + 10);
			after = p.getDamage() - (i * 10);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void setDamage_InRangeInput() {
		Utils.setPassiveDamageUpdated(true);
		p.setDamage(42);
		long dmg = p.getDamage();
		assertEquals(42, dmg);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setDamage_ZeroOrLess() {
		Random ran = new Random();
		long dmg = 1;

		while (dmg > 0) {
			dmg = (long) ((-1) * ran.nextInt());
		}

		Utils.setPassiveDamageUpdated(true);
		p.setDamage(dmg);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setDamage_UpdateNotApproved() {
		p.setDamage(42);
	}

	@Test
	public void setDamage_UtilsSetPassiveDamageUpdateFalseAfterSetting() {
		boolean before = Utils.getPassiveDamageUpdated();
		assertFalse(before);
		Utils.setPassiveDamageUpdated(true);
		p.setDamage(42);
		boolean after = Utils.getPassiveDamageUpdated();
		assertFalse(after);
		assertTrue(before == after);
	}

	@Test
	public void getLife_Persistance() {
		Random ran = new Random();
		long before = p.getLife();
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getLife();
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void setLife_Persistance() {
		Random ran = new Random();
		long before = p.getLife();
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 1; i < end; i++) {
			Utils.setLifeUpdated(true);
			p.setLife(p.getLife() + 10);
			after = p.getLife() - (i * 10);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void setLife_InRangeInput() {
		Utils.setLifeUpdated(true);
		assertFalse(42 == p.getLife());
		p.setLife(42);
		assertTrue(42 == p.getLife());
	}

	@Test
	public void setLife_PlayerDies() {
		Utils.setLifeUpdated(true);
		p.setLife(0);
		assertTrue(p.getLife() == 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setLife_LessThanZero() {
		Random ran = new Random();
		long life = 0;

		while (life >= 0) {
			life = (long) ((-1) * ran.nextInt());
		}
		p.setLife(life);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setLife_UpdateNotApproved() {
		p.setLife(42);
	}

	@Test
	public void getClickDamage_Elemental_Persistance_Air() {
		Random ran = new Random();
		long before = p.getClickDamage_Elemental(ElementTypes.Air_Type);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getClickDamage_Elemental(ElementTypes.Air_Type);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getClickDamage_Elemental_Persistance_Water() {
		Random ran = new Random();
		long before = p.getClickDamage_Elemental(ElementTypes.Water_Type);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getClickDamage_Elemental(ElementTypes.Water_Type);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getClickDamage_Elemental_Persistance_Earth() {
		Random ran = new Random();
		long before = p.getClickDamage_Elemental(ElementTypes.Earth_Type);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getClickDamage_Elemental(ElementTypes.Earth_Type);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getClickDamage_Elemental_Persistance_Fire() {
		Random ran = new Random();
		long before = p.getClickDamage_Elemental(ElementTypes.Fire_Type);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getClickDamage_Elemental(ElementTypes.Fire_Type);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getClickDamage_Elemental_InRangeInput_Air() {
		long airDmgBefore = p.getClickDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgBefore = p
				.getClickDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgBefore = p
				.getClickDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgBefore = p.getClickDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(airDmgBefore == waterDmgBefore
				&& airDmgBefore == earthDmgBefore
				&& airDmgBefore == fireDmgBefore);

		Utils.setElementalDamageUpdated_Air(true);
		p.setElementalDamage_Air(2.0);
		long airDmgAfter = p.getClickDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgAfter = p
				.getClickDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgAfter = p
				.getClickDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgAfter = p.getClickDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(airDmgAfter > waterDmgAfter && airDmgAfter > earthDmgAfter
				&& airDmgAfter > fireDmgAfter);
	}

	@Test
	public void getClickDamage_Elemental_InRangeInput_Water() {
		long airDmgBefore = p.getClickDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgBefore = p
				.getClickDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgBefore = p
				.getClickDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgBefore = p.getClickDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(waterDmgBefore == airDmgBefore
				&& waterDmgBefore == earthDmgBefore
				&& waterDmgBefore == fireDmgBefore);

		Utils.setElementalDamageUpdated_Water(true);
		p.setElementalDamage_Water(2.0);
		long airDmgAfter = p.getClickDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgAfter = p
				.getClickDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgAfter = p
				.getClickDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgAfter = p.getClickDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(waterDmgAfter > airDmgAfter && waterDmgAfter > earthDmgAfter
				&& waterDmgAfter > fireDmgAfter);
	}

	@Test
	public void getClickDamage_Elemental_InRangeInput_Earth() {
		long airDmgBefore = p.getClickDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgBefore = p
				.getClickDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgBefore = p
				.getClickDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgBefore = p.getClickDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(earthDmgBefore == airDmgBefore
				&& earthDmgBefore == waterDmgBefore
				&& earthDmgBefore == fireDmgBefore);

		Utils.setElementalDamageUpdated_Earth(true);
		p.setElementalDamage_Earth(2.0);
		long airDmgAfter = p.getClickDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgAfter = p
				.getClickDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgAfter = p
				.getClickDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgAfter = p.getClickDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(earthDmgAfter > airDmgAfter && earthDmgAfter > waterDmgAfter
				&& earthDmgAfter > fireDmgAfter);
	}

	@Test
	public void getClickDamage_Elemental_InRangeInput_Fire() {
		long airDmgBefore = p.getClickDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgBefore = p
				.getClickDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgBefore = p
				.getClickDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgBefore = p.getClickDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(fireDmgBefore == airDmgBefore
				&& fireDmgBefore == waterDmgBefore
				&& fireDmgBefore == earthDmgBefore);

		Utils.setElementalDamageUpdated_Fire(true);
		p.setElementalDamage_Fire(2.0);
		long airDmgAfter = p.getClickDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgAfter = p
				.getClickDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgAfter = p
				.getClickDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgAfter = p.getClickDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(fireDmgAfter > airDmgAfter && fireDmgAfter > waterDmgAfter
				&& fireDmgAfter > earthDmgAfter);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getClickDamage_Elemental_NullInput() {
		p.getClickDamage_Elemental(null);
	}

	@Test
	public void getDamage_Elemental_Persistance_Air() {
		Random ran = new Random();
		long before = p.getDamage_Elemental(ElementTypes.Air_Type);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getDamage_Elemental(ElementTypes.Air_Type);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getDamage_Elemental_Persistance_Water() {
		Random ran = new Random();
		long before = p.getDamage_Elemental(ElementTypes.Water_Type);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getDamage_Elemental(ElementTypes.Water_Type);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getDamage_Elemental_Persistance_Earth() {
		Random ran = new Random();
		long before = p.getDamage_Elemental(ElementTypes.Earth_Type);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getDamage_Elemental(ElementTypes.Earth_Type);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getDamage_Elemental_Persistance_Fire() {
		Random ran = new Random();
		long before = p.getDamage_Elemental(ElementTypes.Fire_Type);
		long after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getDamage_Elemental(ElementTypes.Fire_Type);
			if (before != after) {
				fail();
			}
		}
		assertEquals(before, after);
	}

	@Test
	public void getDamage_Elemental_InRangeInput_Air() {
		long airDmgBefore = p.getDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgBefore = p.getDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgBefore = p.getDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgBefore = p.getDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(airDmgBefore == waterDmgBefore
				&& airDmgBefore == earthDmgBefore
				&& airDmgBefore == fireDmgBefore);

		Utils.setElementalDamageUpdated_Air(true);
		p.setElementalDamage_Air(2.0);

		long airDmgAfter = p.getDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgAfter = p.getDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgAfter = p.getDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgAfter = p.getDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(airDmgAfter > waterDmgAfter && airDmgAfter > earthDmgAfter
				&& airDmgAfter > fireDmgAfter);
	}

	@Test
	public void getDamage_Elemental_InRangeInput_Water() {
		long airDmgBefore = p.getDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgBefore = p.getDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgBefore = p.getDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgBefore = p.getDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(waterDmgBefore == airDmgBefore
				&& waterDmgBefore == earthDmgBefore
				&& waterDmgBefore == fireDmgBefore);

		Utils.setElementalDamageUpdated_Water(true);
		p.setElementalDamage_Water(2.0);

		long airDmgAfter = p.getDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgAfter = p.getDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgAfter = p.getDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgAfter = p.getDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(waterDmgAfter > airDmgAfter && waterDmgAfter > earthDmgAfter
				&& waterDmgAfter > fireDmgAfter);
	}

	@Test
	public void getDamage_Elemental_InRangeInput_Earth() {
		long airDmgBefore = p.getDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgBefore = p.getDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgBefore = p.getDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgBefore = p.getDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(earthDmgBefore == airDmgBefore
				&& earthDmgBefore == waterDmgBefore
				&& earthDmgBefore == fireDmgBefore);

		Utils.setElementalDamageUpdated_Earth(true);
		p.setElementalDamage_Earth(2.0);

		long airDmgAfter = p.getDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgAfter = p.getDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgAfter = p.getDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgAfter = p.getDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(earthDmgAfter > airDmgAfter && earthDmgAfter > waterDmgAfter
				&& earthDmgAfter > fireDmgAfter);
	}

	@Test
	public void getDamage_Elemental_InRangeInput_Fire() {
		long airDmgBefore = p.getDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgBefore = p.getDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgBefore = p.getDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgBefore = p.getDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(fireDmgBefore == airDmgBefore
				&& fireDmgBefore == waterDmgBefore
				&& fireDmgBefore == earthDmgBefore);

		Utils.setElementalDamageUpdated_Fire(true);
		p.setElementalDamage_Fire(2.0);

		long airDmgAfter = p.getDamage_Elemental(ElementTypes.Air_Type);
		long waterDmgAfter = p.getDamage_Elemental(ElementTypes.Water_Type);
		long earthDmgAfter = p.getDamage_Elemental(ElementTypes.Earth_Type);
		long fireDmgAfter = p.getDamage_Elemental(ElementTypes.Fire_Type);

		assertTrue(fireDmgAfter > airDmgAfter && fireDmgAfter > waterDmgAfter
				&& fireDmgAfter > earthDmgAfter);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getDamage_Elemental_NullInput() {
		p.getDamage_Elemental(null);
	}

	// public void setElementalDamage_Air(double newScale) {
	// if (newScale >= 1) {
	// if (Utils.getElementalDamageUpdated_Air()) {
	// this.elementalDamage_Air = newScale;
	// Utils.setElementalDamageUpdated_Air(false);
	// } else {
	// Utils.setElementalDamageUpdated_Air(false);
	// throw new IllegalArgumentException(
	// "Can't update elemental Damage if no update was approved!");
	// }
	// } else {
	// throw new IllegalArgumentException(
	// "Elemental Damage-Scale can't be less than 1.0!");
	// }
	// }

	@Test
	public void getElementalDamage_Air_Persistance() {
		Random ran = new Random();
		double before = p.getElementalDamage_Air();
		double after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getElementalDamage_Air();
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test
	public void setElementalDamage_Air_Persistance() {
		Random ran = new Random();
		double before = Utils.round(p.getElementalDamage_Air(), 2);
		double after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 1; i < end; i++) {
			Utils.setElementalDamageUpdated_Air(true);
			p.setElementalDamage_Air(p.getElementalDamage_Air() + 0.2);
			after = Utils.round(p.getElementalDamage_Air() - (i * 0.2), 2);
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test
	public void getElementalDamage_Water_Persistance() {
		Random ran = new Random();
		double before = p.getElementalDamage_Water();
		double after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getElementalDamage_Water();
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test
	public void setElementalDamage_Water_Persistance() {
		Random ran = new Random();
		double before = Utils.round(p.getElementalDamage_Water(), 2);
		double after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 1; i < end; i++) {
			Utils.setElementalDamageUpdated_Water(true);
			p.setElementalDamage_Water(p.getElementalDamage_Water() + 0.2);
			after = Utils.round(p.getElementalDamage_Water() - (i * 0.2), 2);
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test
	public void getElementalDamage_Earth_Persistance() {
		Random ran = new Random();
		double before = p.getElementalDamage_Earth();
		double after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getElementalDamage_Earth();
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test
	public void setElementalDamage_Earth_Persistance() {
		Random ran = new Random();
		double before = Utils.round(p.getElementalDamage_Earth(), 2);
		double after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 1; i < end; i++) {
			Utils.setElementalDamageUpdated_Earth(true);
			p.setElementalDamage_Earth(p.getElementalDamage_Earth() + 0.2);
			after = Utils.round(p.getElementalDamage_Earth() - (i * 0.2), 2);
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test
	public void getElementalDamage_Fire_Persistance() {
		Random ran = new Random();
		double before = p.getElementalDamage_Fire();
		double after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getElementalDamage_Fire();
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test
	public void setElementalDamage_Fire_Persistance() {
		Random ran = new Random();
		double before = Utils.round(p.getElementalDamage_Fire(), 2);
		double after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 1; i < end; i++) {
			Utils.setElementalDamageUpdated_Fire(true);
			p.setElementalDamage_Fire((double) (p.getElementalDamage_Fire() + 0.2));
			after = Utils.round(p.getElementalDamage_Fire() - (i * 0.2), 2);
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setElementalDamage_Air_UpdateNotApproved() {
		p.setElementalDamage_Air(4.2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setElementalDamage_Air_LessThanOne() {
		Random ran = new Random();
		long newScale = 1;

		while (newScale >= 1) {
			newScale = (long) ((-1) * ran.nextInt());
		}
		Utils.setElementalDamageUpdated_Air(true);
		p.setElementalDamage_Air(newScale);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setElementalDamage_Water_UpdateNotApproved() {
		p.setElementalDamage_Water(4.2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setElementalDamage_Water_LessThanOne() {
		Random ran = new Random();
		long newScale = 1;

		while (newScale >= 1) {
			newScale = (long) ((-1) * ran.nextInt());
		}
		Utils.setElementalDamageUpdated_Water(true);
		p.setElementalDamage_Water(newScale);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setElementalDamage_Earth_UpdateNotApproved() {
		p.setElementalDamage_Earth(4.2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setElementalDamage_Earth_LessThanOne() {
		Random ran = new Random();
		long newScale = 1;

		while (newScale >= 1) {
			newScale = (long) ((-1) * ran.nextInt());
		}
		Utils.setElementalDamageUpdated_Earth(true);
		p.setElementalDamage_Earth(newScale);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setElementalDamage_Fire_UpdateNotApproved() {
		p.setElementalDamage_Fire(4.2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setElementalDamage_Fire_LessThanOne() {
		Random ran = new Random();
		long newScale = 1;

		while (newScale >= 1) {
			newScale = (long) ((-1) * ran.nextInt());
		}
		Utils.setElementalDamageUpdated_Fire(true);
		p.setElementalDamage_Fire(newScale);
	}

	@Test
	public void getElementalDamageByType_Persistance_Air() {
		Random ran = new Random();
		double before = p.getElementalDamageByType(ElementTypes.Air_Type);
		double after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getElementalDamageByType(ElementTypes.Air_Type);
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test
	public void getElementalDamageByType_Persistance_Water() {
		Random ran = new Random();
		double before = p.getElementalDamageByType(ElementTypes.Water_Type);
		double after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getElementalDamageByType(ElementTypes.Water_Type);
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test
	public void getElementalDamageByType_Persistance_Earth() {
		Random ran = new Random();
		double before = p.getElementalDamageByType(ElementTypes.Earth_Type);
		double after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getElementalDamageByType(ElementTypes.Earth_Type);
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test
	public void getElementalDamageByType_Persistance_Fire() {
		Random ran = new Random();
		double before = p.getElementalDamageByType(ElementTypes.Fire_Type);
		double after = 0;
		int end = 0;

		while (end < 100) {
			end = ran.nextInt(10000);
		}

		for (int i = 0; i < end; i++) {
			after = p.getElementalDamageByType(ElementTypes.Fire_Type);
			if (before != after) {
				fail();
			}
		}
		assertTrue(before == after);
	}

	@Test
	public void getElementalDamageByType_InRangeInput_Air() {
		double airScaleBefore = p
				.getElementalDamageByType(ElementTypes.Air_Type);
		double waterScaleBefore = p
				.getElementalDamageByType(ElementTypes.Water_Type);
		double earthScaleBefore = p
				.getElementalDamageByType(ElementTypes.Earth_Type);
		double fireScaleBefore = p
				.getElementalDamageByType(ElementTypes.Fire_Type);

		assertTrue(airScaleBefore == waterScaleBefore
				&& airScaleBefore == earthScaleBefore
				&& airScaleBefore == fireScaleBefore);

		Utils.setElementalDamageUpdated_Air(true);
		p.setElementalDamage_Air(2.0);

		double airScaleAfter = p
				.getElementalDamageByType(ElementTypes.Air_Type);
		double waterScaleAfter = p
				.getElementalDamageByType(ElementTypes.Water_Type);
		double earthScaleAfter = p
				.getElementalDamageByType(ElementTypes.Earth_Type);
		double fireScaleAfter = p
				.getElementalDamageByType(ElementTypes.Fire_Type);

		assertTrue(airScaleAfter > waterScaleAfter
				&& airScaleAfter > earthScaleAfter
				&& airScaleAfter > fireScaleAfter);
	}

	@Test
	public void getElementalDamageByType_InRangeInput_Water() {
		double airScaleBefore = p
				.getElementalDamageByType(ElementTypes.Air_Type);
		double waterScaleBefore = p
				.getElementalDamageByType(ElementTypes.Water_Type);
		double earthScaleBefore = p
				.getElementalDamageByType(ElementTypes.Earth_Type);
		double fireScaleBefore = p
				.getElementalDamageByType(ElementTypes.Fire_Type);

		assertTrue(waterScaleBefore == airScaleBefore
				&& waterScaleBefore == earthScaleBefore
				&& waterScaleBefore == fireScaleBefore);

		Utils.setElementalDamageUpdated_Water(true);
		p.setElementalDamage_Water(2.0);

		double airScaleAfter = p
				.getElementalDamageByType(ElementTypes.Air_Type);
		double waterScaleAfter = p
				.getElementalDamageByType(ElementTypes.Water_Type);
		double earthScaleAfter = p
				.getElementalDamageByType(ElementTypes.Earth_Type);
		double fireScaleAfter = p
				.getElementalDamageByType(ElementTypes.Fire_Type);

		assertTrue(waterScaleAfter > airScaleAfter
				&& waterScaleAfter > earthScaleAfter
				&& waterScaleAfter > fireScaleAfter);
	}

	@Test
	public void getElementalDamageByType_InRangeInput_Earth() {
		double airScaleBefore = p
				.getElementalDamageByType(ElementTypes.Air_Type);
		double waterScaleBefore = p
				.getElementalDamageByType(ElementTypes.Water_Type);
		double earthScaleBefore = p
				.getElementalDamageByType(ElementTypes.Earth_Type);
		double fireScaleBefore = p
				.getElementalDamageByType(ElementTypes.Fire_Type);

		assertTrue(earthScaleBefore == airScaleBefore
				&& earthScaleBefore == waterScaleBefore
				&& earthScaleBefore == fireScaleBefore);

		Utils.setElementalDamageUpdated_Earth(true);
		p.setElementalDamage_Earth(2.0);

		double airScaleAfter = p
				.getElementalDamageByType(ElementTypes.Air_Type);
		double waterScaleAfter = p
				.getElementalDamageByType(ElementTypes.Water_Type);
		double earthScaleAfter = p
				.getElementalDamageByType(ElementTypes.Earth_Type);
		double fireScaleAfter = p
				.getElementalDamageByType(ElementTypes.Fire_Type);

		assertTrue(earthScaleAfter > airScaleAfter
				&& earthScaleAfter > waterScaleAfter
				&& earthScaleAfter > fireScaleAfter);
	}

	@Test
	public void getElementalDamageByType_InRangeInput_Fire() {
		double airScaleBefore = p
				.getElementalDamageByType(ElementTypes.Air_Type);
		double waterScaleBefore = p
				.getElementalDamageByType(ElementTypes.Water_Type);
		double earthScaleBefore = p
				.getElementalDamageByType(ElementTypes.Earth_Type);
		double fireScaleBefore = p
				.getElementalDamageByType(ElementTypes.Fire_Type);

		assertTrue(fireScaleBefore == airScaleBefore
				&& fireScaleBefore == waterScaleBefore
				&& fireScaleBefore == earthScaleBefore);

		Utils.setElementalDamageUpdated_Fire(true);
		p.setElementalDamage_Fire(2.0);

		double airScaleAfter = p
				.getElementalDamageByType(ElementTypes.Air_Type);
		double waterScaleAfter = p
				.getElementalDamageByType(ElementTypes.Water_Type);
		double earthScaleAfter = p
				.getElementalDamageByType(ElementTypes.Earth_Type);
		double fireScaleAfter = p
				.getElementalDamageByType(ElementTypes.Fire_Type);

		assertTrue(fireScaleAfter > airScaleAfter
				&& fireScaleAfter > waterScaleAfter
				&& fireScaleAfter > earthScaleAfter);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getElementalDamageByType_NullInput() {
		p.getElementalDamageByType(null);
	}

	@Test
	public void equals_Identity() {
		assertTrue(p.equals(p));
	}

	@Test
	public void equals_SamePlayer() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(5000000);
		assertTrue(p.equals(q));
	}

	@Test
	public void equals_differentPlayers() {
		Player q = new Player(1, 1, 1);
		assertFalse(p.equals(q));
	}

	@Test
	public void equals_differentHealth() {
		Player q = new Player(1, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(5000000);
		assertFalse(p.equals(q));
	}

	@Test
	public void equals_differentPassiveDamage() {
		Player q = new Player(100, 1, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(5000000);
		assertFalse(p.equals(q));
	}

	@Test
	public void equals_differentClickDamage() {
		Player q = new Player(100, 10, 1);
		Utils.setAccountUpdated(true);
		q.setAccount(5000000);
		assertFalse(p.equals(q));
	}

	@Test
	public void equals_samePlayerDifferentItems() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(5000000);
		q.getItems().purchase_GodMode();
		Utils.setAccountUpdated(true);
		q.setAccount(5000000);
		assertFalse(p.equals(q));
	}

	@Test
	public void equals_samePlayerDifferentUpgrades() {
		Player q = new Player(100, 10, 25);
		Player p2 = new Player(100, 10, 25);
		q.getUpgrades().purchaseLifeUpgrade();
		Utils.setAccountUpdated(true);
		q.setAccount(5000000);
		Utils.setLifeUpdated(true);
		q.setLife(100);
		assertFalse(p2.equals(q));
	}

	@Test
	public void equals_differentPlayersSameUpgrade() {
		Player q = new Player(100, 10, 25);
		Utils.setUpgrades(true);
		q.setUpgrades(p.getUpgrades());
		assertFalse(p.equals(q));
	}

	@Test
	public void equals_differentPlayersSameItems() {
		Player q = new Player(100, 10, 25);
		Utils.setItems(true);
		q.setItems(p.getItems());
		assertFalse(p.equals(q));
	}

	@Test
	public void equals_samePlayersDifferentAccounts() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(1);
		assertFalse(p.equals(q));
	}

	@Test
	public void equals_samePlayersDifferentLevel() {
		Player q = new Player(100, 10, 25);
		Utils.setLevelUpdated(true);
		q.setLevel(42);
		assertFalse(p.equals(q));
	}

	@Test
	public void equals_samePlayersDifferentElementalDamage_Air() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(5000000);
		Utils.setElementalDamageUpdated_Air(true);
		q.setElementalDamage_Air(4.2);
		assertFalse(p.equals(q));
	}

	@Test
	public void equals_samePlayersDifferentElementalDamage_Water() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(5000000);
		Utils.setElementalDamageUpdated_Water(true);
		q.setElementalDamage_Water(4.2);
		assertFalse(p.equals(q));
	}

	@Test
	public void equals_samePlayersDifferentElementalDamage_Earth() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(5000000);
		Utils.setElementalDamageUpdated_Earth(true);
		q.setElementalDamage_Earth(4.2);
		assertFalse(p.equals(q));
	}

	@Test
	public void equals_samePlayersDifferentElementalDamage_Fire() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(5000000);
		Utils.setElementalDamageUpdated_Fire(true);
		q.setElementalDamage_Fire(4.2);
		assertFalse(p.equals(q));
	}
	
	@Test
	public void equals_Null() {
		assertFalse(p.equals(null));
	}
	
	@Test
	public void equals_ObjectNotPlayer() {
		assertFalse(p.equals(p.getItems()));
	}
}
