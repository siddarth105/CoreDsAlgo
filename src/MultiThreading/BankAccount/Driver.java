package MultiThreading.BankAccount;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {
    public static void main(String[] args) {
        SingleDwAccount sharedSingleDwAccount = new SingleDwAccount(1000);
        singleDepositWithdrawal(sharedSingleDwAccount);
    }

    private static void multiDepositsWithdrawal() {

        Account sharedSingleDwAccount = new Account(1000);

        int numberOfDeposits = 3, numberOfWithdrawals = 3;
        int[] depositAmts = {300, 500, 200};
        int[] withdrawalAmts = {150, 400, 100};
        int totalTasks = numberOfDeposits + numberOfWithdrawals;
        CountDownLatch latch = new CountDownLatch(totalTasks);
        ExecutorService executorService = Executors.newFixedThreadPool(totalTasks);

        for (int amount : withdrawalAmts) {
            executorService.submit(() -> {
                try{
                    sharedSingleDwAccount.withdraw(amount);
                } finally {
                    latch.countDown();
                }
            });
        }
        for (int amount : depositAmts) {
            executorService.submit(() -> {
                try {
                    sharedSingleDwAccount.deposit(amount);
                } finally {
                    latch.countDown();
                }
            });
        }
        executorService.shutdown();

        try {
            latch.await(); // This will block until the latch count reaches zero
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final Balance after all deposits and withdrawals: " + sharedSingleDwAccount.getBalance());

    }


    private static void singleDepositWithdrawal(SingleDwAccount sharedSingleDwAccount) {
        Thread deposit = new Deposit(sharedSingleDwAccount, 400);
        Thread withdraw = new Withdraw(sharedSingleDwAccount, 200);
        deposit.start();
        withdraw.start();
        try {
            deposit.join();
            withdraw.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final Balance: " + sharedSingleDwAccount.getBalance());
    }

    private static void singleDepositWithdrawal(SingleDwAccount sharedSingleDwAccount, boolean anonymousClass) {
        Thread deposit = new Thread("Deposit") {
            public void run() {
                sharedSingleDwAccount.deposit(300);
            }
        };

        Thread withdraw = new Thread("Withdraw") {
            public void run() {
                sharedSingleDwAccount.withdraw(150);
            }
        };

        deposit.start();
        withdraw.start();

        try {
            deposit.join();
            withdraw.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final Balance: " + sharedSingleDwAccount.getBalance());
    }
}
