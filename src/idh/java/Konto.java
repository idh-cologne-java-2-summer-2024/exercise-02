package idh.java;

public class Konto {
	
	private int iD;
	private int accountBalance;
	
	public Konto(int iD, int accountBalance)
	{
		this.iD = iD;
		this.accountBalance = accountBalance;
		
	}
	
	public int getID() {
		return this.iD;
	}
	
	public void minus(int minus)
	{
		this.accountBalance -= minus;
	}
	
	public int getAccountBalance() {
		return this.accountBalance;
	}

}
