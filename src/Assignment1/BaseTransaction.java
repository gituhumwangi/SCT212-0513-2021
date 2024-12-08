package Assignment1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BaseTransaction implements TransactionInterface {
    protected double amount; // Accessible to derived classes
    protected Calendar date;
    protected String transactionID;

    public BaseTransaction(double amount, Calendar date, String transactionID) {
        this.amount = amount;
        this.date = (Calendar) date.clone();
        this.transactionID = transactionID;
    }

    public double getAmount() {
        return amount;
    }

    public Calendar getDate() {
        return (Calendar) date.clone();
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void printTransactionDetails() {
        
        SimpleDateFormat dateFormart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormart.format(date.getTime());

        System.out.println("Transaction Details:");
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + formattedDate);
    }

    public  void apply(BankAccount ba) throws InsufficientFundsException {
        System.out.println("Applying a generic transaction to the account");
    }
}
