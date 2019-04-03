import java.util.*;


public class Name {
	private String fName;
	private char mInitial;
	private String lName;
	
	Scanner input = new Scanner(System.in);

	
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
		return "\nName: " + fName + " " + mInitial + " " + lName + "\n";
	}

	//============================================================================================
	
	public void addName() {
		String fName;
		String lName;
		char mInitial;
		
		fName = Methods.getString("Please enter the player's first name: ");
		mInitial = Methods.getChar("Please enter the player's middle initial ('n/a' if no middle name): ");
		lName = Methods.getString("Please enter the player's last name: ");

		setFName(fName);
		setMInitial(mInitial);
		setLName(lName);
		
	}//end addName
	
	
}//end Name
