package idh.java;
import java.util.List;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	//int accountBalance = 100;
	int availableMoney = 200;
	Accounts account = new Accounts();
	List<String> passwordList = account.generateAcc();
	int[] amountPerAccount = new int[passwordList.size()];
	String accountNumber = "";
	
	
	
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < amountPerAccount.length; i++) {
        amountPerAccount[i] = 100;
		}
		
		while (true) {
			try {
				
				System.out.print("Enter account number: ");
				accountNumber = br.readLine();
				if (passwordList.contains(accountNumber)) {
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(amount);
				}
				else {
					System.out.println("Wrong Password!!");
				}
			} catch (Exception e) {
				System.out.println("Have a nice day!");
			}
		}
	}
	
	public void cashout(int amount) {
		if (amount <= amountPerAccount[passwordList.indexOf(accountNumber)] && amount <= availableMoney)  {
			amountPerAccount[passwordList.indexOf(accountNumber)] = amountPerAccount[passwordList.indexOf(accountNumber)] - amount;
			availableMoney = availableMoney - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else if(amount > amountPerAccount[passwordList.indexOf(accountNumber)]) {
			System.out.println("Sorry, you don't have enough money in the bank.");
			System.out.println(amountPerAccount[passwordList.indexOf(accountNumber)]);
		}else if((amount > availableMoney)) {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
			System.out.println(availableMoney);
			
		}

	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	}

}
