package edu.hw1;

import org.junit.jupiter.api.Test;
import static edu.hw1.Task2.countDigits;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask2 {
    @Test
    void countDigits_test1() {
        int number = 4666;
        int ans = 4;
        assertThat(ans).isEqualTo(countDigits(number));
    }
    @Test
    void countDigits_test2() {
        int number = 0;
        int ans = 1;
        assertThat(ans).isEqualTo(countDigits(number));
    }
}
