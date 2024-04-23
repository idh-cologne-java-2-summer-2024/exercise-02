package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<Integer, Integer> accountBalances;
    private int cashAvailable; // Variable für den Bargeldbestand des Automaten

    public ATM() {
        accountBalances = new HashMap<>();
        accountBalances.put(123, 100);
        accountBalances.put(234, 200);
        cashAvailable = 500; // Wert für den Bargeldbestand des Automaten
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter your account number: ");
                int accountNumber = Integer.parseInt(br.readLine());
                if (!accountBalances.containsKey(accountNumber)) {
                    System.out.println("Invalid account number. Please try again.");
                    continue;
                }

                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());
                cashout(accountNumber, amount);
            } catch (Exception e) {
                break;
            }
        }
    }

    public void cashout(int accountNumber, int amount) {
        int accountBalance = accountBalances.get(accountNumber);
        if (amount <= accountBalance) {
        	if (amount <= cashAvailable) { // Überprüft, ob genug Bargeld da ist
        	accountBalance -= amount;
            accountBalances.put(accountNumber, accountBalance);
            cashAvailable -= amount; // Aktualisiert den Bargeldbestand
            System.out.println("Ok, here you go!");
        } else {
            System.out.println("Sorry, you don't have enough money in the bank.");
        }
    } else {
    	System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
    	} 
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
