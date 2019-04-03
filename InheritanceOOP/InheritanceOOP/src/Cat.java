
public class Cat extends Animal {

	private String name;
	private int lives;
	private int livesUsed;
	private boolean dead;
	

	public Cat(int weight, int height, String name, int lives, int livesUsed, boolean dead) {
		super(weight, height);
		setName(name);
		setLives(lives);
		setLivesUsed(livesUsed);
		setDead(dead);
	}


	public void setDead(boolean dead) {
		this.dead = dead;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getLives() {
		return lives;
	}



	public void setLives(int lives) {
		this.lives = lives;
	}



	public int getLivesUsed() {
		return livesUsed;
	}



	public void setLivesUsed(int livesUsed) {
		this.livesUsed = livesUsed;
	}



	@Override
	public String toString() {
		return "\nMy name is " + name + ". Im a cat weighing " + super.getWeight() + " with a height of " 
				+ super.getHeight() + ".\nI have " + (lives - livesUsed) + " lives remaining." + isDead();
	}
	
	//========================================================================
	
	public void truck() {
		livesUsed++;
		System.out.println(name + " was hit by a truck. Oof.");
	}//end truck
	
	public void felineObesity() {
		livesUsed++;
		System.out.println(name + " lost a life due to their obesity. Aww.");
	}//end felineObesity
	
	public void alotOfStairs() {
		
		for(int i = livesUsed; i < lives; i++) {
			livesUsed++;
		}//end for
		
		System.out.println(name + " fell down some stairs. Like alot of stairs. Jesus thats alot of stairs.");
		
	}//end alotOfStairs
	
	public void alive() {
		boolean isDead = false;
		
		if(lives <= livesUsed)
			isDead = true;
		
		setDead(isDead);
	}//end alive
	
	public String isDead() {
		if(dead)
			return " Im dead.\n";
		else
			return " Im alive.\n";
		
	}//end isDead
}//end Cat
