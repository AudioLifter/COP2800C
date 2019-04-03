//Name: Jonathan De La Cruz
//Date: 2/25/19
//Purpose: Inheritance and OOP assignment

public class TestClass {

	public static void main(String[] args) {
		
		Animal myPet = new Animal(12, 3);
		
		
		System.out.println(myPet.toString());
		
		Dog max = new Dog(34, 2, "Maxwell", "Doberman", "12/6/06");
		max.setName("Maxwell");
		max.setWeight(56);
		
		System.out.println(max);
		
		Cat jazz = new Cat(35, 1, "Jazz", 9, 0, false);
		System.out.println(jazz);
		
		jazz.felineObesity();//simulating life events
		jazz.truck();//this is an unfortunate cat
		
		System.out.println(jazz);
		
		jazz.alotOfStairs(); //cat falls down some stairs
		jazz.alive();//checking for status
		
		System.out.println(jazz);
		
		Bird penguin = new Bird(35, 4, 6, false);
		System.out.println(penguin);
		
		Bird puffin = new Bird(3, 1, 3, true);
		System.out.println(puffin);
		
	}//end main

}//end TestClass
