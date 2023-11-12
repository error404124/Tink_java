package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask7 {
    @Test
    void checkString1Test1() {
        String str = "11010";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task7.checkString1(str));
    }

    @Test
    void checkString1Test2() {
        String str = "00111000";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task7.checkString1(str));
    }
    @Test
    void checkString1Test3() {
        String str = "10";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task7.checkString1(str));
    }
    @Test
    void checkString2Test1() {
        String str = "110101";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task7.checkString2(str));
    }
    @Test
    void checkString2Test2() {
        String str = "11";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task7.checkString2(str));
    }
    @Test
    void checkString2Test3() {
        String str = "1";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task7.checkString2(str));
    }
    @Test
    void checkString2Test4() {
        String str = "10";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task7.checkString2(str));
    }
    @Test
    void checkString3Test1() {
        String str = "1";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task7.checkString3(str));
    }
    @Test
    void checkString3Test2() {
        String str = "111";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task7.checkString3(str));
    }
    @Test
    void checkString3Test3() {
        String str = "111000";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task7.checkString3(str));
    }
}
