package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask8 {
    @Test
    void check1Test1() {
        String str = "1";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task8.check1(str));
    }
    @Test
    void check1Test2() {
        String str = "11";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task8.check1(str));
    }
    @Test
    void check2Test1() {
        String str = "011";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task8.check2(str));
    }
    @Test
    void check2Test2() {
        String str = "01";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task8.check2(str));
    }
    @Test
    void check2Test3() {
        String str = "10";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task8.check2(str));
    }
    @Test
    void check2Test4() {
        String str = "100";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task8.check2(str));
    }
    @Test
    void check2Test5() {
        String str = "100111";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task8.check2(str));
    }

    @Test
    void check3Test1() {
        String str = "1111";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task8.check3(str));
    }
    @Test
    void check3Test2() {
        String str = "000";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task8.check3(str));
    }
    @Test
    void check3Test3() {
        String str = "11010101";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task8.check3(str));
    }
    @Test
    void check3Test4() {
        String str = "11011";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task8.check3(str));
    }
    @Test
    void check3Test5() {
        String str = "110101";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task8.check3(str));
    }
    @Test
    void check4Test11() {
        String str = "11101";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task8.check4(str));
    }
    @Test
    void check4Test2() {
        String str = "1101";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task8.check4(str));
    }
    @Test
    void check4Test3() {
        String str = "0101";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task8.check4(str));
    }
    @Test
    void check6Test1() {
        String str = "001";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task8.check6(str));
    }
    @Test
    void check6Test2() {
        String str = "000";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task8.check6(str));
    }
    @Test
    void check6Test3() {
        String str = "10";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task8.check6(str));
    }
    @Test
    void check6Test4() {
        String str = "101";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task8.check6(str));
    }
    @Test
    void check6Test5() {
        String str = "00101000";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task8.check6(str));
    }
    @Test
    void check7Test1() {
        String str = "1";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task8.check7(str));
    }
    @Test
    void check7Test2() {
        String str = "11";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task8.check7(str));
    }
    @Test
    void check7Test3() {
        String str = "10101";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task8.check7(str));
    }
    @Test
    void check7Test4() {
        String str = "1010100010101";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task8.check7(str));
    }
    @Test
    void check7Test5() {
        String str = "1010100011101";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task8.check7(str));
    }
}
