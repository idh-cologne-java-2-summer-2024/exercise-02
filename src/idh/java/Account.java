package idh.java;

import java.util.Random;

public class Account {
	
	int nr;
	int balance;
	
	public Account(int nr) {
		Random random = new Random();
		this.balance = random.nextInt(1000);
		this.nr = nr;
	}
	
	public int getID() {
		return this.nr;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public void withdraw(int amount) {
		this.balance = this.balance - amount;
	}

}
