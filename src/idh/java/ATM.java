package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int ATMBalance = 100;
	int[][] accounts;
	
	public ATM()
	{
		accounts = new int[2][50];
		
		accounts[0][0] = 123;
		accounts[1][0] = 50;
		accounts[0][1] = 134;
		accounts[1][1] = 200;
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
				int account = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, account);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, int account) {
		if (amount <= ATMBalance) {
			
				for(int i = 0; i < accounts.length; i++) {
					for(int j = 0; j < accounts[i].length; j++) {
						if(accounts[i][j] == account) {
							if(amount <= accounts[i+1][j]) {
								ATMBalance -= amount;
								accounts[i+1][j] -= amount;
								System.out.println("Ok, here is your money, enjoy!");
							} else {
								System.out.println("Sorry, you don't have enough money in the bank.");
							}
							return;
						}
					}
				}
				
		} else {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
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

