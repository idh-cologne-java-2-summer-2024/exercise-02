package idh.java;

public class Bankkonto {
	private int kontonummer;
	private int geldAufKonto;
	
	public Bankkonto(int kontonummer, int geldAufKonto) {
		this.kontonummer = kontonummer;
		this.geldAufKonto = geldAufKonto;
	}
	
	public int getKontonummer() {
		return kontonummer;
	}
	public int getGeldAufKonto() {
		return geldAufKonto;
	}
	
	void setKontonummer(int kontonummer) {
		this.kontonummer = kontonummer;
	}
	void setGeldAufKonto(int geldAufKonto) {
		this.geldAufKonto = geldAufKonto;
	}
	
	protected void kontoVerrechnung(int withdrawMoney){
		this.geldAufKonto = geldAufKonto - withdrawMoney;
	}
	
}
