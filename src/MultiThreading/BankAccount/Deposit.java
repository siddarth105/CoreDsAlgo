package MultiThreading.BankAccount;

public class Deposit extends Thread {

    private SingleDwAccount sharedSingleDwAccount;

    private int amount;

    public Deposit(SingleDwAccount sharedSingleDwAccount, int amount) {
        this.sharedSingleDwAccount = sharedSingleDwAccount;
        this.amount = amount;
    }

    public void run () {
        sharedSingleDwAccount.deposit(amount);
    }
}
