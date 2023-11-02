package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask5 {
    @Test
    void parseContactsTest1() {
        List<Task5.Person> persons = Arrays.asList(
            new Task5.Person("John Locke"),
            new Task5.Person("Thomas Aquinas"),
            new Task5.Person("David Hume"),
            new Task5.Person("Rene Descartes")
        );
        List<Task5.Person> answer = Arrays.asList(
            new Task5.Person("Thomas Aquinas"),
            new Task5.Person("Rene Descartes"),
            new Task5.Person("David Hume"),
            new Task5.Person("John Locke")
        );
        assertThat(answer).isEqualTo(Task5.parseContacts(persons, "ASC"));
    }

    @Test
    void parseContactsTest2() {
        List<Task5.Person> persons = Arrays.asList(
            new Task5.Person("Paul Erdos"),
            new Task5.Person("Leonhard Euler"),
            new Task5.Person("Carl Gauss")
        );
        List<Task5.Person> answer = Arrays.asList(
            new Task5.Person("Carl Gauss"),
            new Task5.Person("Leonhard Euler"),
            new Task5.Person("Paul Erdos")
        );
        assertThat(answer).isEqualTo(Task5.parseContacts(persons, "DESC"));
    }

    @Test
    void parseContactsTest3() {
        List<Task5.Person> persons = Arrays.asList(new Task5.Person(""));
        List<Task5.Person> answer = Arrays.asList(new Task5.Person(""));
        assertThat(answer).isEqualTo(Task5.parseContacts(persons, "DESC"));
    }

    @Test
    void parseContactsTest4() {
        List<Task5.Person> persons = null;
        List<Task5.Person> answer = null;
        assertThat(answer).isEqualTo(Task5.parseContacts(persons, "DESC"));
    }
}
