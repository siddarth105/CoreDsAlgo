package MultiThreading.BankAccount;

public class Account {
    private int amount;
    private int pendingDeposits = 0;  // Tracks ongoing deposits

    public Account(int initialAmount) {
        this.amount = initialAmount;
    }

    public synchronized void deposit(int money) {
        pendingDeposits++; // Mark deposit as pending

        if (money > 0) {
            System.out.println(Thread.currentThread().getName() + " depositing: " + money);
            amount += money;
            System.out.println(Thread.currentThread().getName() + " new balance after deposit: " + amount);
        }

        pendingDeposits--; // Mark deposit as completed
        if (pendingDeposits == 0) {
            notifyAll(); // Notify all waiting threads only when all deposits are completed
        }
    }

    public synchronized void withdraw(int money) {
        while (pendingDeposits > 0) {  // Wait for all deposits to complete
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
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
