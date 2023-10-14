package edu.hw1;

import org.junit.jupiter.api.Test;
import static edu.hw1.Task5.isPalindromeDescendant;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask5 {
    @Test
    void isPalindromeDescendant_test1() {
        int number = 11211230;
        boolean ans = true;
        assertThat(ans).isEqualTo(isPalindromeDescendant(number));
    }
    @Test
    void isPalindromeDescendant_test2() {
        int number = 13001120;
        boolean ans = true;
        assertThat(ans).isEqualTo(isPalindromeDescendant(number));
    }
    @Test
    void isPalindromeDescendant_test3() {
        int number = 134;
        boolean ans = true;
        assertThat(ans).isEqualTo(isPalindromeDescendant(number));
    }
    @Test
    void isPalindromeDescendant_test4() {
        int number = 1;
        boolean ans = true;
        assertThat(ans).isEqualTo(isPalindromeDescendant(number));
    }

}
