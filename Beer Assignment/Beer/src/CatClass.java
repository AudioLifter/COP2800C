
import java.util.Scanner;
public class CatClass {

	public static void main(String[] args) {
		//input
		Scanner cat = new Scanner(System.in); //new scanner
		double beers = 0, cost = 0; // user inputs
		double yearlyBeers = 0, weightGain = 0, beerCalories = 0, yearlyCost = 0;//calculated by program
		
		System.out.println("On average, how many beers will you consume each day?"); //prompt user for daily beer consumption
		beers = cat.nextDouble(); 
		
		System.out.println("On average, how much will you pay for each can of beer?"); //prompting user for cost
		System.out.print("$"); //formatting stuff
		cost = cat.nextDouble();
		
		//calculations
		yearlyBeers = beers * 365;
		beerCalories = yearlyBeers * 150;
		weightGain = beers * 15;
		yearlyCost = yearlyBeers * cost;
		
		//output
		System.out.println("That is approximately " + yearlyBeers + " beers in one year.");
		System.out.println("In one year, you will consume approximately " + beerCalories + " calories from beer alone.");
		System.out.println("Without diet or excercise to counter these calories, you can expect to gain " + weightGain + 
				" pounds from drinking that much beer this year.");
		System.out.println("You will spend $" + yearlyCost + " on beer alone this year drinking that much.");
		
	}//end main
}//end CatClass
