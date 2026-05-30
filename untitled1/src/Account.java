import java.math.BigDecimal;

public class Account{
	private String username;
	private String pin;
	private BigDecimal balance;
	
//Constructor
	public Account(String username, String pin, BigDecimal balance){
		this.username = username;
		this.pin = pin;
		this.balance = balance;
	}
	
//Verifies pin	
	public boolean checkPin(String enteredPin) {
		return pin.equals(enteredPin);
	}

//Shows balance	
	public BigDecimal showBalance(){
		return balance;
	}

//Deposits money	
	public boolean deposit(BigDecimal depositAmount) {
		if(depositAmount.signum() <= 0) {
        	System.out.println("You cannot deposit negative amount or nothing!");
        	return false;
        }
		BigDecimal newBalance = balance.add(depositAmount);
		balance = newBalance;
		System.out.println("New balance: " + balance);
		return true;
	}

//Withdraws money	
	public boolean withdraw(BigDecimal withdrawalAmount) {
		if(withdrawalAmount.compareTo(balance) > 0 || withdrawalAmount.signum() <= 0) {
        	System.out.println("You cannot withdraw more than your balance or negative amounts!");
        	return false;
        }
		BigDecimal remainingAmount = balance.subtract(withdrawalAmount);
		balance = remainingAmount;
		System.out.println("New balance: " + balance);
		return true;
	}
	
//Username getter	
	public String getUsername() {
		return this.username;
	}
	
//Pin getter
	public String getPin() {
		return this.pin;
	}
	
//Shows accounts	
	@Override
	public String toString() {
		return "Name: " + this.username + " Balance: " + this.balance;
	}
	
}