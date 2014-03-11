/**
 * Dice.java
 *
 *	
 */
package com.ghc.javaexample.thread.dice;

import java.util.Random;

/**
 * 
 */
public class Dice {
	private static final int MAX_POINT = 6;
	private Random mRandom;

	public Dice() {
		mRandom = new Random();
	}

	public int roll() {
		int point = 0;
		point = mRandom.nextInt(MAX_POINT);
		return point;
	}
}
