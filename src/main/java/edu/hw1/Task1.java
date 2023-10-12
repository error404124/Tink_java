package edu.hw1;

public class Task1 {
    public static int minutesToSeconds(String str) {
        char[] chars = str.toCharArray();
        int counter = 0;
        int j = 1;
        for (int i = chars.length - 1; i >= 0; --i) {
            if (chars[i] != ':') {
                counter += (chars[i] - '0') * j;
                j *= 10;
            } else if (chars[i] == ':' && counter >= 60) {
                return -1;
            } else if (chars[i] == ':') {
                j = 60;
            }
        }
        return counter;
    }
}
