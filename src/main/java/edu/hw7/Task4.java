package edu.hw7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings({"RegexpSinglelineJava", "MagicNumber", "UncommentedMain"})

public class Task4 {
    private Task4() {

    }

    private static final int THREADS = 6;

    public static double countPI(long iterations) {
        long startTime = System.currentTimeMillis();
        long circleCount = 0;

        long iterForThread = iterations / THREADS;

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        List<Callable<Long>> tasks = new ArrayList<>();

        for (int j = 0; j < THREADS; ++j) {
            Callable<Long> task = (() -> {
                long localCircleCount = 0;
                for (int i = 0; i < iterForThread; ++i) {
                    double x = ThreadLocalRandom.current().nextDouble() * 2 - 1;
                    double y = ThreadLocalRandom.current().nextDouble() * 2 - 1;
                    if (x * x + y * y < 1) {
                        ++localCircleCount;
                    }
                }
                return localCircleCount;
            });
            tasks.add(task);
        }
        try {
            List<Future<Long>> results = executorService.invokeAll(tasks);
            for (Future<Long> result : results) {
                circleCount += result.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        double pi = (double) (4 * circleCount) / iterations;

        System.out.println("Iterations: " + iterations);
        System.out.println("Threads: " + THREADS);
        System.out.println("Result: " + pi);
        System.out.println("Time: " + elapsedTime + " milliseconds");
        System.out.println("Error: " + Math.abs(Math.PI - pi));

        return pi;
    }

    public static void main(String[] args) {
        countPI(1000000000);
//        Iterations: 10000000                 Iterations: 10000000
//        Threads: 1                           Threads: 6
//        Result: 3.142464                     Result: 3.141074
//        Time: 84 milliseconds                Time: 105 milliseconds
//        Error: 8.71346410206808E-4           Error: 5.186535897929723E-4

//        Iterations: 100000000                Iterations: 100000000
//        Threads: 1                           Threads: 6
//        Result: 3.14192492                   Result: 3.1414588
//        Time: 859 milliseconds               Time: 273 milliseconds
//        Error: 3.32266410207005E-4           Error: 1.3385358979300932E-4

//        Iterations: 1000000000               Iterations: 1000000000
//        Threads: 1                           Threads: 6
//        Result: 3.141688884                  Result: 3.141649644
//        Time: 6767 milliseconds              Time: 2159 milliseconds
//        Error: 9.623041020700995E-5          Error: 5.699041020701401E-5

    }

}
