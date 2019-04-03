//Jonathan De La Cruz
//Basic IO assignment
//1/12/19
import java.util.Scanner; //importing scanner 

public class  BasicIO {

	public static void main(String[] args) {
		Scanner cat = new Scanner(System.in); //scanner variable for user input
		double num1 = 0, num2 = 0, num3 = 0, sum = 0, average = 0; //declaring variables
		
		System.out.print("Please enter a number (1 of 3): "); //prompting user for input
		num1 = cat.nextDouble(); //saving user entered number into num1, repeats for num2 and num3
		System.out.print("Please enter a number (2 of 3): ");
		num2 = cat.nextDouble();
		System.out.print("Please enter a number (3 of 3): ");
		num3 = cat.nextDouble();
		
		sum = num1 + num2 + num3; //calculating sum
		average = sum / 3; //calculating average
		
		System.out.println("\nThe three numbers are: " + num1 + ", " + num2 + ", " + num3 + ".\n"); //printing the 3 numbers to console
		System.out.println("The sum of the numbers is: " + sum + ".\n"); //printing sum
		System.out.println("The average of the numbers is: " + average + "."); //printing average
	}//end main
}//end BasicIO
