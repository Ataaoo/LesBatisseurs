package model;

import java.util.ArrayList;
import model.Card;

public abstract class Player {
	private int coinAmount;
	private int pointAmount;
	private String name;
	public ArrayList<Card> cards;

	/**
	 * The Player's constructor
	 * @param aName : the player's name
	 */
	public Player(String aName) {
		if(aName != null) this.name = aName;
		else System.out.println("Player : constructor : the name is missing");
	}

	/**
	 * The abstract method play
	 */
	public abstract void play();

	/**
	 * Print all the cards in the ArrayList cards
	 */
	public void printCards() {
	}

	/**
	 * Get his coinAmount
	 * @return : the coin amount
	 */
	public int getCoinAmount() {
		return this.coinAmount;
	}

	/**
	 * Sets the coin amount
	 * @param coinAmount : the new coin amount
	 */
	public void setCoinAmount(int coinAmount) {
	}

	/**
	 * Pay for a worker
	 * @param aAmount : the amount that has to be substracted from coinAmount
	 */
	public void pay(int aAmount) {
	}

	/**
	 * Print a worker
	 */
	public void printWorker() {
	}

	/**
	 * Prints a building
	 */
	public void printBuilding() {
	}

	/**
	 * Return's a String that contains all the usefull informations about Player
	 * @return : the String that contains all the usefull informations about Player
	 */
	public String toString() {
		return "toString of Player";
	}

	/**
	 * Sends a worker to a building
	 */
	private void sendWorker() {
	}

	/**
	 * Gets the player's name
	 * @return : the player's name
	 */
	public String getName() {
		return this.name;
	}
}