package edu.hw1;

public class Task4 {
    private Task4() {
    }

    public static String fixString(String str) {
        char symb;
        char[] chars = str.toCharArray();
        for (int i = 0; i + 2 <= chars.length; i += 2) {
                symb = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = symb;
        }
        return new String(chars);
    }
}
