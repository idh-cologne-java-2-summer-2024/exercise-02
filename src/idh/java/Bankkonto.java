package idh.java;

public class Bankkonto {

	
	int guthaben=0;
	int kontonummer =0;
	String kontoinhaber = "";
	
	public Bankkonto(int kontonummer, String kontoinhaber, int guthaben) {
		// TODO Auto-generated constructor stub
		this.kontonummer = kontonummer;
		this.kontoinhaber = kontoinhaber;
		this.guthaben = guthaben;
	}
}
