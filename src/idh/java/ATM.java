package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	private int geldInBank= 100;
	
	bankkonto[] kontos;
	
	public ATM() {
		System.out.println("Atm wir gestarted...");
		
		kontos = new bankkonto [20];
		kontos[0] = new bankkonto(1234,"leonie",50);
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
				System.out.print("Enter the Accountnumber: ");
				int accountNUmber = Integer.parseInt(br.readLine());
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount,accountNUmber);
				
				if (geldInBank < amount) {
                    System.out.print("Enter the amount to withdraw: exit ");
                    break;}
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, int accountNumber) {
		
		bankkonto konto = getBankkontoByAccountNumber(accountNumber);
		
		if(konto==null) {
			System.out.println("Account with account number"+ accountNumber + "not found");
			return;
		}
		
		if (konto.guthaben < amount) {
			System.out.println("Sorry, not enough money in your account.");
			return;
		}
		
		
		if (amount <= geldInBank) {
			geldInBank = geldInBank- amount;
			konto.guthaben = konto.guthaben - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	};
	private bankkonto getBankkontoByAccountNumber (int accountNumber) {
		
		for (bankkonto konto : kontos) {
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
