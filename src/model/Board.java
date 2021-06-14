package model;

import java.util.ArrayList;
import model.Card;

public class Board {
	private int width;
	private int height;
	private int coinStorageAmount;
	private ArrayList<Card> cards;

	/**
	 * The Board's constructor
	 */
	public Board() {
	}

	/**
	 * Creates the board and init his composants
	 */
	private void initBoard() {
	}

	/**
	 * Return's the board's width
	 * @return : the board's width
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Return's the board's heigth
	 * @return : the board's heigth
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Prints the board
	 */
	public void printBoard() {
	}

	/**
	 * Prints a player, his cards, his money, because it will have to much information if this appears in printBoard()
	 * @param aN : The player's number
	 */
	public void printPlayer(int aN) {
	}

	/**
	 * Return's a String that contains all the usefull informations about board
	 * @return : the String that contains all the usefull informations about board
	 */
	public String toString() {
		return "toString of Board";
	}

	/**
	 * Adds a card to the ArrayList cards
	 */
	public void addCard() {
	}

	/**
	 * Remove a card from the ArrayList cards
	 */
	public void removeCard() {
	}

	/**
	 * Return's the ArrayList cards' size
	 * @return
	 */
	public int getCardStorageSize() {
		return -1;
	}
}