import java.io.*;
import java.util.*;

public class Methods {
	
	public static void addWord(ArrayList<String> wList) {
		char choice = ' ';
		
		do {
			
			if(wList.size() >= 16) {
				System.out.println("List is full");
				return;
			}//end if
			
			choice = ' ';
			wList.add(getString("Please enter a word: "));
			choice = getChar("Would you like to enter another word (y/n): ");
		}while (choice != 'N');
		
	}//end addWord
	
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

		c = temp.charAt(0);
		return c;
	}//end getChar

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
		
		s = s.toLowerCase();
	
		return s;
	}//end getString
	
	public static void hLine(String word, char[][] grid) {
		int randC = 0; //random column
		int randR = 0; //random row
		int j = 0;
		//random number generator
		Random rand = new Random();
		
		//generating random start position
		randC = rand.nextInt(30);
		randR = rand.nextInt(50);
		
		for(int i = randR; i < (randR + word.length()); i++) {
			grid[randC][i] = word.charAt(j);
			j++;
		}//end for
		
	}//end hLine
	
	public static void hLineBack(String word, char[][] grid) {
		int randC = 0; //random column
		int randR = 0; //random row
		int j = 0;
		//random number generator
		Random rand = new Random();
		
		//generating random start position
		randC = rand.nextInt(30);
		randR = rand.nextInt(50);
		
		for(int i = randR; i < (randR + word.length()); i++) {
			grid[randC][i] = word.charAt((word.length()-1)-j);
			j++;
		}//end for
		
	}//end hLineBack
	
	public static void puzzleFile(char[][] w) throws IOException {
		//Temp variables
		String temp;
		int i, j;
		
		//Stringbuilder
		StringBuilder sb = new StringBuilder(); 
		
		//creating wordSearch file
		File file = new File("wordSearch.txt");
		file.createNewFile();
		PrintWriter out = new PrintWriter(file);
		//checking to see if file was created and is writable
		if(!file.canWrite()) {
			System.out.println("Whoops! Can't write to this.");
			out.close();
			return;
		}//end if
		
		for(i = 0; i < 30; i++) {
			for(j = 0; j < 60; j++) {
				sb.append(w[i][j]);
				sb.append(' ');
			}//end inner for 
			temp = sb.toString();
			out.println(temp);
			sb.setLength(0);
		}//end outer for
		out.close();
	}//end puzzleFile

	public static void vLine(String word, char[][] grid) {
		int randC = 0; //random column
		int randR = 0; //random row
		int j = 0;
		//random number generator
		Random rand = new Random();
		
		//generating random start position
		randC = rand.nextInt(20);
		randR = rand.nextInt(60);
		

		for(int i = randC; i < (randC + word.length()); i++) {
			grid[i][randR] = word.charAt(j);
			j++;
		}//end for
		
	}//end vLine

	public static void vLineBack(String word, char[][] grid) {
		int randC = 0; //random column
		int randR = 0; //random row
		int j = 0;
		//random number generator
		Random rand = new Random();
		
		//generating random start position
		randC = rand.nextInt(20);
		randR = rand.nextInt(60);
		

		for(int i = randC; i < (randC + word.length()); i++) {
			grid[i][randR] = word.charAt((word.length()-1)-j);
			j++;
		}//end for
		
	}//end vLineBack

	public static void dRightForward(String word, char[][] grid) {
		
		int randC = 0; //random column
		int randR = 0; //random row
		int i = 0, j = 0, k = 0; //counters
		//random number generator
		Random rand = new Random();
		
		//generating random start position -- replace with dynamic bounds later
		randC = rand.nextInt(20) + 10;
		randR = rand.nextInt(40) + 10;
		
		//setting k to randR
		k = randR;
		
		for(i = randC; i > (randC - word.length()); i--) {
			grid[i][k] = word.charAt(j);
			j++; //increments char printing counter
			k++; //increments row counter
		}//end outer for
		
	}//end dRightForward
	
	public static void dRightBackward(String word, char[][] grid) {
		
		int randC = 0; //random column
		int randR = 0; //random row
		int i = 0, j = 0, k = 0; //counters
		//random number generator
		Random rand = new Random();
		
		//generating random start position -- replace with dynamic bounds later
		randC = rand.nextInt(20) + 10;
		randR = rand.nextInt(40) + 10;
		
		//setting k to randR
		k = randR;
		
		for(i = randC; i > (randC - word.length()); i--) {
			grid[i][k] = word.charAt((word.length()-1)-j);
			j++; //increments char printing counter
			k++; //increments row counter
		}//end outer for
		
	}//end dRightForward
	
	public static void dLeftForward(String word, char[][] grid) {
		int randC = 0; //random column
		int randR = 0; //random row
		int i = 0, j = 0, k = 0; //counters
		//random number generator
		Random rand = new Random();
		
		//generating random start position -- replace with dynamic bounds later
		randC = rand.nextInt(20);
		randR = rand.nextInt(50);
		
		System.out.println(randC);
		System.out.println(randR);
		//setting k to randR
		k = randR;
		
		for(i = randC; i < (randC + word.length()); i++) {
			grid[i][k] = word.charAt(j);
			j++; //increments char printing counter
			k++; //increments row counter
		}//end outer for
	}//end dLeftForward
	
	public static void dLeftbackward(String word, char[][] grid) {
		int randC = 0; //random column
		int randR = 0; //random row
		int i = 0, j = 0, k = 0; //counters
		//random number generator
		Random rand = new Random();
		
		//generating random start position -- replace with dynamic bounds later
		randC = rand.nextInt(20);
		randR = rand.nextInt(50);
		
		System.out.println(randC);
		System.out.println(randR);
		//setting k to randR
		k = randR;
		
		for(i = randC; i < (randC + word.length()); i++) {
			grid[i][k] = word.charAt((word.length()-1)-j);
			j++; //increments char printing counter
			k++; //increments row counter
		}//end outer for
	}//end dLeftBackward
	
}//end Methods
