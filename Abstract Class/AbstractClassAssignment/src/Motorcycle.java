
public class Motorcycle extends Vehicle implements Noises{

	private String engineType;
	private String type;
	
	

	public Motorcycle(int wheels, int weight, boolean engine, String name, String engineType, String type) {
		super(wheels, weight, engine, name);
		this.engineType = engineType;
		this.type = type;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Motorcycle [engineType=" + engineType + ", type=" + type + "]";
	}

	
	//------------------------------------------------------------------------------
	
	@Override
	public void hasEngine() {
		System.out.println("I have an engine");
		
	}

	@Override
	public void vehicleNoises() {
		// TODO Auto-generated method stub
		System.out.println("*motorcycle noises*");
	}

	
}//end motorcycle
