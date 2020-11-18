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
	static int checkCondition(int player1Position) {
		int condition = (random.nextInt(10) % 3);
		switch(condition) {
			case 0 :
				player1Position = player1Position + 0;
				break;
			case 1 :
				player1Position = player1Position + rollDie();
				break;
			case 2 :
				player1Position = player1Position - rollDie();
				break;
			default :
				break;
		}
		return player1Position;
	}
	public static void main( String[] args )
	{
		System.out.println( "---------------------Welcome in Snake and ladder Game---------------------" );
		int startPosition = 0;
		int player1Position = startPosition;
		System.out.println(checkCondition(player1Position));
	}
}
