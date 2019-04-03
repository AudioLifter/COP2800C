import java.util.ArrayList;

public class TestClass {

	public static void main(String[] args) {

		ArrayList<RaceCar> cars = new ArrayList<RaceCar>();
		
		cars.add(new RaceCar(2.2, 600, 5, "Audi", "Sport Quattro S1", "4WD", 
				"Rally Group B", 1090, 120, 1985));
		
		cars.add(new RaceCar(2.4, 560, 5, "Lancia", "Stratos HF", "RWD", 
				"Rally Group 4", 880, 80, 1984));
		
		cars.add(new RaceCar(3.0, 1250, 5, "Nissan", "GT-R LM NISMO", "FWD", 
				"the Le Mans Prototype 1 Hybrid division", 870, 68, 2015));
		
		RaceCar.printCars(cars);
		
	}//end Main

}//end TestClass
