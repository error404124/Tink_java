package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask1 {
    @Test
    void howTimesTest1() {
        String date1 = "2022-03-12, 20:20 - 2022-03-12, 23:50";
        String date2 = "2022-04-01, 21:30 - 2022-04-02, 01:20";
        String answer = "3ч 40м";
        assertThat(answer).isEqualTo(Task1.howTimes(date1, date2));
    }

    @Test
    void howTimesTest2() {
        String date1 = "2022-03-12, 20:25 - 2022-03-12, 22:51";
        String date2 = "2022-04-01, 21:39 - 2022-04-02, 01:20";
        String answer = "3ч 3м";
        assertThat(answer).isEqualTo(Task1.howTimes(date1, date2));
    }
}
