package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;

	
	package idh.java;

	import java.io.BufferedReader;
	import java.io.InputStreamReader;

	public class ATM {
		int accountBalance = 100;

		
		public ATM() {
			
			
		
			System.out.println("Karte Einfügen...");
			System.out.println(   );
			System.out.println("[Kontostand einsehen]    [Bargeld einzahlen]");
			System.out.println("[Abbruch]                [Bargeld auszahlen]");
			System.out.println(   );
		 	
			Bankkonto[] kontos = new Bankkonto[10];
			 
			 kontos[0]= new Bankkonto(034, "Wilhelm", 100);
			 kontos[1]= new Bankkonto(7368, "Keanu", 60);
		}
		
		public void run() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				try {
					
					System.out.println("Kontonummer eingeben:");
					int accountNumber= Integer.parseInt(br.readLine());
					
					
					System.out.print("Gib den Auszahlungsbetrag ein: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(amount, accountNumber);
				} catch (Exception e) {
					break;
				}
			}
		}

		public void cashout(int amount, int accountNumber) {
			
			Bankkonto konto = getBankkontoByAccountNumber(accountNumber);
			
			if (konto== null) {
				return;
			}
			
			if (konto.guthaben < amount) {
				System.out.println("Sorry, you are too broke...");
				return;
			}
			if (amount < accountBalance) {
				accountBalance = accountBalance - amount;
				System.out.println("Ok, here is your money, enjoy!");
			} else {
				System.out.println("Sorry, not enough money in the bank.");
			}

		};
		private Bankkonto getBankkontoByAccountNumber(int accountNumber) {
		

		

		for (Bankkonto konto: kontos) {
			// Ich weis nicht, warum das immernoch rot ist, dabei habe ich es ja oben bereits initialisiert;/
	 		
	 		if ( konto != null) {
	 			if (konto.kontonummer== accountNumber) {
	 				
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
		}}
		
		
		
		
		
		
		
		
		
		
		
		
	