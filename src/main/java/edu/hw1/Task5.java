package edu.hw1;

public class Task5 {
    private Task5() {
    }

    @SuppressWarnings("MagicNumber")
    public static boolean isPalindromeDescendant(int number) {
        int tmp = number;
        int revers = 0;
        while (tmp > 0) {
            int r = tmp % 10;
            revers = revers * 10 + r;
            tmp /= 10;
        }
        if (revers != number && number >= 10) {
            return isPalindromeDescendant(pairReverse(number));
        } else if (revers == number) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("MagicNumber")
    public static int pairReverse(int number) {
        int number2 = 0;
        int tmp = number;
        int i = 0;
        while (tmp != 0) {
            number2 += (int) (tmp % 10 * Math.pow(10, i));
            tmp /= 10;
            number2 += (int) (tmp % 10 * Math.pow(10, i));
            tmp /= 10;
            i++;
        }
        return number2;
    }
}
