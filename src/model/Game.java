package model;

public class Game {
	private ConfigGame _gameplay;
	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	private Player current;
	private Board board;
	private Mode mode;

	/**
	 * The Game's constructor
	 * @param aName1 : the player1's name
	 * @param aName2 : the player2's name
	 * @param aName3 : the player3's name
	 * @param aName4 : the player4's name
	 * @param aBoard : the gmae's board
	 * @param aMode : the gamemode
	 */
	public Game(String aName1, String aName2, String aName3, String aName4, Board aBoard, Mode aMode) {
	}

	/**
	 * Starts a party
	 */
	public void start() {
	}

	/**
	 * Prints the game's description
	 * ex : the player's names, the gamemode ...
	 * @return
	 */
	public String description() {
		return "description of Game";
	}

	/**
	 * Save the party in a file
	 * @param aFilePath : the path to the save file
	 */
	public void save(String aFilePath) {
	}

	/**
	 * Prints a final message to announce the winner
	 * @param aWinner : the player that have won the game
	 */
	public void end(Player aWinner) {
	}

	/**
	 * Return's a String that contains all the usefull informations about Game
	 * @return : the String that contains all the usefull informations about Game
	 */
	public String toString() {
		return "toString of Game";
	}

	/**
	 * Init all the game's component
	 */
	private void init() {
	}

	/**
	 * Create the players
	 * @param aName1 : the player1's name
	 * @param aName2 : the player2's name
	 * @param aName3 : the player3's name
	 * @param aName4 : the player4's name
	 * @param aBoard : the game's board
	 */
	private void createPlayers(String aName1, String aName2, String aName3, String aName4, Object aBoard) {
	}

}