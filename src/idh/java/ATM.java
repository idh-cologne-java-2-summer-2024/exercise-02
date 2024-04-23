package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class ATM {
	int accountBalance;
	int bankBalance = 10000;
	int[] accounts = new int[] {100, 50, 250, 10001};
	int i;
	
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
			int accountNumber = Integer.parseInt(br.readLine());
		
			if (accountNumber == 123) {
				accountBalance = accounts[0];
				i = 0;
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			}
			else if (accountNumber == 122) {
				accountBalance = accounts[1];
				i = 1;
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			}
			else if (accountNumber == 111) {
				accountBalance = accounts[2];
				i = 2;
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			}
			else if (accountNumber == 132) {
				accountBalance = accounts[3];
				i = 3;
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			}
			else {
				System.out.print("This Account does not exist!\n");
			}
			} catch (Exception e) {
				break;
				
			}
		}}
	
			
	public void cashout(int amount) {
		if (bankBalance > amount) {
		
			if (amount <= accountBalance) {
				accountBalance = accountBalance - amount;
				accounts[i] = accountBalance;
				bankBalance = bankBalance - amount;
				System.out.println("Ok, here is your money, enjoy!");
			} else {
				System.out.println("Sorry, not enough Money in your account.");
			}
		} else {
			System.out.print("Sorry, the ATM doesn't have that much cash anymore.\n");
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