
public class Automobile {
	
	private double engineSizeLiters;
	private int horsepower;
	private int gears;
	private int yearMade;
	private String manufacturer;
	private String name;
	
	public Automobile(double engineSizeLiters, int horsepower, int gears, String manufacturer, String name, int yearMade) {
		setEngineSizeLiters(engineSizeLiters);
		setHorsepower(horsepower);
		setGears(gears);
		setManufacturer(manufacturer);
		setName(name);
		setYearMade(yearMade);
	}
	
	public Automobile() {
		/*No arg*/
	}

	public double getEngineSizeLiters() {
		return engineSizeLiters;
	}

	public void setEngineSizeLiters(double engineSizeLiters2) {
		this.engineSizeLiters = engineSizeLiters2;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	public int getGears() {
		return gears;
	}

	public void setGears(int gears) {
		this.gears = gears;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getYearMade() {
		return yearMade;
	}
	
	public void setYearMade(int yearMade) {
		this.yearMade = yearMade;
	}

	@Override
	public String toString() {
		return "Automobile [engineSizeLiters=" + engineSizeLiters + ", horsepower=" + horsepower + ", gears=" + gears
				+ ", manufacturer=" + manufacturer + "]";
	}
	
}//end Automobile
