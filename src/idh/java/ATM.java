package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
    private int storedMoney = 1200;
    
    Bankkonto[] BK = new Bankkonto[2];
	
    /**
     * Der Constructor um den Konten die Geldbeträge zuzuordnen.
     */
    public ATM() {
    	BK[0] = new Bankkonto(5555, 1000);
        BK[1] = new Bankkonto(1234, 500);
    }
    
    
    /**
     * Launches the ATM
     */
    public static void main(String[] args) {
    	ATM atm = new ATM();
    	atm.run();
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
                System.out.println("Please enter your account number");
                int kontoNrCurrent = Integer.parseInt(br.readLine());
                
                System.out.println("Enter the amount to withdraw: ");   
                int withdrawMoney = Integer.parseInt(br.readLine());
                cashout(kontoNrCurrent, withdrawMoney);
                } 
            catch (Exception e) {
                	System.out.println("Uncorrect Answer, machine shutdown");
                break;
            }
        }
    }

    public void cashout(int kontoNrCurrent, int withdrawMoney) {
        if (withdrawMoney > storedMoney ){
            System.out.println("Sorry, not enough money in the bank.");
            return;
        }
        
        Bankkonto currentKonto = getKonto(kontoNrCurrent);
        if(currentKonto==null) {
        	System.out.println("Uncorrect Answer, machine shutdown");
        	return;
        }
        
        if (withdrawMoney > currentKonto.getGeldAufKonto()) {
        	System.out.println("Sorry, Sie haben nicht genug Geld auf dem Konto");
        	return;
        }
        
        currentKonto.kontoVerrechnung(withdrawMoney);
        System.out.println("Hier bitteschön, nehmen Sie ihr Geld. Ihr neuer Saldo beträgt +"+currentKonto.getGeldAufKonto()+"€");
    }

    protected Bankkonto getKonto (int kontoNrCurrent) {
    	for (int i=0;i<BK.length;i++) {
    		if (BK[i].getKontonummer()==kontoNrCurrent) {
    			return BK[i];
    		}
    	}
    		return null;
    }
   
    
}