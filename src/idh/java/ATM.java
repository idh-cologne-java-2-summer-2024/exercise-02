° package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	private int accountBalance = 100;
	private Bankkonto[] kontos;
	
	public ATM() { 
		System.out.println("ATM wird gestartet");
		
		
		kontos = new Bankkonto[20];
		
		kontos[0] = new Bankkonto(1234, "Max", 100);
		kontos[1] = new Bankkonto(56789, "Mustermann", 150);
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
				System.out.println("Enter your account number: ");
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
		
		Bankkonto konto = getBankkontoByAccountNumber(accountNumber);
		
		if(konto ==null) {
			return;
		}
		
		if(konto.guthaben < amount) {
			System.out.println("Sorry, you don't have enough money in your account.");
			return;
		}
	
		if (amount < accountBalance) {
			accountBalance = accountBalance - amount;
			konto.guthaben = konto.guthaben - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, the ATM doesn't have that much money anymore.");
		}

	};
	
private Bankkonto getBankkontoByAccountNumber (int accountNumber) {
		
		for(Bankkonto konto : kontos) {
			if(konto != null) {
				
				if(konto.kontonummer == accountNumber) {
					return konto;
				}
			}
		}
		return null;
		


	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
