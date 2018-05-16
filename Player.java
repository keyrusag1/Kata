package com.kata;

public class Player {
	private String name;
	private Score gameScore = Score.ZERO;
	private int setScore = 0;
	private int tieBreakScore = 0;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Score getGameScore() {
		return gameScore;
	}

	public void setGameScore(Score gameScore) {
		this.gameScore = gameScore;
	}
	
	public void addGameScore() {
		this.gameScore = this.gameScore.add();
	}
	
	public void resetScore() {
		this.gameScore = Score.ZERO;
	}
	
	public int getSetScore() {
		return setScore;
	}

	public void setSetScore(int setScore) {
		this.setScore = setScore;
	}
	
	public void addSetScore() {
		this.setScore++;
	}
	
	public int getTieBreakScore() {
		return tieBreakScore;
	}

	public void setTieBreakScore(int tieBreakScore) {
		this.tieBreakScore = tieBreakScore;
	}
	
	public void addTieBreakScore() {
		this.tieBreakScore++;
	}

	public String toString() {
		return this.name + " = " + this.gameScore;
	}
}
