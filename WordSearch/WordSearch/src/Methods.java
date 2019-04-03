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
	
	public static void createWordSearch(ArrayList<String> wList, char[][] grid) { 
		Random rand = new Random();//generates a random number
		int placement = 0;//used to store the random number
		
		for(int i = 0; i < wList.size(); i++) {//loops through all the words in the word arraylist
			placement = rand.nextInt(8);//generating random number 
			
			switch(placement) { //switch used to call method based on the number generated
			case 0:
				hLine(wList.get(i), grid);
				break;
			case 1:
				hLineBack(wList.get(i), grid);
				break;
			case 2:
				vLine(wList.get(i), grid);
				break;
			case 3:
				vLineBack(wList.get(i), grid);
				break;
			case 4:
				dRightForward(wList.get(i), grid);
				break;
			case 5: 
				dRightBackward(wList.get(i), grid);
				break;
			case 6: 
				dLeftForward(wList.get(i), grid);
				break;
			case 7:
				dRightBackward(wList.get(i), grid);
				break;
			}//end switch
			
		}//end for 
		
	}//end createWordSearch
	
	public static char getChar(String message) { //generic method to return a single char, used for menus
		char c;
		boolean badChar = true;
		String temp  = "";
		Scanner input = new Scanner(System.in);
		
		do {
			badChar = false;
			
			try {
				System.out.print(message); //message passed as argument when called
				temp = input.next();
			}//end try
			
			catch (InputMismatchException e){
				badChar = true;
				System.out.println("Please enter a letter!");
				input.next();
			}//end catch
			
		} while (badChar);
		
		temp = temp.toUpperCase(); //returns it as uppercase 

		c = temp.charAt(0);
		return c;
	}//end getChar
	
	public static void fillArray(char wordSearch[][]){//used to fill array with captial letters at random
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";//every upper case letter in alphabet. TO DEBUG DELETE LETTERS AND LEAVE A BLANK SPACE
        for (int i = 0; i < wordSearch.length; i++) {
            for (int j = 0; j < wordSearch[i].length; j++) {
                Random r = new Random();//random number used to pick which letter to place
                wordSearch[i][j] = chars.charAt(r.nextInt(chars.length()));//wordsearch gets filled with random capitol letters
            } // end inner for loop
        } // end outer for loop
    } // end fillArray

	public static String getString(String message) {//generic method used to prompt user for a string
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
		
		s = s.toLowerCase();//converts it to lowercase before returning it
	
		return s;
	}//end getString
	
	public static void hLine(String word, char[][] grid) {//horizontal 
		int randC = 0; //random column
		int randR = 0; //random row
		int j = 0;
		boolean validPlace = true;
		//random number generator
		Random rand = new Random();
		
		//generating random start position
		do {
			validPlace = true;
			//generate random start position
			randC = rand.nextInt(30);//all positioning methods use different bounds depending on direction
			randR = rand.nextInt(50);
			//checks to see if a word is placed
			for(int i = randR; i < (randR + word.length()); i++) {
	        	if(Character.isLowerCase(grid[randC][i])){
	        		validPlace = false;
	        	} // end if
	        } // end for
		}while (!validPlace);
			
			
		for(int i = randR; i < (randR + word.length()); i++) {
			grid[randC][i] = word.charAt(j);
			j++;
		}//end for
		
	}//end hLine
	
	public static void hLineBack(String word, char[][] grid) {//horizontal backwards
		int randC = 0; //random column
		int randR = 0; //random row
		int j = 0;
		boolean validPlace = true;
		//random number generator
		Random rand = new Random();
		
		do {
			validPlace = true;
			//generating random start position
			randC = rand.nextInt(30);
			randR = rand.nextInt(50);
			//checks to see if a word is placed
			for(int i = randR; i < (randR + word.length()); i++) {
				if(Character.isLowerCase(grid[randC][i])) 
					validPlace = false;
			}//end for
		}while (!validPlace);
		
		
		for(int i = randR; i < (randR + word.length()); i++) {
			grid[randC][i] = word.charAt((word.length()-1)-j);
			j++;
		}//end for
		
	}//end hLineBack
	
	public static void puzzleFile(String name, char[][] w, boolean isKey, ArrayList<String> words) throws IOException { //creates wordsearch.txt file
		//Temp variables
		String temp;
		int i, j;
		
		//Stringbuilder
		StringBuilder sb = new StringBuilder(); //uses string builder
		
		//creating wordSearch file
		File file = new File(name);
		file.createNewFile();
		PrintWriter out = new PrintWriter(file);
		//checking to see if file was created and is writable
		if(!file.canWrite()) {
			System.out.println("Whoops! Can't write to this.");
			out.close();
			return;
		}//end if
		
		for(i = 0; i < 30; i++) {//for every row, the stringbuilder builds a string with every char in the row
			for(j = 0; j < 60; j++) {
				sb.append(w[i][j]);
				sb.append(' ');//insets a space between chars for formatting/readability of the puzzle
			}//end inner for 
			temp = sb.toString();
			if(!isKey)//if flag passed is false, then change everything in the string built to upper
				temp = temp.toUpperCase();
			out.println(temp);//print the whole thing to the txt file, on a new line
			sb.setLength(0);//clears the stringbuilder before loop restarts
		}//end outer for
		
		//printing answer key below puzzle
		out.println("\n\n");//formatting lines
		Collections.sort(words);//sorts wordlist alphabetically
		for(i = 0; i < words.size(); i++) {//uses for loop to print words
			out.println((i+1) + ". " + words.get(i));
		}//end for
		
		out.close();//closes txt file
	}//end puzzleFile

	public static void vLine(String word, char[][] grid) {//vertical line
		int randC = 0; //random column
		int randR = 0; //random row
		int j = 0;
		boolean validPlace = true;

		//random number generator
		Random rand = new Random();
		
		
		
		do {
			validPlace = true;
			//generating random start position
			randC = rand.nextInt(20);
			randR = rand.nextInt(60);
			//checks to see if a word is placed
			for(int i = randC; i < (randC + word.length()); i++) {
				if(Character.isLowerCase(grid[i][randR])) 
					validPlace = false;
			}//end for
		}while (!validPlace);
		

		for(int i = randC; i < (randC + word.length()); i++) {
			grid[i][randR] = word.charAt(j);
			j++;
		}//end for
		
	}//end vLine

	public static void vLineBack(String word, char[][] grid) {//vertical backwards
		int randC = 0; //random column
		int randR = 0; //random row
		int j = 0;
		boolean validPlace = true;

		//random number generator
		Random rand = new Random();
		
		do {
			validPlace = true;
			//generating random start position
			randC = rand.nextInt(20);
			randR = rand.nextInt(60);
			//checks to see if a word is placed
			for(int i = randC; i < (randC + word.length()); i++) {
				if(Character.isLowerCase(grid[i][randR])) 
					validPlace = false;
			}//end for
		}while (!validPlace);
		
		
		for(int i = randC; i < (randC + word.length()); i++) {
			grid[i][randR] = word.charAt((word.length()-1)-j);
			j++;
		}//end for
		
	}//end vLineBack

	public static void dRightForward(String word, char[][] grid) {//diagonal right
		
		int randC = 0; //random column
		int randR = 0; //random row
		int i = 0, j = 0, k = 0; //counters
		boolean validPlace = true;

		//random number generator
		Random rand = new Random();
		
		
		do{
			validPlace = true;
			//generating random start position -- replace with dynamic bounds later
			randC = rand.nextInt(20) + 10;
			randR = rand.nextInt(40) + 10;
			
			//setting k to randR
			k = randR;
			j = 0;
			
		    //checks if word can be placed
			for(i = randC; i > (randC - word.length()); i--) {
		    	if(Character.isLowerCase(grid[i][k])){
		    		validPlace = false;
		    	} // end if
	    		j++; //increments char printing counter
				k++; //increments row counter
		    } // end for
		  }while(!validPlace);
		
		
		//setting k to randR
		k = randR;
		j = 0;
		for(i = randC; i > (randC - word.length()); i--) {
			grid[i][k] = word.charAt(j);
			j++; //increments char printing counter
			k++; //increments row counter
		}//end outer for
		
	}//end dRightForward
	
	public static void dRightBackward(String word, char[][] grid) { //diagonal right backwards
		
		int randC = 0; //random column
		int randR = 0; //random row
		int i = 0, j = 0, k = 0; //counters
		boolean validPlace = true;

		//random number generator
		Random rand = new Random();
		
		//generating random start position -- replace with dynamic bounds later
		randC = rand.nextInt(20) + 10;
		randR = rand.nextInt(40) + 10;
		
		
		do{
			validPlace = true;
			//generating random start position -- replace with dynamic bounds later
			randC = rand.nextInt(20) + 10;
			randR = rand.nextInt(40) + 10;
			
			//setting k to randR
			k = randR;
			j = 0;
			
		    //checks if word can be placed
			for(i = randC; i > (randC - word.length()); i--) {
		    	if(Character.isLowerCase(grid[i][k])){
		    		validPlace = false;
		    	} // end if
	    		j++; //increments char printing counter
				k++; //increments row counter
		    } // end for
		  }while(!validPlace);
		
		//setting k to randR
		k = randR;
		j = 0;
		
		for(i = randC; i > (randC - word.length()); i--) {
			grid[i][k] = word.charAt((word.length()-1)-j);
			j++; //increments char printing counter
			k++; //increments row counter
		}//end outer for
		
	}//end dRightForward
	
	public static void dLeftForward(String word, char[][] grid) { //diagonal left
		int randC = 0; //random column
		int randR = 0; //random row
		int i = 0, j = 0, k = 0; //counters
		boolean validPlace = true;

		//random number generator
		Random rand = new Random();
		
		
		
		
		do{
			validPlace = true;
			//generating random start position -- replace with dynamic bounds later
			randC = rand.nextInt(20);
			randR = rand.nextInt(50);
			
			//setting k to randR
			k = randR;
			j = 0;
			
		    //checks if word can be placed
			for(i = randC; i < (randC + word.length()); i++) {
		    	if(Character.isLowerCase(grid[i][k])){
		    		validPlace = false;
		    	} // end if
	    		j++; //increments char printing counter
				k++; //increments row counter
		    } // end for
		  }while(!validPlace);
		
		
		
		//setting k to randR
		k = randR;
		j = 0;
		
		for(i = randC; i < (randC + word.length()); i++) {
			grid[i][k] = word.charAt(j);
			j++; //increments char printing counter
			k++; //increments row counter
		}//end outer for
	}//end dLeftForward
	
	public static void dLeftbackward(String word, char[][] grid) { //diagonal left backwards
		int randC = 0; //random column
		int randR = 0; //random row
		int i = 0, j = 0, k = 0; //counters
		boolean validPlace = true;

		//random number generator
		Random rand = new Random();
		
		do{
			validPlace = true;
			//generating random start position -- replace with dynamic bounds later
			randC = rand.nextInt(20);
			randR = rand.nextInt(50);
			
			//setting k to randR
			k = randR;
			j = 0;
			
		    //checks if word can be placed
			for(i = randC; i < (randC + word.length()); i++) {
		    	if(Character.isLowerCase(grid[i][k])){
		    		validPlace = false;
		    	} // end if
	    		j++; //increments char printing counter
				k++; //increments row counter
		    } // end for
		 }while(!validPlace);
		
		//setting k to randR
		k = randR;
		
		for(i = randC; i < (randC + word.length()); i++) {
			grid[i][k] = word.charAt((word.length()-1)-j);
			j++; //increments char printing counter
			k++; //increments row counter
		}//end outer for
	}//end dLeftBackward
	
}//end Methods
