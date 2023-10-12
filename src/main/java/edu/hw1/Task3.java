package edu.hw1;

public class Task3 {
    public static boolean isNestable(int[] mass1, int[] mass2) {
        if (min(mass1) > min(mass2)) {
            return true;
        } else if (max(mass1) < max(mass2)) {
            return true;
        } else {
            return false;
        }
    }

    private static int min(int[] mass) {
        int min = mass[0];
        for (int elem : mass) {
            if (elem < min) {
                min = elem;
            }
        }
        return min;
    }

    private static int max(int[] mass) {
        int max = mass[0];
        for (int elem : mass) {
            if (elem > max) {
                max = elem;
            }
        }
        return max;
    }
}
