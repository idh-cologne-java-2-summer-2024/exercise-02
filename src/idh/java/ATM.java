package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
    private int storedMoney;

    /**
     * Der Constructor um den Konten die Geldbeträge zuzuordnen.
     */
    public ATM(int storedMoney) {
    	Bankkonto[] BK = new Bankkonto[2];
    	BK[0] = new Bankkonto(5555, 1000);
        BK[1] = new Bankkonto(1234, 500);
        this.storedMoney = storedMoney;
    }

    /**
     * Main command loop of the ATM Asks the user to enter a number, and passes this
     * number to the function cashout(...) which actually does the calculation and
     * produces money. If the user enters anything else than an integer number, the
     * loop breaks and the program exists
     */
    public static void run() {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Please enter your account number");
                int kontoNrCurrent = Integer.parseInt(br.readLine());
                for (int i=0;i<BK.length;i++) {
                	if (BK[i]) {
                		System.out.println("Enter the amount to withdraw: ");
                    int amount = Integer.parseInt(br.readLine());
                    //    atm2.cashout(amount);
                    } else {
                    //    System.out.println("Please type in a correct account number");
                    //	}
                	}
                } catch (Exception e) {
                break;
            }
        }
    }

    public void cashout(Bankkonto BK_t, int withdrawMoney) {
        if (withdrawMoney <= storedMoney ){
        	storedMoney = storedMoney - withdrawMoney;
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