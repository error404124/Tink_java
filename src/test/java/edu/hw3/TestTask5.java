package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask5 {
    @Test
    void parseContactsTest1() {
        List<String> persons = Arrays.asList("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes");
        List<String> answer = Arrays.asList("Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke");
        assertThat(answer).isEqualTo(Task5.parseContacts(persons, "ASC"));
    }
    @Test
    void parseContactsTest2() {
        List<String> persons = Arrays.asList("Paul Erdos", "Leonhard Euler", "Carl Gauss");
        List<String> answer = Arrays.asList("Carl Gauss", "Leonhard Euler", "Paul Erdos");
        assertThat(answer).isEqualTo(Task5.parseContacts(persons, "DESC"));
    }
    @Test
    void parseContactsTest3() {
        List<String> persons = Arrays.asList("");
        List<String> answer = Arrays.asList("");
        assertThat(answer).isEqualTo(Task5.parseContacts(persons, "DESC"));
    }
    @Test
    void parseContactsTest4() {
        List<String> persons = null;
        List<String> answer = null;
        assertThat(answer).isEqualTo(Task5.parseContacts(persons, "DESC"));
    }
}
