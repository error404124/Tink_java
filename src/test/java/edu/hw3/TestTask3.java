package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask3 {
    @Test
    void freqDictTest1() {
        String[] array = {"a", "bb", "a", "bb"};
        String answer = "{bb=2, a=2}";
        assertThat(answer).isEqualTo(Task3.freqDict(array).toString());
    }
    @Test
    void freqDictTest2() {
        String[] array = {"this", "and", "that", "and"};
        String answer = "{that=1, and=2, this=1}";
        assertThat(answer).isEqualTo(Task3.freqDict(array).toString());
    }
    @Test
    void freqDictTest3() {
        String[] array = {"1", "1", "2", "2"};
        String answer = "{1=2, 2=2}";
        assertThat(answer).isEqualTo(Task3.freqDict(array).toString());
    }

}
