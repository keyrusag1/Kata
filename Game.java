package com.kata;

public class Game {
	public static void main(String[] args) {
		TennisSimple tennis = new TennisSimple("Jo-Wilfried", "Gaël Monfils");
		
		while(!tennis.isFinished()) {
			int winner = (int)(Math.random()*2);
			if(winner == 0) {
				tennis.playerOneWin();
			} else {
				tennis.playerTwoWin();
			}
			System.out.println(tennis.toString());
		}
	}
}
