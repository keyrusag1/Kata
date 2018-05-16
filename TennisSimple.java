package com.kata;

public class TennisSimple {
	private Player playerOne;
	private Player playerTwo;
	private boolean finished = false;
	
	public TennisSimple(String one, String two) {
		this.playerOne = new Player(one);
		this.playerOne.resetScore();
		this.playerTwo = new Player(two);
		this.playerTwo.resetScore();
	}
	
	public void playerOneWin() {
		if(!finished)
			rule(this.playerOne, this.playerTwo);
	}
	
	public void playerTwoWin() {
		if(!finished)
			rule(this.playerTwo, this.playerOne);
	}
	
	private void rule(Player playerWinner, Player playerLooser) {
	// Deuce rule
		if(playerWinner.getGameScore().equals(Score.THREE)
				&& playerLooser.getGameScore().equals(Score.THREE)) {
			playerWinner.setGameScore(Score.ADVANTAGE);
		} else if(playerWinner.getGameScore().equals(Score.THREE)
				&& playerLooser.getGameScore().equals(Score.ADVANTAGE)) {
			playerWinner.setGameScore(Score.DEUCE);
			playerLooser.setGameScore(Score.DEUCE);
		} else if(playerWinner.getGameScore().equals(Score.DEUCE)) {
			playerWinner.setGameScore(Score.ADVANTAGE);
			playerLooser.setGameScore(Score.THREE);
		} else {
	// Normal rule 
			playerWinner.addGameScore();
		}
	// Tie Break rule
		if(playerWinner.getSetScore() == 6 && playerLooser.getSetScore() == 6) {
			this.resetScore();
			playerWinner.addTieBreakScore();
			// Win the game
			if(playerWinner.getTieBreakScore() >= 7) {
				playerWinner.addSetScore();
				this.finished = true;
			}
		} else {
	// Normal rule 
			// Win the set
			if(playerWinner.getGameScore().equals(Score.ZERO)) {
				this.resetScore();
				playerWinner.addSetScore();
			}
			// Win the game
			if(playerWinner.getSetScore() >= 7) {
				this.finished = true;
			}
		}
	}

	private void resetScore() {
		this.playerOne.resetScore();
		this.playerTwo.resetScore();
	}
	
	public boolean isFinished() {
		return this.finished;
	}
	
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		
		if(this.playerOne.getSetScore() >= 7) {
			s.append(this.playerOne.getName() + " win the game.\n");
		}		
		if(this.playerTwo.getSetScore() >= 7) {
			s.append(this.playerTwo.getName() + " win the game.\n");
		}
		
		s.append(this.playerOne.getName()
				+ "\t" + this.playerOne.getGameScore()
				+ "\t" + this.playerOne.getSetScore());
		if(this.playerOne.getTieBreakScore() > 0 || this.playerTwo.getTieBreakScore() > 0) {
			s.append("\t" + this.playerOne.getTieBreakScore() + "\n");
		} else {
			s.append("\n");
		}
		
		s.append(this.playerTwo.getName()
				+ "\t" + this.playerTwo.getGameScore()
				+ "\t" + this.playerTwo.getSetScore());
		if(this.playerOne.getTieBreakScore() > 0 || this.playerTwo.getTieBreakScore() > 0) {
			s.append("\t" + this.playerTwo.getTieBreakScore() + "\n");
		} else {
			s.append("\n");
		}
		
		return s.toString();
	}
}
