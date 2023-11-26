package edu.hw7;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static edu.hw7.Task2.parallelFactorial;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask2 {

    @Test
    void parallelFactorialTest1() throws IllegalAccessException {
        long a = 12;
        BigInteger answer = new BigInteger("479001600");
        assertThat(answer).isEqualTo(parallelFactorial(a));
    }

    @Test
    void parallelFactorialTest2() throws IllegalAccessException {
        long a = 34;
        BigInteger answer = new BigInteger("295232799039604140847618609643520000000");
        assertThat(answer).isEqualTo(parallelFactorial(a));
    }

    @Test
    void parallelFactorialTest3() throws IllegalAccessException {
        long a = 0;
        BigInteger answer = new BigInteger("1");
        assertThat(answer).isEqualTo(parallelFactorial(a));
    }
}
