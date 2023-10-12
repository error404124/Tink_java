package edu.hw1;

public class Task2 {
    private Task2() {
    }

    @SuppressWarnings("MagicNumber")
    public static int countDigits(int number) {
        int counter = 0;
        int copyNumber = number;
        if (copyNumber == 0) {
            return 1;
        }
        while (copyNumber != 0) {
            copyNumber /= 10;
            counter++;
        }
        return counter;
    }
}
