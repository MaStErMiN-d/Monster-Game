package de.mastermind.thegoog.project.monstergame.test.item;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.mastermind.thegoog.project.monstergame.monsters.Player;
import de.mastermind.thegoog.project.monstergame.utils.Utils;

@RunWith(JUnit4.class)
public class ItemsTest {

	private static Player p;

	@Before
	public void initPlayer() {
		p = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		p.addBounty(5000000);
	}

	@Test
	public void aBombPurchaseable() {
		assertTrue(p.getItems().purchase_aBomb());
	}

	@Test
	public void godModePurchaseable() {
		assertTrue(p.getItems().purchase_GodMode());
	}

	@Test
	public void aBombNotPurchaseable_NotEnoughMoney() {
		Utils.setAccountUpdated(true);
		p.setAccount(0);
		;
		assertFalse(p.getItems().purchase_aBomb());
	}

	@Test
	public void godModeNotPurchaseable_NotEnoughMoney() {
		Utils.setAccountUpdated(true);
		p.setAccount(0);
		assertFalse(p.getItems().purchase_GodMode());
	}

	@Test
	public void canUseABomb() {
		p.getItems().purchase_aBomb();
		assertTrue(p.getItems().use_ABomb());
	}

	@Test
	public void canUseGodMode() {
		p.getItems().purchase_GodMode();
		assertTrue(p.getItems().use_GodMode());
	}

	@Test
	public void cantUseABomb_NonePurchased() {
		assertFalse(p.getItems().use_ABomb());
	}

	@Test
	public void cantUseGodMode_NonePurchased() {
		assertFalse(p.getItems().use_GodMode());
	}

	@Test
	public void aBombCountAlwaysGreaterOrEqualToZero() {
		p.getItems().purchase_aBomb();
		p.getItems().use_ABomb();
		p.getItems().use_ABomb();
		assertEquals(0, p.getItems().getABombCount(), 0);
	}

	@Test
	public void godModeCountAlwaysGreaterOrEqualToZero() {
		p.getItems().purchase_GodMode();
		p.getItems().use_GodMode();
		p.getItems().use_GodMode();
		assertEquals(0, p.getItems().getGodModeCount(), 0);
	}

	@Test
	public void aBombCountRisingWhenPurchasing() {
		Random ran = new Random();
		int end = ran.nextInt(100);

		for (int i = 0; i < end; i++) {
			p.getItems().purchase_aBomb();
			Utils.setAccountUpdated(true);
			p.setAccount(p.getItems().getPrice_ABomb());
		}

		assertEquals(end, p.getItems().getABombCount(), 0);
	}

	@Test
	public void godModeCountRisingWhenPurchasing() {
		Random ran = new Random();
		int end = ran.nextInt(100);

		for (int i = 0; i < end; i++) {
			p.getItems().purchase_GodMode();
			Utils.setAccountUpdated(true);
			p.setAccount(p.getItems().getPrice_GodMode());
		}

		assertEquals(end, p.getItems().getGodModeCount(), 0);
	}

	@Test
	public void aBombPriceNotChangingWhenPurchased() {
		Random ran = new Random();
		int end = ran.nextInt(100);
		long price = p.getItems().getPrice_ABomb();

		for (int i = 0; i < end; i++) {
			p.getItems().purchase_aBomb();
			Utils.setAccountUpdated(true);
			p.setAccount(p.getItems().getPrice_ABomb());
		}

		assertEquals(price, p.getItems().getPrice_ABomb(), 0);
	}

	@Test
	public void godModePriceNotChangingWhenPurchased() {
		Random ran = new Random();
		int end = ran.nextInt(100);
		long price = p.getItems().getPrice_GodMode();

		for (int i = 0; i < end; i++) {
			p.getItems().purchase_GodMode();
			Utils.setAccountUpdated(true);
			p.setAccount(p.getItems().getPrice_GodMode());
		}

		assertEquals(price, p.getItems().getPrice_GodMode(), 0);
	}

	@Test
	public void equals_SamePlayerIdentity() {
		assertTrue(p.getItems().equals(p.getItems()));
	}

	@Test
	public void equals_SamePlayerOneItems() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.addBounty(5000000);
		Utils.setItems(true);
		q.setItems(p.getItems());
		assertTrue(p.getItems().equals(q.getItems()));
	}

	@Test
	public void equals_SamePlayerSameItems() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.addBounty(5000000);
		assertTrue(p.getItems().equals(q.getItems()));
	}

	@Test
	public void equals_DifferentPlayersSameItems() {
		Player q = new Player(1, 1, 1);
		assertFalse(p.getItems().equals(q.getItems()));
	}

	@Test
	public void equals_SamePlayerDifferentABombCount() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.addBounty(5000000);
		q.getItems().purchase_aBomb();
		Utils.setAccountUpdated(true);
		q.addBounty(5000000);
	}

	@Test
	public void equals_SamePlayerDifferentGodModeCount() {
		Player q = new Player(100, 10, 25);
		Utils.setAccountUpdated(true);
		q.addBounty(5000000);
		q.getItems().purchase_GodMode();
		Utils.setAccountUpdated(true);
		q.addBounty(5000000);
		assertFalse(p.getItems().equals(q.getItems()));
	}

	@Test
	public void equals_Null() {
		assertFalse(p.getItems().equals(null));
	}

	@Test
	public void equals_ObjectNotItems() {
		assertFalse(p.getItems().equals(p));
	}
}
