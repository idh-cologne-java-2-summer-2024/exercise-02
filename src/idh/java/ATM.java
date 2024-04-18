package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ATM {
	private int availableMoney = 1000000;
	private Konto[] accounts;


	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	
	public ATM()
	{
		this.accounts = new Konto[10];
		for (int i = 0; i < this.accounts.length; i++) {
			this.accounts[i] = new Konto(i+1,1500);
		}
	}
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				
				System.out.print("Enter your account number: ");
				int id = Integer.parseInt(br.readLine());
				
					if (findID(id)) { //Id wird in der Kontoliste gesucht.
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(id,amount);
					} else {
						System.out.println("Sorry, account wasn´t found.");
					}
				
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int id, int amount) {
		
		if (amount <= this.accounts[id-1].getAccountBalance() && amount <= this.availableMoney) { //Eingegebene ID wird genutzt um ein Konto zu finden. 
			this.accounts[id-1].minus(amount);
			this.availableMoney -= amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}
		}

	
	
	public boolean findID(int findID) { //Methode, um sicherzustellen, dass eine ID existiert.
	
		for (int i = 0; i < this.accounts.length; i++) {
		  if (findID == this.accounts[i].getID()) {
			  return true;
		  }
		}
		return false;	
			
	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		
		ATM atm = new ATM();
		atm.run();
	};

}
