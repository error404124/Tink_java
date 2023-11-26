package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("InnerTypeLast")
public class Task1 {
    private Task1() {

    }

    private final static int N = 100;

    public static class Counter {
        AtomicInteger counter = new AtomicInteger(0);

        public AtomicInteger getCounter() {
            return counter;
        }

        public void increment() {
            counter.incrementAndGet();
        }
    }

    public static Counter parallelCount(Counter counter) {
        Thread first = new Thread(() -> {
            for (int i = 0; i < N; ++i) {
                counter.increment();
            }
        });
        Thread second = new Thread(() -> {
            for (int i = 0; i < N; ++i) {
                counter.increment();
            }
        });

        first.start();
        second.start();

        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return counter;
    }
}
