package task.bankaccount;

import java.util.*;

public final class BankAccount implements AccountOperation{

    private double balance;
    private final List<Transaction> transactions;

    public BankAccount() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    @Override
    public double getAccountBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void transferFunds(double amount) throws AccountOperationException {
        if(balance - amount < 0)
            throw new AccountOperationException("Error! Not enough money in the bank account");
        else
            balance -= amount;
    }

    @Override
    public void makeDeposit(double amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
