package edu.hw1;

import org.junit.jupiter.api.Test;
import static edu.hw1.Task7.rotateLeft;
import static edu.hw1.Task7.rotateRight;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask7 {
    @Test
    void rotateLeft_test1() {
        int number = 16, shift = 1;
        int ans = 1;
        assertThat(ans).isEqualTo(rotateLeft(number, shift));
    }
    @Test
    void rotateLeft_test2() {
        int number = 17, shift = 2;
        int ans = 6;
        assertThat(ans).isEqualTo(rotateLeft(number, shift));
    }
    @Test
    void rotateRight_test1() {
        int number = 16, shift = 1;
        int ans = 8;
        assertThat(ans).isEqualTo(rotateRight(number, shift));
    }
    @Test
    void rotateRight_test2() {
        int number = 8, shift = 1;
        int ans = 4;
        assertThat(ans).isEqualTo(rotateRight(number, shift));
    }
}
