package com.snakeandladder;
import java.util.Random;
/**
 * Hello world!
 *
 */
public class App 
{
	static Random random = new Random();
	static int setPosition() {
		return 0;
	}
	static int rollDie() {
		int diceValue = (random.nextInt(10) % 6)+1;
		return diceValue;
	}
	static int checkCondition(int player1Position, int rollDieValue) {
		int condition = (random.nextInt(10) % 3);
		switch(condition) {
			case 0 :
				player1Position = player1Position + 0;
				break;
			case 1 :
				player1Position = player1Position + rollDieValue;
				break;
			case 2 :
				player1Position = player1Position - rollDieValue;
				break;
			default :
				break;
		}
		return player1Position;
	}
	static int checkDestination(int player1Position) {
		int i=0;
		while (player1Position<100) {
			int rollDieValue = rollDie();
			player1Position = checkCondition(player1Position , rollDieValue);
			if(player1Position < 0) {
				player1Position = setPosition();
			}
			else if(player1Position > 100) {
				player1Position = player1Position - rollDieValue;
			}
			System.out.println(i+" = "+ player1Position);
			i++;
		}
		System.out.println("Dies roll : "+ (i-1) + "\nPlayer final position : " + player1Position);
		return player1Position;
	}
	public static void main( String[] args )
	{
		System.out.println( "---------------------Welcome in Snake and ladder Game---------------------" );
		int player1Position = setPosition();
		checkDestination(player1Position);
	}
}
