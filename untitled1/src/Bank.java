import java.util.Scanner;

public class Bank {

	private Scanner scanner = new Scanner(System.in);
	private Account[] accounts = new Account[5];
	
	private int count = 0;
	private Account currentAccount;
	private boolean success = false;
	
//Menu	
	public void menu() {
		while(true) {
			if(count == 0) {
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
		
		if(count >= accounts.length) {
			
			System.out.println("You hit the account limit!");
			
		}
		else {
			
			System.out.println("Enter the username:");
			String name = scanner.next();
			
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
			
			for(int i = 0; i < accounts.length; i++) {
				if(accounts[i] == null) {
					accounts[i] = new Account(name, pin, balance);
					currentAccount = accounts[i];
					break;
				}
			}
			count++;
			success = true;
		}
	}
	
//Login	
	public void login() {
		System.out.println("Enter your username:");
		String target = scanner.next();
		
		boolean found = false;
		
		for(int i = 0; i < accounts.length; i++) {
			
			if(accounts[i] != null && accounts[i].getUsername().equalsIgnoreCase(target)) {
				found = true;
				int tries = 0;
				
				while(tries < 3) {
					System.out.println("Enter your pin:");
					int enteredPin = scanner.nextInt();
					if(accounts[i].checkPin(enteredPin)) {
						System.out.println("Logged in successfully!");
						currentAccount = accounts[i];
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
