import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Bank bank = new Bank();
        bank.menu();

        while(bank.isSuccess()) {
        	boolean logout = false;
        	while(!logout) {
        		System.out.println("Choose one of the following:\n1. Balance\n2. Deposit\n3. Withdraw\n4. Log out");
                int choice = scanner.nextInt();
                	
        //Checks based on the choices        	
                switch(choice) {
                	
        //Shows balance        	
                case 1 : 
                	if(bank.getCurrentAccount().showBalance() < 100) {
                    	System.out.println("Your balance is " + bank.getCurrentAccount().showBalance() + ". You are kinda poor tbh");
                    }
                    else {
                    	System.out.println("Your balance is " + bank.getCurrentAccount().showBalance());
                    }
                	break;
                		
        //Deposits the given amount        	
                case 2 :
                	while(true) {
                		System.out.println("Enter the amount to deposit:");
                        double depositAmount = scanner.nextDouble();
                        if(bank.getCurrentAccount().deposit(depositAmount)) {
                        	System.out.println("Your new balance is " + bank.getCurrentAccount().showBalance());
                            break;
                        }
                	}
                	break;

        //Withdraw given amount           	
                case 3 : 
                	while(true) {
                		System.out.println("Enter the amount to withdraw:");
                        double withdrawalAmount = scanner.nextDouble();
                        if(bank.getCurrentAccount().withdraw(withdrawalAmount)) {
                        	System.out.println("Your new balance is " + bank.getCurrentAccount().showBalance());
                            break;
                        }
                	}
                	break;
                    
                case 4 :
                	logout = true;
                	bank.logout();
                	bank.menu();
                	break;
                    	
                default : System.out.println("That is not an option");
                	
                	}
        	}
        	
        }
        
        scanner.close();
        	
    }
}
