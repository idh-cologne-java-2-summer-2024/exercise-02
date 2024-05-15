package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<Integer, Integer> accountBalances; // Map to store account balances
    private int cash; // Cash available in ATM

    public ATM() {
        accountBalances = new HashMap<>();
        // Sample account balances
        accountBalances.put(123, 500);
        accountBalances.put(234, 1000);
        accountBalances.put(345, 200);
        cash = 1000; // Initial cash in ATM
    }

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
        if (!accountBalances.containsKey(accountNumber)) {
            System.out.println("Account not found.");
            return;
        }

        int balance = accountBalances.get(accountNumber);
        if (amount > balance) {
            System.out.println("Sorry, you don't have enough money in the bank.");
            return;
        }

        if (amount > cash) {
            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
            return;
        }

        // Withdraw from ATM
        cash -= amount;
        // Update account balance
        balance -= amount;
        accountBalances.put(accountNumber, balance);

        System.out.println("Ok, here you go!");
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}

