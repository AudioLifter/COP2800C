
public class Bird extends Animal{
	private int wingSpan;
	private boolean canFly;
	
	public Bird(int weight, int height, int wingSpan, boolean canFly) {
		super(weight, height);
		setWingSpan(wingSpan);
		setCanFly(canFly);
	}

	public int getWingSpan() {
		return wingSpan;
	}

	public void setWingSpan(int wingSpan) {
		this.wingSpan = wingSpan;
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}

	@Override
	public String toString() {
		return "Im a bird. I weigh " + super.getWeight() + " and im " + super.getHeight() + 
				" tall . I have a " + wingSpan + " wingspan.\nI have no name and I " + checkFly();
	}
	
	//=============================
	
	public String checkFly(){
	
		if (canFly)
			return "can fly.\n";
		else
			return "can't fly\n";
	}//end checkFly
	
}//end bird
