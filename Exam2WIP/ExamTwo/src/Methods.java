import java.util.*;
import java.io.*;

public class Methods {
	
	public static char getChar(String message) {
		char c;
		boolean badChar = true;
		String temp  = "";
		Scanner input = new Scanner(System.in);
		
		do {
			badChar = false;
			
			try {
				System.out.print(message);
				temp = input.next();
			}//end try
			
			catch (InputMismatchException e){
				badChar = true;
				System.out.println("Please enter a letter!");
				input.next();
			}//end catch
			
		} while (badChar);
		
		temp = temp.toUpperCase();
		
		if(temp.equals("N/A")) { //checking to see if user entered n/a for middle name
			return ' ';
		}//end if
			
		c = temp.charAt(0);
		return c;
	}//end getChar
	
	public static double getDouble(String message) {
		double num = 0;
		boolean badNum = true;
		Scanner input = new Scanner(System.in);
		do {
			badNum = false;
			
			try {
				System.out.print(message);
				num = input.nextInt();
			}//end try
			catch(InputMismatchException e) {
				badNum = true;
				System.out.println("Invalid input, please try again!");
				input.next();
			}//end catch
			
			
		}while(badNum);
		
		
		return num;
	}//end getDouble

	public static int getInt(String message) {
		int num = 0;
		boolean badNum = true;
		Scanner input = new Scanner(System.in);
		
		do {
			badNum = false;
			
			try {
				System.out.print(message);
				num = input.nextInt();
			}//end try
			catch(InputMismatchException e) {
				badNum = true;
				System.out.println("Invalid input, please try again!");
				input.next();
			}//end catch
			
			
		}while(badNum);
		
		
		return num;
	}//end getInt
	
	public static String getString(String message) {
		String s = "";
		boolean badString = true;
		Scanner input = new Scanner(System.in);
		
		do {
			badString = false;
			
			try {
				System.out.print(message);
				s = input.nextLine();
			}//end try
			catch(InputMismatchException e) {
				badString = true;
				System.out.println("Invalid input, please try again!");
				input.next();
			}//end Catch
		}while(badString);
		
		s = s.substring(0, 1).toUpperCase() + s.substring(1);
	
		return s;
	}//end getString
	
}
