/**
 * Player.java
 *
 *	
 */
package com.ghc.javaexample.thread.dice;

import com.ghc.javaexample.Log;
import com.ghc.javaexample.thread.dice.DiceGame.Gamer;

/**
 * 
 */
public class Player implements Runnable {
	private int mPoint;
	private Gamer mGamer;
	private Dice mDice;

	private static final int MAX_THROWS = 6;

	public Player(Gamer gamer, Dice dice) {
		mGamer = gamer;
		mPoint = 0;
		mDice = dice;
	}

	public Gamer getGamer() {
		return mGamer;
	}

	public void setGamer(Gamer gamer) {
		mGamer = gamer;
	}

	public int getPoint() {
		return mPoint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < MAX_THROWS; i++) {
			synchronized (mDice) {
				Log.debug("Player %s throw dice: ", mGamer.name());
				mPoint = mDice.roll();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
