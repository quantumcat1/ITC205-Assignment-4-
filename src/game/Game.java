package game;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Game
{
	//why do we need DiceValues and Dice, when Dice contain a DiceValue instance variable?
	private List<Dice> dice;
	private List<DiceValue> values;

	public Game(Dice die1, Dice die2, Dice die3)
	{
		if (die1 == null || die2 == null || die3 == null)
		{
			throw new IllegalArgumentException("Dice cannot be null.");
		}
		dice = new ArrayList<Dice>();
		dice.add(die1);
		dice.add(die2);
		dice.add(die3);
		values = new ArrayList<DiceValue>();
	}

	/*
	 * Why do we need a separate list of DiceValues, when all we do is
	 * populate the list based on the values of the list of Dice?
	 * Why wouldn't we just use one list and then ask what the values
	 * are at the time that we need to know them? This makes no sense.
	 * Unless maybe we store the *prior* values so we can know the previous
	 * roll and the current roll. But in that case it's a very badly named
	 * variable! And in any case it would be better to have two lists of
	 * the same object type, if one is storing the previous values of the
	 * other.
	 */
	public List<DiceValue> getDiceValues()
	{
		values.clear();
		for (Dice d : dice)
		{
			values.add(d.getValue());
		}
		return Collections.unmodifiableList(values);
	}

	public int playRound(Player player, DiceValue pick, int bet)
	{
		if (player == null) throw new IllegalArgumentException("Player cannot be null.");
		if (pick == null) throw new IllegalArgumentException("Pick cannot be negative.");
		if (bet < 0) throw new IllegalArgumentException("Bet cannot be negative.");

		int matches = 0;
		for (Dice d : dice)
		{
			d.roll();
			if (d.getValue().equals(pick))
			{
				matches += 1;
			}
		}

		int winnings = matches * bet;

		if (matches > 0)
		{
			player.receiveWinnings(winnings);
		}
		else
		{
			player.takeBet(bet);
		}
        return winnings;
	}

	/*
	 * OK, one question is answered. Main uses "getDiceValues". But there is no
	 * reason to make it an actual instance variable of Game! It should just
	 * create this list for whenever Main wants it, but it doesn't need to store
	 * it itself, since it never actually uses it. It's weird. I wonder if it's
	 * related to any bugs? Probably not ... it's a little silly but I can't see
	 * how it would actually hurt anything? Well, I'll keep it in the back of
	 * my mind for now.
	 */
}
