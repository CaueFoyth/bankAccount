package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private int type;
    private double amount;
    private Date date;

    public Transaction(int type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    public int getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // Define o formato
        return formatter.format(date);
    }

    public String toString() {
        String transactionType = (this.type == 1) ? "Saque" : "Depósito";
        return "Transação: " + transactionType + " | Valor: R$" + this.amount + " | Data: " + this.getDate();
    }
}
