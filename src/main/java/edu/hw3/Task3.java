package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    public static Map<String, Integer> freqDict(String[] list) {
        Map<String, Integer> dict = new HashMap<>();
        for (String word : list) {
            String wordLower = word.toLowerCase();
            if (dict.containsKey(wordLower)) {
                dict.put(wordLower, dict.get(wordLower) + 1);
            } else {
                dict.put(wordLower, 1);
            }
        }
        return dict;
    }

}
