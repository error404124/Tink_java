package edu.hw7;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestTaskReadWriteLock {
    @Test
    public void test() throws InterruptedException {
        ReadWriteLockPersonDatabase database = new ReadWriteLockPersonDatabase();

        Thread writer = new Thread(() -> {
            for (int i = 0; i < 100; ++i) {
                Person person = new Person(
                    i,
                    String.valueOf(i),
                    String.valueOf(i),
                    String.valueOf(i)
                );
                database.add(person);
            }
        });

        Thread reader = new Thread(() -> {
            for (int i = 0; i < 100; ++i) {
                List<Person> result = database.findByName(String.valueOf(i));
                if (result != null) {
                    Person person = result.get(0);
                    assertEquals(i, person.id());
                    assertNotNull(person.name());
                }
            }
        });

        writer.start();
        reader.start();

        writer.join();
        reader.join();
    }

}

