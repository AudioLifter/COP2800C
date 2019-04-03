
public class Animal {

	private int weight;
	private int height;

	public Animal(int weight, int height) {
		setWeight(weight);
		setHeight(height);
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Im an animal weighing " + weight + " with a height of " + height + ".";
	}
	
	
	
}//end Animal
