
public class Methods {
	
	public static void broke(int count) {
		System.out.println("Vicky ran out of quarters after " + count + " plays. Oh well.");
	}//end broke

	public static int machine1(int q, int count) {
		int result = 0;
		
		if(count % 35 == 0) { 
			result = 25;
			q += result;
			win(q, count, 1, 25);
		}//end if
		
		return result;
	}//end machine1
	
	public static int machine2(int q, int count) {
		int result = 0;
		
		if(count % 100 == 0) {
			result = 75;
			q += result;
			win(q, count, 2, 75);
		}//end if
		
		return result;
	}//end machine2
	
	public static int machine3(int q, int count) {
		int result = 0;
		
		if(count % 8 == 0) {
			result = 5;
			q += result;
			win(q, count, 3, 5);
		}//end if
		
		return result;
	}//end machine3
	
	public static void start(int q) {
		double jar = q * 0.25;
		System.out.println("Vicky starts playing with " + q + " quarters, which totals to $" +
		jar + ".");
	}//end start
	
	public static void win(int q, int count, int machine, int prize) { //prints info if Vickie won
		double winnings = prize * 0.25;
		double jar = q * 0.25;
		
		System.out.println(count + ".Vickie just won $" + winnings + " from machine " + machine+ ". There are " +
		q + " quarters in the jar which totals to $" + jar);
		
		
	}//end win
	
}//end Methods
