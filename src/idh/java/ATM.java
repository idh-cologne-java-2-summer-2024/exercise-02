package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
    int[] accountNumbers = {123, 234, 345};
    int[] accountBalances = {200, 1000, 500};
    int cashInATM = 500;

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

    public void cashout(int accountNumber, int amount) {
        int index = -1;
        for (int i = 0; i < accountNumbers.length; i++) {
            if (accountNumbers[i] == accountNumber) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            int accountBalance = accountBalances[index];
            if (amount <= accountBalance) {
                if (amount <= cashInATM) {
                    accountBalances[index] -= amount;
                    cashInATM -= amount;
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

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
