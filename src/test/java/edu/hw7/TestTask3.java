package edu.hw7;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestTask3 {

    @Test
    void findByName() {
        PersonDatabase personDatabase = new PersonDatabase();
        Person person = new Person(1, "John", "123", "123");
        personDatabase.add(person);
        List<Person> result = personDatabase.findByName("John");
        assertThat(result.get(0)).isEqualTo(person);
    }

    @Test
    void findByAddress() {
        PersonDatabase personDatabase = new PersonDatabase();
        Person person = new Person(2, "Alice", "456 Mos", "123");
        personDatabase.add(person);

        List<Person> result = personDatabase.findByAddress("456 Mos");
        assertThat(result.get(0)).isEqualTo(person);
    }

    @Test
    void findByPhone() {
        PersonDatabase personDatabase = new PersonDatabase();
        Person person = new Person(3, "Bob", "123", "561-038");
        personDatabase.add(person);

        List<Person> result = personDatabase.findByPhone("561-038");

        assertThat(result.get(0)).isEqualTo(person);
    }

    @Test
    void nullAttributes() {
        PersonDatabase personDatabase = new PersonDatabase();
        Person person = new Person(4, "J", null, null);
        personDatabase.add(person);
        assertNull(personDatabase.findByName("J"));
    }

    @Test
    void deletePerson(){
        PersonDatabase personDatabase = new PersonDatabase();
        Person person = new Person(1, "John", "123", "123");
        personDatabase.add(person);
        personDatabase.delete(1);
        assertThat("[]").isEqualTo(personDatabase.findByName("John").toString());
    }
}
