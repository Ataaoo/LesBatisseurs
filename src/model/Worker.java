package model;

public class Worker extends Card {
	private int cost;
	private String name;
	private int stone;
	private int tile;
	private int wood;
	private int knowledge;
	private boolean isIntern;
	private Building bat;

	public Worker(String aName, int aStone, int aTile, int aWood, int aKnowledge, int aCost) {
		super(aName);
		if (aStone >= 0) this.stone = aStone;
		else System.out.println("Worker : Constructor : Wrong value for stone");

		if (aWood >= 0) this.stone = aWood;
		else System.out.println("Worker : Constructor : Wrong value for wood");

		if (aTile >= 0) this.stone = aTile;
		else System.out.println("Worker : Constructor : Wrong value for tile");

		if (aKnowledge >= 0) this.stone = aKnowledge;
		else System.out.println("Worker : Constructor : Wrong value for knowledge");
	}


	public Building isWorkingOn() {
		return this.bat;
	}

	public void startWorkingOn(Building bat){
		if(bat != null) this.bat = bat;
		else System.out.println("Worker : startWorkingOn : The building isn't specified");
	}

	public void stopWorking() {
		this.bat = null;
	}

	public int getCost() {
		return this.cost;
	}

	public boolean isIntern(){
		return this.isIntern;
	}

}