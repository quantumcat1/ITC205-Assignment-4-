package test;

import game.DiceValue;

import static org.junit.Assert.*;

import org.junit.Test;


public class DiceValueTest
{
	/*
	 * Things to test:
	 * - toString should return the right word (I don't think
	 * this method is ever used in practice. It is a bit of
	 * a nonsense method. It is an instance method, yet you
	 * have to give it a value as an argument? What about the
	 * instance's value?)
	 * - getRandom should return an int between 0 and 5
	 */

	public DiceValueTest ()
	{
		//can't make a new enum, so will have to use locals
	}

	@Test
	public void TestGetRandom()
	{
		DiceValue diceValue = DiceValue.getRandom();
		for(int i = 0; i < 50; i ++)
		{
			assertEquals(true, diceValue.ordinal() > -1);
			assertEquals(true, diceValue.ordinal() < 6);
			diceValue = DiceValue.getRandom();
		}
	}

	@Test
	public void TestToString()
	{
		DiceValue diceValue = DiceValue.SPADE;
		String sDiceValue = diceValue.toString(diceValue);
		assertEquals(true, sDiceValue.equals("Spade"));

		diceValue = DiceValue.HEART;
		sDiceValue = diceValue.toString(diceValue);
		assertEquals(true, sDiceValue.equals("Heart"));

		diceValue = DiceValue.CLUB;
		sDiceValue = diceValue.toString(diceValue);
		assertEquals(true, sDiceValue.equals("Club"));

		diceValue = DiceValue.DIAMOND;
		sDiceValue = diceValue.toString(diceValue);
		assertEquals(true, sDiceValue.equals("Diamond"));

		diceValue = DiceValue.CROWN;
		sDiceValue = diceValue.toString(diceValue);
		assertEquals(true, sDiceValue.equals("Crown"));

		diceValue = DiceValue.ANCHOR;
		sDiceValue = diceValue.toString(diceValue);
		assertEquals(true, sDiceValue.equals("Anchor"));
	}
}
