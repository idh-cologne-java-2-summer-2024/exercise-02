package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;
	
	public void start () {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				account(accountNumber);
				BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
				while (true) {
					try {
						System.out.print("Enter the amount to withdraw: ");
						int amount = Integer.parseInt(bu.readLine());
						cashout(amount);
					} catch (Exception e) {
						break;
					}
					}
			} catch (Exception e) {
				break;
			}
		}
	}
	public void account (int accountNumber) {
		if (accountNumber == 123 || accountNumber == 234 || accountNumber == 345 || accountNumber == 456) {
		}else {
			System.out.println("This account number doesn't exist.");
			}}
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
			}
		}
	public void cashout(int amount) {
			if (amount < accountBalance) {
				accountBalance = accountBalance - amount;
				System.out.println("Ok, here is your money, enjoy!");
			} else {
				System.out.println("Sorry, not enough money in the bank.");
			}
			
	}

	

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.start();
		atm.run();
	};

}
