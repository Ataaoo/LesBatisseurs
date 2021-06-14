package model;

public class Building extends Card {
	private int coinReward;
	private int stoneCost;
	private int woodCost;
	private int tileCost;
	private int knowledgeCost;
	private boolean isFinished;

	/**
	 * The Building's constructor
	 * @param aName : the Building's name
	 * @param aStone : the Building's stone cost
	 * @param aTile : the Building's tle cost
	 * @param aWood : the Building's wood cost
	 * @param aKnowledge : the Building's knowledge
	 * @param aCoinReward : the Building's coin reward
	 */
	public Building(String aName, int aStone, int aTile, int aWood, int aKnowledge, int aCoinReward) {
		super(aName);
	}

	/**
	 * Returns true if the building is finished, false if not
	 * @return : true if the building is finished, false if not
	 */
	public boolean isFinished() {
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
		this.coinReward = coinReward;
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
		this.stoneCost = stoneCost;
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
		this.woodCost = woodCost;
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
		this.tileCost = tileCost;
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
		this.knowledgeCost = knowledgeCost;
	}
}