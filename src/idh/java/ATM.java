package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<String, Integer> accountBalances = new HashMap<>(); // accounts with balances
    private int cashInATM = 500; // starting balance

    /**
     * main command loop of the ATM. Asks the user for an account number & amount money, then provides cash
     */
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter your account number: ");
                String accountNumber = br.readLine();

                // if account number not available, it gets added
                if (!accountBalances.containsKey(accountNumber)) {
                    accountBalances.put(accountNumber, 500); // starting balance 500
                    System.out.println("New account created with initial balance of 500.");
                }

                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());
                cashout(accountNumber, amount);

            } catch (Exception e) {
                System.out.println("Wrong input moron, try again!");
                break;
            }
        }
    }

    /**
     * function for withdrawing money. Checks if user has enough money and if the ATM has enough cash
     */
    public void cashout(String accountNumber, int amount) {
        if (amount <= accountBalances.get(accountNumber)) {
            if (amount <= cashInATM) {
                accountBalances.put(accountNumber, accountBalances.get(accountNumber) - amount);
                cashInATM -= amount;
                System.out.println("Ok, here you go!");
            } else {
                System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
            }
        } else {
            System.out.println("Sorry, you don't have enough money in the bank.");
        }
    }

    /**
     * starts the ATM.
     */
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}