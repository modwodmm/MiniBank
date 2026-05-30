import java.io.FileWriter;
import java.math.BigDecimal;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

public class DataManager {

	public DataManager() {
		
	}
	
	public void writer(ArrayList<Account> accounts) {
		
		try(FileWriter writer = new FileWriter("accounts.txt")){
			for(Account acc : accounts) {
				writer.write(acc.getUsername() + "\n");
				writer.write(acc.getPin() + "\n");
				writer.write(acc.showBalance() + "\n");
			}
		}
		catch(IOException e) {
			System.out.println("Error while file writing!!");
		}
	
	}
	
	public void reader(ArrayList<Account> accounts) {
		
		try(BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))){
			String username;
			while((username = reader.readLine()) != null) {
				String pin = reader.readLine();
				String balanceStr = reader.readLine();
				
				if(pin == null || balanceStr == null || username.isEmpty() || pin.isEmpty() || balanceStr.isEmpty()) {
					System.out.println("File corrupted!!");
					break;
				}
				
				BigDecimal balance = new BigDecimal(balanceStr);
				
				Account account = new Account(username, pin, balance);
				accounts.add(account);
			}
		}
		catch(IOException e) {
			System.out.println("No saved file!!");
		}
	}
}
