package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
    private int[] accountNumbers = {123, 234, 345}; // Beispielkontonummern
    private int[] accountBalances = {300, 800, 700}; // Beispielkontostände
    private int cashAvailable = 1111; // Beispiel Bargeldbestand des Automaten

    /**
     * Schleife des Automaten
     */
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter your account number: ");
                int accountNumber = Integer.parseInt(br.readLine());
                int accIndex = findaccIndex(accountNumber);
                if (accIndex == -1) {
                    System.out.println("Account not found.");
                    continue;
                }
                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());
                cashout(accIndex, amount);
            } catch (Exception e) {
                break;
            }
        }
    }

    /**
     * Suchmethode nach dem Index des Arrays eines Kontos in der Kontonummernliste
     */
    private int findaccIndex(int accountNumber) {
        for (int i = 0; i < accountNumbers.length; i++) {
            if (accountNumbers[i] == accountNumber) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Auszahlungsmethode
     */
    public void cashout(int accIndex, int amount) {
        int balance = accountBalances[accIndex];
        if (amount <= balance && amount <= cashAvailable) {
            accountBalances[accIndex] -= amount;
            cashAvailable -= amount;
            System.out.println("Ok, here you go!");
        } else if (amount > balance) {
            System.out.println("Sorry, you don't have enough money in the bank.");
        } else {
            System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
        }
    }

    /**
     * Startet den Geldautomaten
     */
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
