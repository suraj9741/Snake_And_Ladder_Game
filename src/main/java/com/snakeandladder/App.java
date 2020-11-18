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
	static int[] checkCondition(int player1Position, int rollDieValue , int playerTurn) {
		int[] multipalValues = new int[2];
		int condition = (random.nextInt(10) % 3);
		switch(condition) {
			case 0 :
				player1Position = player1Position + 0;
				if(playerTurn==0) {
					playerTurn=1;
				}
				else {
					playerTurn=0;
				}
				break;
			case 1 :
				player1Position = player1Position + rollDieValue;
				if(playerTurn==0) {
					playerTurn=0;
				}
				else {
					playerTurn=1;
				}
				break;
			case 2 :
				player1Position = player1Position - rollDieValue;
				if(playerTurn==0) {
					playerTurn=1;
				}
				else {
					playerTurn=0;
				}
				break;
			default :
				break;
		}
		multipalValues[0]=playerTurn;
		multipalValues[1]=player1Position;
		return multipalValues;
	}
	static int[] checkDestination(int player1Position , int player) {
		int rollDieValue = rollDie();
		int[] multipalValues = new int[2];
		multipalValues = checkCondition(player1Position, rollDieValue, player);
		player1Position = multipalValues[1];
		if(player1Position < 0) {
			player1Position = setPosition();
		}
		else if(player1Position > 100) {
			player1Position = player1Position - rollDieValue;
		}
		System.out.println("Player "+ (player+1) +" = "+ player1Position);
		//i++;
		//System.out.println("Dies roll : "+ (i-1) + "\nPlayer final position : " + player1Position);
		player=multipalValues[0];		
		multipalValues[0]=player;
		multipalValues[1]=player1Position;
		return multipalValues;
	}
	static int toss() {
		int playerTurn = random.nextInt(10) % 2;
		if (playerTurn == 0) {
			System.out.println("Player 1 win the toss");
		}
		else {
			System.out.println("Player 2 win the toss");
		}
		return playerTurn;
	}
	static void startGame() {
		int player1Position = setPosition();
		int player2Position = setPosition();
		int position = setPosition();
		int playerTurn = toss();
		int[] multipalValues = new int[2];
		while(position<100) {
			if(playerTurn == 0) {
				multipalValues = checkDestination(player1Position , playerTurn);
				player1Position = multipalValues[1];
				position = player1Position;
				playerTurn = multipalValues[0];
				if(position == 100) {
					System.out.println("Player 1 win the Game");
				}
			}
			else {
				multipalValues = checkDestination(player2Position , playerTurn);
				player2Position = multipalValues[1];
				position = player2Position;
				playerTurn = multipalValues[0];
				if(position == 100) {
					System.out.println("Player 2 win the Game");
				}
			}
		}
	}
	static void playGame() {
		
	}
	public static void main( String[] args )
	{
		System.out.println( "--------------------- Welcome to Snake and ladder Game ---------------------" );
		startGame();
	}
}
