import java.util.*;

public class Person {
	private Name name;
	private char gender;
	private int age;
	private int salary;
	
	public Person() {
		addPerson();
	}

	public Person(Name name, char gender, int age, int salary) {
		setName(name);
		setGender(gender);
		setAge(age);
		setSalary(salary);
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		boolean badValue = true;
		
		do {
			if(gender == 'M' || gender == 'F') //making sure gender is valid
				badValue = false;//flag 
			else {
				System.out.println("\nInvalid entry, please re-enter gender!");
				gender = Methods.getChar("Please enter the person's gender (M or F): ");
			}//end else
			
		}while(badValue);
		
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		boolean badValue = true;
		
		do {
			badValue = false;
			
			if(age < 1 || age > 120) {//validating age between 1 and 120
				badValue = true;
				System.out.println("Age must be between 1 and 120!");
				age = Methods.getInt("Please enter their age: ");
			}//end if
			
			
		}while(badValue);
		
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		boolean badValue = true;
		
		do {
			badValue = false;
			
			if(salary < 0) {//making sure salary isn't negative
				badValue = true;
				System.out.println("Salary cannot be negative!");
				salary = Methods.getInt("Please enter their salary: ");
			}//end if
			
			
		}while(badValue);
		
		this.salary = salary;
	}

	@Override
	public String toString() {
		return  "\n" + name.toString() + "Gender: " + gender + "\nAge: " + age + "\nSalary: $" + salary + "\n";
	}
	
	//=====================================================================================================
	
	public void addPerson() {
		Name name;
		char gender;
		int age;
		int salary;
		Scanner input = new Scanner(System.in);

		name = new Name();
		setName(name);
		
		gender = Methods.getChar("Please enter the person's gender (M or F): ");
		setGender(gender); //sending to setter for validation

		age = Methods.getInt("Please enter their age: ");
		setAge(age); //sending to setter for validation

		salary = Methods.getInt("Please enter their salary: ");
		setSalary(salary); //sending to setter for validation

		
	}//end addPerson
	
	public static void displayEditMenu() {
		System.out.println("\n[N]ame");
		System.out.println("[G]ender");
		System.out.println("[A]ge");
		System.out.println("[S]alary");
		System.out.println("[Q]uit to main menu");
	}//end displayEditMenu
	
	public static void displayPeople(ArrayList<Person> p, int size) {
		
		if(size < 3) { //doesn't allow user to display less than 3 people
			System.out.println("Please add " + (3 - p.size()) + " more people to the list first.");
			return;
		}//end if
		else {
			System.out.println("\n");//formatting
			for(int i = 0; i < p.size(); i++) { // printing out people
				System.out.print("Person " + (i+1));
				System.out.println(p.get(i).toString());
			}//end for
		}//end else
		return;
	}//end display people
	
	public static void editPerson(ArrayList<Person> p) {
		char mChoice;
		int pChoice, tempAge, tempSalary;
		char tempGender;
		
		if(p.size() == 0) {
			System.out.println("Enter somebody first.");
			return;
		}
		
		displayPeople(p, 3);//sends list along with size of 3 to bypass print requirement
		pChoice = Methods.getInt("Please enter the person you would like to edit: ") - 1;
		
		if(pChoice < 0 || pChoice > p.size()) {
			System.out.println("That person doesn't exist.");
			return;
		}//end if
		else {
		do {
			displayEditMenu();
			mChoice = Methods.getChar("Enter selection: ");
			
			
			switch (mChoice) {
			
			case 'N':
				p.get(pChoice).name.addName();
				break;
			case 'G':
				tempGender = Methods.getChar("Please enter gender: ");
				p.get(pChoice).setGender(tempGender);
				break;
			case 'A':	
				tempAge = Methods.getInt("Please enter age: ");
				p.get(pChoice).setAge(tempAge);
				break;
			case 'S':
				tempSalary = Methods.getInt("Please enter salary: ");
				p.get(pChoice).setSalary(tempSalary);
				break;
			case 'Q':
				break;
			default: 
				System.out.println("That's not even a choice jesus christ get it together.");
				break;
			}//menu switch
			
		}while (mChoice != 'Q'); //do-while allows user to make multiple edits on 1 person
		return;
		}
	}//end edit person
	
}//end Person
