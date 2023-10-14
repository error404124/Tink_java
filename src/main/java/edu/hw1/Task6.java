package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private static final int ANSWER = 6174;
    private static final int CONDITION = 1000;

    private Task6() {

    }

    @SuppressWarnings("MagicNumber")
    public static int k(int number) {

        if (number <= CONDITION) {
            return -1;
        }
        if (number == ANSWER) {
            return 0;
        }
        int numb = 0;
        String str = Integer.toString(number);
        char[] max = str.toCharArray();
        Arrays.sort(max);
        for (int i = max.length - 1; i >= 0; --i) {
            numb -= (max[max.length - i - 1] - '0') * Math.pow(10, i);
            numb += (max[i] - '0') * Math.pow(10, i);
        }
        return 1 + k(numb);
    }
}
