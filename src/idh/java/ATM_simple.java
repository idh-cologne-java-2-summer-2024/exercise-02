package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * This is a simpler solution to the exercise. Instead of creating an additional
 * class Account, we're storing the balance of each account in a simple
 * int-Array. This is a good solution for this exercise, but is difficult to
 * extend (e.g., if we want to store other data for each account).
 */
public class ATM_simple {

    // initial cash in the ATM
    int cash = 100;

    // accounts known to the ATM
    int[] balances = new int[5];

    public ATM_simple() {
	// create accounts with varying balances
	Random random = new Random();
	for (int i = 0; i < balances.length; i++) {
	    balances[i] = random.nextInt(1000);
	}
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
		e.printStackTrace();
		break;
	    }
	}
    }

    public void cashout(int accountNumber, int amount) {
	// check for cash in the ATM
	if (amount > cash) {
	    System.out.println("Sorry, not enough cash left.");
	    return;
	}

	// check for existence of the account
	if (accountNumber > balances.length - 1 || accountNumber < 0) {
	    System.out.println("Sorry, this account doesn't exist.");
	    return;
	}

	// check for balance of the account
	if (amount > balances[accountNumber]) {
	    System.out.println("Sorry, you're out of money.");
	    return;
	}

	// withdraw
	balances[accountNumber] = balances[accountNumber] - amount;
	cash -= amount;
	System.out.println("Ok, here is your money, enjoy!");

    };

    /**
     * Launches the ATM
     */
    public static void main(String[] args) {
	ATM_simple atm = new ATM_simple();
	atm.run();
    };

}
