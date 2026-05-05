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
	public double deposit(double depositAmount) {
		return balance += depositAmount;
	}

//Withdraws money	
	public double withdraw(double withdrawalAmount) {
		return balance -= withdrawalAmount;
	}
	
}