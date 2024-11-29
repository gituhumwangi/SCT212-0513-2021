package Assignment1;

import java.util.Calendar;

class WithdrawalTransaction extends BaseTransaction {
    private double amountNotWithdrawn;

    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
        this.amountNotWithdrawn = 0; // Initialize amount not withdrawn
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal: " + amount);
        }
        ba.withdraw(amount);
        System.out.println("Withdrawal successful. Amount: " + amount);
    }

    // Overloaded apply() method for partial withdrawals
    public void apply(BankAccount ba, boolean allowPartialWithdrawal) {
        try {
            if (ba.getBalance() <= 0) {
                throw new InsufficientFundsException("Balance is zero. Withdrawal not possible.");
            } else if (allowPartialWithdrawal && ba.getBalance() < amount) {
                amountNotWithdrawn = amount - ba.getBalance();
                double withdrawnAmount = ba.withdrawAll();
                System.out.println("Partial withdrawal performed. Amount withdrawn: " + withdrawnAmount);
                System.out.println("Amount not withdrawn: " + amountNotWithdrawn);
            } else {
                apply(ba); // Call the regular apply method
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed. Current balance: " + ba.getBalance());
        }
    }
}
