package edu.hw1;

public class Task4 {
    public static String fixString(String str) {
        char symb;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i += 2) {
            if (i + 2 <= chars.length) {
                symb = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = symb;
            }
        }
        String string = new String(chars);
        return string;
    }
}
