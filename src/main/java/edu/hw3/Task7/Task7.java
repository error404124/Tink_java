package edu.hw3.Task7;

import java.util.Comparator;

public class Task7 {
    private Task7() {
    }

    public static class NullComparator<T> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
