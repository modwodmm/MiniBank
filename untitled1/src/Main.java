import java.util.Scanner;
import java.math.BigDecimal;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Bank bank = new Bank();
        bank.menu();
    	boolean logout = false;
    	int choice = 0;

//Outer loop        
        while(bank.isLoggedin()) {

//Inner loop        	
        	while(!logout) {
        	
        		boolean correctChoice = false;
        		
        		while(!correctChoice) {
        			try {
            			System.out.println("Choose one of the following:\n1. Balance\n2. Deposit\n3. Withdraw\n4. Log out");
                        choice = scanner.nextInt();
                        correctChoice = true;
            		}
            		catch(InputMismatchException e) {
            			System.out.println("Please enter the number of choice.");
            			scanner.nextLine();
            		}
        		}
        		
//Checks based on the choices        	
                switch(choice) {
                	
//Shows balance        	
                case 1 : 
                	if(bank.getCurrentAccount().showBalance().compareTo(new BigDecimal("100")) < 0) {
                    	System.out.println("Your balance is " + bank.getCurrentAccount().showBalance() + ". You are kinda poor tbh");
                    }
                    else {
                    	System.out.println("Your balance is " + bank.getCurrentAccount().showBalance());
                    }
                	break;
                		
//Deposits the given amount        	
                case 2 :
                	while(true) {
                        BigDecimal depositAmount = new BigDecimal("0");
                        boolean correctDeposit = false;
                        
                        while(!correctDeposit) {
                        	
                        	try {
                        		System.out.println("Enter the amount to deposit:");
                        		depositAmount = scanner.nextBigDecimal();
                        		correctDeposit = true;
                        	}
                        	catch(InputMismatchException e) {
                        		System.out.println("Please enter an actual amount to deopist.");
                        		scanner.nextLine();
                        	}

                        }
                        
                        if(bank.getCurrentAccount().deposit(depositAmount)) {                        	
                            break;
                        }
                	}
                	break;

//Withdraw given amount           	
                case 3 : 
                	while(true) {
                		
                		boolean correctWithdrawal = false;
                        BigDecimal withdrawalAmount = new BigDecimal("0");
                        
                        while(!correctWithdrawal) {
                        	try {
                        		System.out.println("Enter the amount to withdraw:");
                        		withdrawalAmount = scanner.nextBigDecimal();
                        		correctWithdrawal = true;
                        	}
                        	catch(InputMismatchException e){
                        		System.out.println("Please enter an actual amount to withdraw.");
                        		scanner.nextLine();
                        	}
                        	
                        }
                        if(bank.getCurrentAccount().withdraw(withdrawalAmount)) {
                            break;
                        }
                	}
                	break;
                	
//Logout                    
                case 4 :
                	logout = true;
                	bank.logout();
                	bank.menu();
                	logout = false;
                	break;
                    	
                default : System.out.println("That is not an option");
                	
                	}
        	}
        	
        }
        
        scanner.close();
        	
    }
}
