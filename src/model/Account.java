package model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountHolder;
    private int type;
    private double balance;
    private List<Transaction> transactionList = new ArrayList<>();


    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAccountHolder() {
        return this.accountHolder;

    }

    public int getType() {
        return this.type;
    }

    public void deposit(double amount) {
        Transaction transaction = new Transaction(2, amount);
        transactionList.add(transaction);
        balance += amount;
    }

    public Boolean withdraw(double amount) {
        if (balance - amount >= -1000) {
            Transaction transaction = new Transaction(1, amount);
            transactionList.add(transaction);
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getFullStatement() {
        return transactionList;
    }

    public List<Transaction> getDepositStatement() {
        List<Transaction> deposits = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            if (transaction.getType() == 2) {
                deposits.add(transaction);
            }
        }
        return deposits;
    }

    public List<Transaction> getWithdrawalStatement() {
        List<Transaction> withdrawals = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            if (transaction.getType() == 1) {
                withdrawals.add(transaction);
            }
        }
        return withdrawals;
    }
}
