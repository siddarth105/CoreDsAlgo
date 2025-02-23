package MultiThreading.BankAccount;

public class SingleDwAccount {
    private int amount;
    private boolean depositDone = false;

    public SingleDwAccount(int initialAmount) {
        this.amount = initialAmount;
    }

    public synchronized void deposit(int money) {
        if (money > 0) {
            System.out.println(Thread.currentThread().getName() + " depositing: " + money);
            amount += money;
            System.out.println(Thread.currentThread().getName() + " new balance after deposit: " + amount);

            depositDone = true; // Mark deposit as done
            notify(); // Notify waiting(deposit) thread
        }
    }


    public synchronized void withdraw(int money) {
        // Wait until deposit is done
        while (!depositDone) {
            try {
                wait(); // Wait for deposit to complete
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (money > 0) {
            if (money <= amount) {
                System.out.println(Thread.currentThread().getName() + " withdrawing: " + money);
                amount -= money;
                System.out.println(Thread.currentThread().getName() + " new balance after withdrawal: " + amount);
            } else {
                System.out.println(Thread.currentThread().getName() + " tried to withdraw " + money + " but insufficient funds. Balance: " + amount);
            }
        }
    }

    public synchronized int getBalance() {
        return amount;
    }

}
