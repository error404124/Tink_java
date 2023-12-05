package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask6 {
    @Test
    void stringInStingTest1() {
        String str2 = "achfdbaabgabcaabg";
        String str1 = "abc";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task6.stringInSting(str1, str2));
    }
    @Test
    void stringInStingTest2() {
        String str2 = "1234jkhsa,kd";
        String str1 = "kd";
        Boolean answer = true;
        assertThat(answer).isEqualTo(Task6.stringInSting(str1, str2));
    }
    @Test
    void stringInStingTest3() {
        String str2 = "ABdsajkfFASF";
        String str1 = "fas";
        Boolean answer = false;
        assertThat(answer).isEqualTo(Task6.stringInSting(str1, str2));
    }
}
