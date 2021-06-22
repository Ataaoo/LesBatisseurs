package model;

import java.io.IOException;
import java.util.Scanner;

public class HumanPlayer extends Player {

	/**
	 * The HumanPlayer's constructor
	 * @param name : the player's name
	 */
	public HumanPlayer(String name,Board board, Game game) {
		super(name, board, game);
	}

	/**
	 * The method that will collect the order from the player
	 */
	public void play() throws IOException {
		super.resetActionAmount();
		System.out.println("\n"+super.getName()+", it's your turn ! What do you want to do ?");
		String menu = "\n" +
					  "\nEnter your choice's number\n" +
					  "1] Open a construction site\n" +
					  "2] Recruit a Worker\n" +
					  "3] Send a Worker\n" +
					  "4] Take one / two / three coins\n" +
					  "5] Print your cards and your coins\n" +
					  "6] Print the board\n"+
				      "7] Buy Actions\n" +
					  "8] End your turn\n" +
					  "9] Quit and save";

		Scanner scan = new Scanner(System.in);

		boolean end = false;
		while(!end){
			System.out.printf("\nYou have %s actions left",super.getActionAmount());
			int nbActions = super.getActionAmount();
			System.out.println(menu);
			int choice = scan.nextInt();
			switch (choice){
				case 1:
					//Select a building
					super.board.printFiveFirstBuildings();
					System.out.println("Which building you want to start building ? Choose between 0 and 4");
					int t =scan.nextInt();
					while(t < 0 || t > 4) t = scan.nextInt();
					Building b = super.board.playerTakesBuilding(t);
					b.setIsFinished(false);
					super.buildings.add(b);
					super.useAction(1);
					break;
				case 2:
					super.board.printFiveFirstWorkers();
					//Ask the number of the worker that has to be recruited
					System.out.println("Which worker do you want to recruit ? Choose between 0 and 4");

					int taken = scan.nextInt();
					while(taken < 0 || taken > 4) taken = scan.nextInt();

					super.addWorker(super.board.playerTakesWorker(taken));
					super.useAction(1);
					break;
				case 3:
					if(super.nbWorkersUnused()>0 && super.nbBuildingsUnfinished() >0){
						checkIfSpecialBuildingIsFinished();
						//Send a worker to a construction site
						System.out.println("Choose the building");
						super.printBuildings();
						t = scan.nextInt();
						while(t<0 || t> super.buildings.size()) t = scan.nextInt();
						b = super.buildings.get(t);
						int nbWorkersOnIt = b.nbWorkers();
						if(nbActions >= nbWorkersOnIt){
							//Select a worker to send
							System.out.println("Which worker you want to send ?");
							System.out.println("If you want to send a specialBuilding, enter 10");
							super.printWorkersUnUsed();
							t = scan.nextInt();
							if(t ==10 ){
								System.out.println("You have chosen to send a Special Building, which one ?");
								super.printSpecialBuildings();
								t = scan.nextInt();
								while(t <0 || t > super.specialBuildingsFinished.size()) t = scan.nextInt();
							}
							else{
								while(t <0 || t > super.workers.size()) t = scan.nextInt();
								super.sendWorker(t,b);
							}
							super.sendWorker(t,b);
							nbWorkersOnIt = b.nbWorkers();
							System.out.println(nbWorkersOnIt);
							super.useAction(nbWorkersOnIt);
						}
						else System.out.println("You don't have enough actions to do this ! Please select something else");
					}else System.out.println("You can't send a worker if you don't have a worker and a construction site");
					break;

				case 4:
					//Take some coins
					String text = "How many coin do you want to take ?"+
							"\n1] 1 coin for 1 action"+
							"\n2] 3 coins for 2 actions"+
							"\n3] 6 coins for 3 actions";
					System.out.println(text);
					taken = scan.nextInt();

					while(taken >3 || 0 > taken) taken = scan.nextInt();
					if(taken <= nbActions){
						super.useAction(taken);
						if(taken ==1 ) super.addCoin(1);
						if(taken ==2 ) super.addCoin(3);
						if(taken ==3 ) super.addCoin(6);
					}
					else System.out.println("You don't have enough action to do that ! Please select something else");

					break;
				case 5:
					super.printBuildings();
					super.printWorkers();
					break;
				case 6:
					super.board.printBoard();
					break;
				case 7:
					System.out.println("You can buy 1 action for 5 coins");
					System.out.println("You have "+super.getCoinAmount()+" coins");
					taken = scan.nextInt();
					if(taken < 0 && taken > super.getCoinAmount()){
						System.out.println("Please select a right amount of actions");
						taken = scan.nextInt();
					}
					super.addActions(taken*5);
					break;
				case 8:
					System.out.println("You ended your turn !");
					end = true;
					break;
				case 9:
					System.out.println("Bye !");
					super.game.save();
					break;
			}
		}
	}

}