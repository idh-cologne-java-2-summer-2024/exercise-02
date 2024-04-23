package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	private int accountNumber = 0;
	private int accountBalance = 0;
	public ATM () {
			try{
		System.out.print("Enter the account number you want to have: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.accountNumber = Integer.parseInt(br.readLine());
		System.out.print("What is your current balance?");
		this.accountBalance = Integer.parseInt(br.readLine());
			} catch (Exception e) {		
			}	
	}
	public void fun () {
		System.out.print("Enter your account number: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			accountNumber = Integer.parseInt(br.readLine());
			accountNumber = this.accountNumber;
			accountNumber.run;
		} catch (Exception e) {
			
		} // habs versucht schaffe es aber nicht wirklich wie ich auf das spezifische Balance zugreife anhand der accountNumber die eingegeben wird
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
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, this.accountBalance);
			} catch (Exception e) {
				break;
			}
		}
	}
	public void cashout(int amount, int balance) {
		int moneyLeft = 500;
		if (amount < this.accountBalance && moneyLeft >= amount) {
			System.out.println("Ok, here is your money, enjoy!");
			this.accountBalance = this.accountBalance - amount;
			moneyLeft -= amount;
		} else {
			System.out.println("Sorry, not enough money in the bank.");

		}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.fun();
		atm.fun();
	};

}
