
public class CatClass {

	public static void main(String[] args) {
		int quarters = 100; //stores number of quarters. Starts at 100 as per assignment sheet
		int playCount = 0; //stores the number of plays
		int winnings = 0; //used to store the amount won from a machine
		
		Methods.start(quarters); //displaying starting info
		
		while(quarters > 0){
			winnings = 0; //resetting winnings
			playCount += 1; //incrementing play count
			
			quarters -= 1;
			winnings = Methods.machine1(quarters, playCount); //playing first machine
			
			quarters -= 1;
			winnings = Methods.machine2(quarters, playCount); //playing second machine
			
			quarters -= 1;
			winnings = Methods.machine3(quarters, playCount); //playing third machine

			quarters += winnings;	
		}
		
		Methods.broke(playCount);
		
	}//end main

}//end CatClass
