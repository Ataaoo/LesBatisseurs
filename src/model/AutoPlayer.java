package model;

import java.util.Random;

public class AutoPlayer extends Player {

	/**
	 * The AutoPlayer constructor
	 * @param name ; the AutoPLayer's name
	 */
	public AutoPlayer(String name, Board board, Game game) {
		super(name, board, game);
	}

	/**
	 * A methods that simulate a player playing at the game
	 */
	public void play() {
		Random rand = new Random();
		int choice = rand.nextInt(5);
		switch (choice){
			case 0:
				//Open a construction site -> Select a building
				super.buildings.add(super.board.playerTakesBuilding(rand.nextInt(4)));
				break;
			case 1:
				int taken = rand.nextInt(5);
				super.addWorker(super.board.playerTakesWorker(taken));
				super.useAction(1);
				break;
			case 2:
				super.checkIfSpecialBuildingIsFinished();
				taken  = rand.nextInt(super.buildings.size());
				Building b = super.buildings.get(taken);

				//Choose the worker
				if(super.specialBuildingsFinished.size()>0){
					taken = rand.nextInt(2);
					if(taken == 0) super.sendWorker(rand.nextInt(super.workers.size()),b);
					else super.sendSpecialBuilding(rand.nextInt(super.workers.size()),b);
				}
				else super.sendWorker(rand.nextInt(super.workers.size()),b);
				break;
			case 3:
				super.addCoin(rand.nextInt(super.getActionAmount())+1);
				break;
			case 4:
				super.addActions(rand.nextInt(super.getCoinAmount()+1)*5);
				break;
		}

		while(super.getActionAmount()>0){
			choice = rand.nextInt(5);
			switch (choice){
				case 0:
					//Open a construction site -> Select a building
					super.buildings.add(super.board.playerTakesBuilding(rand.nextInt(4)));
					break;
				case 1:
					int taken = rand.nextInt(5);
					super.addWorker(super.board.playerTakesWorker(taken));
					super.useAction(1);
					break;
				case 2:
					super.checkIfSpecialBuildingIsFinished();
					taken  = rand.nextInt(super.buildings.size());
					Building b = super.buildings.get(taken);

					//Choose the worker
					if(super.specialBuildingsFinished.size()>0){
						taken = rand.nextInt(2);
						if(taken == 0) super.sendWorker(rand.nextInt(super.workers.size()),b);
						else super.sendSpecialBuilding(rand.nextInt(super.workers.size()),b);
					}
					else super.sendWorker(rand.nextInt(super.workers.size()),b);
					break;
				case 3:
					super.addCoin(rand.nextInt(super.getActionAmount())+1);
					break;
				case 4:
					super.addActions(rand.nextInt(super.getCoinAmount()+1)*5);
					break;
			}
		}

	}
}