package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask3 {
    @Test
    void parseDataTest1() {
        String str = "1/3/20";
        String answer = "Optional[2020-03-01]";
        assertThat(answer).isEqualTo(Task3.parseData(str).toString());
    }

    @Test
    void parseDataTest2() {
        String str = "2020-10-10";
        String answer = "Optional[2020-10-10]";
        assertThat(answer).isEqualTo(Task3.parseData(str).toString());
    }

    @Test
    void parseDataTest3() {
        String str = "1/3/1976";
        String answer = "Optional[1976-03-01]";
        assertThat(answer).isEqualTo(Task3.parseData(str).toString());
    }

    @Test
    void parseDataTest4() {
        String str = "today";
        String answer = "Optional[2023-11-22]";
        assertThat(answer).isEqualTo(Task3.parseData(str).toString());
    }

    @Test
    void parseDataTest5() {
        String str = "tomorrow";
        String answer = "Optional[2023-11-23]";
        assertThat(answer).isEqualTo(Task3.parseData(str).toString());
    }

    @Test
    void parseDataTest6() {
        String str = "yesterday";
        String answer = "Optional[2023-11-21]";
        assertThat(answer).isEqualTo(Task3.parseData(str).toString());
    }

    @Test
    void parseDataTest7() {
        String str = "1 day ago";
        String answer = "Optional[2023-11-21]";
        assertThat(answer).isEqualTo(Task3.parseData(str).toString());
    }

    @Test
    void parseDataTest8() {
        String str = "10 days ago";
        String answer = "Optional[2023-11-12]";
        assertThat(answer).isEqualTo(Task3.parseData(str).toString());
    }

    @Test
    void parseDataTest9() {
        String str = "12-32/12";
        String answer = "Optional.empty";
        assertThat(answer).isEqualTo(Task3.parseData(str).toString());
    }
}
