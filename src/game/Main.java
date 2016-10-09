package game;

import java.util.List;
import java.io.*;

public class Main
{
	public static int totalWins;
	public static int totalLosses;

	public static void main(String[] args) throws IOException
	{
		boolean bSupressGeneralMessages = false;
		boolean bSupressRollMessages = false;
		if(args.length > 0)
		{
			bSupressGeneralMessages = true;
			if(args[0].equals("7"))
			{
				bSupressRollMessages = true;
			}
		}

		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();

        Player player = new Player("Fred", 100);
        Game game = new Game(d1, d2, d3);
        List<DiceValue> cdv = game.getDiceValues();

        totalWins = 0;
        totalLosses = 0;

/*        while (true)
        {*/
            int winCount = 0;
            int loseCount = 0;

            for (int i = 0; i < 100; i++)
            {
            	String name = "Fred";
            	int balance = 100;
            	int limit = 0;
                player = new Player(name, balance);
                player.setLimit(limit);
                int bet = 5;

                if(!bSupressGeneralMessages)
                {
	                System.out.println(String.format("Start Game %d: ", i));
	                System.out.println(String.format("%s starts with balance %d, limit %d",
	                		player.getName(), player.getBalance(), player.getLimit()));
                }

                int turn = 0;
                while (player.balanceExceedsLimitBy(bet) && player.getBalance() < 200)
                {
                    turn++;
                	DiceValue pick = DiceValue.getRandom();

                	if(!bSupressGeneralMessages)
                	{
	                	System.out.printf("Turn %d: %s bet %d on %s\n",
	                			turn, player.getName(), bet, pick);
                	}

                	int winnings = game.playRound(player, pick, bet);
                    cdv = game.getDiceValues();

                    if(!bSupressRollMessages)
                    {
	                    System.out.printf("Rolled %s, %s, %s\n",
	                    		cdv.get(0), cdv.get(1), cdv.get(2));
                    }

                    if (winnings > 0)
                    {
                    	if(!bSupressGeneralMessages)
                    	{
		                    System.out.printf("%s won %d, balance now %d\n\n",
		                    		player.getName(), winnings, player.getBalance());
                    	}
	                	winCount++;
                    }
                    else
                    {
                    	if(!bSupressGeneralMessages)
                    	{
		                    System.out.printf("%s lost, balance now %d\n\n",
		                    		player.getName(), player.getBalance());
                    	}
	                	loseCount++;
                    }
                    if(player.getBalance() - bet == player.getLimit())
                    {
                    	int kitty = 0;
                    }

                } //while
                if(!bSupressGeneralMessages)
                {
                	System.out.print(String.format("%d turns later.\nEnd Game %d: ", turn, i));
                	System.out.println(String.format("%s now has balance %d\n", player.getName(), player.getBalance()));
                }
            } //for

            if(!bSupressGeneralMessages)
            {
            	System.out.println(String.format("Win count = %d, Lose Count = %d, %.2f", winCount, loseCount, (float) winCount/(winCount+loseCount)));
            }
            totalWins += winCount;
            totalLosses += loseCount;

/*            String ans = console.readLine();
            if (ans.equals("q")) break;
        } //while true
*/
        if(!bSupressGeneralMessages)
        {
        	System.out.println(String.format("Overall win rate = %.1f%%", (float)(totalWins * 100) / (totalWins + totalLosses)));
        }
	}
}
