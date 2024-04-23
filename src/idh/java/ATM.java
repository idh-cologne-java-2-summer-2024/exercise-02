package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class ATM {
	private Map<String, Integer> accounts = new HashMap<>();
	int accountBalance = 100;
	private int cashAvailable = 1000;  //Bargeld im Automaten 

	public ATM() {
		accounts.put("123", 500); // Konto und Kontostand
		accounts.put("789", 1000);
		accounts.put("456", 400);
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
				String accountNumber = br.readLine();
				if (!accounts.containsKey(accountNumber)) {
					System.out.println("Account not found.");
					continue;
				}		
				
				accountBalance = accounts.get(accountNumber);
				System.out.println("Your current balance is:  "+ accountBalance);
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				
				if (amount < 0) {
					System.out.println("Invalid amount.");  //ungültige Eingabe
					continue; 
				}
				if (amount > accountBalance) {
					System.out.println("Sorry, you dont have enough money in the bank.");
					continue;
				}
				if (amount > cashAvailable) {
					System.out.println("Sorry, the ATM doesnt have that much cash anymore.");
					continue;
				}
				
				cashout(accountNumber, amount);
				System.out.println("Ok, here is your money!");
				System.out.println("Your new Balance is:" + accounts.get(accountNumber));
				System.out.println("Remaining cash in ATM: " + cashAvailable);
				
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	public void cashout(String accountNumber, int amount) {
		int accountBalance = accounts.get(accountNumber);
		accountBalance -= amount;
		accounts.put(accountNumber, accountBalance);
		cashAvailable -= amount;		
			
		}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
