package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 1000;

	Bankkonto kontos [];
	
	public ATM () { 
		
		System.out.print("ATM wird gestarted...");
		
		kontos = new Bankkonto [20];
		
		kontos [0] = new Bankkonto (1234, "Hans", 1000);
	}
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, accountNumber);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, int accountNumber) {
		
		Bankkonto konto = getBankKontoByNumber(accountNumber);
		
		if (konto == null) {
			return;
		}
		
		if (konto.guthaben < amount) {
			System.out.print("Sorry, you dont't have enough money in the bank.");
			return;
			}
		
		if (amount < accountBalance) {
			accountBalance = accountBalance - amount;
			konto.guthaben = konto.guthaben - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}
	}

		
		private Bankkonto getBankKontoByNumber(int accountNumber) {
			 for (Bankkonto konto : kontos) {
				if (konto != null) {
					if (konto.kontonummer == accountNumber) {
						return konto;
					}
				}
			 
			 }
			 
			return null;
			 
		 }
		

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};


}