package edu.hw6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask1 {
    private static final String TEST_FILE_PATH = "testfile.txt";

    @BeforeEach
    void setUp() {
        try {
            Files.write(Path.of(TEST_FILE_PATH), "key1:value1\nkey2:value2\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterEach
    void tearDown() {
        try {
            Files.deleteIfExists(Path.of(TEST_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSize() {
        Task1.DiskMap diskMap = new Task1.DiskMap(TEST_FILE_PATH);
        assertEquals(2, diskMap.size());
    }

    @Test
    void testIsEmpty() {
        Task1.DiskMap diskMap = new Task1.DiskMap(TEST_FILE_PATH);
        assertFalse(diskMap.isEmpty());
    }

    @Test
    void testContainsKey() {
        Task1.DiskMap diskMap = new Task1.DiskMap(TEST_FILE_PATH);
        assertTrue(diskMap.containsKey("key1"));
    }

    @Test
    void testContainsValue() {
        Task1.DiskMap diskMap = new Task1.DiskMap(TEST_FILE_PATH);
        assertTrue(diskMap.containsValue("value1"));
    }

    @Test
    void testGet() {
        Task1.DiskMap diskMap = new Task1.DiskMap(TEST_FILE_PATH);
        assertEquals("value1", diskMap.get("key1"));
    }

    @Test
    void testPut() {
        Task1.DiskMap diskMap = new Task1.DiskMap(TEST_FILE_PATH);
        diskMap.put("key3", "value3");
        assertEquals(3, diskMap.size());
    }

    @Test
    void testRemove() {
        Task1.DiskMap diskMap = new Task1.DiskMap(TEST_FILE_PATH);
        diskMap.remove("key1");
        assertNull(diskMap.get("key1"));
        assertEquals(1, diskMap.size());
    }

    @Test
    void testPutAll() {
        Task1.DiskMap diskMap = new Task1.DiskMap(TEST_FILE_PATH);
        Map<String, String> newData = new HashMap<>();
        newData.put("key3", "value3");
        newData.put("key4", "value4");
        diskMap.putAll(newData);
        assertEquals(4, diskMap.size());
    }


    @Test
    void testKeySet() {
        Task1.DiskMap diskMap = new Task1.DiskMap(TEST_FILE_PATH);
        assertEquals(2, diskMap.keySet().size());
        assertTrue(diskMap.containsKey("key1"));
        assertTrue(diskMap.containsKey("key2"));
    }

    @Test
    void testValues() {
        Task1.DiskMap diskMap = new Task1.DiskMap(TEST_FILE_PATH);
        assertEquals(2, diskMap.values().size());
        assertTrue(diskMap.containsValue("value1"));
        assertTrue(diskMap.containsValue("value2"));
    }
}

