package de.mastermind.thegoog.project.monstergame.upgrades;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.mastermind.thegoog.project.monstergame.monsters.Player;
import de.mastermind.thegoog.project.monstergame.utils.Utils;

@RunWith(JUnit4.class)
public class UpgradesTest {

	private static Player p;

	@Before
	public void initPlayer() {
		p = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		p.setAccount(500000000);
	}

	@Test
	public void everyPlayersUpgradeIdentity() {
		Upgrades one = p.getUpgrades();
		Player q = new Player(100, 10, 25);
		Upgrades two = q.getUpgrades();
		assertFalse(one.equals(two));
	}

	@Test
	public void canPurchaseLifeUpgrade() {
		assertTrue(p.getUpgrades().purchaseLifeUpgrade());
	}

	@Test
	public void canPurchaseClickDamageUpgrade() {
		assertTrue(p.getUpgrades().purchaseClickDamageUpgrade());
	}

	@Test
	public void canPurchasePassiveDamageUpgrade() {
		assertTrue(p.getUpgrades().purchasePassiveDamageUpgrade());
	}

	@Test
	public void canPurchaseElementalDamageUpgrade_Air() {
		assertTrue(p.getUpgrades().purchaseElementalDamageUpgrade_Air());
	}

	@Test
	public void canPurchaseElementalDamageUpgrade_Water() {
		assertTrue(p.getUpgrades().purchaseElementalDamageUpgrade_Water());
	}

	@Test
	public void canPurchaseElementalDamageUpgrade_Earth() {
		assertTrue(p.getUpgrades().purchaseElementalDamageUpgrade_Earth());
	}

	@Test
	public void canPurchaseElementalDamageUpgrade_Fire() {
		assertTrue(p.getUpgrades().purchaseElementalDamageUpgrade_Fire());
	}

	@Test
	public void cantPurchaseLifeUpgrade_notEnoughMoney() {
		Utils.setAccountUpdated(true);
		p.setAccount(0);
		assertFalse(p.getUpgrades().purchaseLifeUpgrade());
	}

	@Test
	public void cantPurchaseClickDamageUpgrade_notEnoughMoney() {
		Utils.setAccountUpdated(true);
		p.setAccount(0);
		assertFalse(p.getUpgrades().purchaseClickDamageUpgrade());
	}

	@Test
	public void cantPurchasePassiveDamageUpgrade_notEnoughMoney() {
		Utils.setAccountUpdated(true);
		p.setAccount(0);
		assertFalse(p.getUpgrades().purchasePassiveDamageUpgrade());
	}

	@Test
	public void cantPurchaseElementalDamageUpgrade_Air_notEnoughMoney() {
		Utils.setAccountUpdated(true);
		p.setAccount(0);
		assertFalse(p.getUpgrades().purchaseElementalDamageUpgrade_Air());
	}

	@Test
	public void cantPurchaseElementalDamageUpgrade_Water_notEnoughMoney() {
		Utils.setAccountUpdated(true);
		p.setAccount(0);
		assertFalse(p.getUpgrades().purchaseElementalDamageUpgrade_Water());
	}

	@Test
	public void cantPurchaseElementalDamageUpgrade_Earth_notEnoughMoney() {
		Utils.setAccountUpdated(true);
		p.setAccount(0);
		assertFalse(p.getUpgrades().purchaseElementalDamageUpgrade_Earth());
	}

	@Test
	public void cantPurchaseElementalDamageUpgrade_Fire_notEnoughMoney() {
		Utils.setAccountUpdated(true);
		p.setAccount(0);
		assertFalse(p.getUpgrades().purchaseElementalDamageUpgrade_Fire());
	}

