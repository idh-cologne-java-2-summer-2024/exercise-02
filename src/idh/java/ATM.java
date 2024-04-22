package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	// Struktur zur Speicherung von Benutzerkonten
    private static class Account {
        int accountNumber;
        int balance;

        public Account(int accountNumber, int balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }
    }
    
    private Account[] accounts;
    private int ATMBalance;

    public ATM() {
        
        accounts = new Account[] {
            new Account(123, 1000),
            new Account(789, 500)
        };
        
        ATMBalance = 900;
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
                int accountNumber = Integer.parseInt(br.readLine());
                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());
                cashout(accountNumber, amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int accountNumber, int amount) {
		
		Account account = findAccount(accountNumber);
        if (account != null) {
            if (amount <= account.balance && amount <= ATMBalance) {
                account.balance -= amount;
                ATMBalance -= amount;
                System.out.println("Ok, here you go!");
            } else if (amount <= account.balance && amount > ATMBalance) {
                System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
            } else {
                System.out.println("Sorry, you don't have enough money in the bank.");
            }
        } else {
            System.out.println("Account number not found.");
        }

	}
	
	private Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
        }
        return null; // Account nicht gefunden
    }

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
