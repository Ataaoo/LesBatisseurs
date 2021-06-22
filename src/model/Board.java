package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Board implements Serializable {
	private int coinStorageAmount;
	private ArrayList<Worker> workers;
	private ArrayList<Worker> interns;
	private ArrayList<Building> buildings;
	private ArrayList<SpecialBuilding> specialBuildings;
	private ArrayList<Player> players;

	/**
	 * The Board's constructor
	 */
	public Board(String fileNameBat, String fileNameWorker,String fileNameSpecialBuilding) {
		workers = new ArrayList<Worker>();
		buildings = new ArrayList<Building>();
		specialBuildings = new ArrayList<SpecialBuilding>();
		interns = new ArrayList<Worker>();
		players = new ArrayList<Player>();

		configure(fileNameBat,fileNameWorker,fileNameSpecialBuilding);


	}

	public void addArrayListOfPlayers(ArrayList<Player> players){
		if( players != null) this.players = players;
		else System.out.println("Board : addArrayListOfPlayers : The array list is missing");
	}
	/**
	 * Creates the board and init his component
	 */
	public void initBoard(){
		//shuffle the buildings cards
		Collections.shuffle(buildings);

		//Give one intern to all the players
		Collections.shuffle(interns);
		for(Player p : players){
			p.addWorker(this.interns.get(0));
			this.interns.remove(0);
		}
		this.workers.addAll(this.interns);
		Collections.shuffle(workers);

	}

	/**
	 * Prints the board
	 */
	public void printBoard() {
		System.out.println("Cards in the building's stack : "+getBuildingStorageSize()+"\n");
		printFiveFirstBuildings();
		System.out.println("Cards in the worker's stack : "+getWorkerStorageSize()+"\n");
		printFiveFirstWorkers();
	}


	/**
	 * Return's a String that contains all the useful information about board
	 * @return : the String that contains all the useful information about board
	 */
	public String toString() {
		return "toString of Board";
	}


	/**
	 * Return's the ArrayList workers' size
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
				String[] tab = scanBat.nextLine().split(";");
				Worker w = new Worker(tab[0],Integer.parseInt(tab[1]),Integer.parseInt(tab[2]),Integer.parseInt(tab[3]),Integer.parseInt(tab[4]),Integer.parseInt(tab[5]));
				if(w.getName().equals("Apprenti")) this.interns.add(w);
				else this.workers.add(w);
			}
		}
		catch (FileNotFoundException e){
			System.out.println("Board : configuration : "+e.getMessage());
		}

		//Initialize the specialBuildings' card
		try{
			Scanner scanBat = new Scanner(new FileReader(fileNameSpecialBuilding));
			while(scanBat.hasNext()){
				String[] tab = scanBat.nextLine().split(";");
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
				String[] tab = scanBat.nextLine().split(";");
				this.buildings.add(new Building(tab[0],Integer.parseInt(tab[1]),Integer.parseInt(tab[2]),Integer.parseInt(tab[3]),Integer.parseInt(tab[4]),Integer.parseInt(tab[5]),Integer.parseInt(tab[6])));
			}
		}
		catch (FileNotFoundException e){
			System.out.println("Board : configuration : "+e.getMessage());
		}
	}


	public void printFiveFirstWorkers(){
		System.out.println("The workers available");
		Worker w0 = this.workers.get(0);
		Worker w1 = this.workers.get(1);
		Worker w2 = this.workers.get(2);
		Worker w3 = this.workers.get(3);
		Worker w4 = this.workers.get(4);
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------" +
						   "\nn°0 : " + w0.getName()+"\t\t\t"+				"n°1 : " + w1.getName()+					"\t\t\t"+"n°2 : " + w2.getName()+							"\t\t\t"+"n°3 : " + w3.getName()+"\t\t\t"+		"\t\t\t"+"n°4 : " + w4.getName()+"\t\t\t"+
						   "\nCost : " + w0.getCost()+"\t\t\t\t"+			"Cost : " + w1.getCost()+					"\t\t\t\t"+"Cost : " + w2.getCost()+"\t\t\t\t"+				"Cost : " + w3.getCost()+"\t\t\t\t"+			"Cost : " + w4.getCost()+"\t\t\t\t"+
						   "\nStone : " + w0.getStone()+"\t\t\t\t"+			"Stone : " + w1.getStone()+					"\t\t\t\t"+"Stone : " + w2.getStone()+"\t\t\t\t"+		"Stone : " + w3.getStone()+"\t\t\t\t"+				"Stone : " + w4.getStone()+"\t\t\t\t"+
						   "\nWood : " + w0.getWood()+"\t\t\t\t"+			"Wood : " + w1.getWood()+					"\t\t\t\t"+"Wood : " + w2.getWood()+"\t\t\t\t"+			"Wood : " + w3.getWood()+"\t\t\t\t"+				"Wood : " + w4.getWood()+"\t\t\t\t"+
						   "\nTile : " + w0.getTile()+"\t\t\t\t"+			"Tile : " + w1.getTile()+					"\t\t\t\t"+"Tile : " + w2.getTile()+"\t\t\t\t"+			"Tile : " + w3.getTile()+"\t\t\t\t"+				"Tile : " + w4.getTile()+"\t\t\t\t"+
						   "\nKnowledge" + w0.getKnowledge()+"\t\t\t\t"+	"Knowledge" + w1.getKnowledge()+			"\t\t\t\t"+ "Knowledge" + w2.getKnowledge()+"\t\t\t\t"+	"Knowledge" + w3.getKnowledge()+"\t\t\t\t"+			"Knowledge" + w4.getKnowledge()+"\t\t\t\t"+
						   "\n-------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	public void printFiveFirstBuildings(){
		System.out.println("The buildings available");
		Building b0 = this.buildings.get(0);
		Building b1 = this.buildings.get(1);
		Building b2 = this.buildings.get(2);
		Building b3 = this.buildings.get(3);
		Building b4 = this.buildings.get(4);

		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------" +
						   "\nn°0 : " + b0.getName()+"\t\t\t"+						"n°1 : " + b1.getName()+							"\t\t\t"+"n°2 : " + b2.getName()+								"\t\t\t"+"n°3 : " + b3.getName()+"\t\t\t"+				"\t\t\t"+"n°4 : " + b4.getName()+"\t\t\t"+
						   "\nCoinReward : " + b0.getCoinReward()+"\t\t\t\t"+		"CoinReward : " + b1.getCoinReward()+				"\t\t\t\t"+"CoinReward : " + b2.getCoinReward()+"\t\t\t\t"+		"CoinReward : " + b3.getCoinReward()+"\t\t\t\t"+		"CoinReward : " + b4.getCoinReward()+"\t\t\t\t"+
						   "\nStoneCost : " + b0.getStoneCost()+"\t\t\t\t"+			"StoneCost : " + b1.getStoneCost()+					"\t\t\t\t"+"StoneCost : " + b2.getStoneCost()+"\t\t\t\t"+		"StoneCost : " + b3.getStoneCost()+"\t\t\t\t"+			"StoneCost : " + b4.getStoneCost()+"\t\t\t\t"+
						   "\nWoodCost : " + b0.getWoodCost()+"\t\t\t\t"+			"WoodCost : " + b1.getWoodCost()+					"\t\t\t\t"+"WoodCost : " + b2.getWoodCost()+"\t\t\t\t"+			"WoodCost : " + b3.getWoodCost()+"\t\t\t\t"+			"WoodCost : " + b4.getWoodCost()+"\t\t\t\t"+
						   "\nTileCost : " + b0.getTileCost()+"\t\t\t\t"+			"TileCost : " + b1.getTileCost()+					"\t\t\t\t"+"TileCost : " + b2.getTileCost()+"\t\t\t\t"+			"TileCost : " + b3.getTileCost()+"\t\t\t\t"+			"TileCost : " + b4.getTileCost()+"\t\t\t\t"+
						   "\nKnowledgeCost" + b0.getKnowledgeCost()+"\t\t\t\t"+	"KnowledgeCost" + b1.getKnowledgeCost()+			"\t\t\t\t"+ "KnowledgeCost" + b2.getKnowledgeCost()+"\t\t\t\t"+	"KnowledgeCost" + b3.getKnowledgeCost()+"\t\t\t\t"+		"KnowledgeCost" + b4.getKnowledgeCost()+"\t\t\t\t"+
						   "\n-------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	public Worker playerTakesWorker(int index){
		Worker ret = null;
		if(index < 5){
			ret = this.workers.get(index);
			this.workers.remove(index);
		}
		return ret;
	}

	public Building playerTakesBuilding(int index){
		Building ret = null;
		if(index < 5){
			ret = this.buildings.get(index);
			this.buildings.remove(index);
		}
		return ret;
	}
}