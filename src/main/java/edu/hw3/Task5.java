package edu.hw3;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Task5 {
    static final private String SPACE = "\\s+";

    private Task5() {
    }

    public static List<Person> parseContacts(List<Person> persons, String condition) {
        if (persons == null) {
            return null;
        }
        persons.sort(new PersonComaparator());
        if (Objects.equals(condition, "ASC")) {
            return persons;
        } else if (Objects.equals(condition, "DESC")) {
            return persons.reversed();
        } else {
            return null;
        }
    }

    public static class PersonComaparator implements Comparator<Person> {
        public int compare(Person person1, Person person2) {
            String[] str1 = person1.toString().split(SPACE);
            String[] str2 = person2.toString().split(SPACE);
            if (str1.length < 2 || str2.length < 2) {
                return person1.toString().compareTo(person2.toString());
            } else {
                int result = str1[1].compareTo(str2[1]);
                if (result == 0) {
                    return str1[0].compareTo(str2[0]);
                } else {
                    return result;
                }
            }
        }
    }

    record Person(String fullName) {
    }
}
