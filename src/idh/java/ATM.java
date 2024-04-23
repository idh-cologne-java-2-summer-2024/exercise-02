package idh.java;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
int accountBalance = 100;
	public class Bankkonto {
		int kontonummer;
		String kontoinhaber;
		int guthaben; 
		
	public Bankkonto(int kontonummer, String kontoinhaber, int guthaben) {
		this.kontonummer= kontonummer;
		this.kontoinhaber = kontoinhaber;
		this.guthaben = guthaben;
	}
		
	}
	int moneyDepot = 400;
	
	Bankkonto[] kontos; 
	
	public ATM () {
		System.out.println( "ATM wird gestartet..");
		kontos = new Bankkonto[10];
		kontos[0] = new Bankkonto (281," taya", 100);
		
	}
	
 
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your Iban: ");
				int iban =Integer.parseInt(br.readLine());
				
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount,iban);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, int iban) {
		
		Bankkonto konto = getBankkontowithIban(iban);
		
		if (konto== null) {
			return;
			
		}
		if (konto.guthaben < amount) {
			System.out.println("Sorry, your dont have enough money in the bank. ");
		}

		if ((moneyDepot - amount) >= 0) {
			moneyDepot = moneyDepot - amount;
			konto.guthaben=konto.guthaben - amount;
			System.out.println("Ok, here is your money enjoy!");
		} else {
			System.out.println("Sorry not enough money in the bank");
		}
	};

	
	private Bankkonto getBankkontowithIban (int iban) {
		for (Bankkonto konto : kontos) {
			if (konto != null) {
				System.out.println(" No account!");
				if (konto.kontonummer== iban) {
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
};
