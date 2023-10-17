package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private static final int SEEKING_NUMBER = 6174;
    private static final int MINIMUM_NUMBER = 1000;

    private Task6() {

    }

    @SuppressWarnings("MagicNumber")
    public static int k(int number) {
        if (checkNumber(number)) {
            return -1;
        }
        if (number <= MINIMUM_NUMBER) {
            return -1;
        }
        if (number == SEEKING_NUMBER) {
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

    @SuppressWarnings("MagicNumber")
    public static boolean checkNumber(int number) {
        int units = number % 10;
        int dozens = number / 10 % 10;
        int hundreds = number / 100 % 10;
        int thousands = number / 1000;
        return (units == dozens && units == hundreds && units == thousands);
    }
}
