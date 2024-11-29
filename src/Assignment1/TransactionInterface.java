package Assignment1;
import java.util.Calendar;

public interface TransactionInterface {

    //Method to get the transaction amount 
    double getAmount();

    //Method to get transaction date 
    Calendar getDate ();

    //Method to get a unique identifier for the transaction 
    String getTransactionID();
    
} 
    
    

