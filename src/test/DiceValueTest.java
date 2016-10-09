package test;

import game.DiceValue;

import static org.junit.Assert.assertEquals;

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
	 * - My suspicion is this will be a defect, maybe the
	 * rules will say the game should say "Spade" not
	 * "SPADE". In the very least it is a poor method,
	 * since at first glance it looks like it is overriding
	 * Object's toString() method when it isn't, it just has
	 * a similar name.
	 * - getRandom should return an int between 0 and 5
	 */

	int randomResults[] = {0, 0, 0, 0, 0, 0};
	/*
	*this variable stores the number of times we
	*roll each face after rolling 100 times
	*('rolling' being calling getRandom).
	*/

	public DiceValueTest()
	{
		RunRandoms();
	}

	public void RunRandoms()
	{
		DiceValue diceValue = DiceValue.getRandom();
		for(int i = 0; i < 100; i ++)
		{
			if(diceValue.ordinal() < 0 || diceValue.ordinal() > 5)
			{
				assertEquals(true, false); //should be between 0 and 5
			}
			randomResults[diceValue.ordinal()] += 1;
			diceValue = DiceValue.getRandom();
		}
	}

	//Separate tests so I can tell which one failed
	@Test
	public void TestGetRandomsProducesCrown()
	{
		//we would expect to get at least some of each after 100 rolls.
		assertEquals(true, randomResults[(DiceValue.CROWN).ordinal()] > 0);
	}

	@Test
	public void TestGetRandomsProducesAnchor()
	{
		//we would expect to get at least some of each after 100 rolls.
		assertEquals(true, randomResults[(DiceValue.ANCHOR).ordinal()] > 0);
	}

	@Test
	public void TestGetRandomsProducesHeart()
	{
		//we would expect to get at least some of each after 100 rolls.
		assertEquals(true, randomResults[(DiceValue.HEART).ordinal()] > 0);
	}

	@Test
	public void TestGetRandomsProducesDiamond()
	{
		//we would expect to get at least some of each after 100 rolls.
		assertEquals(true, randomResults[(DiceValue.DIAMOND).ordinal()] > 0);
	}

	@Test
	public void TestGetRandomsProducesClub()
	{
		//we would expect to get at least some of each after 100 rolls.
		assertEquals(true, randomResults[(DiceValue.CLUB).ordinal()] > 0);
	}

	@Test
	public void TestGetRandomsProducesSpade()
	{
		//we would expect to get at least some of each after 100 rolls.
		assertEquals(true, randomResults[(DiceValue.SPADE).ordinal()] > 0);
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
