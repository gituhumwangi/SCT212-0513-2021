package Assignment1;
import java.util.Calendar;

class DepositTransaction extends BaseTransaction {
    public DepositTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);

        // Validate that the deposit amount is positive
        if (amount <= 0) {
            throw new IllegalArgumentException("Insufficient amount for deposit into your account.");
        }
    }

    @Override
    public void apply(BankAccount ba) {
        ba.deposit(amount);
        System.out.println("Deposit successful: " + amount + ". Updated balance: " + ba.getBalance());
    }

    @Override
    public void printTransactionDetails() {
        super.printTransactionDetails(); // Call the base class method
        System.out.println("Transaction Type: Deposit");
    }

}
