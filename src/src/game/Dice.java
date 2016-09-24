<<<<<<< HEAD:src/src/game/Dice.java
package game;

public class Dice
{
=======
public class Dice {
			
>>>>>>> parent of b12c512... Tidies up slightly:src/src/Dice.java
	private DiceValue value;
	
	public Dice() {
		value =  DiceValue.getRandom();
	}
	
	public DiceValue getValue() {
		return value;
	}

	public DiceValue roll() {
		return DiceValue.getRandom();
	}		
	
	public String toString() {
		return value.toString();
	}
}
