package model;

public class ConfigGame {

	private Game gameplay;
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private Board board;
	private Mode mode;

	/**
	 * The ConfigGame's constructor
	 */
	public ConfigGame(){
	}

	/**
	 * Configure the game from the value got in StartMenu
	 */
	public void configure() {
	}

	/**
	 * Return's a String that contains all the usefull informations about ConfigGame
	 * @return : the String that contains all the usefull informations about ConfigGame
	 */
	public String toString() {
		return "toString of ConfigGame";
	}

	/**
	 * Loads information from a save file serialized
	 * @param filePath : the path to the file
	 */
	public void load(String filePath){
	}

	/**
	 * Start a menu to get all the information : create a new game or load another one, how many player if it's a new game
	 */
	public void startMenu(){

	}

	/**
	 * Gets the player1's name
	 * @return : the player1's name
	 */
	public String getName1() {
		return name1;
	}

	/**
	 * Sets the player1's name
	 * @param name1 : the new player1's name
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}

	/**
	 * Gets the player2's name
	 * @return : the player2's name
	 */
	public String getName2() {
		return name2;
	}

	/**
	 * Sets the player2's name
	 * @param name2 : the new player2's name
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}

	/**
	 * Gets the player3's name
	 * @return : the player3's name
	 */
	public String getName3() {
		return name3;
	}

	/**
	 * Sets the player3's name
	 * @param name3 : the new player3's name
	 */
	public void setName3(String name3) {
		this.name3 = name3;
	}

	/**
	 * Gets the player4's name
	 * @return : the player4's name
	 */
	public String getName4() {
		return name4;
	}

	/**
	 * Sets the player4's name
	 * @param name4 : the new player4's name
	 */
	public void setName4(String name4) {
		this.name4 = name4;
	}

	/**
	 * Gets the Game's Board
	 * @return : the game's board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Sets the game's baord
	 * @param board : the new game's board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * gets the gamemode
	 * @return : the new gamemode
	 */
	public Mode getMode() {
		return mode;
	}

	/**
	 * Sets the gamemode
	 * @param mode : the new gamemode
	 */
	public void setMode(Mode mode) {
		this.mode = mode;
	}
}