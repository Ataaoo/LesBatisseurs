package model;

public abstract class Card {

	private String face;
	private String name;

	/**
	 * The card's constructor
	 * @param name
	 */
	public Card(String name) {
	}

	/**
	 * Flips the card
	 */
	public void flip() {
	}

	/**
	 * Return's a String that contains all the usefull informations about Card
	 * @return : the String that contains all the usefull informations about card
	 */
	public String toString() {
		return "toString of Card";
	}


}