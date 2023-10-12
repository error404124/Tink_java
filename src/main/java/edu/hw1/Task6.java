package edu.hw1;

import java.util.Arrays;

public class Task6 {

    public static int K(int number) {
        int numb = 0;
        String str = Integer.toString(number);
        char[] max = str.toCharArray();
        Arrays.sort(max);
        if (number == 6174) {
            return 0;
        }
        for (int i = max.length - 1; i >= 0; --i) {
            numb -= (max[max.length - i - 1] - '0') * Math.pow(10, i);
            numb += (max[i] - '0') * Math.pow(10, i);
        }
        if (numb != 6174) {
            return 1 + K(numb);
        } else {
            return 1;
        }
    }
}
