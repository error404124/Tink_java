package edu.hw7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDatabase {
    private final Map<String, List<Person>> personName;
    private final Map<String, List<Person>> personAddress;
    private final Map<String, List<Person>> personPhone;
    private final Map<Integer, Person> personId;

    PersonDatabase() {
        personName = new HashMap<>();
        personAddress = new HashMap<>();
        personPhone = new HashMap<>();
        personId = new HashMap<>();
    }

    synchronized void add(Person person) {
        if (person.name() != null && person.address() != null && person.phoneNumber() != null) {
            personName.computeIfAbsent(person.name(), k -> new ArrayList<>()).add(person);
            personAddress.computeIfAbsent(person.address(), k -> new ArrayList<>()).add(person);
            personPhone.computeIfAbsent(person.phoneNumber(), k -> new ArrayList<>()).add(person);
            personId.put(person.id(), person);
        }
    }

    synchronized void delete(int id) {
        Person removePerson = personId.get(id);
        if (removePerson != null) {
            personName.get(removePerson.name()).remove(removePerson);
            personPhone.get(removePerson.phoneNumber()).remove(removePerson);
            personAddress.get(removePerson.address()).remove(removePerson);
            personId.remove(id);
        }
    }

    synchronized List<Person> findByName(String name) {
        return personName.get(name);
    }

    synchronized List<Person> findByAddress(String address) {
        return personAddress.get(address);
    }

    synchronized List<Person> findByPhone(String phone) {
        return personPhone.get(phone);
    }
}