	@Test
	public void lifeUpgradePrice_IncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(35);
		}
		long before = 0;
		long after = 0;
		for (long i = 0; i < end; i++) {
			after = p.getUpgrades().getLifeUpgradePrice();
			p.getUpgrades().purchaseLifeUpgrade();
			if (after > before) {
				before = after;
				Utils.setAccountUpdated(true);
				p.addBounty(p.getUpgrades().getLifeUpgradePrice());
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	public void passiveDamageUpgradePrice_IncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(35);
		}
		long before = 0;
		long after = 0;
		for (long i = 0; i < end; i++) {
			after = p.getUpgrades().getPassiveDamageUpgradePrice();
			p.getUpgrades().purchasePassiveDamageUpgrade();
			if (after > before) {
				before = after;
				Utils.setAccountUpdated(true);
				p.addBounty(p.getUpgrades().getPassiveDamageUpgradePrice());
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	public void clickDamageUpgradePrice_IncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(35);
		}
		long before = 0;
		long after = 0;
		for (long i = 0; i < end; i++) {
			after = p.getUpgrades().getClickDamageUpgradePrice();
			p.getUpgrades().purchaseClickDamageUpgrade();
			if (after > before) {
				before = after;
				Utils.setAccountUpdated(true);
				p.addBounty(p.getUpgrades().getClickDamageUpgradePrice());
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	public void elementalDamageUpgradePrice_Air_IncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(35);
		}
		long before = 0;
		long after = 0;
		for (long i = 0; i < end; i++) {
			after = p.getUpgrades().getElementalDamageUpgradePrice_Air();
			p.getUpgrades().purchaseElementalDamageUpgrade_Air();
			if (after > before) {
				before = after;
				Utils.setAccountUpdated(true);
				p.addBounty(p.getUpgrades()
						.getElementalDamageUpgradePrice_Air());
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	public void elementalDamageUpgradePrice_Water_IncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(35);
		}
		long before = 0;
		long after = 0;
		for (long i = 0; i < end; i++) {
			after = p.getUpgrades().getElementalDamageUpgradePrice_Water();
			p.getUpgrades().purchaseElementalDamageUpgrade_Water();
			if (after > before) {
				before = after;
				Utils.setAccountUpdated(true);
				p.addBounty(p.getUpgrades()
						.getElementalDamageUpgradePrice_Water());
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	public void elementalDamageUpgradePrice_Earth_IncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(35);
		}
		long before = 0;
		long after = 0;
		for (long i = 0; i < end; i++) {
			after = p.getUpgrades().getElementalDamageUpgradePrice_Earth();
			p.getUpgrades().purchaseElementalDamageUpgrade_Earth();
			if (after > before) {
				before = after;
				Utils.setAccountUpdated(true);
				p.addBounty(p.getUpgrades()
						.getElementalDamageUpgradePrice_Earth());
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	public void elementalDamageUpgradePrice_Fire_IncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(35);
		}
		long before = 0;
		long after = 0;
		for (long i = 0; i < end; i++) {
			after = p.getUpgrades().getElementalDamageUpgradePrice_Fire();
			p.getUpgrades().purchaseElementalDamageUpgrade_Fire();
			if (after > before) {
				before = after;
				Utils.setAccountUpdated(true);
				p.addBounty(p.getUpgrades()
						.getElementalDamageUpgradePrice_Fire());
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	public void lifeUpgradeValue_IncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(35);
		}
		long before = 0;
		long after = 0;
		for (long i = 0; i < end; i++) {
			after = p.getUpgrades().getLifeUpgrade();
			p.getUpgrades().purchaseLifeUpgrade();
			if (after > before) {
				before = after;
				Utils.setAccountUpdated(true);
				p.addBounty(p.getUpgrades().getLifeUpgradePrice());
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	public void passiveDamageUpgradeValue_IncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(35);
		}
		long before = 0;
		long after = 0;
		for (long i = 0; i < end; i++) {
			after = p.getUpgrades().getPassiveDamageUpgrade();
			p.getUpgrades().purchasePassiveDamageUpgrade();
			if (after > before) {
				before = after;
				Utils.setAccountUpdated(true);
				p.addBounty(p.getUpgrades().getPassiveDamageUpgradePrice());
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	public void clickDamageUpgradeValue_IncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(35);
		}
		long before = 0;
		long after = 0;
		for (long i = 0; i < end; i++) {
			after = p.getUpgrades().getClickDamageUpgrade();
			p.getUpgrades().purchaseClickDamageUpgrade();
			if (after > before) {
				before = after;
				Utils.setAccountUpdated(true);
				p.addBounty(p.getUpgrades().getClickDamageUpgradePrice());
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	public void elementalDamageUpgradeValue_Air_IncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(35);
		}
		double before = 0;
		double after = 0;
		for (long i = 0; i < end; i++) {
			after = p.getUpgrades().getElementalDamageUpgrade_Air();
			p.getUpgrades().purchaseElementalDamageUpgrade_Air();
			if (after > before) {
				before = after;
				Utils.setAccountUpdated(true);
				p.addBounty(p.getUpgrades()
						.getElementalDamageUpgradePrice_Air());
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	public void elementalDamageUpgradeValue_Water_IncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(35);
		}
		double before = 0;
		double after = 0;
		for (long i = 0; i < end; i++) {
			after = p.getUpgrades().getElementalDamageUpgrade_Water();
			p.getUpgrades().purchaseElementalDamageUpgrade_Water();
			if (after > before) {
				before = after;
				Utils.setAccountUpdated(true);
				p.addBounty(p.getUpgrades()
						.getElementalDamageUpgradePrice_Water());
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	public void elementalDamageUpgradeValue_Earth_IncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(35);
		}
		double before = 0;
		double after = 0;
		for (long i = 0; i < end; i++) {
			after = p.getUpgrades().getElementalDamageUpgrade_Earth();
			p.getUpgrades().purchaseElementalDamageUpgrade_Earth();
			if (after > before) {
				before = after;
				Utils.setAccountUpdated(true);
				p.addBounty(p.getUpgrades()
						.getElementalDamageUpgradePrice_Earth());
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	public void elementalDamageUpgradeValue_Fire_IncreasingByLevel() {
		Random ran = new Random();
		long end = 0;
		while (end < 2) {
			// TODO obere Grenze anpassen!!
			end = (long) ran.nextInt(35);
		}
		double before = 0;
		double after = 0;
		for (long i = 0; i < end; i++) {
			after = p.getUpgrades().getElementalDamageUpgrade_Fire();
			p.getUpgrades().purchaseElementalDamageUpgrade_Fire();
			if (after > before) {
				before = after;
				Utils.setAccountUpdated(true);
				p.addBounty(p.getUpgrades()
						.getElementalDamageUpgradePrice_Fire());
			} else {
				fail();
			}
		}
		assertTrue(before == after ? true : false);
	}

	@Test
	public void equals_SameUpgradesSamePlayer() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		p.getUpgrades().purchaseLifeUpgrade();
		q.getUpgrades().purchaseLifeUpgrade();
		assertTrue(p.getUpgrades().equals(q.getUpgrades()));
	}

	@Test
	public void equals_SameUpgradesDifferentPlayers() {
		Player q = new Player(100, 10, 25);
		Utils.setUpgrades(true);
		q.setUpgrades(p.getUpgrades());
		assertTrue(p.getUpgrades().equals(q.getUpgrades()));

	}

	@Test
	public void equals_SamePlayerDifferentLifeUpgrade() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		q.getUpgrades().purchaseLifeUpgrade();
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		Utils.setLifeUpdated(true);
		q.setLife(100);
		assertFalse(p.getUpgrades().equals(q.getUpgrades()));
	}

	@Test
	public void equals_SamePlayerDifferentClickDamageUpgrade() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		q.getUpgrades().purchaseClickDamageUpgrade();
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		Utils.setClickDamageUpdated(true);
		q.setClickDamage(25);
		assertFalse(p.getUpgrades().equals(q.getUpgrades()));
	}

	@Test
	public void equals_SamePlayerDifferentPassiveDamageUpgrade() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		q.getUpgrades().purchasePassiveDamageUpgrade();
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		Utils.setPassiveDamageUpdated(true);
		q.setDamage(10);
		assertFalse(p.getUpgrades().equals(q.getUpgrades()));
	}

	@Test
	public void equals_SamePlayerDifferentElementalDamageUpgrade_Air() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		q.getUpgrades().purchaseElementalDamageUpgrade_Air();
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		Utils.setElementalDamageUpdated_Air(true);
		q.setElementalDamage_Air(1.0);
		assertFalse(p.getUpgrades().equals(q.getUpgrades()));
	}

	@Test
	public void equals_SamePlayerDifferentElementalDamageUpgrade_Water() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		q.getUpgrades().purchaseElementalDamageUpgrade_Water();
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		Utils.setElementalDamageUpdated_Water(true);
		q.setElementalDamage_Water(1.0);
		assertFalse(p.getUpgrades().equals(q.getUpgrades()));
	}

	@Test
	public void equals_SamePlayerDifferentElementalDamageUpgrade_Earth() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		q.getUpgrades().purchaseElementalDamageUpgrade_Earth();
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		Utils.setElementalDamageUpdated_Earth(true);
		q.setElementalDamage_Earth(1.0);
		assertFalse(p.getUpgrades().equals(q.getUpgrades()));
	}

	@Test
	public void equals_SamePlayerDifferentElementalDamageUpgrade_Fire() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		q.getUpgrades().purchaseElementalDamageUpgrade_Fire();
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		Utils.setElementalDamageUpdated_Fire(true);
		q.setElementalDamage_Fire(1.0);
		assertFalse(p.getUpgrades().equals(q.getUpgrades()));
	}

	@Test
	public void equals_SamePlayerSameUpgrade() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.setAccount(500000000);
		Utils.setUpgrades(true);
		q.setUpgrades(p.getUpgrades());
		assertTrue(p.getUpgrades().equals(q.getUpgrades()));
	}
	
	@Test
	public void equals_Null() {
		assertFalse(p.getUpgrades().equals(null));
	}
	
	@Test
	public void equals_ObjectNotUpgradess() {
		assertFalse(p.getUpgrades().equals(p));
	}
}
