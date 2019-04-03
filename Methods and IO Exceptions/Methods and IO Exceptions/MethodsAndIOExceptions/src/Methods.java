import java.util.*;
import java.io.*;

public class Methods {//all methods stored in here for simplicity

	public static void fileTriangle() throws IOException { //method used to created text file triangle
		int userNum = 0;//number of rows, from user
		int i, j; //loop counters
		boolean badNum = true; //used for checking user input
		
		
		do {
			badNum = false;
			userNum = getNum();//try and catch for input mismatch contained in getNum
			if(userNum < 3 || userNum > 50) {
				System.out.println("Please enter a number between 3 and 50!");
				badNum = true;
			}//end if
		} while(badNum); //checks user input to make sure it's between 3 and 50.
	
		//creating traingle file
		File file = new File("triangle.txt"); 
		file.createNewFile();
		PrintWriter out = new PrintWriter(file);
		
		//checking to see if file was created and user can write to triangle.txt
		if(!file.canWrite()) {
			System.out.println("You cannot write to this document.");
			return;
		}//end if 
		
		
		for(i = 0; i < userNum; i++) {
			for(j = 0; j <= i; j++) {
				out.print(" * ");
			}//end inner for
			out.println("\n");
		}//end outer for loop
		
		System.out.println("\nTriangle created successfully.");
		out.close();//closing file
	}//end file triangle
	
	public static int getAge() {
		int age = 0; //stores user inputted age
		boolean badAge = true; //used to check user input 
		Scanner cat = new Scanner(System.in);

		
		do { //checking user input, making sure the user enteres an integer
			badAge = false;
			try { 
				System.out.print("\nHow old are you?: ");
				age = cat.nextInt();
			}//end try
			
			catch(InputMismatchException z){
				System.out.println("AGE MUST BE AN INTEGER");
				badAge = true;
			}//end catch
			
			cat.nextLine();// flush
			
		}while(badAge);
		
		System.out.println("\nYou are " + age + " years old!"); //prints user age
		System.out.println(age * 2 + " is double your current age!"); //prints the doubled age
		return age; //returns age to main, so it can be used for the isTeen method
	}//end getAge
	
	public static int getMenuChoice() { //gets user menu choice
		Scanner cat = new Scanner(System.in);
		int choice = 0;
		boolean badValue = true;
		
		menu(); //calls menu method to print the menu

		do {
			badValue = false;
			
			try {
				System.out.print("Please enter your selection: ");
				choice = cat.nextInt();
			}//end try
			catch (InputMismatchException x){
				System.out.println("INVALID INPUT, ENTER CHOICE AS INTEGER!");
				badValue = true;
			}//end  catch
			
			cat.nextLine(); //acts as flush
				
		}while(badValue); //loops while user entered choice is invalid
		
		return choice;		
	}//end getMenuChoice

	public static int getNum() { //prompts user for number of triangle rows to generate, returns it
		
		int num = 0; //user entered number
		boolean badNum = true; //used for input check
		Scanner cat = new Scanner(System.in);
	
		
		do {
			badNum = false;
			try {
				System.out.print("\nHow many rows of triangles would you like to print? (3-50): ");
				num = cat.nextInt();
			}//end try
			
			catch(InputMismatchException z){
				System.out.println("NUMBER MUST BE AN INTEGER");
				badNum = true;
			}//end catch
			
			cat.nextLine();// flush
			
		}while(badNum);
		
		
		return num;
	}//end getNum

	public static void isTeen(boolean flag, int age) { //checks to see if user is a teenager using user entered age from option 2
		
		if(flag == false) { // checking flag to see if user has entered age 
			System.out.println("\nPlease go back and enter your age first! (Option 2)");
			return; //sends user back to main menu
		}//checking if user entered age using option 2
		
		if(age > 12 && age < 20)
			System.out.println("\nYou are a teenager!");
		else
			System.out.println("\nYou are NOT a teenager!");
	}//end isTeen
	
	public static void menu() {//simple method, prints menu
		System.out.println("\n\nMAIN MENU\n");
		System.out.println("1. Echo your name");
		System.out.println("2. Get age, double it");
		System.out.println("3. Are you a teenager?");
		System.out.println("4. File traingle!");
		System.out.println("5. Quit\n");	
	}//end menu
	
	public static void nameEcho() {//gets user first name, then echos it 20 times.
		String name; //stores user entered name
		Scanner cat = new Scanner(System.in);
		
		System.out.print("Please enter your first name: "); //prompting user
		name = cat.nextLine();//scanning input 
		
		for(int i = 0; i < 20; i++)  //for loop to print name 20 times
			System.out.println(i + 1 + ". " + name);

		
	}//end nameEcho
	
}//end Methods
