import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class TestClass {

	public static void main(String[] args) throws IOException {		
		char choice;
		ArrayList<SlotMachine> slotArray = new ArrayList<>();
		ArrayList<Player> playerArray = new ArrayList<>();
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		SlotMachine luckySeven = new SlotMachine("Lucky 7", 5000, 10000, 0, 5000, 
				10, 0, 5);
		slotArray.add(luckySeven);
		SlotMachine luckyLotto = new SlotMachine("Lucky Lotto", 55000, 100000, 0, 75000, 
				50, 0, 25);
		slotArray.add(luckyLotto);
		SlotMachine purplePeopleEater = new SlotMachine("Purple People Eater", 1000, 50, 0, 40, 
				5, 0, 2);
		slotArray.add(purplePeopleEater);
		
		Name charlieN = new Name("Charlie", 'C', "Hunchuck");
		Date charlieDob = new Date(23, 3, 1960);
		Player charlie = new Player(5000, charlieN, charlieDob);
		
		playerArray.add(charlie);
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		do{
			choice = mainMenuChoice();
			switch(choice) {
			case 'A': // ADD A PLAYER
				playerArray.add(new Player(playerArray.size()));
				break;
			case 'M': // ADD A SLOT MACHINE
				slotArray.add(new SlotMachine(slotArray.size()));
				break;
			case 'P': // PLAY A SLOT MACHINE
				SlotMachine.playSlot(slotArray, playerArray, Player.pickPlayer(playerArray), SlotMachine.pickSlot(slotArray));
				break;
			case 'C': // CREATE PLAYER FILE
				Player.filePlayers(playerArray);
				break;
			case 'Q': // QUIT
				System.out.println("Thanks for for playing!.");
			default:
				System.out.println("Invalid selection");
			} // end switch
        }while (choice != 'Q');
		
	} // end main
	
	public static void displayMainMenu(){
		System.out.println("===========================");
		System.out.println("====== SLOT  MACHINE ======");
		System.out.println("===========================");
		System.out.println("[A] Add a player.");
		System.out.println("[M] Add a slot machine.");
		System.out.println("[P] Play a slot machine.");
		System.out.println("[C] Create player file.");
		System.out.println("[Q] Quit.");
		System.out.print("\nEnter selection: ");
	} // end displayMainMenu
	
	public static char mainMenuChoice(){
		char result;
		String temp;
		displayMainMenu();
		Scanner input = new Scanner(System.in);
		temp = input.next();
		temp = temp.toUpperCase();
		result = temp.charAt(0);
		return result;
	} // end mainMenuChoice
	
} // end TestClass
