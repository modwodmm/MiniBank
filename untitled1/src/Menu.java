import java.util.Scanner;
import java.math.BigDecimal;

public class Menu {
	
	Scanner scanner = new Scanner(System.in);
	Bank bank = new Bank(scanner);

	public Menu() {
		
	}
	
	public void menu() { 
		while(bank.isLoggedin()) {
			
			int choice = 0;
			boolean correctChoice = false;
			while(!correctChoice) {
				try {
					System.out.println("Choose one of the following:\n1. Show balance\n2. Deposit\n3. Withdraw\n4. Log out");
					choice = Integer.parseInt(scanner.nextLine());
					correctChoice = true;
				}
				catch(NumberFormatException e) {
					System.out.println("Please enter a valid choice");
				}
			}
			switch(choice){
			case 1:
				if(bank.getCurrentAccount().showBalance().compareTo(new BigDecimal("100")) < 0) {
					System.out.println("Balance: " + bank.getCurrentAccount().showBalance() + "\nYou kinda poor tbh!");
				}
				else {
					System.out.println("Balance: " + bank.getCurrentAccount().showBalance());
				}
				break;
			case 2:
				while(true) {
                    BigDecimal depositAmount = new BigDecimal("0");
                    boolean correctDeposit = false;
                    
                    while(!correctDeposit) {
                    	
                    	try {
                    		System.out.println("Enter the amount to deposit:");
                    		depositAmount = new BigDecimal(scanner.nextLine().trim());
                    		correctDeposit = true;
                    	}
                    	catch(NumberFormatException e) {
                    		System.out.println("Please enter an actual amount to deposit.");
                    	}

                    }
                    
                    if(bank.getCurrentAccount().deposit(depositAmount)) {                        	
                        break;
                    }
            	}
				
				break;
			case 3:
				while(true) {
            		
            		boolean correctWithdrawal = false;
                    BigDecimal withdrawalAmount = new BigDecimal("0");
                    
                    while(!correctWithdrawal) {
                    	try {
                    		System.out.println("Enter the amount to withdraw:");
                    		withdrawalAmount = new BigDecimal(scanner.nextLine().trim());
                    		correctWithdrawal = true;
                    	}
                    	catch(NumberFormatException e){
                    		System.out.println("Please enter an actual amount to withdraw.");
                    	}
                    	
                    }
                    if(bank.getCurrentAccount().withdraw(withdrawalAmount)) {
                        break;
                    }
            	}
				break;
			case 4:
				bank.logout();
				break;
			}
			
		}
	}
	
	public void start() {
		while(true) {
			bank.menu();
			if(!bank.isLoggedin()) {
				break;
			}
			menu();
		}
	}
	
}
