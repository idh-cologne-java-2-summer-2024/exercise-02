package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	private int accountBalance = 100;
	Bankkonto[] kontos;

	public ATM() {
		System.out.println("ATM wird gestartet...");
		kontos = new Bankkonto[20];
		kontos[0] = new Bankkonto(1234, "Nils", 100);
		kontos[1] = new Bankkonto(5678, "Max Mustermann", 150);}

	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				System.out.println("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, accountNumber);
			} catch (Exception e) {
				break;}}}

	public void cashout(int amount, int accountNumber) {
		Bankkonto konto =  getBankontoByAccountNumber(accountNumber);
		if(konto == null) {
			System.out.println("Account with account number "+ accountNumber +" not found");
			return;}
		if(konto.guthaben < amount) {
			System.out.println("Sorry, you don't have enough money in the bank.");
			return;}
		if (amount < accountBalance) {
			accountBalance = accountBalance - amount;
			konto.guthaben = konto.guthaben - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in your account.");}};

	private Bankkonto getBankontoByAccountNumber(int accountNumber) {
		for(Bankkonto konto : kontos) {
			if(konto != null) {	
				if(konto.kontonummer == accountNumber) {
					return konto;}}}
			return null;}
	
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();};}