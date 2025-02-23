package MultiThreading.BankAccount;

public class Withdraw extends Thread {

    private SingleDwAccount sharedSingleDwAccount;
    private int amount;

    public Withdraw(SingleDwAccount sharedSingleDwAccount, int amount) {
        this.sharedSingleDwAccount = sharedSingleDwAccount;
        this.amount = amount;
    }

    public void run () {
        sharedSingleDwAccount.withdraw(amount);
    }

}
