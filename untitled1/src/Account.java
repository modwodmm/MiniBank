import java.util.Scanner;

public class Account {
    Scanner scanner = new Scanner(System.in);
    private String username;
    private int pin;
    private double balance;

    public void makeAccount(String username, int pin, double balance){
        this.username = username;
        this.pin = pin;
        this.balance = balance;
    }

    public void showBalance(){
        System.out.println("Enter your pin:");
        int enteredPin = scanner.nextInt();
        if(enteredPin == pin){
            if(balance <= 100){
                System.out.println("Your balance is: " + balance);
                System.out.println("You're kinda poor tbh");
            }
            else{
                System.out.println("Your balance is: " + balance);
            }
        }
        else{
            System.out.println("You entered the wrong pin!!");
        }
    }

    public void deposit(){
        System.out.println("Enter your pin:");
        int enteredPin1 = scanner.nextInt();
        if(enteredPin1 == pin){
            System.out.println("Enter the amount to deposit:");
            double amountDeposited = scanner.nextDouble();
            if(amountDeposited <= 0){
                System.out.println("You can't deposit negative values or nothing!");
            }
            else{
                balance += amountDeposited;
                System.out.println("Your new balance is: " + balance);
            }
        }
        else{
            System.out.println("You entered the wrong pin!!");
        }
    }
    public void withdraw() {
        System.out.println("Enter your pin:");
        int enteredPin2 = scanner.nextInt();
        if(enteredPin2 == pin){
            System.out.println("Enter the amount to withdraw:");
            double amountWithdrawn = scanner.nextDouble();
            if(balance < amountWithdrawn){
                System.out.println("You don't have enough funds!");
            }
            else{
                balance -= amountWithdrawn;
                System.out.println("Your new balance is: " + balance);
            }
        }
        else{
            System.out.println("You entered the wrong pin!!");
        }
    }
}
