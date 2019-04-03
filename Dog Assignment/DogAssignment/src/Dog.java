import java.util.ArrayList;
import java.util.Scanner;

public class Dog {
	   private String name;
	   private double weight;
	   private char gender;
	   private Owner owner;
	
	   public Dog() { //Constructor
		String tempName;
		double tempWeight;
		char tempGender;
		String temp;
		Owner tempOwner = new Owner();
		
		
		Scanner cat = new Scanner(System.in);//Scanner
		
		System.out.print("Please enter the dog's name: ");
		tempName = cat.nextLine();
		
		System.out.print("Please enter the dog's weight: ");
		tempWeight = cat.nextDouble();
		
		System.out.print("Please enter the dogs gender: ");
		temp = cat.next();
		
		temp = temp.toUpperCase();
		tempGender = temp.charAt(0);
		
		
		setName(tempName);
		setWeight(tempWeight);
		setGender(tempGender);
		setOwner(tempOwner);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "My name is: " + name + "\nMy weight is: " + weight + "\nMy gender is: " + gender +
				owner.toString();
	}
	   
	/*
	 * CLASS
	 * METHODS
	 */

	public static void addDog(ArrayList<Dog> dogs) {
		Dog tempDog = new Dog();
		dogs.add(tempDog);
		
	}//end addDog
	
	public static void displayAllDogs(ArrayList<Dog> dogs) {
		
		for (int i = 0; i < dogs.size(); i++) {
			System.out.println("[" + (i+1) + "]");
			System.out.println(dogs.get(i).toString());
		}//end for
		
		
	}//end display all dogs
	
	public static void dogStats(ArrayList<Dog> dogs) {
		double averageWeight = 0, sumWeight = 0;
		int numM = 0, numF = 0;
		int ownedSmith = 0;
		String smith = "smith";
		for(int i = 0; i < dogs.size(); i++) {
			
			if(dogs.get(i).getOwner().getLastName().toLowerCase().equals(smith)) 
				ownedSmith++;
				
			sumWeight += dogs.get(i).getWeight();
			
			if(dogs.get(i).getGender() == 'M')
				numM++;
			
			if(dogs.get(i).getGender() == 'F')
				numF++;
	
		}//end for
		averageWeight = sumWeight / dogs.size();
		
		System.out.println("The average dog weight is: " + averageWeight);
		System.out.println("The number of males is: " + numM);
		System.out.println("The number of females is: " + numF);
		System.out.println("The number of dogs owned by someone named 'Smith': "
				+ ownedSmith);
		
	}//end dogStats

	public static void removeDog(ArrayList<Dog> dogs) {
		String dogRemove;
		boolean removed = false;
		Scanner input = new Scanner(System.in);//Scanner
		
		System.out.print("Please enter the dog to remove: ");
		dogRemove = input.nextLine();
		
		
		for(int i = 0; i < dogs.size(); i++) {
			if(dogs.get(i).getName().equals(dogRemove)) {
				dogs.remove(i);
				System.out.println(dogRemove + " has been removed from the list!");
			}//end if
			removed = true;
		}//end for
		
		if(removed == false)
			System.out.println("This dog doesnt exist!");
		
	}//end removeDog
	
	
	
	

}// end class dog

