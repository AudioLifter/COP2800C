
public class Car extends Vehicle implements Noises, Fire, Explodes{
	
	private String engineType;
	private boolean manual;
	private int horsepower;
	


	public Car(int wheels, int weight, boolean engine, String name, String engineType, boolean manual, int horsepower) {
		super(wheels, weight, engine, name);
		this.engineType = engineType;
		this.manual = manual;
		this.horsepower = horsepower;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public boolean isManual() {
		return manual;
	}

	public void setManual(boolean manual) {
		this.manual = manual;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	@Override
	public String toString() {
		return "Car [engineType=" + engineType + ", manual=" + manual + ", horsepower=" + horsepower + "]";
	}
	
//----------------------------------------------------------------
	
	@Override
	public void caughtFire() {
		System.out.println("Your " + getName() + " has caught fire. You might want to call someone.");
	}

	@Override
	public void exploded() {
		System.out.println("Your " + getName() + " has exploded. That sucks.");
	
	}

	@	Override
	public void hasEngine() {
		// TODO Auto-generated method stub
		System.out.println("I have an engine");
	}

	@Override
	public void vehicleNoises() {
		System.out.println("*car noises*");
		
	}

	

}//end Car
