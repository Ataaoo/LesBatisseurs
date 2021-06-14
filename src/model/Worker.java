package model;

public class Worker extends Card {
	private int cost;
	private String name;

	public Worker(String aName, int aStone, int aTile, int aWood, int aKnowledge, int aCost) {
		super(aName);
	}

	public Building isWorkingOn() {
		return new Building("",0,0,0,0,0);
	}

	public void startWorking() {
	}

	public void stopWorking() {
	}

	public int getCost() {
		return this.cost;
	}

}