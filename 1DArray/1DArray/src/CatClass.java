//Name: Jonathan De La Cruz
//Date: 2/2/2019
//Purpose: 1D Array Assignment

//START AT STEP 7!!!!!!!!!

import java.util.*;

public class CatClass {

	public static void main(String[] args) {
		//variable declarations
		int userNum, size, searchNum;
		int array[]; //creating reference to array
		
		userNum = Methods.getUserNum("How many random (1-100) numbers would you like to generate?: "); //getting array size from user
		array = new int[userNum]; //creating array
		size = userNum;
		
		Methods.fillArray(array, size); //filling the array
		Methods.printArray(array, size); //printing the array
		
		Arrays.sort(array); //sorting array in ascending order
		System.out.println("\nSorted");
		Methods.printArray(array, size); //printing sorted array
		
		searchNum = Methods.getSearchNum("\nPlease enter a number to search for: "); //prompting user for number to search for
		Methods.searchArray(array, size, searchNum);//searching array
		
		Methods.oneToHundred(array, size); //calling method to display frequency of numbers 1-100 in array
		
		Methods.arrayData(array, size); //calling method to display data about array (high low average)
	}// end main

}//end CatClass
