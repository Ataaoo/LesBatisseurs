package model;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.Serializable;

public class Game implements Serializable{
	private Player current;
	private ArrayList<Player> players;
	private Board board;

	/**
	 * The Game's constructor
	 * @param aName1 : the player1's name
	 * @param aName2 : the player2's name
	 * @param aName3 : the player3's name
	 * @param aName4 : the player4's name
	 * @param aBoard : the game's board
	 * @param aMode : the gamemode
	 */
	public Game(String aName1, String aName2, String aName3, String aName4, Board aBoard, Mode aMode) throws IOException {
		if(aBoard != null && aMode !=null){
			this.players = new ArrayList<Player>();
			this.board = aBoard;
			createPlayers(aName1,aName2,aName3,aName4,aBoard,aMode);
			this.board.addArrayListOfPlayers(players);
			this.board.initBoard();
			start();
		}
		else System.out.println("Game : Constructor : The board or the mode is missing");
	}

	/**
	 * Starts a party
	 */
	public void start() throws IOException {
		//Print the game's description
		System.out.println(description());

		//Pick up a random player
		Collections.shuffle(players);
		this.current = this.players.get(0);

		//The game's loop
		while (this.current.getVictoryPoints()<17){
			System.out.println(current);
			this.current.play();
			changeCurrent();
			this.board.printBoard();
		}
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
	 */
	public void save() throws IOException {
		System.out.println("Saving the game !");
		System.out.println("On which file do you want to save [1] / [2] / [3]");
		Scanner scan  = new Scanner(System.in);
		int taken = scan.nextInt();
		while(taken< 0 || taken >3){
			System.out.println("Please select a right option");
			taken = scan.nextInt();
		}
		String aFilePath = "data/save/save"+ taken;

		PrintWriter writer = new PrintWriter(aFilePath+"/partyInformations.txt", StandardCharsets.UTF_8);
		for(Player p : players){
			writer.println(p.toString());
		}
		writer.close();

		//Save the Game
		try {
			FileOutputStream fileOut = new FileOutputStream(aFilePath+"/Game.txt");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(this);
			objectOut.close();
			System.out.println("The Game  was successfully written in a file");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Prints a final message to announce the winner
	 * @param aWinner : the player that have won the game
	 */
	public void end(Player aWinner) {
	}


	private void changeCurrent(){
		int ind = this.players.indexOf(this.current);
		if (ind == this.players.size()){
			this.current = this.players.get(0);
		}
		else this.current = this.players.get(ind+1);
		System.out.println("\n\nThe current player is : " + this.current.getName());
	}

	/**
	 * Create the players
	 * @param aName1 : the player1's name
	 * @param aName2 : the player2's name
	 * @param aName3 : the player3's name
	 * @param aName4 : the player4's name
	 * @param aBoard : the game's board
	 */
	private void createPlayers(String aName1, String aName2, String aName3, String aName4, Board aBoard, Mode mode){
		switch (mode) {
			case AA :
				this.players.add(new AutoPlayer("Computer 1", aBoard,this));
				this.players.add(new AutoPlayer("Computer 2", aBoard,this));
				break;
			case AAA :
				this.players.add(new AutoPlayer("Computer 1", aBoard,this));
				this.players.add(new AutoPlayer("Computer 2", aBoard,this));
				this.players.add(new AutoPlayer("Computer 3", aBoard,this));
				break;
			case AAAA :
				this.players.add(new AutoPlayer("Computer 1", aBoard,this));
				this.players.add(new AutoPlayer("Computer 2", aBoard,this));
				this.players.add(new AutoPlayer("Computer 3", aBoard,this));
				this.players.add(new AutoPlayer("Computer 4", aBoard,this));
				break;
			case HH :
				this.players.add(new HumanPlayer(aName1, aBoard,this));
				this.players.add(new HumanPlayer(aName2, aBoard,this));
				break;
			case HHH :
				this.players.add(new HumanPlayer(aName1, aBoard,this));
				this.players.add(new HumanPlayer(aName2, aBoard,this));
				this.players.add(new HumanPlayer(aName3, aBoard,this));
				break;
			case HHHH :
				System.out.println("ok");
				this.players.add(new HumanPlayer(aName1, aBoard,this));
				this.players.add(new HumanPlayer(aName2, aBoard,this));
				this.players.add(new HumanPlayer(aName3, aBoard,this));
				this.players.add(new HumanPlayer(aName4, aBoard,this));
				break;
			case AAH :
				this.players.add(new AutoPlayer("Computer 1", aBoard,this));
				this.players.add(new AutoPlayer("Computer 2", aBoard,this));
				this.players.add(new HumanPlayer(aName3, aBoard,this));
				break;
			case AH :
				this.players.add(new AutoPlayer("Computer 1", aBoard,this));
				this.players.add(new HumanPlayer(aName2, aBoard,this));
				break;
			case AHH :
				this.players.add(new AutoPlayer("Computer 1", aBoard,this));
				this.players.add(new HumanPlayer(aName2, aBoard,this));
				this.players.add(new HumanPlayer(aName3, aBoard,this));
				break;
			case AAAH :
				this.players.add(new AutoPlayer("Computer 1", aBoard,this));
				this.players.add(new AutoPlayer("Computer 2", aBoard,this));
				this.players.add(new AutoPlayer("Computer 3", aBoard,this));
				this.players.add(new HumanPlayer(aName4, aBoard,this));
				break;
			case AAHH :
				this.players.add(new AutoPlayer("Computer 1", aBoard,this));
				this.players.add(new AutoPlayer("Computer 2", aBoard,this));
				this.players.add(new HumanPlayer(aName3, aBoard,this));
				this.players.add(new HumanPlayer(aName4, aBoard,this));
				break;
			case AHHH :
				this.players.add(new AutoPlayer("Computer 1", aBoard,this));
				this.players.add(new HumanPlayer(aName2, aBoard,this));
				this.players.add(new HumanPlayer(aName3, aBoard,this));
				this.players.add(new HumanPlayer(aName4, aBoard,this));
				break;
			}
		}
}
