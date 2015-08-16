package de.mastermind.thegoog.project.monstergame.test.monsters;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.mastermind.thegoog.project.monstergame.monsters.AppearanceTypes;

@RunWith(JUnit4.class)
public class AppearanceTypesTest {

	@Test
	public void get_Position_0() {
		assertEquals(AppearanceTypes.Standard_Type, AppearanceTypes.get(0));
	}

	@Test
	public void get_Position_1() {
		assertEquals(AppearanceTypes.Alternative_Type, AppearanceTypes.get(1));
	}

	@Test
	public void get_Position_2() {
		assertEquals(AppearanceTypes.Boss_Type, AppearanceTypes.get(2));
	}

	@Test
	public void get_Position_3() {
		assertEquals(AppearanceTypes.Spawner_Type, AppearanceTypes.get(3));
	}

	@Test
	public void get_Position_4() {
		assertEquals(AppearanceTypes.SpawnerBoss_Type, AppearanceTypes.get(4));
	}

	@Test
	public void get_Position_5() {
		assertEquals(AppearanceTypes.Invisible, AppearanceTypes.get(5));
	}

	@Test
	public void get_Position_OutOfRange() {
		assertEquals(null, AppearanceTypes.get(6));
	}

	@Test
	public void getMonsters_Position_0() {
		assertEquals(AppearanceTypes.Standard_Type,
				AppearanceTypes.getMonsters(0));
	}

	@Test
	public void getMonsters_Position_1() {
		assertEquals(AppearanceTypes.Alternative_Type,
				AppearanceTypes.getMonsters(1));
	}

	@Test
	public void getMonsters_Position_OutOfRange() {
		assertEquals(null, AppearanceTypes.getMonsters(2));
	}

	@Test
	public void getBosses_Position_0() {
		assertEquals(AppearanceTypes.Boss_Type, AppearanceTypes.getBosses(0));
	}

	@Test
	public void getBosses_Position_1() {
		assertEquals(AppearanceTypes.SpawnerBoss_Type,
				AppearanceTypes.getBosses(1));
	}

	@Test
	public void getBosses_Position_OutOfRange() {
		assertEquals(null, AppearanceTypes.getBosses(3));
	}
}
