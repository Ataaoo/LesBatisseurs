package model;

public class SpecialBuilding extends Building {
	private int stoneProduced;
	private int tileProduced;
	private int woodProduced;
	private int knowledgeProduced;

	/**
	 * The Special building's constructor
	 * @param aName : The Special building's name
	 * @param aStone : The Special building's stone cost
	 * @param aTile : The Special building's tile cost
	 * @param aWood : The Special building's wood cost
	 * @param aKnowledge : The Special building's knowledge cost
	 * @param aCoinReward : The Special building's coin reward amount
	 * @param aStoneProduced : The Special building's produced stone amount
	 * @param aTileProduced : The Special building's produced tile amount
	 * @param aWoodProduced : The Special building's produced wood amounnt
	 * @param aKnowledgeProduced : The Special building's produced knowledge amount
	 */
	public SpecialBuilding(String aName, int aStone, int aTile, int aWood, int aKnowledge, int aCoinReward, int aStoneProduced, int aTileProduced, int aWoodProduced, int aKnowledgeProduced) {
		super(aName,aStone,aTile,aWood,aKnowledge,aCoinReward);
	}

	/**
	 * Gets the produced stone amount
	 * @return : the produced stone amount
	 */
	public int getStoneProduced() {
		return this.stoneProduced;
	}

	/**
	 * Stest the produced stone amount
	 * @param value : the new produced stone amount
	 */
	public void setStoneProduced(int value) {
	}

	/**
	 * Gets the produced tile amount
	 * @return : the produced stone amount
	 */
	public int getTileProduced() {
		return this.tileProduced;
	}

	/**
	 * Sets the produced tile amount
	 * @param value : the new produced tile amount
	 */
	public void setTileProduced(int value) {
	}

	/**
	 * Gets the produced wood amount
	 * @return : the produced stone amount
	 */
	public int getWoodProduced() {
		return this.woodProduced;
	}

	/**
	 * Sets the produced wood amount
	 * @param value : the new produced wood amount
	 */
	public void setWoodProduced(int value) {
	}

	/**
	 * Gets the produced knowledge amount
	 * @return : the produced stone amount
	 */
	public int getKnowledgeProduced() {
		return this.knowledgeProduced;
	}

	/**
	 * Sets the produced knowledge amount
	 * @param value : the new produced knowledge amount
	 */
	public void setKnowledgeProduced(int value) {
	}
}