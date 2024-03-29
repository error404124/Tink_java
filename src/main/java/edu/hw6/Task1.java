package edu.hw6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Task1 {
    private Task1() {

    }

    public static class DiskMap implements Map<String, String> {
        private final String filePath;
        private final Map<String, String> map;

        public DiskMap(String filePath) {
            this.filePath = filePath;
            this.map = loadMapFromFile();
        }

        public Map<String, String> loadMapFromFile() {
            Map<String, String> loadMap = new HashMap<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        loadMap.put(parts[0], parts[1]);
                    }
                }
            } catch (IOException ignored) {
            }
            return loadMap;
        }

        public void saveMapToFile() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    writer.write(entry.getKey() + ":" + entry.getValue());
                    writer.newLine();
                }
            } catch (IOException ignored) {
            }
        }

        @Override
        public int size() {
            return map.size();
        }

        @Override
        public boolean isEmpty() {
            return map.isEmpty();
        }

        @Override
        public boolean containsKey(Object key) {
            return map.containsKey(key);
        }

        @Override
        public boolean containsValue(Object value) {
            return map.containsValue(value);
        }

        @Override
        public String get(Object key) {
            return map.get(key);
        }

        @Override
        public String put(String key, String value) {
            String oldValue = map.put(key, value);
            saveMapToFile();
            return oldValue;
        }

        @Override
        public String remove(Object key) {
            String removedValue = map.remove(key);
            saveMapToFile();
            return removedValue;
        }

        @Override
        public void putAll(Map<? extends String, ? extends String> m) {
            map.putAll(m);
            saveMapToFile();
        }

        @Override
        public void clear() {
            map.clear();
            saveMapToFile();
        }

        @Override
        public Set<String> keySet() {
            return map.keySet();
        }

        @Override
        public Collection<String> values() {
            return map.values();
        }

        @Override
        public Set<Entry<String, String>> entrySet() {
            return map.entrySet();
        }
    }
}
