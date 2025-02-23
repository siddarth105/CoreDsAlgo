package MultiThreading.ProducerConsumer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceCounterWithLatchExample {

    public static class Counter {
        private int count;

        public Counter(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public void increment() {
            count++;
        }
    }

    // AtomicReference for the counter object
    private static AtomicReference<Counter> atomicCounter = new AtomicReference<>(new Counter(0));
    private static final int THREAD_COUNT = 100;

    public static void main(String[] args) throws InterruptedException {
        // Create a CountDownLatch initialized to the number of threads
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);

        // Create and start 100 threads
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(() -> {
                while (true) {
                    Counter oldCounter = atomicCounter.get();
                    Counter newCounter = new Counter(oldCounter.getCount());
                    newCounter.increment();

                    // Attempt to update the atomic reference
                    if (atomicCounter.compareAndSet(oldCounter, newCounter)) {
                        System.out.println("Counter incremented to: " + newCounter.getCount());
                        latch.countDown(); // Decrement the latch count
                        break;  // Exit loop after successful update
                    }
                    // Retry if update failed due to concurrent modification
                }
            }).start();
        }

        // Wait for all threads to finish
        latch.await();

        // Print the final value of the counter
        System.out.println("Final counter value: " + atomicCounter.get().getCount());
    }
}
