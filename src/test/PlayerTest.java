package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import game.Player;

public class PlayerTest
{
	/*
	 * To test:
	 * - receiveWinnings
	 * - takeBet
	 * - balanceExceedsLimitBy: I don't really understand what this
	 * function is for, so there's not much point testing it (I
	 * would only be testing that it did what i could see the
	 * function actually doing, which would be a bit of a
	 * tautology and wouldn't tell me anything.
	 * - balanceExceedsLimit: this one is also very straightforward,
	 * the test would be identical to the program code so not a lot
	 * of point testing it.
	 */

	Player player;

	public PlayerTest()
	{
		player = new Player("Mike", 20);
		assertEquals(0, player.getLimit());
		assertEquals(20, player.getBalance());
	}

	@Test
	public void TestReceiveWinnings()
	{
		int balance = player.getBalance();
		int winnings = 10;
		player.receiveWinnings(winnings);
		assertEquals(balance + winnings, player.getBalance());

		player.setBalance(balance);
	}

	/*indirectly we can test the "balance exceeds limits" functions.
	 * We don't know what they're supposed to do or what their
	 * purpose is exactly but one occurs in takeBet and has a
	 * exception so we can do what the exception says and see if it
	 * gets raised.
	 */

	//this test may get refined once I understand what is actually meant
	//to be happening.

	@Test
	public void TestTakeBetNegative()
	{
		int bet = -1;
		int balance = player.getBalance();
		try
		{
			player.takeBet(bet);
			assertEquals(true, false); //if we get to this point, the exception was not thrown.
		}
		catch(IllegalArgumentException e)
		{
			assertEquals(true, e.getMessage().equals("Bet cannot be negative."));
		}
		finally
		{
			player.setBalance(balance);
			/*just in case it changed - in finally block so it gets put back
			 * whether or not an exception was thrown (so it won't affect the
			 * other tests)
			 */
		}
	}



	@Test
	public void TestTakeBetGood()
	{
		int balance = player.getBalance();
		assertEquals(true, balance > 2); //so we can make sure we get a positive bet that is smaller than balance
		int bet = balance - 1;

		boolean bThrewException = true;
		try
		{
			player.takeBet(bet);
			bThrewException = false; //only gets here if no exception thrown.
		}
		catch(IllegalArgumentException e)
		{
			assertEquals(true, false);//don't want an exception thrown
		}
		finally
		{
			assertEquals(false, bThrewException);
			player.setBalance(balance);
			/*just in case it changed - in finally block so it gets put back
			 * whether or not an exception was thrown (so it won't affect the
			 * other tests)
			 */
		}
	}

	@Test
	public void TestTakeBetBig()
	{
		int limit = player.getLimit();
		int balance = player.getBalance();
		player.setLimit(5);
		int bet = balance - player.getLimit() + 1;

		try
		{
			player.takeBet(bet);
			assertEquals(true, false); //if we get to this point, the exception was not thrown.
		}
		catch(IllegalArgumentException e)
		{
			assertEquals(true, e.getMessage().equals("Placing bet would go below limit."));
		}
		finally
		{
			player.setBalance(balance);
			player.setLimit(limit);
			/*just in case it changed - in finally block so it gets put back
			 * whether or not an exception was thrown (so it won't affect the
			 * other tests)
			 */
		}
	}
}
