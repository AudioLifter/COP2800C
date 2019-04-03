import java.util.*;

public class Owner {
	String lastName;
	String zipCode;


	public Owner() {
		String tempName;
		String tempZip;
		Scanner cat = new Scanner(System.in); //scanner
		
		System.out.print("Please enter the owners name: ");
		tempName = cat.nextLine();
		
		System.out.print("Please enter the owners zipcode: ");
		tempZip = cat.nextLine();
		
		setLastName(tempName);
		setZipCode(tempZip);
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getZipCode() {
		return zipCode;
	}

	

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	@Override
	public String toString() {
		return "\nMy owner is " + lastName + " and their zipcode is " + zipCode + "\n";
	}
	
}//end Owner
