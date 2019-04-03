import java.util.*;

public class Methods {
	
	public static void arrayData(int a[], int size) { //gets descriptive data about array
		int high = 0, low = 0, sum = 0, i;
	
		for(i = 0; i < size; i++) //adding all values in the array
			sum += a[i];
			
		//since array is already sorted in ascending order...
		high = a[size - 1]; //highest value is last element of array
		low = a[0]; //lowest value is the first element of the array
		
		double average = (double) sum / (double) size; //casting sum and size as doubles
		
		//sysout printing 
		System.out.println("\nThe average for the array is: " + average);
		System.out.println("The highest value in the array is: " + high);
		System.out.println("The lowest value in the array is: " + low);
	}//end arrayData

	public static void fillArray(int a[], int size) { //fills array with random numbers
		Random dice = new Random(); //random number generator
		int num; //temp variable used for random numbers
		
		for(int i = 0; i < size; i++) {
			num = 1 + dice.nextInt(100);
			a[i] = num;
		} //end for 
		
	}//end fillArray
	
	public static int getUserNum(String message) { //generic function to get int input from user
		int num = 0; //stores user entered number
		boolean badNum = true; //used to check 
		Scanner cat = new Scanner(System.in);
		
		do {
			badNum = false;
			try {
				System.out.print(message);
				num = cat.nextInt();
			}//end try
			catch(InputMismatchException z) {
				System.out.println("NUMBER MUST BE A POSITIVE INTEGER");
				badNum = true;
			}//end catch
			
			if(num <= 0 && badNum == false) { //making user user enters a positive number
				System.out.println("NUMBER MUST BE A POSITIVE INTEGER");
				badNum = true;
			}//end if
			
			cat.nextLine(); //FLUSH
			
		} while(badNum); //checks user input to make sure its a positive int
		
		return num;
	}//end getUserNum

	public static int getSearchNum(String message) { //gets number to search array for from user
		int result = 0;
		boolean badResult = true;
		
		do {
			badResult = false;
			result = getUserNum("\nPlease enter a number to search for: ");

			if(result > 100 || result < 1) { //checking user input
				badResult = true;
				System.out.println("Please enter a number between 1 and 100!");
			}//end if
			
			
		} while(badResult); //checking if input is between 1 and 100
		
		return result;
	}//end getSearchNum
	
	public static void oneToHundred(int a[], int size) { //displays how many times each number appears
		int i; // loop counter
		int num = 0; //number being counter
		int appears = 0; //counting the number of times a number appears
		
		for(num = 0; num <= 100; num++) {
			appears = 0;
			
			for(i = 0; i < size; i++) {
				if(a[i] == num) {
					appears++;
				}//end if
			}//end inner for
			
			if(appears > 0) {
				System.out.println("The number " + num + " appears " + 
						appears + " times in the array.");
			}//end if
		}//end outer for
	}//end oneToHundred
	
	public static void printArray(int a[], int size) { //prints the array
		
		for(int i = 0; i < size; i++) {
			System.out.println((i + 1) + ". " + a[i]);
		}//end for
		
	}//end printArray
	
	public static void searchArray(int a[], int size, int num) { //searches the array for user entered number from getSearchNum
		int found = 0;
		
		found = Arrays.binarySearch(a, num);
		
		if( found > -1) 
			System.out.println("Found!\n");
		
		else
			System.out.println("Not found!\n");
		
	}//end searchArray
	
	
}//end Methods
