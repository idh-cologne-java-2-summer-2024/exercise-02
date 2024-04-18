package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;
	int atmBalance= 50000; 
	userAccount[] userAccounts = new userAccount [4];
	public ATM( ) {
		
		userAccounts[0]=  new userAccount(1234, 5000, "Bibi"); 
		userAccounts[1] = new userAccount(9876, 20000, "Tina"); 
		userAccounts[2] = new userAccount(7654, 50, "Amadeus"); 
		userAccounts[3] = new userAccount(4321, 966745656, "Sabrina");
		
	}
	
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and checks with the function checkAccountNbr 
	 * if the number is an existing account number and returns the array-slot of the account as an integer, if it exists. 
	 * If the number is an existing Account number it asks for an Amount to withdraw and passes the new number and the array-slot
	 *-number to the function cashout(...) which actually does the calculation and checks if the atm has enough money and the balance of the account owner is high enough.
	 * If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Welcome! Please enter your accountnumber: ");
			int accountNbr = Integer.parseInt(br.readLine());
			int account = checkAccountNbr(accountNbr);
			if (account>=0) {
				 System.out.print("Hello "+ userAccounts[account].userName + "! Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(account, amount);
			 } else {
					 System.out.println("This Account does not exist. Please try again");
			 }
			} catch (Exception e) {
				break;
			}
		}
	}
	
	/* checks if accountnumber belongs to an existing account by looping through an array with useraccounts-objects
	*and compares the accountnumbers. If true, it returns the array-slot of the useraccount. Else it returns an 
    *array-slot.  
	*/
	public int checkAccountNbr(int accountNbr) {
		
		for (int i=0; i<=userAccounts.length; i++) {
			
			if (userAccounts[i].accountNumber==accountNbr) {
				return i; 
			}
		}
		return -1;
	}
	/*takes the array-slot of the account and the wanted amount and checks if the amount is smaller then the cash-reserve
	 * of the atm. If it is it checks if the user has enough money, using the array-slot of the account. If true, the money will be withdrawn 
	 * and the balance of the atm and the account will be updated.  
	 * No money will be withdrawn if one or both checks fail. 
	 */
	public void cashout(int account, int amount) {
		
		if (amount <= atmBalance) {
			if (amount <=userAccounts[account].userBalance) {
			
				userAccounts[account].userBalance = userAccounts[account].userBalance - amount;
				this.atmBalance= this.atmBalance-amount; 
				System.out.println("Ok, here is your money, enjoy! Your new Balance is: "+userAccounts[account].userBalance+"€");
			} else {
				System.out.println("Sorry, you're broke");
			}
		} else {
			System.out.println("Sorry, not enough money in this ATM.");
		}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		
		
		ATM atm = new ATM();
		atm.run();
	}

}
