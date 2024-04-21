package idh.java;
import java.util.ArrayList;
import java.util.List;



public class Accounts {
	
	//Hier könnte es später eine Logik zur Estellung mehrerer Accounts geben
		
	public List<String> generateAcc() {
		
		List<String> accNumbers = new ArrayList<>();
		
		
		accNumbers.add("123");
		accNumbers.add("234");
		accNumbers.add("345");
		
		return accNumbers;
	}

}
