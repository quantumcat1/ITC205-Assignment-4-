package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner
{
	public static void main(String[] args)
	{
		Result result = JUnitCore.runClasses(DiceValueTest.class);
		for(Failure failure : result.getFailures())
		{
			System.out.println(failure.toString());
		}
		System.out.println("DiceValue unit testing success: " + result.wasSuccessful());

		result = JUnitCore.runClasses(PlayerTest.class);
		for(Failure failure : result.getFailures())
		{
			System.out.println(failure.toString());
		}
		System.out.println("Player unit testing success: " + result.wasSuccessful());

		result = JUnitCore.runClasses(GameTest.class);
		for(Failure failure : result.getFailures())
		{
			System.out.println(failure.toString());
		}
		System.out.println("Game unit testing success: " + result.wasSuccessful());
	}
}