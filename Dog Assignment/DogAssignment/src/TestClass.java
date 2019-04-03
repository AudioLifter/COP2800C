//Name: Jonathan De La Cruz
//Date: 2/15/19
//Purpose: February 13th Assignment

import java.util.ArrayList;
import java.util.*;

public class TestClass {

	public static void main(String[] args) {
		char choice;
		// create an array list to hold dogs
		ArrayList<Dog> dogs = new ArrayList();

				
		do {
        	choice = getChoice();
        	switch(choice) {
        	case 'A': // add a dog
        		Dog.addDog(dogs);
        	    break;
        	case 'B': // display all dogs
        		Dog.displayAllDogs(dogs);
        		break;
        	case 'C': // remove a dog
        		Dog.removeDog(dogs);
        		break;
        	case 'D': // statistics for all dogs
        		Dog.dogStats(dogs);
        		break;
        	case 'Q': // quit
        		System.out.println("Thanks for using my program.");
        	default:
        		System.out.println("Invalid selection");
        	} // end switch
        }while (choice != 'Q');

	} // end main
	//***********************************
	
	public static void displayMenu() {
		System.out.println("\n(A) add a dog");
		System.out.println("(B) display all dogs");
		System.out.println("(C) remove a dog by name");
		System.out.println("(D) statistics for all dogs");
		System.out.println("(Q) quit");
		System.out.print("\nEnter selection: ");
	} // end displayMenu
	
	public static char getChoice() {
		char result;
		String temp;
		displayMenu();
		Scanner input = new Scanner(System.in);
		temp = input.next();
		temp = temp.toUpperCase();
		result = temp.charAt(0);
		//input.close();
		return result;
	}// end getChoice
	

} // end TestClass
