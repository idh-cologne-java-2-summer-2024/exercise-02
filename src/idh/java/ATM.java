package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;
	ATMaccount [] accounts;
	
	public ATM() {
		accounts = new ATMaccount[10];
		accounts[0] = new ATMaccount(100, "123");
		accounts[1] = new ATMaccount(400, "234");
		accounts[2] = new ATMaccount(100, "345");
	}

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
		try {
			System.out.print("Enter your account number: ");
			String accountNumber = br.readLine();
			
			System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, accountNumber);
			} catch (Exception e) {
				break;
			}
		}
	}
	
	public ATMaccount getATMaccountByaccountNumber (String accountNumber) {
		for (ATMaccount account : accounts) {
			if(account != null) {
				System.out.println("Ok, here you go!");
			} else { 
				System.out.println("Sorry, you don't have enough money in the bank");
			
			}
		}
		return null;
		
	}

	public void cashout( int amount, String accountNumber) {
		ATMaccount account = getATMaccountByaccountNumber(accountNumber);
		
		if (account ==null) {
			return;
		}
		
		if (amount <= accountBalance) {
			accountBalance = accountBalance - amount;
			
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM(); 
		atm.run();
	
	};

}
