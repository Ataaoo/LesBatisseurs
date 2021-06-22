package model;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class ConfigGame {

	private Game gameplay;
	private Board board;
	private Mode mode;
	private String fileBat = "data/rowData/batiments.txt";
	private String fileWorkers = "data/rowData/ouvriers.txt";
	private String fileSpecialBuildings = "data/rowData/machines.txt";

	/**
	 * The ConfigGame's constructor
	 */
	public ConfigGame() throws IOException {
		Scanner scan = new Scanner(System.in);
		startMenu(scan);
	}


	/**
	 * Return's a String that contains all the usefull informations about ConfigGame
	 * @return : the String that contains all the usefull informations about ConfigGame
	 */
	public String toString() {
		return "toString of ConfigGame";
	}

	/**
	 * Loads information from a save file serialized
	 */
	public void load(int nbGame){
		String path = "data/save/save"+nbGame+"/Game.txt";
		ObjectInputStream OIS = null;
		try {
			OIS = new ObjectInputStream(new FileInputStream(path));
			this.gameplay = (Game)(OIS.readObject());
			this.gameplay.start();
			OIS.close();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("load(path) - Error : " + e.getMessage());
		}
	}


	/**
	 * Start a menu to get all the information : create a new game or load another one, how many player if it's a new game
	 */
	public void startMenu(Scanner scan) throws IOException {
		System.out.println("Welcome to \"Les Bâtisseurs : Moyen-Âge \"");
		System.out.println("Voulez-vous :\n" +
						   "1] Lancer une nouvelle partie\n" +
						   "2] Charger une nouvelle partie\n" +
						   "3] Voir les règles\n" +
						   "4] Quitter le jeu\n" +
						   "Veuillez entrer le numéro de votre choix");


		int choice = scan.nextInt();
		while(choice >4 || choice <1){
			System.out.println("Please select a right option");
			choice = scan.nextInt();
		}

		switch(choice) {
			case 1:
				createGame(scan);
			case 2:
				System.out.println("Which party do you want to load ?");
				System.out.println("\n\nThe party n°1");
				Scanner loadScan = new Scanner(new FileReader("data/save/save1/partyInformations.txt"));
				while(loadScan.hasNextLine()){
					System.out.println(loadScan.nextLine());
				}

				System.out.println("\n\nThe party n°2");
				loadScan = new Scanner(new FileReader("data/save/save2/partyInformations.txt"));
				while(loadScan.hasNextLine()){
					System.out.println(loadScan.nextLine());
				}

				System.out.println("\n\nThe party n°3");
				loadScan = new Scanner(new FileReader("data/save/save3/partyInformations.txt"));
				while(loadScan.hasNextLine()){
					System.out.println(loadScan.nextLine());
				}

				int nbParty = scan.nextInt();
				while(nbParty> 3 || nbParty<0){
					System.out.println("Please select a right option");
					nbParty = scan.nextInt();
				}

				load(nbParty);
				break;
			case 3:
				System.out.println("Here are the gamerules : \n https://studiobombyx.com/assets/LES-BATISSEURS_MOYEN-AGE_rulebook_FR.pdf");
				break;
			case 4 :
				System.out.println("A bientôt !");
				break;
		}


	}

	private void createGame(Scanner scan) throws IOException {
		System.out.println("Let's create a game !\n" +
						   "How many players ? Choose an option between 1 and 12\n" +
						   "1] 1 Computer and 1 Human\n" +
						   "2] 1 Computer and 2 Humans\n" +
						   "3] 1 Computer and 3 Humans\n" +
						   "4] 2 Computers\n" +
						   "5] 2 Computers and 1 Human\n" +
						   "6] 2 Computers and 2 Humans\n" +
						   "7] 3 Computers\n" +
						   "8] 3 Computers and 1 Human\n" +
						   "9] 4 Computers\n" +
						   "10] 2 Humans\n" +
						   "11] 3 Humans\n" +
						   "12] 4 Humans");
		int t = scan.nextInt();
		while(t >12 || t < 1){
			System.out.println("Please select a correct value");
			t=scan.nextInt();
		}
		switch (t){
			case 1:
				System.out.println("What is the player1's name ?");
				String name = scan.next();
				this.gameplay = new Game(null,name,null,null,new Board(fileBat,fileWorkers,fileSpecialBuildings),Mode.AH);
				break;
			case 2:
				System.out.println("What is the player1's name ?");
				name = scan.next();
				System.out.println("What is the player2's name ?");
				String name2 = scan.next();
				this.gameplay = new Game(null,name,name2,null,new Board(fileBat,fileWorkers,fileSpecialBuildings),Mode.AHH);
				break;
			case 3:
				System.out.println("What is the player1's name ?");
				name = scan.next();
				System.out.println("What is the player2's name ?");
				name2 = scan.next();
				System.out.println("What is the player3's name ?");
				String name3 = scan.next();
				this.gameplay = new Game(null,name,name2,name3,new Board(fileBat,fileWorkers,fileSpecialBuildings),Mode.AHHH);
				break;
			case 4:
				this.gameplay = new Game(null,null,null,null,new Board(fileBat,fileWorkers,fileSpecialBuildings),Mode.AA);
				break;
			case 5:
				System.out.println("What is the player1's name ?");
				name = scan.next();
				this.gameplay = new Game(null,null,name,null,new Board(fileBat,fileWorkers,fileSpecialBuildings),Mode.AAH);
				break;
			case 6:
				System.out.println("What is the player1's name ?");
				name = scan.next();
				System.out.println("What is the player2's name ?");
				name2 = scan.next();
				this.gameplay = new Game(null,null,name,name2,new Board(fileBat,fileWorkers,fileSpecialBuildings),Mode.AAHH);
				break;
			case 7:
				this.gameplay = new Game(null,null,null,null,new Board(fileBat,fileWorkers,fileSpecialBuildings),Mode.AAA);
				break;
			case 8:
				System.out.println("What is the player1's name ?");
				name = scan.next();
				this.gameplay = new Game(null,null,null,name,new Board(fileBat,fileWorkers,fileSpecialBuildings),Mode.AAAH);
				break;
			case 9:
				this.gameplay = new Game(null,null,null,null,new Board(fileBat,fileWorkers,fileSpecialBuildings),Mode.AAAA);
				break;
			case 10:
				System.out.println("What is the player1's name ?");
				name = scan.next();
				System.out.println("What is the player2's name ?");
				name2 = scan.next();
				this.gameplay = new Game(name,name2,null,null,new Board(fileBat,fileWorkers,fileSpecialBuildings),Mode.HH);
				break;
			case 11 :
				System.out.println("What is the player1's name ?");
				name = scan.next();
				System.out.println("What is the player2's name ?");
				name2 = scan.next();
				System.out.println("What is the player3's name ?");
				name3 = scan.next();
				this.gameplay = new Game(name,name2,name3,null,new Board(fileBat,fileWorkers,fileSpecialBuildings),Mode.HHH);
				break;
			case 12:
				System.out.println("What is the player1's name ?");
				name = scan.next();
				System.out.println("What is the player2's name ?");
				name2 = scan.next();
				System.out.println("What is the player3's name ?");
				name3 = scan.next();
				System.out.println("What is the player4's name ?");
				String name4 = scan.next();
				this.gameplay = new Game(name,name2,name3,name4,new Board(fileBat,fileWorkers,fileSpecialBuildings),Mode.HHHH);
				break;
		}

	}
}