package com.kata;

public enum Score {
	ZERO ("0"),
	ONE ("15"),
	TWO ("30"),
	THREE ("40"),
	ADVANTAGE ("ADV"),
	DEUCE ("DEUCE");

	private String name;
	
	private Score(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public Score add() {
		switch(this) {
			case ZERO:
				return ONE;
			case ONE:
				return TWO;
			case TWO:
				return THREE;
			case THREE:
				return ZERO;
			case ADVANTAGE:
				return ZERO;
			default :
				return ZERO;
		}
	}
}
