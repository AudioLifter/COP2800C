
public abstract class Vehicle implements Noises{
	
	
	private int wheels;
	private int weight;
	boolean engine;
	private String name;
	

	public Vehicle(int wheels, int weight, boolean engine, String name) {
		setWheels(wheels);
		setWeight(weight);
		setEngine(engine);
		setName(name);
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isEngine() {
		return engine;
	}

	public void setEngine(boolean engine) {
		this.engine = engine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vehicle [wheels=" + wheels + ", weight=" + weight + ", engine=" + engine + ", name=" + name + "]";
	}
//----------------------------------------------------------------------------------------
	
	abstract public void hasEngine();
	
	public void vehicleNoises() {
		// TODO Auto-generated method stub
		
	}

	
	
}//end vehicle
