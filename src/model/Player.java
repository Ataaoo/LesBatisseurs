package model;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Player implements Serializable {
	private int coinAmount = 10;
	private int action = 3;
	private String name;
	protected Board board;
	protected ArrayList<Worker> workers;
	protected ArrayList<Building> buildings;
	protected ArrayList<SpecialBuilding> specialBuildingsFinished;
	protected Game game;


	/**
	 * The Player's constructor
	 * @param aName : the player's name
	 */
	public Player(String aName, Board board, Game game) {
		workers = new ArrayList<Worker>();
		buildings = new ArrayList<Building>();
		specialBuildingsFinished = new ArrayList<SpecialBuilding>();
		if(aName != null) this.name = aName;
		else System.out.println("Player : constructor : the name is missing");

		if(board != null ) this.board = board;
		else System.out.println("Player : Constructor : The board is missing");

		this.game = game;
	}

	/**
	 * The abstract method play
	 */
	public abstract void play() throws IOException;


	/**
	 * Get his coinAmount
	 * @return : the coin amount
	 */
	public int getCoinAmount() {
		return this.coinAmount;
	}


	/**
	 * Pay for a worker
	 * @param aAmount : the amount that has to be substracted from coinAmount
	 */
	public void payCoin(int aAmount) {
	}

	public void addCoin(int amount){
		if(amount >= 0) this.coinAmount += amount;
		else System.out.println("Player : addCoin : The amount is wrong");
	}

	public void addActions(int amount){
		if(amount >= 0) this.action += amount;
		else System.out.println("Player : addActions : Wrong amount");
	}

	/**
	 * Updates the action amount
	 * @param amount
	 */
	public void useAction(int amount){
		if(amount >= 0) this.action = this.action - amount;
	}

	/**
	 * Reset at 3 the action amount
	 */
	public void resetActionAmount(){
		this.action = 3;
	}

	/**
	 * Prints all the player's worker
	 */
	public void printWorkers() {
		System.out.println("Your workers : ");
		for (Worker w : workers){
			String text = "Worker n° "+this.workers.indexOf(w)+w.toString();
			System.out.println(text);
		}
	}

	public void printWorkersUnUsed() {
		System.out.println("Your workers available: ");
		for (Worker w : workers){
			if(w.isWorkingOn() == null){
				String text = "Worker n° "+this.workers.indexOf(w)+w.toString();
				System.out.println(text);
			}

		}
	}

	public int nbWorkersUnused(){
		int ret = 0;
		for (Worker w : workers){
			if(w.isWorkingOn() == null) ret++;
		}
		return ret;
	}

	/**
	 * Prints all the player's building
	 */
	public void printBuildings() {
		System.out.println("Your buildings : ");
		for (Building b : buildings){
			String text = "Building n° "+this.buildings.indexOf(b)+"\n"+ b.toString();
			System.out.println(text);
		}
	}

	/**
	 * Prints all the player's building still in construction
	 */
	public void printBuildingsUnfinished() {
		System.out.println("Your buildings still in construction : ");
		for (Building b : buildings){
			if(!b.isFinished()){
				String text = "Building n° "+this.buildings.indexOf(b)+"\n"+ b.toString();
				System.out.println(text);
			}

		}
	}

	public int nbBuildingsUnfinished(){
		int ret = 0;
		for (Building b : buildings){
			if(!b.isFinished()){
				ret++;
			}

		}
		return ret;
	}

	/**
	 * Return's a String that contains all the useful information about Player
	 * @return : the String that contains all the useful information about Player
	 */
	public String toString() {
		return "Name : "+ this.name+
				"\nCoinAmount : "+this.coinAmount+
				"\nNumber of workers : " + this.workers.size();
	}

	/**
	 * Sends a worker to a building
	 */
	public void sendWorker(int indexWorker, Building b) {
		if(b != null ){
			if (indexWorker >= 0 && indexWorker < this.workers.size()){
				b.addWorker(this.workers.get(indexWorker));
			}
			else System.out.println("Player : sendWorker : the index is wrong");
		}
		else System.out.println("Player : sendWorker : the building is missing");
	}

	/**
	 * Gets the player's name
	 * @return : the player's name
	 */
	public String getName() {
		return this.name;
	}

	public void addWorker(Worker w){
		if(w !=null) this.workers.add(w);
		else System.out.println("Player : addWorker : the card is missing");

	}

	public void addBuilding(Building b){
		if(b !=null) this.buildings.add(b);
		else System.out.println("Player : addBuilding : the card is missing");
	}

	public void addSpecialBuildingFinished(SpecialBuilding s){
		this.specialBuildingsFinished.add(s);
		this.buildings.remove(s);
	}

	public int getVictoryPoints(){
		int ret = 0;
		for(Building b :buildings){
				if(b.isFinished()){
					ret += b.getVictoryPoints();
				}

		}
		return ret;
	}

	public int getActionAmount(){
		return this.action;
	}

	public void sendSpecialBuilding(int index, Building b){
		if(b != null ){
			if (index > 0 && index < this.workers.size()){
				b.addSpecialBuilding(this.specialBuildingsFinished.get(index));
			}
			else System.out.println("Player : sendWorker : the index is wrong");
		}
		else System.out.println("Player : sendWorker : the building is missing");
	}

	public void printSpecialBuildings(){
		System.out.println("Your Special Buildings");
		for (SpecialBuilding b : specialBuildingsFinished){
			String text = "Special Building n° "+this.specialBuildingsFinished.indexOf(b)+"\n"+ b.toString();
			System.out.println(text);
		}
	}

	public void checkIfSpecialBuildingIsFinished(){
		for(Building b : buildings){
			if(!specialBuildingsFinished.contains(b)){
				if(b.isFinished() && b.getClass()==SpecialBuilding.class){
					specialBuildingsFinished.add((SpecialBuilding) b);
				}
			}
		}
	}
}