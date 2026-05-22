public class Account{
	private String username;
	private String pin;
	private double balance;
	
//Constructor
	public Account(String username, String pin, double balance){
		this.username = username;
		this.pin = pin;
		this.balance = balance;
	}
	
//Verifies pin	
	public boolean checkPin(String enteredPin) {
		return pin.equals(enteredPin);
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
	
//Pin getter
	public String getPin() {
		return this.pin;
	}
	
//Balance getter
	public double getBalance() {
		return this.balance;
	}
	
//Shows accounts	
	@Override
	public String toString() {
		return "Name: " + this.username + " Balance: " + this.balance;
	}
	
}