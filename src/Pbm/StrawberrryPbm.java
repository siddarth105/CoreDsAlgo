package Pbm;

public class StrawberrryPbm {

    public static void main(String[] args) {
    }

    /*Aleks is a strawberry merchant, selling strawberries at a price of 5 EUR for 1 kilogram. Each customer can only buy 1 KG of strawberries, but can pay with 5 EUR, 10 EUR or 20 EUR bills. When a customer is paying with a bill of more than 5 EUR, Aleks needs to return correct change.
    Given an array of customers represented with the bills with which they are paying, your function should return true if Aleks can serve each customer in the queue (either the customer is paying the exact price or Aleks will need to return the correct change), or false otherwise.

    Example 1: input array is: [5, 10, 5, 20]; should return true because:
        - First customer pays with 5 EUR bill, gets no change
        - Second customer pays with 10 EUR bill, gets 5 EUR change
        - Third customer pays with 5 EUR bill, gets no change
        - Fourth customer pays with 20 EUR bill, gets 15 EUR change (10 EUR + 5 EUR bills)


    Example 2: input array is: [5, 20, 5, 20]; should return false because:
        - First customer pays with 5 EUR bill, gets no change
        - Second customer pays with 20 EUR bill, should get 15 EUR change, but Aleks only has one 5 EUR bill. At this point Aleks cannot return the change and our function should return false.


    Assumption : Merchant starts without money


    */
}
