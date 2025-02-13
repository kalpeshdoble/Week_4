package org.example.OtherQuestions;


import java.util.*;

public class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>();
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    // Add a new account
    public void addAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        sortedAccounts.put(initialBalance, accountNumber);
    }

    // Deposit money into an account
    public void deposit(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found.");
            return;
        }
        double newBalance = accounts.get(accountNumber) + amount;
        sortedAccounts.remove(accounts.get(accountNumber)); // Remove old balance
        accounts.put(accountNumber, newBalance);
        sortedAccounts.put(newBalance, accountNumber);
        System.out.println("Deposited " + amount + " to account " + accountNumber);
    }

    // Request a withdrawal
    public void requestWithdrawal(int accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found.");
            return;
        }
        withdrawalQueue.offer(accountNumber);
        System.out.println("Withdrawal request added for account " + accountNumber);
    }

    // Process the next withdrawal request
    public void processWithdrawal(double amount) {
        if (withdrawalQueue.isEmpty()) {
            System.out.println("No withdrawal requests to process.");
            return;
        }
        int accountNumber = withdrawalQueue.poll();
        if (accounts.get(accountNumber) >= amount) {
            double newBalance = accounts.get(accountNumber) - amount;
            sortedAccounts.remove(accounts.get(accountNumber)); // Remove old balance
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber);
            System.out.println("Processed withdrawal of " + amount + " from account " + accountNumber);
        } else {
            System.out.println("Insufficient funds in account " + accountNumber);
        }
    }

    // Display all accounts sorted by balance
    public void displayAccountsSortedByBalance() {
        System.out.println("\nAccounts Sorted by Balance:");
        sortedAccounts.forEach((balance, account) ->
                System.out.println("Account " + account + " -> Balance: " + balance)
        );
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Adding customer accounts
        bank.addAccount(1001, 5000);
        bank.addAccount(1002, 3000);
        bank.addAccount(1003, 7000);
        bank.addAccount(1004, 4000);

        // Depositing money
        bank.deposit(1001, 2000);
        bank.deposit(1003, 1000);

        // Requesting withdrawals
        bank.requestWithdrawal(1002);
        bank.requestWithdrawal(1004);

        // Processing withdrawals
        bank.processWithdrawal(1500);
        bank.processWithdrawal(2000);

        // Displaying accounts sorted by balance
        bank.displayAccountsSortedByBalance();
    }
}

