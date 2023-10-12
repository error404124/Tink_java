package edu.hw1;

import org.junit.jupiter.api.Test;
import static edu.hw1.Task6.K;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask6 {
    @Test
    void K_test1() {
        int number_1 = 6621;
        int ans = 5;
        assertThat(ans).isEqualTo(K(number_1));
    }
    @Test
    void K_test2() {
        int number_2 = 6554;
        int ans = 4;
        assertThat(ans).isEqualTo(K(number_2));
    }
    @Test
    void K_test3() {
        int number_3 = 6174;
        int ans = 0;
        assertThat(ans).isEqualTo(K(number_3));
    }
}
