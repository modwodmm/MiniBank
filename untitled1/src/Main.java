import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
//Takes user info and creates account        
        System.out.println("Enter the username: ");
        String name = scanner.next();
        
        System.out.println("Enter the pin: ");
        int pin = scanner.nextInt();
        
        System.out.println("Enter the starting amount: ");
        double amount = scanner.nextDouble();
        
        Account account = new Account(name, pin, amount);
        
        System.out.println("Enter your pin:");
        
//Checks pin and gives choices        
        int enteredPin = scanner.nextInt();
        if(account.checkPin(enteredPin)) {
        	System.out.println("Choose one of the following:\n" + "- Balance\n" + "- Deposit\n" + "- Withdraw");
        	String choice = scanner.next().toLowerCase();
        	
//Checks based on the choices        	
        	switch(choice) {
        	
//Shows balance        	
        	case "balance" : 
        		if(account.showBalance() < 100) {
            		System.out.println("Your balance is " + account.showBalance() + ". You are kinda poor tbh");
            	}
            	else {
            		System.out.println("Your balance is " + account.showBalance());
            	}
        		break;
        		
//Deposits the given amount        	
        	case "deposit" : 
        		System.out.println("Enter the amount to deposit:");
            	double depositAmount = scanner.nextDouble();
            	if(depositAmount < 0 || depositAmount == 0) {
            		System.out.println("You cannot deposit negative amount or nothing!");
            	}
            	else {
            		System.out.println("Your new balance is " + account.deposit(depositAmount));
            	}
            	break;
            	
//Withdraw given amoun            	
        	case "withdraw" : 
        		System.out.println("Enter the amount to withdraw:");
            	double withdrawalAmount = scanner.nextDouble();
            	if(withdrawalAmount > account.showBalance() || withdrawalAmount < 0) {
            		System.out.println("You cannot withdraw more than your balance or negative amounts!");
            	}
            	else {
            		System.out.println("Your new balance is " + account.withdraw(withdrawalAmount));
            	}
            	break;
            	
        	default : System.out.println("That is not an option");
        	
        	}
 
        }
        else {
        	System.out.println("Wrong pin!!!");
        }
        
        scanner.close();
        	
    }
}
