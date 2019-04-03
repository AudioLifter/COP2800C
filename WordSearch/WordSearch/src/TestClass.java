//Names: Drew Moyer, Jonathan De La Cruz
//Purpose: Exam 3 Program option
//Date: 3/24


import java.io.IOException;
import java.util.*;

public class TestClass {

	public static void main(String[] args) throws IOException {
		char choice = ' ';
		ArrayList<String> wordList = new ArrayList<String>();
		char[][] wordSearch = new char[30][60];
	    
		//filling array with random upper case chars
		Methods.fillArray(wordSearch);//TO DEBUG GO TO fillArray() in Methods and change the string there to " ".
	        
		do {
			printMenu();
			choice = Methods.getChar("Enter selection: ");
			switch(choice) {
			
			case 'A':
				Methods.addWord(wordList); //prompts user for words, adds them to the word list. Max 16 words.
				break;
			case 'P':
				Methods.createWordSearch(wordList, wordSearch);//creates the wordsearch
			    Methods.puzzleFile("AnswerKey.txt", wordSearch, true, wordList);//creates an answerkey
			    Methods.puzzleFile("WordSearch.txt", wordSearch, false, wordList);//creates the word search text file 
			    displayArray(wordSearch);//displays the created wordsearch in the console
			    System.out.println("Puzzle created!");
			    return;
			case 'Q':
				System.out.println("Bye bye.");//exits program
				break;
			default:
				System.out.println("Try again.");
				break;
			}//end switch
			
		} while (choice != 'Q');
		
	}//end main
	
	//-----------------------------------------------------------
	
	public static void displayArray(char wordSearch[][]){ //uses nested for loop to print out the wordsearch array
        int rows = 30;
        int columns = 60;
        for(int i = 0; i<rows; i++) {
            for(int j = 0; j<columns; j++) {
                System.out.print(wordSearch[i][j]);
                System.out.print(" "); //space added between each char for readability
            } // end inner for loop
            System.out.println();
        } // end outer for loop
    }//end displayArray
	
    
	public static void printMenu() {
		System.out.println("MAIN MENU");
		System.out.println("(A) Add word to the word list");
		System.out.println("(P) Print word search (Warning: closes when done)");
		System.out.println("(Q) Quit");
	}//end printMenu
	
}//end TestClass
;