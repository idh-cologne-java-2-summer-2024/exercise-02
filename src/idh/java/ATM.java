package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	int cash = 25000;
	
	Account [] accounts = new Account[5];
	
	public ATM() {
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i);
		}
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
				System.out.println("Enter Account ID: ");
			//	acc.getAccount(Integer.parseInt(br.readLine()));
				int accnr = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, accnr);
			} catch (Exception e) {
				break;
			}
		}
	}
	
	private Account getAccount (int nr) {
		for (Account account: accounts) {
			if (account.getID() == nr) 
				return account;
			
		}
		return null;
	}
	

	public void cashout(int amount, int accountNumber) {
		Account myacc = getAccount(accountNumber);
		
		if (myacc == null) {
			System.out.println("Account doesn´t exist");
			return;

		}
		
		if (amount > cash) {
			System.out.println("Sorry not enough cash in ATM");
			return;
		}
		
		if (amount > myacc.balance) {
			System.out.println("Sorry, not enough money in your account. Your current balance is " + myacc.balance);
			return;
		}
		
		myacc.withdraw(amount);
		this.cash = this.cash - amount;
		System.out.println("Ok, here is your money, enjoy!");
		

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
		
		
		
		
		
	};

}
