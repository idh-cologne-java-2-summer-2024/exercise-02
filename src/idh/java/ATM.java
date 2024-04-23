package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;




public class ATM {
	
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	int kontostand = 1337; // ist jetzt initiale Wert für Neukunden €
	int moneyInAtm = 100000;// initialer Menge an Geld im Automaten €
	int maxPinTries = 3;
	int[][]kundenKontos = new int[0][0]; 
	/*
	 * kundenKontos[0][0] = erste Kundennummer,  kundenKontos[0][1] =  PIN der ersten Kundenummer, kundenKontos[0][2] = Kontostand,  kundenKontos[0][3] = Status (0 = gesperrt, 1 = aktiv)
	 * kundenKontos[1][0] = zweite Kundennummer, "", ""
	 * ""
	*/
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				boolean flagKundennummerIsInKundenKontos = false;
				System.out.println("Enter your account number: ");
				int enteredKundennummer = Integer.parseInt(br.readLine());
				for (int i = 0; i < kundenKontos.length; i++)
				{
					if(flagKundennummerIsInKundenKontos) // eingegeben Acoountnummer bereits gefunden, Suche beenden.
							break;
					
					if (kundenKontos[i][0] == enteredKundennummer) // Es existiert bereits ein Konto mit der eingegebenen Nummer
					{
						flagKundennummerIsInKundenKontos = true;
						if(0 == kundenKontos[i][3]) { // gesperrtes Konto?
							System.out.println("The account is blocked. Please contact the support to reactivate."); break;
							}
						System.out.println("Enter your PIN: ");
						if(kundenKontos[i][1] == Integer.parseInt(br.readLine())) // Die hinterlegte PIN abfragen
						{
							System.out.println("Enter the amount to withdraw: ");
							int amount = Integer.parseInt(br.readLine());
							
							cashout(amount, i);								
						}
						else
						{
							System.out.println("Wrong PIN. Please try again. You have " + (maxPinTries - 1) + " tries left." );
							for(int j = 1; j < maxPinTries; j++) // wenn man in diesen else abschnitt kommt hat man bereits einmal die PIN falsch eingetippt
							{
								System.out.println("Enter your PIN: ");
								int reenteredPin = Integer.parseInt(br.readLine());
								if(kundenKontos[i][1] == reenteredPin)
								{
									System.out.println("Enter the amount to withdraw: ");
									int amount = Integer.parseInt(br.readLine());
									
									cashout(amount, i);	
									break;
								}
								else if (kundenKontos[i][1] != reenteredPin && 0 ==  maxPinTries - j - 1)
								{
									System.out.println("Wrong PIN. The account is blocked. Please contact the support to reactivate.");
									kundenKontos[i][3] = 0;
									break;
								}
								else
									System.out.println("Wrong PIN pls try again. You have " + (maxPinTries - j - 1) + " tries left." );
								
							}
						}
							
					}
				}
				if(!flagKundennummerIsInKundenKontos)
				{
					int newKundennummer = enteredKundennummer;
					System.out.println("Enter your PIN for your new account: ");
					int newPin =  Integer.parseInt(br.readLine());
					int nIndexNewAccount = createNewAccount(newKundennummer, newPin);
					
				}
			}
			catch (Exception e) {
				System.out.println("Error!!! Please reboot ATM.");
				break;
			}
		}
	}
	public int createNewAccount(int newKundennummer, int newPin)
	{
		int ret = -1;
		int newIndex = -1;
		
		if(0 == kundenKontos.length)
			newIndex = kundenKontos.length;
		else
			newIndex = kundenKontos.length + 1;
		
		int [][]copyAppendArray = new int[newIndex + 1][4];

		for(int z = 0; z < kundenKontos.length; z++)
			copyAppendArray[z] = kundenKontos[z];

		copyAppendArray[newIndex][0] = newKundennummer;
		copyAppendArray[newIndex][1] = newPin;
		copyAppendArray[newIndex][2] = kontostand;
		copyAppendArray[newIndex][3] = 1; // 1 = aktiv; 0 = gesperrt;
		kundenKontos = copyAppendArray;
		ret = newIndex;
		System.out.println("Congratulation, you will start with: " + kontostand + "€!");
		return ret;
	}
	
	public void cashout(int amount, int nIndexKundenKontos) {
		if(0 == kundenKontos[nIndexKundenKontos][3]) { // gesperrtes Konto
			System.out.println("The account is blocked. Please contact the support to reactivate."); return;
			}
		if(kundenKontos[nIndexKundenKontos][2] - amount < 0){// Noch genug Geld?
			System.out.println("Sorry, yout do not have enough money in the bank.");
			return;
		}
		if(moneyInAtm - amount < 0) {
			System.out.println("Sorry, yout do not have enough money in the bank.");
			return;
		}
		
		kundenKontos[nIndexKundenKontos][2] = kundenKontos[nIndexKundenKontos][2] - amount;
		moneyInAtm = moneyInAtm - amount;
		System.out.println("Ok, here is your money, enjoy!");
	};
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		
		atm.run();
	};
};