package MultiThreading.BankAccount;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockAccount {
    private int amount;
    private boolean depositDone = false; // Flag to track deposit completion
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition depositCondition = lock.newCondition(); // Condition for deposit completion

    public ReentrantLockAccount(int initialAmount) {
        this.amount = initialAmount;
    }

    public void deposit(int money) {
        lock.lock(); // Acquire the lock
        try {
            if (money > 0) {
                System.out.println(Thread.currentThread().getName() + " depositing: " + money);
                amount += money;
                System.out.println(Thread.currentThread().getName() + " new balance after deposit: " + amount);

                depositDone = true; // Mark deposit as done
                depositCondition.signal(); // Notify waiting withdraw thread
            }
        } finally {
            lock.unlock(); // Always release the lock
        }
    }

    public void withdraw(int money) {
        lock.lock(); // Acquire the lock
        try {
            // Wait until deposit is done
            while (!depositDone) {
                try {
                    depositCondition.await(); // Wait for deposit to complete
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
        } finally {
            lock.unlock(); // Always release the lock
        }
    }

    public int getBalance() {
        lock.lock();
        try {
            return amount;
        } finally {
            lock.unlock();
        }
    }
}
