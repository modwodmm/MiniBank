import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Account account = new Account("modwodmm", 9898, 10);
        
        System.out.println("Enter your pin:");
        
//Checks pin and gives choices        
        int enteredPin = scanner.nextInt();
        if(account.checkPin(enteredPin)) {
        	System.out.println("Choose one of the following:\n" + "1.Balance\n" + "2. Deposit\n" + "3. Withdraw");
        	int choice = scanner.nextInt();    
 
//For showing balance        	
        	if(choice == 1) {
        		if(account.showBalance() < 100) {
        			System.out.println("$" + account.showBalance() + "\nKinda poor tbh");
        		}
        		else {
        			System.out.println("$" + account.showBalance());
        		}
        			
        	}
  
//For depositing money        	
        	if(choice == 2) {
        		System.out.println("Enter the amount:");
        		double amount = scanner.nextDouble();
        		if (amount <= 0) {
        		    System.out.println("Invalid amount");
        		} else {
        		    account.deposit(amount);
        		    System.out.println("New balance: $" + account.showBalance());
        		}
        	}
  
//For withdrawing money        	
        	if(choice == 3) {
        		System.out.println("Enter the amount:");
        		double amount = scanner.nextDouble();
        		if (amount <= 0 || amount > account.showBalance()) {
        		    System.out.println("Invalid withdrawal");
        		} else {
        		    account.withdraw(amount);
        		    System.out.println("New balance: $" + account.showBalance());
        		}
        	}
        }
        
        else {
        	System.out.println("Wrong pin!!");
        }
       
    }
}
