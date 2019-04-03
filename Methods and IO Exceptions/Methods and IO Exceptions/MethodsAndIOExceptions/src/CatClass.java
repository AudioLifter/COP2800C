//Name: Jonathan De La Cruz
//Date: 1/27/19
//Purpose: Methods and IO Exceptions assignment

import java.util.Scanner; //import scanner
import java.io.*;

public class CatClass {

	public static void main(String[] args) throws IOException { //calls method that can throw an IO Exception
	
		int choice, age = 0; //choice stores user menu choice, age stores user entered age from choice 2
		boolean ageEntered = false; //flag to make sure user enters an age before using option 3
		
		do { //menu do-while
			choice = Methods.getMenuChoice();//menu method
			
			
			switch(choice) { 
			
			case 1:
				Methods.nameEcho(); //echos name back 20 times
				break;
			case 2:
				age = Methods.getAge(); //gets user age, stores it in age
				ageEntered = true;//trips flag 
				break;
			case 3:
				Methods.isTeen(ageEntered, age); //isTeen is passed flag and age
				break;
			case 4:
				Methods.fileTriangle(); //creates a .txt triangle 
				break;
			case 5:
				System.out.println("\nGoodbye!");
				break;
			default:
				System.out.println("Please select a menu option!"); //used if user enters an int choice that is not 1-5
				break;
			}//end switch
			
		} while (choice != 5); //program continues to run until user chooses to quit
		
	} //end main

}// end Cat Class
