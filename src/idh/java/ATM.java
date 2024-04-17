package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

	int cashInATM = 2000; // The ATM has only 2000 units of money on hand
	static int[] bankAccounts = new int[999]; // The bank has up to 1000 accounts
	
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print("Enter you account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				int amountToWithdraw = Integer.parseInt(br.readLine());
				cashout(accountNumber, amountToWithdraw);
			} catch (Exception e) {
				break;
			}
		}
	}
	
	private static void createDummyAccounts() {
		bankAccounts[123] = 1500;
		bankAccounts[234] = 250;
		bankAccounts[345] = 750;
	}
	
	
	public void cashout(int accountNumber, int amountToWithdraw) {
		if (amountToWithdraw <= cashInATM) {
			if (amountToWithdraw > bankAccounts[accountNumber]) {
				System.out.println("Sorry, not enough cash in your account :(");
			} else if (amountToWithdraw <= bankAccounts[accountNumber]){
				cashInATM += -amountToWithdraw;
				bankAccounts[accountNumber] += -amountToWithdraw;
				System.out.println("Ok, here is your cash, enjoy!");
				System.out.println("New cash total: " + bankAccounts[accountNumber]);
			}
		} else {
			System.out.println("We are very sorry but this ATM is out of cash :(");
		}
	}
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		createDummyAccounts();
		ATM atm = new ATM();
		atm.run();
	}
}