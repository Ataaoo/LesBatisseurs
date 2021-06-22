package model;

import java.io.Serializable;

public abstract class Card implements Serializable {

	private String face;
	private String name;

	/**
	 * The card's constructor
	 * @param name
	 */
	public Card(String name) {
		if (name != null) this.name = name;
		else System.out.println("Card : Constructor : Wrong name");
	}

	/**
	 * Flips the card
	 */
	public void flip() {
	}

	/**
	 * Return's a String that contains all the useful information about Card
	 * @return : the String that contains all the useful information about card
	 */
	public String toString() {
		return "toString of Card";
	}

	public String getName(){
		return this.name;
	}
}