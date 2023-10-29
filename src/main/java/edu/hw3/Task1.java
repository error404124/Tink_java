package edu.hw3;

public class Task1 {
    private Task1() {
    }

    public static String atbash(String array) {
        char[] copyArray = array.toCharArray();
        StringBuilder answer = new StringBuilder();
        for (char symbol : copyArray) {
            if (Character.isLetter(symbol)) {
                if (Character.isUpperCase(symbol)) {
                    answer.append((char) ('Z' - (symbol - 'A')));
                } else {
                    answer.append((char) ('z' - (symbol - 'a')));
                }
            } else {
                answer.append(symbol);
            }
        }
        return answer.toString();
    }
}
