package Assignment1;

import java.util.Calendar;

public abstract class BaseTransaction implements TransactionInterface {
    protected double amount; // Accessible to derived classes
    protected Calendar date;
    protected String transactionID;

    public BaseTransaction(double amount, Calendar date, String transactionID) {
        this.amount = amount;
        this.date = date;
        this.transactionID = transactionID;
    }

    public double getAmount() {
        return amount;
    }

    public Calendar getDate() {
        return date;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public abstract void apply(BankAccount ba) throws InsufficientFundsException;
}
