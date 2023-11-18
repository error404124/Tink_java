package edu.hw3;

public class Task1 {
    private Task1() {
    }

    static final int ALPHABET = 27;

    public static String atbash(String str) {
        char[] copyArray = str.toCharArray();
        StringBuilder answer = new StringBuilder(str.length());
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
