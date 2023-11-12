package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask5 {
    @Test
    void numberCheckTest1() {
        String number = "А123ВЕ777";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task4.checkPassword(number));
    }

    @Test
    void numberCheckTest2() {
        String number = "О777ОО177";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task5.checkCarNumber(number));
    }
    @Test
    void numberCheckTest3() {
        String number = "123АВЕ777";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task5.checkCarNumber(number));
    }
    @Test
    void numberCheckTest4() {
        String number = "А123ВГ77";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task5.checkCarNumber(number));
    }
    @Test
    void numberCheckTest5() {
        String number = "А123ВЕ7777";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task5.checkCarNumber(number));
    }
}
