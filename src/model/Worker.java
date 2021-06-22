package model;

public class Worker extends Card {
	private int cost;
	private int stone;
	private int tile;
	private int wood;
	private int knowledge;
	private boolean isIntern;
	private Building bat;

	public Worker(String aName, int aCost, int aStone, int aWood, int aKnowledge, int aTile) {
		super(aName);
		if (aStone >= 0) this.stone = aStone;
		else System.out.println("Worker : Constructor : Wrong value for stone");

		if (aWood >= 0) this.wood = aWood;
		else System.out.println("Worker : Constructor : Wrong value for wood");

		if (aTile >= 0) this.tile = aTile;
		else System.out.println("Worker : Constructor : Wrong value for tile");

		if (aKnowledge >= 0) this.knowledge = aKnowledge;
		else System.out.println("Worker : Constructor : Wrong value for knowledge");

		if(aCost >= 0) this.cost = aCost;
		else System.out.println("Worker : Constructor : Wrong value for cost");
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

	@Override
	public String toString() {
		String ret = String.format("\n-------------------------\n" +
								   "	 Name : %s				\n" +
								   "	 Cost : %s				\n" +
								   "	 Stone : %s			\n" +
								   "	 Wood : %s				\n" +
								   "	 Tile : %s				\n" +
								   "	 Knowledge : %s 		\n" +
								   "-------------------------\n",
				super.getName(),
				this.cost,
				this.stone,
				this.wood,
				this.tile,
				this.knowledge);
		return ret;
	}

	public int getStone() {
		return stone;
	}

	public int getTile() {
		return tile;
	}

	public int getWood() {
		return wood;
	}

	public int getKnowledge() {
		return knowledge;
	}
}