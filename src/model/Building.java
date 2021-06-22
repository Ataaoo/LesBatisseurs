package model;

import java.util.ArrayList;

public class Building extends Card {
	private int coinReward;
	private int stoneCost;
	private int woodCost;
	private int tileCost;
	private int knowledgeCost;
	private int victoryPoints;
	private boolean isFinished = false;
	private ArrayList<Worker> workers;
	private ArrayList<SpecialBuilding> specialBuildings;

	/**
	 * The Building's constructor
	 * @param aName : the Building's name
	 * @param aStone : the Building's stone cost
	 * @param aTile : the Building's tle cost
	 * @param aWood : the Building's wood cost
	 * @param aKnowledge : the Building's knowledge
	 * @param aCoinReward : the Building's coin reward
	 */
	public Building(String aName,int aCoinReward,  int victoryPoints, int aStone,int aWood,  int aKnowledge, int aTile) {
		super(aName);
		workers = new ArrayList<>();
		specialBuildings = new ArrayList<>();
		if(aWood >=0) this.stoneCost = aStone;
		else System.out.println("Building : Constructor : wrong value for stoneCost");

		if(aWood >=0) this.woodCost = aWood;
		else System.out.println("Building : Constructor : wrong value for woodCost");

		if(aKnowledge >=0) this.knowledgeCost = aKnowledge;
		else System.out.println("Building : Constructor : wrong value for knowledgeCost");

		if(aTile >=0) this.knowledgeCost = aKnowledge;
		else System.out.println("Building : Constructor : wrong value for knowledgeCost");

		if(aCoinReward >=0) this.coinReward = aCoinReward;
		else System.out.println("Building : Constructor : wrong value for coinReward");

		if(victoryPoints >= 0) this.victoryPoints = victoryPoints;
		else System.out.println("Building : Constructor : Wrong value for victoryPoints");
	}

	/**
	 * Returns true if the building is finished, false if not
	 * @return : true if the building is finished, false if not
	 */
	public boolean isFinished() {
		int nbWoodFromWorker = 0;
		int nbStoneFromWorker = 0;
		int nbTileFromWorker = 0;
		int nbKnowledgeFromWorker = 0;
		for(Worker w : workers){
			nbWoodFromWorker += w.getWood();
			nbKnowledgeFromWorker += w.getKnowledge();
			nbStoneFromWorker =+ w.getStone();
			nbTileFromWorker += w.getTile();
		}
		for(SpecialBuilding s : specialBuildings){
			nbWoodFromWorker += s.getWoodProduced();
			nbKnowledgeFromWorker += s.getKnowledgeProduced();
			nbStoneFromWorker =+ s.getStoneProduced();
			nbTileFromWorker += s.getTileProduced();
		}
		if(nbKnowledgeFromWorker >= knowledgeCost && nbStoneFromWorker >= stoneCost && nbTileFromWorker >= tileCost && nbWoodFromWorker >= woodCost) this.isFinished = true;
		else this.isFinished = false;
		return isFinished;
	}

	/**
	 * Sets if the building is finished or not
	 * @param isFinished : the Building's state
	 */
	public void setIsFinished(boolean isFinished){
		this.isFinished = isFinished;
	}

	/**
	 * Gets the coin reward
	 * @return : the coin reward
	 */
	public int getCoinReward() {
		return coinReward;
	}

	/**
	 * Sets the coin reward
	 * @param coinReward : the new coin reward
	 */
	public void setCoinReward(int coinReward) {

		if(coinReward >= 0)this.coinReward = coinReward;
		else System.out.println("Building : setCoinReward : wrong value");
	}

	/**
	 * Gets the stone cost
	 * @return : the stone cost
	 */
	public int getStoneCost() {
		return stoneCost;
	}

	/**
	 * Sets the stone cost
	 * @param stoneCost : the new stone cost
	 */
	public void setStoneCost(int stoneCost) {
		if(stoneCost >= 0)this.stoneCost = stoneCost;
		else System.out.println("Building : setStoneCost : wrong value");
	}

	/**
	 * Gets the wood cost
	 * @return : the wood cost
	 */
	public int getWoodCost() {
		return woodCost;
	}

	/**
	 * Sets the wood cost
	 * @param woodCost : the new wood cost
	 */
	public void setWoodCost(int woodCost) {
		if(woodCost >= 0)this.woodCost = woodCost;
		else System.out.println("Building : setWoodCost : wrong value");
	}

	public int getVictoryPoints(){
		return this.victoryPoints;
	}
	/**
	 * Gets the Tile cost
	 * @return : the tile cost
	 */
	public int getTileCost() {
		return tileCost;
	}

	/**
	 * Sets the tile cost
	 * @param tileCost : the new tile cost
	 */
	public void setTileCost(int tileCost) {
		if(tileCost >= 0)this.tileCost = tileCost;
		else System.out.println("Building : setTileCost : wrong value");
	}

	/**
	 * Gets the knowledge cost
	 * @return : the knowledge cost
	 */
	public int getKnowledgeCost() {
		return knowledgeCost;
	}

	/**
	 * Sets the knowledge cost
	 * @param knowledgeCost : the new knowledge cost
	 */
	public void setKnowledgeCost(int knowledgeCost) {
		if(knowledgeCost >= 0)this.knowledgeCost = knowledgeCost;
		else System.out.println("Building : setKnowledgeCost : wrong value");
	}

	/**
	 * Add a worker to the construction site
	 * @param w : the worker that has to be added
	 */
	public void addWorker(Worker w){
		if(w != null) this.workers.add(w);
		else System.out.println("Building : addWorker : The worker is missing");
	}

	public void addSpecialBuilding(SpecialBuilding s){
		if(s != null ) this.specialBuildings.add(s);
		else System.out.println("Building : addSpecialBuilding : ");

	}

	@Override
	public String toString() {
		String ret = String.format("------------------------------\n" +
								   "	 Name : %s				\n" +
								   "	 CoinReward : %s				\n" +
								   "	 StoneCost : %s			\n" +
								   "	 WoodCost : %s				\n" +
								   "	 TileCost : %s				\n" +
								   "	 KnowledgeCost : %s 		\n" +
								   "------------------------------\n",
				super.getName(),
				this.coinReward,
				this.stoneCost,
				this.woodCost,
				this.tileCost,
				this.knowledgeCost);
		return ret;
	}

	public int nbWorkers(){
		return this.workers.size()+this.specialBuildings.size()-1;
	}

}