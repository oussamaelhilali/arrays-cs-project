package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    int transactionCount = 0;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double[] transactions = new double[100];

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if (amount > 0) {
            currentBalance += amount;
            transactions[transactionCount] = amount;
            transactionCount++;
            System.out.println(name + " deposited " + amount + "$. New balance: " + currentBalance + "$");
        }
        else {
            System.out.println("Error: Unsuccessful deposit. Amount must be positive.");
        }
    }

    public void withdraw(double amount){
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            transactions[transactionCount] = -amount;
            transactionCount--;
            System.out.println(name + " withdrew " + amount + "$. New balance: " + currentBalance + "$");
        }
        else {
            System.out.println("Error: Unsuccessful withdrawal. Invalid amount or insufficient balance.");
        }
    }

    public void displayTransactions(){
        System.out.println("\nTransaction History for " + name + ":");
        for (int i = 0; i < transactionCount; i++) {
            if (transactions[i] > 0) {
                System.out.println("Deposit: +" + transactions[i] + "$");
            } else {
                System.out.println("Withdrawal: -" + Math.abs(transactions[i]) + "$");
            }
        }
    }

    public void displayBalance(){
        System.out.println("Current balance for " + name + ": " + currentBalance + "$");
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
