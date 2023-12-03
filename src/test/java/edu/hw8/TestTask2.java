package edu.hw8;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask2 {

    @Test
    void parallelFibonacciTest1() throws Exception {
        var answer = "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55]";
        assertThat(answer).isEqualTo(Task2.parallelFibonacci(11, 3));
    }

    @Test
    void parallelFibonacciTest2() throws Exception {
        var answer = "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181]";
        assertThat(answer).isEqualTo(Task2.parallelFibonacci(20, 3));
    }

    @Test
    void parallelFibonacciTest3() throws Exception {
        var answer =
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986]";
        assertThat(answer).isEqualTo(Task2.parallelFibonacci(40, 5));
    }
}
