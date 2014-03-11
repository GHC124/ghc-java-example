/**
 * DiceGame.java
 *
 *	
 */
package com.ghc.javaexample.thread.dice;

import java.util.ArrayList;
import java.util.List;

import com.ghc.javaexample.Log;

/**
 * 
 */
public class DiceGame {
	public enum Gamer {
		JOE, JANE
	};
	
	private Dice mDice;
	private List<Player> mPlayers;

	public DiceGame() {
		mDice = new Dice();
		mPlayers = new ArrayList<>();
	}

	public void addPlayer(Gamer gamer) {
		boolean exist = false;
		for (Player player : mPlayers) {
			if (player.getGamer() == gamer) {
				exist = true;
				break;
			}
		}
		if (exist) {
			Log.error(String.format("Gamer %s existed!", gamer.name()));
		} else {
			
		}
	}

	public void playGame() {
		for (Player player : mPlayers) {
			
		}
	}
}
