package Lecture1_adt;

import java.util.Calendar;

/**
 * There is still Exposure seen in Transaction2 I that if we make next payment the date of first payment is also altered
 * This Class Transaction3:Adds Code to correct this exposure:
 * Intentional review of any methods that receive produces (returns)
 *              If produces interface of a method deals with objects or any reference types,
 *              there is need to perform defensive copying to enhance Invariant preservation
 */
public class Transaction3 {
    private final int amount;
    private final Calendar date;

    public Transaction3(int amount, Calendar date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.amount = amount;
        this.date = (Calendar) date.clone();
    }
    

    public int getAmount() {
        return amount; // Because we are dealing with Value types we need not worry about what we return
    }

    public Calendar getDate() {
//        return date;    // Because we are dealing with Reference types we need to judiciously copy what our getters return
        return (Calendar) date.clone(); // Defensive copying or Judicious Copying
    }
}
