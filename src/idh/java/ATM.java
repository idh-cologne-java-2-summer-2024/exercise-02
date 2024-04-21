package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ATM {
	
	int cashInATM = 1000;
	
	Account[] accounts;
	
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		accounts = new Account[5];
		accounts[0] = new Account(123, 100);
		accounts[1] = new Account(234, 150);
		accounts[2] = new Account(345, 125);
		accounts[3] = new Account(456, 500);
		accounts[4] = new Account(567, 400);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number to proceed:");
				int accountNr = Integer.parseInt(br.readLine());
				if (findAccount(accountNr) != null) {
					System.out.print("Enter the amount to withdraw:");
					int amount = Integer.parseInt(br.readLine());
					cashout(findAccount(accountNr), amount);
				}
			} catch (Exception e) {
				break;
			}
		}
	}
	
	public Account findAccount(int accountNr) {
		for (int c = 0; c < accounts.length; c++) {
			if (accountNr == accounts[c].accountNumber) {
				return accounts[c];
			}
		} System.out.println("No account registered under that number. Please try again");  
		return null;
	}
	

	public void cashout(Account a, int amount) {
		if(this.cashInATM > 0) {
			if (amount < a.balance) {
				a.balance = a.balance - amount;
				System.out.println("Ok, here is your money, enjoy!");
				cashInATM = cashInATM - amount;
			} else {
				System.out.println("Sorry, not enough money in the bank.");
			}
		} else {System.out.println("Sorry, the ATM doesn't have that much cash anymore.");}
	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		
		ATM atm = new ATM();
		
		atm.run();
	};

}
