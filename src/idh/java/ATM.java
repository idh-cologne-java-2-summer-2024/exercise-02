package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	private int accountBalance = 100;
Bankkonto[]kontos;

public ATM() {
System.out.println("ATM wird gestartet");
kontos= new Bankkonto(20);
}{
	kontos[0]= new Bankkonto(567,"Wobbles",300);
}{
kontos[1]=new Bankkonto (5673,"Yoschie",330);}
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
				System.out.println("Enter your account number");
				int accountNumber=Integer.parseInt(br.readLine());
			
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, accountNumber);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, int accountNumber) {
		Bankkonto konto= getBankkontoByAccountnumber(accountNumber);
		if(konto==null) {
			return;
		}
		}{
		if (amount <= accountBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");}
		}

	
private Bankkonto getBankkontoByAccountNumber(int accountNumber) {
	for(Bankkonto konto:kontos) {
		if(konto!=null) {
			if(konto.kontonummer==accountNumber) {
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
