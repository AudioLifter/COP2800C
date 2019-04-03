//Name: Jonathan De La Cruz
//Date: 3/24/10
//Purpose: Interface Assignment

import java.util.*;

public class TestClass {

	public static void main(String[] args) {
		
		
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		vehicles.add(new Motorcycle(2, 350, true, "Ninja 400", "parallel twin", "standard"));
		vehicles.add(new Car(4, 3000, true, "Honda Fit", "inline 4", true, 128));
		vehicles.add(new Bicycle(2, 20, false, "Surly Cross-Check", false, "cromoly", "road"));
		vehicles.add(new Bicycle(2, 20, false, "Kilo TT", true, "cromoly", "track"));
		
		
		for(Vehicle vehicle : vehicles) {
			vehicle.hasEngine();
			vehicle.vehicleNoises();
			
			if(vehicle instanceof Car) {
				((Car) vehicle).caughtFire();
				((Car) vehicle).exploded();
			}//end if
				
			System.out.println("\n");
		}//end for
		
		
	}//end main

	
}//end TestClass
