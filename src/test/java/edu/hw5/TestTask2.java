package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask2 {
    @Test
    void allFriday13Test1() {
        int year = 1925;
        String answer = "[1925-02-13, 1925-03-13, 1925-11-13]";
        assertThat(answer).isEqualTo(Task2.allFriday13(year).toString());
    }
    @Test
    void allFriday13Test2() {
        int year = 2024;
        String answer = "[2024-09-13, 2024-12-13]";
        assertThat(answer).isEqualTo(Task2.allFriday13(year).toString());
    }
    @Test
    void nextFriday13Test1() {
        LocalDate date = LocalDate.of(2024, 2, 20);
        LocalDate answer = LocalDate.of(2024, 9, 13);
        assertThat(answer).isEqualTo(Task2.nextFriday13(date));
    }
    @Test
    void nextFriday13Test2() {
        LocalDate date = LocalDate.of(1925, 2, 10);
        LocalDate answer = LocalDate.of(1925, 2, 13);
        assertThat(answer).isEqualTo(Task2.nextFriday13(date));
    }
    @Test
    void nextFriday13Test3() {
        LocalDate date = LocalDate.of(1925, 4, 1);
        LocalDate answer = LocalDate.of(1925, 11, 13);
        assertThat(answer).isEqualTo(Task2.nextFriday13(date));
    }
}
