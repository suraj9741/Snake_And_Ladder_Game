package com.snakeandladder;
import java.util.Random;
/**
 * Hello world!
 *
 */
public class App 
{
	static Random random = new Random();
	static int rollDie() {
		int diceValue = (random.nextInt(10) % 6)+1;
		return diceValue;
	}
    public static void main( String[] args )
    {
        System.out.println( "---------------------Welcome in Snake and ladder Game---------------------" );
        int startPosition = 0;
        int player1Position = startPosition;
        System.out.println(rollDie());
    }
}
