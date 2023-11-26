package edu.hw7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockPersonDatabase {
    private final Map<String, List<Person>> personName;
    private final Map<String, List<Person>> personAddress;
    private final Map<String, List<Person>> personPhone;
    private final Map<Integer, Person> personId;

    private static final ReadWriteLock LOCK = new ReentrantReadWriteLock();

    ReadWriteLockPersonDatabase() {
        personName = new HashMap<>();
        personAddress = new HashMap<>();
        personPhone = new HashMap<>();
        personId = new HashMap<>();
    }

    void add(Person person) {
        LOCK.writeLock().lock();
        try {
            if (person.name() != null && person.address() != null && person.phoneNumber() != null) {
                personName.computeIfAbsent(person.name(), k -> new ArrayList<>()).add(person);
                personAddress.computeIfAbsent(person.address(), k -> new ArrayList<>()).add(person);
                personPhone.computeIfAbsent(person.phoneNumber(), k -> new ArrayList<>()).add(person);
                personId.put(person.id(), person);
            }
        } finally {
            LOCK.writeLock().unlock();
        }
    }

    void delete(int id) {
        LOCK.writeLock().lock();
        try {
            Person removePerson = personId.get(id);
            if (removePerson != null) {
                personName.get(removePerson.name()).remove(removePerson);
                personPhone.get(removePerson.phoneNumber()).remove(removePerson);
                personAddress.get(removePerson.address()).remove(removePerson);
                personId.remove(id);
            }
        } finally {
            LOCK.writeLock().unlock();
        }
    }

    List<Person> findByName(String name) {
        LOCK.readLock().lock();
        try {
            return personName.get(name);
        } finally {
            LOCK.readLock().unlock();
        }
    }

    List<Person> findByAddress(String address) {
        LOCK.readLock().lock();
        try {
            return personAddress.get(address);
        } finally {
            LOCK.readLock().unlock();
        }
    }

    List<Person> findByPhone(String phone) {
        LOCK.readLock().lock();
        try {
            return personPhone.get(phone);
        } finally {
            LOCK.readLock().unlock();
        }
    }
}
