import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class SlotMachine {
	private String slotName; // Name of slot machine
	private int slotBal; // Current balance in slot machine
	private int jackWinRate; // Jackpot payout happens one in "  " times
	private int jackCounter; // Amount of times jackpot payout has been won
	private int jackPayout; // Jackpot payout
	private int regWinRate; // Regular payout happens one in "  " times
	private int regCounter; // Amount of times regular payout has been won
	private int regPayout; // Regular payout
	
	Scanner input = new Scanner(System.in);

	
	public SlotMachine(String slotName, int slotBal, int jackWinRate, int jackCounter, int jackPayout, 
			int regWinRate, int regCounter, int regPayout) {
		setSlotName(slotName);
		setSlotBal(slotBal);
		setJackWinRate(jackWinRate);
		setJackCounter(jackCounter);
		setJackPayout(jackPayout);
		setRegWinRate(regWinRate);
		setRegCounter(regCounter);
		setRegPayout(regPayout);
	}
	
	public SlotMachine(int size){
		addSlotMachine(size);
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public int getSlotBal() {
		return slotBal;
	}

	public void setSlotBal(int slotBal) {
		this.slotBal = slotBal;
	}

	public int getJackWinRate() {
		return jackWinRate;
	}

	public void setJackWinRate(int jackWinRate) {
		this.jackWinRate = jackWinRate;
	}

	public int getJackCounter() {
		return jackCounter;
	}

	public void setJackCounter(int jackCounter) {
		this.jackCounter = jackCounter;
	}

	public int getJackPayout() {
		return jackPayout;
	}

	public void setJackPayout(int jackPayout) {
		this.jackPayout = jackPayout;
	}

	public int getRegWinRate() {
		return regWinRate;
	}

	public void setRegWinRate(int regWinRate) {
		this.regWinRate = regWinRate;
	}

	public int getRegCounter() {
		return regCounter;
	}

	public void setRegCounter(int regCounter) {
		this.regCounter = regCounter;
	}

	public int getRegPayout() {
		return regPayout;
	}

	public void setRegPayout(int regPayout) {
		this.regPayout = regPayout;
	}

	public String toString() {
		return "" + slotName + ", " + "hopper has " + slotBal + " dollars, jackpot happens once in " + jackWinRate + " plays, the jackpot"
				+ " pays out " + jackPayout + " dollars.\nThe regular payout happens once in " + regWinRate + " plays, the regular payout is " +
				regPayout + " dollars.";
	}
	
	public void addSlotMachine(int size) {
		if(size >= 50) {
			System.out.println("Maximum number of slot machines entered!");
			return;
		}
		String tempslotName;
		int tempslotBal;
		int tempjackWinRate;
		int tempjackCounter;
		int tempjackPayout;
		int tempregWinRate;
		int tempregCounter;
		int tempregPayout;
		
		
		tempslotName = Methods.getString("Please enter the name of the slot machine: ");
		tempslotBal = Methods.getInt("Please enter the starting balance of the slot machine: ");
		tempjackWinRate = Methods.getInt("Please enter the odds of winning the jackpot for this machine, 1 in: ");
		tempjackCounter = 0;
		tempjackPayout = Methods.getInt("Please enter the amount of the jackpot prize for this machine: ");
		tempregWinRate = Methods.getInt("Please enter the odds of winning the regular payout for this machine, 1 in: ");
		tempregCounter = 0;
		tempregPayout = Methods.getInt("Please enter the amount of the regular prize for this machine: ");

		setSlotName(tempslotName);
		setSlotBal(tempslotBal);
		setJackWinRate(tempjackWinRate);
		setJackCounter(tempjackCounter);
		setJackPayout(tempjackPayout);
		setRegWinRate(tempregWinRate);
		setRegCounter(tempregCounter);
		setRegPayout(tempregPayout);
		
	}//end addSlotMachine
	
	public static int pickSlot(ArrayList<SlotMachine> slotArray){
		Scanner scan = new Scanner(System.in);
		int choice;
		boolean badPlayer = true;

		do {
			badPlayer = false;
			System.out.println("===========================");
			System.out.println("==== SLOT MACHINE LIST ====");
			System.out.println("===========================");
			for(int i = 0; i < slotArray.size(); i++) { //printing slot names
				System.out.println( "["+ (i+1) + "] " + slotArray.get(i).getSlotName());
			} //end for
			
			
			do { //validate outofbounds 
				choice = Methods.getInt("\nPlease select a slot: "); //getting slot selection from slot
				if(choice > slotArray.size()) {
					System.out.println("Slot doen't exist, try again!");
				}//end if
			}while(choice > slotArray.size()); //forces player to enter a valid slot
			
		}while(badPlayer);
		
		choice = choice - 1;
		return choice;
	} // end pickSlot
	
	public static void playSlot(ArrayList<SlotMachine> slotArray, ArrayList<Player> playerArray, int playerChoice, int slotChoice){
		Scanner scan = new Scanner(System.in);
		int s = slotChoice;
		int p = playerChoice;
		int i = 0; //for-loop counter
		int mLen = 0; //marquee length for formatting
		char choice;
		boolean flag = false;
		String slotName = slotArray.get(s).getSlotName();
		String marquee = "";
		int slotBal = slotArray.get(s).getSlotBal();
		int jackWinRate = slotArray.get(s).getJackWinRate();
		int jackCounter = slotArray.get(s).getJackCounter();
		int jackPayout = slotArray.get(s).getJackPayout();
		int regWinRate = slotArray.get(s).getRegWinRate();
		int regCounter = slotArray.get(s).getRegCounter();
		int regPayout = slotArray.get(s).getRegPayout();
		do{
// Actual slot play
		playerArray.get(p).setMoneyBalance(playerArray.get(p).getMoneyBalance() - 1); // 1 dollar to play slot
// generate winning numbers
		int jackRandom = (int)(Math.random() * jackWinRate + 1); // Comes up with random number for one jackpot slot play
		int regRandom = (int)(Math.random() * regWinRate + 1); // Comes up with random number for one regular slot play
// Results of slot play
	//	System.out.println("===========================");
// Banner formatting
		displaySlotMarquee(slotArray, s);
		/*
		mLen = slotArray.get(s).getSlotName().length(); //gets length of slot machines name string
		for(i = 0; i < (mLen + 10); i++)
				System.out.print("=");
		System.out.print("\n");
		marquee = "===  " + slotArray.get(s).getSlotName() + "  ===";
		System.out.println(marquee);
		for(i = 0; i < (mLen + 10); i++)
			System.out.print("=");
			*/
// if hit jackpot
		if(jackRandom == jackWinRate && slotBal >= jackPayout){ // jackpot win if the hopper has enough to pay out jackpot
			System.out.println("\nYou have won the " + slotName + " jackpot!");
			System.out.println("You won " + jackPayout + " dollars!");
			slotArray.get(s).setSlotBal(slotBal - jackPayout); // Jackpot payout subtracted from the slot machine hopper
			slotArray.get(s).setJackCounter(jackCounter += 1); // Number of times jackpot has been paid out increased
			playerArray.get(p).setMoneyBalance(playerArray.get(p).getMoneyBalance() + jackPayout);
			flag = true;
		} // end if
// if regular win
		if(regRandom == regWinRate && !flag){ // regular slot win
			System.out.println("\nYou have won the " + slotName + "!");
			System.out.println("You won " + regPayout + " dollars!");
			slotArray.get(s).setSlotBal(slotBal - regPayout); // Regular payout subtracted from the slot machine hopper
			slotArray.get(s).setRegCounter(regCounter += 1);// Number of times regular has been paid out increased
			playerArray.get(p).setMoneyBalance(playerArray.get(p).getMoneyBalance() + regPayout);
		} // end if
// did not win 
		else{
			System.out.println("\nYou lost " + slotArray.get(s).getSlotName() + ".\nYour current balance is " + playerArray.get(p).getMoneyBalance());
		}
		System.out.println("Would " + playerArray.get(p).getPlayerName() + " like to play " + slotArray.get(s).getSlotName() + " again?");
		do{
		choice = Methods.getChar("Enter either Y or N:");
		if(choice != 'Y' && choice != 'N'){
			System.out.println("Please enter only Y or N to continue");
		} // end if
		}while(choice != 'Y' && choice != 'N');
		}while((choice != 'N'));
	} // end playSlot
	
public static void fileMachines(ArrayList<SlotMachine> m) throws IOException {
		
		//creating players file
		File file = new File("machines.txt"); 
		file.createNewFile();
		PrintWriter out = new PrintWriter(file);
		
		//checking to see if file was created and user can write to triangle.txt
		if(!file.canWrite()) {
			System.out.println("You cannot write to this document!");
			out.close();
			return;
		}//end if 
		
		for(int i = 0; i < m.size(); i++) { // printing players to file
			out.println("\nMachine " + (i + 1));
			out.println(m.get(i).toString());
			out.print("\n\n");
		}//end for 
				
		System.out.println("Machine file created.");
		out.close(); //closing file
}//end fileMachine
	
	public static void displaySlotMarquee(ArrayList<SlotMachine> slotArray, int s) {
		int mLen;
		int i;
		String marquee;
		mLen = slotArray.get(s).getSlotName().length(); //gets length of slot machines name string
		for(i = 0; i < (mLen + 10); i++)
				System.out.print("=");
		System.out.print("\n");
		marquee = "===  " + slotArray.get(s).getSlotName() + "  ===";
		System.out.println(marquee);
		for(i = 0; i < (mLen + 10); i++)
			System.out.print("=");
		
	}//end printSlotMarquee
	
	
	
}
