package edu.hw1;

import org.junit.jupiter.api.Test;
import static edu.hw1.Task1.minutesToSeconds;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask1 {
    @Test
    void minutesToSeconds_test1() {
        String str = "01:00";
        int ans = 60;
        assertThat(ans).isEqualTo(minutesToSeconds(str));
    }

    @Test
    void minutesToSeconds_test2() {
        String str = "10:60";
        int ans = -1;
        assertThat(ans).isEqualTo(minutesToSeconds(str));
    }

    @Test
    void minutesToSeconds_test3() {
        String str = "999:59";
        int ans = 59999;
        assertThat(ans).isEqualTo(minutesToSeconds(str));
    }
}
