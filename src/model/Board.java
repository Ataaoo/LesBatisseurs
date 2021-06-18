package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	private int coinStorageAmount;
	private ArrayList<Worker> workers;
	private ArrayList<Building> buildings;
	private ArrayList<SpecialBuilding> specialBuildings;

	/**
	 * The Board's constructor
	 */
	public Board(String fileNameBat, String fileNameWorker,String fileNameSpecialBuilding) {
		configure(fileNameBat,fileNameWorker,fileNameSpecialBuilding);
	}

	/**
	 * Creates the board and init his component
	 */
	private void initBoard(){
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
	 * Return's a String that contains all the useful information about board
	 * @return : the String that contains all the useful information about board
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
	public int getWorkerStorageSize() {
		return this.workers.size();
	}

	public int getBuildingStorageSize(){
		return this.buildings.size();
	}

	public int getSpecialBuildingSize(){ return this.specialBuildings.size();}

	private void configure(String fileNameBat, String fileNameWorker,String fileNameSpecialBuilding){

		//Initialize the workers' card
		try{
			Scanner scanBat = new Scanner(new FileReader(fileNameWorker));
			while(scanBat.hasNext()){
				String[] tab = scanBat.next().split(";");
				this.workers.add(new Worker(tab[0],Integer.parseInt(tab[1]),Integer.parseInt(tab[2]),Integer.parseInt(tab[3]),Integer.parseInt(tab[4]),(int) Integer.parseInt(tab[5])));
			}
		}
		catch (FileNotFoundException e){
			System.out.println("Board : configuration : "+e.getMessage());
		}

		//Initialize the specialBuildings' card
		try{
			Scanner scanBat = new Scanner(new FileReader(fileNameSpecialBuilding));
			while(scanBat.hasNext()){
				String[] tab = scanBat.next().split(";");
				this.specialBuildings.add(new SpecialBuilding(tab[0],Integer.parseInt(tab[1]),Integer.parseInt(tab[2]),Integer.parseInt(tab[3]),Integer.parseInt(tab[4]),Integer.parseInt(tab[5]),Integer.parseInt(tab[6]),Integer.parseInt(tab[7]),Integer.parseInt(tab[8]),Integer.parseInt(tab[9])));
			}
		}
		catch (FileNotFoundException e){
			System.out.println("Board : configuration : "+e.getMessage());
		}

		//Initialize the buildings' card
		try{
			Scanner scanBat = new Scanner(new FileReader(fileNameBat));
			while(scanBat.hasNext()){
				String[] tab = scanBat.next().split(";");
				this.buildings.add(new Building(tab[0],Integer.parseInt(tab[1]),Integer.parseInt(tab[2]),Integer.parseInt(tab[3]),Integer.parseInt(tab[4]),Integer.parseInt(tab[5])));
			}
		}
		catch (FileNotFoundException e){
			System.out.println("Board : configuration : "+e.getMessage());
		}
	}
}