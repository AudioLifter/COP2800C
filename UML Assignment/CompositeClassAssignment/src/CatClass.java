//Name: Jonathan De La Cruz
//Date 2/22/19
//Purpose: Composite Class + UML Assignment

import java.util.*;

public class CatClass {

	public static void main(String[] args) {
		
		ArrayList<Person> people = new ArrayList<>();
		char choice;
		
		do {
			displayMenu();
			choice = Methods.getChar("Enter selection: ");
		
			switch(choice) {
			
			case 'A':
				people.add(new Person());
				break;
			
			case 'M':
				Person.editPerson(people);
				break;
			
			case 'D':
				Person.displayPeople(people, people.size());
				break;
			
			case 'Q':
				break;//quits program
			
			default:
				System.out.println("That wasn't even a valid letter. Do it again.");
				break;
			
			}//end menu switch
		
		}while (choice != 'Q');
		
		System.out.println("Goodbye.");
		
	}//end main

	//=========================================================
	
	public static void displayMenu() {
		System.out.println("\nMAIN MENU");
		System.out.println("[A]: Add new person ");
		System.out.println("[M]: Modify exisitng person");
		System.out.println("[D]: Output everybody's info");
		System.out.println("[Q]: Quit");
	}//end displayMenu
	
}//end CatClass
