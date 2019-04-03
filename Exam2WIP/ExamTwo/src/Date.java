import java.util.*;


public class Date {
	private int day;
	private int month;
	private int year;
	
	Scanner input = new Scanner(System.in);

	
	public Date() {
		addDate();
	}

	public Date(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "\nDOB: " + month + "/" + day + "/" + year + "\n";
	}
	
	//====================================================================================
	
	public void addDate() {
		int day;
		int month;
		int year;
		boolean badDate = true;
		
		do {
			year = Methods.getInt("Please enter the player's year of birth: ");
			month = Methods.getInt("Please enter the player's month of birth: ");
			day = Methods.getInt("Please enter the player's day of birth: ");
		
			badDate = validateDate(year, month, day);
			
			
		} while(badDate);
		
		setYear(year);
		setMonth(month);
		setDay(day);
		
	}//end addDate
	
	public static boolean validateDate(int year, int month, int day) {
		boolean badDate = false;
		boolean leapYear = false;
		int daysIn = 0;
		
		if(year > 2018) {
			System.out.println("You aren't less than a year old. Stop it.");
			return true;
		}//end if
		
		leapYear = ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)));//checking to see if its a leapYear
		
		if(month > 12 || month < 1) { //making sure user enters valid month
			System.out.println("Please enter a valid month (1-12)");
			return true;
		}//end if
		
		daysIn = monthDays(month, leapYear);
		
		if(day < 1 || day > daysIn) {
			System.out.println("Invalid date. That month has " + daysIn + " days!");
			return true;
		}//end if
		
		return badDate;
	}//end validateDate
	
	public static int monthDays(int month, boolean leapYear) {
		int days = 0;
		
		if(month == 1 || month == 3 || month == 5 || month == 7 
				|| month == 8 || month == 10 || month == 12) //checking if its a month with 31 days
			days = 31;
		
		else if(month == 2) {//checking if its feb, handling leap years
			if(leapYear)
				days = 29;
			else
				days = 28;
		}//end else if
		
		else {//all other months have 30 days
			days = 30;
		}
		return days;
	}//end monthDays
	
}//end Date
