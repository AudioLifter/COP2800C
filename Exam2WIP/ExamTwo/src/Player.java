import java.util.*;
import java.io.*;

public class Player {

	private int moneyBalance;
	private Name playerName;
	private Date dob;
	
	Scanner input = new Scanner(System.in);
	
	public Player(int moneyBalance, Name playerName, Date dob) {
		setMoneyBalance(moneyBalance);
		setPlayerName(playerName);
		setDob(dob);
	}

	public Player(int size) {
		addPlayer(size);
	}

	public int getMoneyBalance() {
		return moneyBalance;
	}

	public void setMoneyBalance(int moneyBalance) {
		this.moneyBalance = moneyBalance;
	}

	public Name getPlayerName() {
		return playerName;
	}

	public void setPlayerName(Name playerName) {
		this.playerName = playerName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return playerName.toString() + " \n " + dob.toString() + " \n " + "\nBalance: $" + moneyBalance;
	}
	
	//=============================================================================
	
	public void addPlayer(int size) {
		Name name;
		Date dob;
		int balance;
		
		if(size >= 50) {
			System.out.println("Maximum number of players entered!");
			return;
		}
		
		name = new Name();
		dob = new Date();
		balance  = Methods.getInt("Please enter the player's starting balance: ");
		
		setPlayerName(name);
		setDob(dob);
		setMoneyBalance(balance);
		
	}//end addPlayer
	
	public static void filePlayers(ArrayList<Player> p) throws IOException {
		Scanner input = new Scanner(System.in);
		//creating players file
		File file = new File("players.txt"); 
		file.createNewFile();
		PrintWriter out = new PrintWriter(file);
		
		//checking to see if file was created and user can write to triangle.txt
		if(!file.canWrite()) {
			System.out.println("You cannot write to this document!");
			out.close();
			return;
		}//end if 
		
		for(int i = 0; i < p.size(); i++) { // printing players to file
			out.println("\nPlayer " + (i + 1));
			out.println(p.get(i).toString());
			out.println("\n");
		}//end for 
				
		System.out.println("Player file created.");
		out.close(); //closing file
	}//end filePlayers
	
	public static int pickPlayer(ArrayList<Player> p){
		Scanner scan = new Scanner(System.in);
		int choice;
		boolean badPlayer = true;
		
		do {
			badPlayer = false;
			System.out.println("===========================");
			System.out.println("======= PLAYER LIST =======");
			System.out.println("===========================");
			for(int i = 0; i < p.size(); i++) { //printing player names
				System.out.print( "["+ (i+1) + "] " + p.get(i).getPlayerName().toString());
			} //end for
			
			
			do { //validate outofbounds player
				choice = Methods.getInt("\nPlease select a player: ") - 1; //getting player selection from player
				if(choice < 0) {
					System.out.println("Player doen't exist, try again!");
				}//end if
			}while(choice < 0); //forces player to enter a valid player
			
			
			if(choice < p.size()) { 
				if(p.get(choice).getMoneyBalance() <= 1) {
					badPlayer = true;
					System.out.println("Insufficient funds, please select another player!");
				}//end inner if
				
			}//end outer if
			
			else {
				badPlayer = true;
				System.out.println("That player doesn't exist, please try again!");
			}//end else
			
		}while(badPlayer);
		
		
		return choice;
	} // end pickPlayer
	
}//end Player
