package edu.hw8;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask3 {

    @Test
    void nexPasswordTest() {
        var a = Task3.nextPassword("a", 1173);
        assertThat("av").isEqualTo(a);
    }

    @Test
    void countMD5Hash() {
        var a = "a";
        assertThat("0cc175b9c0f1b6a831c399e269772661").isEqualTo(Task3.countMD5Hash("a"));
    }
}
