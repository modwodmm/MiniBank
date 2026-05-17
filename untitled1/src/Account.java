public class Account{
	private String username;
	private int pin;
	private double balance;
	
//Constructor
	public Account(String username, int pin, double balance){
		this.username = username;
		this.pin = pin;
		this.balance = balance;
	}
	
//Verifies pin	
	public boolean checkPin(int enteredPin) {
		return pin == enteredPin;
	}

//Shows balance	
	public double showBalance(){
		return balance;
	}

//Deposits money	
	public boolean deposit(double depositAmount) {
		if(depositAmount < 0 || depositAmount == 0) {
        	System.out.println("You cannot deposit negative amount or nothing!");
        	return false;
        }
		balance += depositAmount;
		return true;
	}

//Withdraws money	
	public boolean withdraw(double withdrawalAmount) {
		if(withdrawalAmount > balance || withdrawalAmount < 0) {
        	System.out.println("You cannot withdraw more than your balance or negative amounts!");
        	return false;
        }
		balance -= withdrawalAmount;
		return true;
	}
	
//Username getter	
	public String getUsername() {
		return this.username;
	}
	
}