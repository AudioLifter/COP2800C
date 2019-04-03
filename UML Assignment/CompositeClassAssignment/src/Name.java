import java.util.*;


public class Name {

	private String fName;
	private char mInitial;
	private String lName;
	

	
	public Name(String fName, char mInitial, String lName) {
		setFName(fName);
		setMInitial(mInitial);
		setLName(lName);
		
	}
	
	

	public Name() {
		addName();
	}



	public String getFName() {
		return fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public char getMInitial() {
		return mInitial;
	}

	public void setMInitial(char mInitial) {
		this.mInitial = mInitial;
	}

	public String getLName() {
		return lName;
	}

	public void setLName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "Name: " + fName + " " + mInitial + " " + lName + "\n";
	}

	//============================================================================================
	
	public void addName() {
		String fName;
		String lName;
		char mInitial;
		Scanner input = new Scanner(System.in);

		fName = Methods.getString("Please enter the person's first name: ");
		mInitial = Methods.getChar("Please enter " + fName + "'s middle initial ('n/a' if no middle name): ");
		lName = Methods.getString("Please enter their last name: ");

		setFName(fName);
		setMInitial(mInitial);
		setLName(lName);
		
	}//end addName
}