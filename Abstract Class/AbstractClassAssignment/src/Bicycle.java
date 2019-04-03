
public class Bicycle extends Vehicle implements Noises{
	private boolean fixedGear;
	private String frameMaterial;
	private String type;
	


	public Bicycle(int wheels, int weight, boolean engine, String name, boolean fixedGear, String frameMaterial,
			String type) {
		super(wheels, weight, engine, name);
		this.fixedGear = fixedGear;
		this.frameMaterial = frameMaterial;
		this.type = type;
	}

	public boolean isFixedGear() {
		return fixedGear;
	}

	public void setFixedGear(boolean fixedGear) {
		this.fixedGear = fixedGear;
	}

	public String getFrameMaterial() {
		return frameMaterial;
	}

	public void setFrameMaterial(String frameMaterial) {
		this.frameMaterial = frameMaterial;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Bicycle [fixedGear=" + fixedGear + ", frameMaterial=" + frameMaterial + ", type=" + type + "]";
	}

	//-----------------------------
	
	@Override
	public void vehicleNoises() {
		
		if(this.fixedGear)
			System.out.println("*hipster noises*");
		else
			System.out.println("*cyclist noises*");
	}

	@Override
	public void hasEngine() {
		// TODO Auto-generated method stub
		System.out.println("I don't have an engine.");
	}

	
}//end Bicycle
