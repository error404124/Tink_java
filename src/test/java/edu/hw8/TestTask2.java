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
}
