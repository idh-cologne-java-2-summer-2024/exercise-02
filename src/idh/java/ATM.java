package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//i changed something 
public class ATM {
	int accountBalance = 300;
	
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run(User[] u) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			try {
				System.out.println("Enter your name.");
				String input = br.readLine();
				
					if(input.compareToIgnoreCase(u[0].name) == 0 || input.compareToIgnoreCase(u[1].name) == 0) {
						System.out.print("Enter the amount to withdraw: ");
						int amount = Integer.parseInt(br.readLine());
						cashout(amount);
				}else {
					System.out.println("Name not found");
				}
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount) {
		if (amount <= accountBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
			return;
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		User[] users = new User[20];
		User u1 = new User(1, 50, "Max Muster");
		User u2 = new User(2, 100, "Timmy Turner");
		users[0] = u1;
		users[1] = u2;
//		System.out.println(users[0].name);
		atm.run(users);
	};

}
