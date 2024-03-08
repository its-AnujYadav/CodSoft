// TASK 3 - ATM Machine 

import java.util.Scanner;

public class AtmMachine {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        BankAccount userAcc = new BankAccount(1000.00);

        System.out.println("Welcome to the ATM Machine!");
        displayOptions();

        int option;
        do {
            System.out.print("\nEnter your choice (1-4): ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> handleTransaction(userAcc, "withdraw", "Enter the amount to withdraw: Rs.");
                case 2 -> handleTransaction(userAcc, "deposit", "Enter the amount to deposit: Rs.");
                case 3 -> System.out.printf("Current Balance: Rs.%.2f%n", userAcc.getBalance());
                case 4 -> System.out.println("Thank you for using the ATM. Goodbye!");
                default -> System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (option != 4);

    }

    private static void displayOptions() {
        System.out.println("1. Withdraw\n2. Deposit\n3. Check Balance\n4. Exit");
    }

    private static void handleTransaction(BankAccount account, String userInput, String message) {
        System.out.print(message);
        double amount = sc.nextDouble();
    
        if (("withdraw".equals(userInput) && account.withdraw(amount)) || ("deposit".equals(userInput) && amount > 0)) {
            if ("withdraw".equals(userInput)) {
                System.out.printf("%s successful. New balance: Rs.%.2f%n", capitalize(userInput), account.getBalance());
            } 
            else {
                account.deposit(amount);
                System.out.printf("%s successful. New balance: Rs.%.2f%n", capitalize(userInput), account.getBalance());
            }
        }   
        
        else {
            System.out.println("withdraw".equals(userInput) ? "Insufficient funds. Withdrawal failed."
                    : "Invalid amount. Please enter a positive value.");
        }
    }
        

    private static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
