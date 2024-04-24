package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	int cash = 200;
	Bankkonto[] kontos;
			
	public ATM() {
		System.out.println("ARM wird gestartet!");
		kontos = new Bankkonto[20];
		kontos[0] = new Bankkonto(0,"Uwe", 200);
		kontos[1] = new Bankkonto(1,"Sabrina", 200);
		kontos[2] = new Bankkonto(2,"Godfried", 200);
		kontos[3] = new Bankkonto(3,"Agatha", 200);
		
	}
	
			/**
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists ssss
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int accountnumber = Integer.parseInt(br.readLine());
				
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, accountnumber);
			} catch (Exception e) {
				break;
			}
		}
	}
	
	public void cashout(int amount, int accountnumber) {
		
		Bankkonto konto = getKontobyAccountnumber(accountnumber);
		
		if (amount < konto.guthaben && cash >= amount) {
			konto.guthaben = konto.guthaben - amount;
			System.out.println("Ok, here is your money, enjoy!");
		}
		else {
			if(amount > konto.guthaben) {
				System.out.println("Sorry, not enough money in the bank.");
			} else {
			if(cash < amount) {
				System.out.println("Sorry, the ATM doesn't have that much cash anymore");
			}}
		}
		}

	private Bankkonto getKontobyAccountnumber(int accountnumber) {
		for(Bankkonto konto : kontos) {
			if(konto != null && konto.kontonummer == accountnumber) {
					System.out.print("Enter the amount to withdraw: ");
					return konto;
				
			}
		}
		System.out.println("Es wurde kein Konto gefunden!");
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
