package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<Integer, Integer> accountBalances = new HashMap<>();
    private int cashAvailable = 500; // Beispielwert für den verfügbaren Bargeldbestand

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

    /**
     * Withdraws money from the specified account if sufficient balance is available
     * and if the ATM has enough cash available.
     */
    public void cashout(int accountNumber, int amount) {
        if (accountBalances.containsKey(accountNumber)) {
            int accountBalance = accountBalances.get(accountNumber);
            if (amount <= accountBalance) {
                if (amount <= cashAvailable) {
                    accountBalance -= amount;
                    cashAvailable -= amount;
                    accountBalances.put(accountNumber, accountBalance);
                    System.out.println("Ok, here you go!");
                } else {
                    System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
                }
            } else {
                System.out.println("Sorry, you don't have enough money in the bank.");
            }
        } else {
            System.out.println("Account number not found.");
        }
    }

    /**
     * Launches the ATM
     */
    public static void main(String[] args) {
        ATM atm = new ATM();
        // Beispielkonten hinzufügen
        atm.accountBalances.put(123, 150); // Beispielkontostand: 150
        atm.accountBalances.put(234, 300); // Beispielkontostand: 300
        atm.accountBalances.put(345, 100); // Beispielkontostand: 100
        atm.run();
    }
}
