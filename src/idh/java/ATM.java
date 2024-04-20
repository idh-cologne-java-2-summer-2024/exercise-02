package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
    private int accountBalance;
    private int kontoNr;

    /**
     * Der Constructor um den Konten die Geldbeträge zuzuordnen.
     */
    public ATM(int kontoNr, int accountBalance) {
        this.kontoNr = kontoNr;
        this.accountBalance = accountBalance;
    }

    /**
     * Main command loop of the ATM Asks the user to enter a number, and passes this
     * number to the function cashout(...) which actually does the calculation and
     * produces money. If the user enters anything else than an integer number, the
     * loop breaks and the program exists
     */
    public static void run() {
        ATM atm1 = new ATM(5555, 1000);
        ATM atm2 = new ATM(1234, 500);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Please enter your account number");
                int kontoNrCurrent = Integer.parseInt(br.readLine());
                if (atm1.kontoNr == kontoNrCurrent) {
                    System.out.println("Enter the amount to withdraw: ");
                    int amount = Integer.parseInt(br.readLine());
                    atm1.cashout(amount);
                } else if (atm2.kontoNr == kontoNrCurrent) {
                    System.out.println("Enter the amount to withdraw: ");
                    int amount = Integer.parseInt(br.readLine());
                    atm2.cashout(amount);
                } else {
                    System.out.println("Please type in a correct account number");
                }
            } catch (Exception e) {
                break;
            }
        }
    }

    public void cashout(int amount) {
        if (amount < accountBalance) {
            accountBalance = accountBalance - amount;
            System.out.println("Ok, here is your money, enjoy!");
        } else {
            System.out.println("Sorry, not enough money in the bank.");
        }
    }

    /**
     * Launches the ATM
     */
    public static void main(String[] args) {
        run();
    }
}