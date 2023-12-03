package edu.hw8;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

@SuppressWarnings({"MagicNumber"})
public class Task2 {
    private Task2() {

    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static String parallelFibonacci(int n, int threadCount) throws Exception {
        Long[] results = new Long[n];
        try (FixedThreadPool threadPool = new FixedThreadPool(threadCount)) {
            threadPool.start();
            for (int i = 0; i < n; ++i) {
                int index = i;
                threadPool.execute(() -> {
                    long result = fibonacci(index);
                    results[index] = result;
                });
            }
            Thread.sleep(1000);
        }
        return Arrays.stream(results)
            .sorted()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "[", "]"));
    }

    public interface ThreadPool extends AutoCloseable {

        void start();

        void execute(Runnable runnable) throws InterruptedException;
    }

    public static class FixedThreadPool implements ThreadPool {
        private final Thread[] threads;
        private final BlockingQueue<Runnable> tasks;
        private final int threadCount;

        public FixedThreadPool(int threadCount) {
            this.threads = new Thread[threadCount];
            this.tasks = new LinkedBlockingDeque<>();
            this.threadCount = threadCount;
        }

        public void start() {
            for (int i = 0; i < threadCount; ++i) {
                threads[i] = new Thread(() -> {
                    try {
                        while (true) {
                            Runnable task = tasks.take();
                            task.run();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
                threads[i].start();
            }
        }

        @Override
        public void execute(Runnable runnable) throws InterruptedException {
            tasks.put(runnable);
        }

        @Override
        public void close() throws Exception {
            for (var th : threads) {
                th.interrupt();
            }
            for (var th : threads) {
                th.interrupt();
            }
        }
    }

}
