package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
    private int[] kontoNR = {361, 420, 611}; 
    private int[] accountBalance = {100, 200, 150}; 
    private int geldimATM = 300; 
//Test
    /**
     * Main command loop of the ATM Asks the user to enter an account number and
     * amount, and performs withdrawal if conditions are met.
     */
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter your account number: ");
                int accountNumber = Integer.parseInt(br.readLine());
                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());
                withdraw(accountNumber, amount);
            } catch (Exception e) {
                System.out.println("Invalid input. Exiting...");
                break;
            }
        }
    }

    /**
     * Withdraws the specified amount from the specified account if conditions are met.
     */
    public void withdraw(int accountNumber, int amount) {
        int index = findKontoIndex(accountNumber);
        if (index == -1) {
            System.out.println("Account not found.");
            return;
        }

        int balance = accountBalance[index];
        if (amount > balance) {
            System.out.println("Sorry, you don't have enough money in the bank.");
            return;
        }

        if (amount > geldimATM) {
            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
            return;
        }

        accountBalance[index] -= amount;
        geldimATM -= amount;
        System.out.println("Ok, here is your money, enjoy!");
    }

    private int findKontoIndex(int accountNumber) {
        for (int i = 0; i < kontoNR.length; i++) {
            if (kontoNR[i] == accountNumber) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
