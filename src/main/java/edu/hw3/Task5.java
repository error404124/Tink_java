package edu.hw3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Task5 {
    static final private String SPACE = "\\s+";

    private Task5() {
    }

    public static List<Person> parseContacts(String[] persons, String condition) {
        if (persons == null) {
            return null;
        }

        List<Person> personList = convertToPersonList(persons);

        personList.sort(new PersonComparator());

        if (Objects.equals(condition, "DESC")) {
            personList.sort(new PersonComparator().reversed());
        }

        return personList;
    }

    private static List<Person> convertToPersonList(String[] persons) {
        List<Person> personList = new ArrayList<>(persons.length);

        for (String personStr : persons) {
            personList.add(new Person(personStr));
        }

        return personList;
    }

    public static class PersonComparator implements Comparator<Person> {
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

    public static record Person(String fullName) {
    }
}
