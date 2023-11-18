package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask4 {
    @Test
    void convertToRomanTest1() {
        int number = 2;
        String answer = "II";
        assertThat(answer).isEqualTo(Task4.convertToRoman(number));
    }
    @Test
    void convertToRomanTest2() {
        int number = 12;
        String answer = "XII";
        assertThat(answer).isEqualTo(Task4.convertToRoman(number));
    }
    @Test
    void convertToRomanTest3() {
        int number = 16;
        String answer = "XVI";
        assertThat(answer).isEqualTo(Task4.convertToRoman(number));
    }
    @Test
    void convertToRomanTest4() {
        int number = 100000;
        String answer = null;
        assertThat(answer).isEqualTo(Task4.convertToRoman(number));
    }
}
