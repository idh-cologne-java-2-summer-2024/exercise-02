package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;
	Bankkonto[] konten; 

	public ATM () {
		//Bankkonten anlegen
		konten = new Bankkonto [10000];
		konten [0] = new Bankkonto ("3456", "Max Mustermann");
		konten [1200] = new Bankkonto ("6678", "Karl Kabeljau");
		
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
                String kontonummer = br.readLine();
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(kontonummer, amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(String kontonummer, int amount) {
		Bankkonto konto = kontoSuchen (kontonummer);
		
		if (konto != null) {
			
			if (amount <= konto.getKontostand()) {
				konto.setKontostand (konto.getKontostand()- amount);
				System.out.println("Ok, here is your money, enjoy!");
				
			} else {
				System.out.println("Sorry, not enough money.");
			}

		}	
	}

	private Bankkonto kontoSuchen(String kontonummer) {
		for (Bankkonto konto : konten) {
			if (konto.getKontonummer().equals(kontonummer)) {
				return konto;
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
