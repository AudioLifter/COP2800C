
public class Dog extends Animal {

	private String name;
	private String breed;
	private String dob;
	
	public Dog(int weight, int height, String name, String breed, String dob) {
		super(weight, height);
		this.name = name;
		this.breed = breed;
		this.dob = dob;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "\nMy name is " + name + ". Im a dog weighing " + super.getWeight() + " with a height of " 
				+ super.getHeight() + ".\nIm a " + breed + ". I was born on " + dob + ".";
	}
	
	
	
	
	
	
}//end Dog
