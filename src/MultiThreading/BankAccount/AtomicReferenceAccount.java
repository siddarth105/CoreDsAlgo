package MultiThreading.BankAccount;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicReferenceAccount {
    private final AtomicInteger amount;
    private final AtomicInteger pendingDeposits;  // Track ongoing deposits
    private final AtomicBoolean depositDone;

    public AtomicReferenceAccount(int initialAmount) {
        this.amount = new AtomicInteger(initialAmount);
        this.pendingDeposits = new AtomicInteger(0);  // Start with 0 deposits
        this.depositDone = new AtomicBoolean(false);  // Initially no deposit done
    }

    public void deposit(int money) {
        pendingDeposits.incrementAndGet();  // pendingDeposits ++

        if (money > 0) {
            System.out.println(Thread.currentThread().getName() + " depositing: " + money);
            int newBalance = amount.addAndGet(money);
            System.out.println(Thread.currentThread().getName() + " new balance after deposit: " + newBalance);
        }

        if (pendingDeposits.decrementAndGet() == 0) { // pendingDeposits ++
            depositDone.set(true);  // All deposits are now complete
        }
    }

    public void withdraw(int money) {
        // Wait until all deposits are done
        while (!depositDone.get() || pendingDeposits.get() > 0) {
            // Busy-wait (this should be replaced with a proper waiting mechanism)
        }

        if (money > 0) {
            if (money <= amount.get()) {
                System.out.println(Thread.currentThread().getName() + " withdrawing: " + money);
                int newBalance = amount.addAndGet(-money);
                System.out.println(Thread.currentThread().getName() + " new balance after withdrawal: " + newBalance);
            } else {
                System.out.println(Thread.currentThread().getName() + " tried to withdraw " + money + " but insufficient funds. Balance: " + amount.get());
            }
        }
    }

    public int getBalance() {
        return amount.get();
    }
}
