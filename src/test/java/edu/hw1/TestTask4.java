package edu.hw1;

import org.junit.jupiter.api.Test;
import static edu.hw1.Task4.fixString;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask4 {
    @Test
    void fixString_test1() {
        String str = "hTsii  s aimex dpus rtni.g";
        String ans = "This is a mixed up string.";
        assertThat(ans).isEqualTo(fixString(str));
    }
    @Test
    void fixString_test2() {
        String str = "badce";
        String ans = "abcde";
        assertThat(ans).isEqualTo(fixString(str));
    }
}
