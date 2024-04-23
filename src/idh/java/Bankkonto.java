package idh.java;

public class Bankkonto {
	private String kontonummer;
    private String kontoinhaber;
    private double kontostand;


    public Bankkonto(String kontonummer, String kontoinhaber) {
        this.kontonummer = kontonummer;
        this.kontoinhaber = kontoinhaber;
        this.kontostand = 0.0;
    }

    public String getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(String nummer) {
        this.kontonummer = nummer;
    }

    public String getKontoinhaber() {
        return kontoinhaber;
    }

    public void setKontoinhaber(String name) {
        this.kontoinhaber = name;
    }
    
    public double getKontostand () {
    	return kontostand;
    }

    public void setKontostand(double zahl) {
        this.kontostand = zahl;
    }
}
