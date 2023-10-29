package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {
    }

    public static String[] clusterize(String array) {
        List<String> brackets = new ArrayList<>();
        int counter = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < array.length(); ++i) {
            if (array.charAt(i) == ')') {
                ++counter;
                answer.append(array.charAt(i));
            } else if (array.charAt(i) == '(') {
                --counter;
                answer.append(array.charAt(i));
            }
            if (counter == 0) {
                brackets.add(answer.toString());
                answer.setLength(0);
            }
        }
        return brackets.toArray(new String[] {});
    }
}
