package de.mastermind.thegoog.project.monstergame.monsters;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import de.mastermind.thegoog.project.monstergame.monsters.ElementTypes;

@RunWith(JUnit4.class)
public class ElementTypesTest {

	@Test
	public void get_Position_0() {
		assertEquals(ElementTypes.Air_Type, ElementTypes.get(0));
	}

	@Test
	public void get_Position_1() {
		assertEquals(ElementTypes.Water_Type, ElementTypes.get(1));
	}

	@Test
	public void get_Position_2() {
		assertEquals(ElementTypes.Earth_Type, ElementTypes.get(2));
	}

	@Test
	public void get_Position_3() {
		assertEquals(ElementTypes.Fire_Type, ElementTypes.get(3));
	}

	@Test
	public void get_Position_OutOfRange() {
		assertEquals(null, ElementTypes.get(4));
	}
}
