package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask4 {
    @Test
    void passwordCheckTest1() {
        String str = "HIUEQwfjIJ13412";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task4.checkPassword(str));
    }

    @Test
    void passwordCheckTest2() {
        String str = "HIUEQwfjIJ1%3412";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task4.checkPassword(str));
    }
    @Test
    void passwordCheckTest3() {
        String str = "*HIUEQwfjIJ13412";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task4.checkPassword(str));
    }
    @Test
    void passwordCheckTest4() {
        String str = "HIUEQwfjIJ13412|";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task4.checkPassword(str));
    }
}
