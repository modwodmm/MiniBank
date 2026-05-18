import java.util.Scanner;
import java.util.ArrayList;

public class Bank {

	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Account> accounts = new ArrayList<>();
	
	private Account currentAccount;
	private boolean success = false;
	
//Menu	
	public void menu() {
		while(true) {
			if(accounts.size() == 0) {
				System.out.println("There are no accounts.\n1. Create new account");
			}
			else {
				System.out.println("1. Create new account\n2. Login\n3. Exit");
			}
			int choice = scanner.nextInt();
			switch(choice) {
			case 1 :
				createAccount();
				if(success) {
					return;
				}
				break;
			case 2 :
				login();
				if(success) {
					return;
				}
				break;
			case 3 :
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
			
			System.out.println("Enter the username:");
			String name = scanner.next();
			
			for(int i = 0; i < accounts.size(); i++) {
				if(accounts.get(i).getUsername().equalsIgnoreCase(name)) {
					exists = true;
					break;
				}
			}
			if(exists) {
				System.out.println("Account already exists!!");
			}
			else {
				
				System.out.println("Enter the pin:");
				int pin = scanner.nextInt();
				
				double balance;
				
				while(true) {
					System.out.println("Enter the starting amount:");
					balance = scanner.nextDouble();
					if(balance > 0 && balance <= 100) {
						break;
					}
					System.out.println("Starting balance can't be negative or above 100");
				}
				accounts.add(new Account(name, pin, balance));
				System.out.println("New account has been added.");
				success = true;
			}
		}
	}
	
//Login	
	public void login() {
		System.out.println("Enter your username:");
		String target = scanner.next();
		
		boolean found = false;
		
		for(int i = 0; i < accounts.size(); i++) {
			
			if(accounts.get(i).getUsername().equalsIgnoreCase(target)) {
				found = true;
				int tries = 0;
				
				while(tries < 3) {
					System.out.println("Enter your pin:");
					int enteredPin = scanner.nextInt();
					if(accounts.get(i).checkPin(enteredPin)) {
						System.out.println("Logged in successfully!");
						currentAccount = accounts.get(i);
						success = true;
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
		success = false;
		currentAccount = null;
	}
	
//Success getter	
	public boolean isSuccess() {
		return success;
	}
	
//Current Account getter	
	public Account getCurrentAccount() {
		return currentAccount;
	}

}
