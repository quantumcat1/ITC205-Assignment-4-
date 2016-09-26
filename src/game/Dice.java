package game;

public class Dice
{
	private DiceValue value;

	public Dice()
	{
		value = DiceValue.getRandom();
	}

	public DiceValue getValue()
	{
		return value;
	}

	/*possible defect: the return value does not get
	 * captured. (i.e. it doesn't set 'value' to
	 * what it gets from the getRandom function).
	 * In Game.playRound, the dice is just rolled
	 * but the result is not captured.
	 */
	public DiceValue roll()
	{
		return DiceValue.getRandom();
	}

	public String toString()
	{
		return value.toString();
	}
}
