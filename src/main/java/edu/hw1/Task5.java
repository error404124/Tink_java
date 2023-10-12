package edu.hw1;

public class Task5 {
    public static boolean isPalindromeDescendant(int number) {
        int tmp = number;
        int revers = 0;
        while (tmp > 0) {
            int r = tmp % 10;
            revers = revers * 10 + r;
            tmp /= 10;
        }
        if (revers != number && number >= 10) {
            return isPalindromeDescendant(f(number));
        } else if (revers == number && number > 10) {
            return true;
        }
        return false;
    }

    public static int f(int number) {
        int number_2 = 0;
        int tmp = number;
        int i = 0;
        while (tmp != 0) {
            number_2 += tmp % 10 * Math.pow(10, i);
            tmp /= 10;
            number_2 += tmp % 10 * Math.pow(10, i);
            tmp /= 10;
            i++;
        }
        return number_2;
    }
}
