package Assignment1;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500); // Create a bank account with initial balance
        Calendar date = Calendar.getInstance();    // Transaction date

        // Withdrawal without sufficient funds
        WithdrawalTransaction withdrawal1 = new WithdrawalTransaction(1000, date, "TXN001");
        try {
            withdrawal1.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        // Partial withdrawal
        WithdrawalTransaction withdrawal2 = new WithdrawalTransaction(700, date, "TXN002");
        withdrawal2.apply(account, true);
    }
}
