package Assignment1;
import java.util.Calendar;

class DepositTransaction extends BaseTransaction {
    public DepositTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);

        // Validate that the deposit amount is positive
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    @Override
    public void apply(BankAccount ba) {
        ba.deposit(amount);
        System.out.println("Deposit successful: " + amount + ". Updated balance: " + ba.getBalance());
    }

    // @Override
    // public boolean reverse(BankAccount ba) {
    //     System.out.println("Deposits are irreversible. Transaction ID: " + transactionID);
    //     return false;
    // }
}
