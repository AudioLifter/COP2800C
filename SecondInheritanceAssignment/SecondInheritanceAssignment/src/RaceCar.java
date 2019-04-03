import java.util.ArrayList;

public class RaceCar extends Automobile{
	

	private String driveLayout;
	private String raceDivision;
	private int weight;
	private int fuelCapacity;

	public RaceCar(double d, int horsepower, int gears, String manufacturer, String name,
			String driveLayout, String raceDivision, int weight, int fuelCapacity, int yearMade) {
		super(d, horsepower, gears, manufacturer, name, yearMade);
		setDriveLayout(driveLayout);
		setRaceDivision(raceDivision);
		setWeight(weight);
		setFuelCapacity(fuelCapacity);
		}

	public String getDriveLayout() {
		return driveLayout;
	}

	public void setDriveLayout(String driveLayout) {
		this.driveLayout = driveLayout;
	}

	public String getRaceDivision() {
		return raceDivision;
	}

	public void setRaceDivision(String raceDivision) {
		this.raceDivision = raceDivision;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	@Override
	public String toString() {
		return "The " + super.getManufacturer() + " " + super.getName() + " competed in " + raceDivision + " in " + super.getYearMade() + ". It made " + 
				super.getHorsepower() + "HP from a " + super.getEngineSizeLiters() + "L engine.\nIt used a " + super.getGears() + 
				"-speed gearbox with a " + getDriveLayout() + " layout. It has a " + getFuelCapacity() + " liter fuel tank and weighs " +
				getWeight() + " kgs.\n\n"; 
	}
	
	//=====================================================
	
	public static void printCars(ArrayList<RaceCar> cars) {
		for(RaceCar car: cars) {
			System.out.println(car.toString());
		}//end for
	}
	
}//end RaceCar
