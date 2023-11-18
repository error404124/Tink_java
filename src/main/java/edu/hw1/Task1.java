package edu.hw1;

public class Task1 {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int MAX = 100000000;

    private Task1() {

    }

    @SuppressWarnings("MagicNumber")
    public static int minutesToSeconds(String str) {
        char[] chars = str.toCharArray();
        int counter = 0;
        int j = 1;
        for (int i = chars.length - 1; i >= 0; --i) {
            if (chars[i] != ':') {
                if (Character.getNumericValue(chars[i]) <= 9 && Character.getNumericValue(chars[i]) >= 0) {
                    counter += Character.getNumericValue(chars[i]) * j;
                    j *= 10;
                    if (counter > MAX) {
                        return -1;
                    }
                } else {
                    return -1;
                }
            } else if (chars[i] == ':' && counter >= SECONDS_IN_MINUTE) {
                return -1;
            } else if (chars[i] == ':') {
                j = SECONDS_IN_MINUTE;
            }
        }
        return counter;
    }
}
