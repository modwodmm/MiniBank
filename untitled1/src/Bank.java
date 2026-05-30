import java.util.Scanner;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Bank {

	private Scanner scanner;
	private ArrayList<Account> accounts = new ArrayList<>();
	DataManager manager = new DataManager();
	
	private Account currentAccount;
	private boolean loggedin = false;
	
	public Bank(Scanner scanner) {
		this.scanner = scanner;
	}
	
//Menu	
	public void menu() {
		
		accounts.clear();
		manager.reader(accounts);
		
		while(true) {
			
			int choice = 0;
			boolean correctChoice = false;
			
			while(!correctChoice) {
				try {
					
					if(accounts.size() == 0) {
						System.out.println("There are no accounts.\n1. Create new account");
					}
					else {
						System.out.println("1. Create new account\n2. Login\n3. Show accounts\n4. Exit");
					}
					choice = Integer.parseInt(scanner.nextLine());
					
					correctChoice = true;
					
				}
				catch(NumberFormatException e) {
					
					System.out.println("Please enter the number of the choice.");
					
				}
			}
			
			switch(choice) {
			case 1 :
				createAccount();
				break;
			case 2 :
				login();
				if(loggedin) {
					return;
				}
				break;
			case 3 :
				for(int i = 0; i < accounts.size(); i++)
					System.out.println(accounts.get(i));
				break;
			case 4:
				System.out.println("You exited the program!");
				return;
			}
		}
		
	}
	
//Creates account	
	public void createAccount() {
		
		if(accounts.size() >= 5) {
			
			System.out.println("You hit the account limit!");
			
		}
		else {
			
			boolean exists = false;
			String name = "";
			String pin = "";
			BigDecimal balance = new BigDecimal("0");
	        
			System.out.println("Enter the username:");
			name = scanner.nextLine();
			
			for(int i = 0; i < accounts.size(); i++) {
				if(accounts.get(i).getUsername().trim().equalsIgnoreCase(name)) {
					exists = true;
					break;
				}
			}
			if(exists) {
				System.out.println("Account already exists!!");
			}
			else {
				
				System.out.println("Enter the pin:");
				pin = scanner.nextLine();
				
				while(true) {
					
					boolean correctBalance = false;
					
					while(!correctBalance) {
						try {
							System.out.println("Enter the starting amount:");
							balance = new BigDecimal(scanner.nextLine().trim());
							correctBalance = true;
						}
						catch(NumberFormatException e) {
							System.out.println("Please enter the actual amount.");
						}
					}
					
					if(balance.signum() > 0 && balance.compareTo(new BigDecimal("100")) < 0) {
						break;
					}
					System.out.println("Starting balance can be between 1 and 100");
				}
				
				accounts.add(new Account(name, pin, balance));
				manager.writer(accounts);
				System.out.println("New account has been added.");
			}
		}
	}
	
//Login	
	public void login() {
		System.out.println("Enter your username:");
		String target = scanner.nextLine();
		
		boolean found = false;
		int tries = 0;
		String enteredPin = "";
		
		for(int i = 0; i < accounts.size(); i++) {
			
			if(accounts.get(i).getUsername().equalsIgnoreCase(target)) {
				found = true;
				
				while(tries < 3) {
					System.out.println("Enter your pin:");
					enteredPin = scanner.nextLine();
					if(accounts.get(i).checkPin(enteredPin)) {
						System.out.println("Logged in successfully!");
						currentAccount = accounts.get(i);
						loggedin = true;
						return;
					}
					tries++;
					
					
				}
				System.out.println("You ran out of tries");
				return;
			}
			
		}
		if(!found) {
			System.out.println("No such user exists.");
		}
	}
	
//Logout	
	public void logout() {
		loggedin = false;
		currentAccount = null;
	}
	
//Success getter	
	public boolean isLoggedin() {
		return loggedin;
	}
	
//Current Account getter	
	public Account getCurrentAccount() {
		return currentAccount;
	}

}
